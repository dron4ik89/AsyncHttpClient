package andrey.shpilevoy.http_client

import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import okhttp3.*
import java.net.URLEncoder
import java.security.KeyStore
import javax.net.ssl.*
import okhttp3.RequestBody
import java.io.File
import android.webkit.MimeTypeMap

open class HttpClient {

    private val httpClient = OkHttpClient.Builder()
    private val requestBuilder = Request.Builder()

    open fun setBasicAuth(login: String, password: String): HttpClient {
        httpClient.authenticator { route, response ->
            val credential = Credentials.basic(login, password)
            response.request().newBuilder().header("Authorization", credential).build()
        }
        return this
    }

    open fun addHeader(header: String, value: String): HttpClient {
        requestBuilder.addHeader(header, value)
        return this
    }

    open fun setHeaders(map: Map<String, String>): HttpClient {
        map.forEach { (header, value) ->
            requestBuilder.addHeader(header, value)
        }
        return this
    }

    open fun isVerifierSSl(flag: Boolean): HttpClient {
        if (!flag)
            setVerifier(httpClient)
        return this
    }

    private fun setVerifier(httpClient: OkHttpClient.Builder) {
        val trustStore = KeyStore.getInstance(KeyStore.getDefaultType())
        trustStore.load(null, null)

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf(X509TrustManager()), java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        httpClient.sslSocketFactory(sslSocketFactory, X509TrustManager())
        httpClient.hostnameVerifier { _, _ -> true; };
    }

    open fun get(url: String, params: RequestParams?, responseHelper: ResponseHelper?) {
        requestBuilder.url(getUrlWithParams(url, params))
        requestBuilder.get()
        setResponse(responseHelper)
    }

    open fun head(url: String, params: RequestParams?, responseHelper: ResponseHelper?) {
        requestBuilder.url(getUrlWithParams(url, params))
        requestBuilder.head()
        setResponse(responseHelper)
    }

    open fun post(url: String, params: RequestParams?, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.post(createParams(params))
        setResponse(responseHelper)
    }

    open fun postBody(url: String, body: String?, json: Boolean, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.post(createBodyParams(body, json))
        setResponse(responseHelper)
    }

    open fun postBody(url: String, json: String?, responseHelper: ResponseHelper?) {
        postBody(url, json, true, responseHelper)
    }

    open fun put(url: String, params: RequestParams?, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.put(createParams(params))
        setResponse(responseHelper)
    }

    open fun putBody(url: String, body: String?, json: Boolean, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.put(createBodyParams(body, json))
        setResponse(responseHelper)
    }

    open fun putBody(url: String, json: String?, responseHelper: ResponseHelper?) {
        putBody(url, json, true, responseHelper)
    }

    open fun patch(url: String, params: RequestParams?, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.patch(createParams(params))
        setResponse(responseHelper)
    }

    open fun patchBody(url: String, body: String?, json: Boolean, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.patch(createBodyParams(body, json))
        setResponse(responseHelper)
    }

    open fun patchBody(url: String, json: String?, responseHelper: ResponseHelper?) {
        patchBody(url, json, true, responseHelper)
    }

    open fun delete(url: String, params: RequestParams?, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.delete(createParams(params))
        setResponse(responseHelper)
    }

    open fun deleteBody(url: String, body: String?, json: Boolean, responseHelper: ResponseHelper?) {
        requestBuilder.url(url)
        requestBuilder.delete(createBodyParams(body, json))
        setResponse(responseHelper)
    }

    open fun deleteBody(url: String, json: String?, responseHelper: ResponseHelper?) {
        deleteBody(url, json, true, responseHelper)
    }

    private fun getParams(params: RequestParams): String {
        val result = StringBuilder()
        var first = true

        params.map.forEach { (key, value) ->
            if (first)
                first = false
            else
                result.append("&")

            result.append(URLEncoder.encode(key, "UTF-8"))
            result.append("=")
            result.append(value)
        }

        return result.toString()
    }

    private fun createParams(params: RequestParams?): RequestBody {
        return if (params != null && params.map.size > 0)
            if (params.json) {
                createJsonParams(params)
            } else {
                createFormParams(params)
            }
        else
            RequestBody.create(null, ByteArray(0))
    }

    private fun createBodyParams(body: String?, json: Boolean = true) : RequestBody{
        val type: MediaType? = if(json)
            MediaType.parse("application/json; charset=utf-8")
        else
            MediaType.parse("text/plain; charset=utf-8")
        return RequestBody.create(type, body ?: "")
    }

    private fun createJsonParams(params: RequestParams): RequestBody {
        val type = MediaType.parse("application/json; charset=utf-8")
        val json = Gson().toJson(params.map)
        return RequestBody.create(type, json)
    }

    private fun createFormParams(params: RequestParams): RequestBody {
        val formBody = MultipartBody.Builder()
        formBody.setType(MultipartBody.FORM)
        params.map.forEach { (key, value) ->
            if (value is File) {
                val name = value.name
                val extension = MimeTypeMap.getFileExtensionFromUrl(value.absolutePath)
                if (extension != null) {
                    val typeString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
                    if (typeString != null) {
                        val type = MediaType.parse(typeString)
                        formBody.addFormDataPart(key, name, RequestBody.create(type, value))
                    }
                }
            } else
                formBody.addFormDataPart(key, "$value")
        }
        return formBody.build()
    }

    private fun getUrlWithParams(url: String, params: RequestParams?): String {
        return if (params != null && params.map.size > 0)
            "$url?${getParams(params)}"
        else
            url
    }

    private fun setResponse(responseHelper: ResponseHelper?) {

        Thread(Runnable {

            var response: Response? = null
            var exception: Exception? = null
            try {
                response = httpClient.build().newCall(requestBuilder.build()).execute()
            } catch (e: Exception) {
                exception = e
            }

            if (responseHelper != null) {

                if(responseHelper is HttpCodeResponseHelper){

                    val statusCode = response?.code() ?: 0

                    Handler(Looper.getMainLooper()).post {
                        responseHelper.onFinal(statusCode, exception)
                    }

                }else if(responseHelper is HttpHeadResponseHelper){

                    val statusCode = response?.code() ?: 0
                    val responseHeaders = response?.headers()

                    val headers: Array<Header>? = Array(responseHeaders?.size() ?: 0) { i ->
                        Header(responseHeaders!!.name(i), responseHeaders.value(i))
                    }

                    if (statusCode in 1..300) {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onSuccess(statusCode, headers)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onFailure(statusCode, headers, exception)
                        }
                    }

                }else if(responseHelper is HttpTextResponseHelper){

                    val statusCode = response?.code() ?: 0
                    val responseContent = if(response != null) response.body()?.string() else null

                    if (statusCode in 1..300) {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onSuccess(statusCode, responseContent)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onFailure(statusCode, responseContent, exception)
                        }
                    }

                }else if(responseHelper is HttpResponseHelper){

                    val statusCode = response?.code() ?: 0
                    val responseContent = if(response != null) response.body()?.string() else null
                    val responseHeaders = response?.headers()

                    val headers: Array<Header>? = Array(responseHeaders?.size() ?: 0) { i ->
                        Header(responseHeaders!!.name(i), responseHeaders.value(i))
                    }

                    if (statusCode in 1..300) {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onSuccess(statusCode, headers, responseContent)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onFailure(statusCode, headers, responseContent, exception)
                        }
                    }

                }else if(responseHelper is HttpBytesResponseHelper){

                    val statusCode = response?.code() ?: 0
                    val responseBytes = if(response != null) response.body()?.bytes() else null

                    if (statusCode in 1..300) {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onSuccess(statusCode, responseBytes)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onFailure(statusCode, responseBytes, exception)
                        }
                    }

                }else if(responseHelper is HttpByteStreamResponseHelper){

                    val statusCode = response?.code() ?: 0
                    val responseByteStream = if(response != null) response.body()?.byteStream() else null

                    if (statusCode in 1..300) {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onSuccess(statusCode, responseByteStream)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onFailure(statusCode, responseByteStream, exception)
                        }
                    }

                }else if(responseHelper is HttpCharStreamResponseHelper){

                    val statusCode = response?.code() ?: 0
                    val responseCharStream = if(response != null) response.body()?.charStream() else null

                    if (statusCode in 1..300) {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onSuccess(statusCode, responseCharStream)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            responseHelper.onFailure(statusCode, responseCharStream, exception)
                        }
                    }

                }

            }

        }).start()
    }

}
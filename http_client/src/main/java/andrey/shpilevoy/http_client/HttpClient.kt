package andrey.shpilevoy.http_client

import android.annotation.SuppressLint
import android.net.Proxy
import android.net.wifi.hotspot2.pps.Credential
import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import okhttp3.*
import java.net.URLEncoder
import java.security.KeyStore
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*
import okhttp3.RequestBody
import java.io.File
import android.webkit.MimeTypeMap
import okhttp3.Route
import okhttp3.Challenge
import java.net.URL

open class HttpClient {

    private val httpClient = OkHttpClient.Builder()
    private val requestBuilder = Request.Builder()

    open fun setBasicAuth(login: String, password: String) {
        httpClient.authenticator(object : Authenticator {
            override fun authenticate(route: Route, response: Response): Request? {
                val credential = Credentials.basic(login, password)
                return response.request().newBuilder().header("Authorization", credential).build()
            }
        })
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

    open fun get(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        requestBuilder.url(getUrlWithParams(url, params))
        requestBuilder.get()
        setResponse(httpResponse)
    }

    open fun head(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        requestBuilder.url(getUrlWithParams(url, params))
        requestBuilder.head()
        setResponse(httpResponse)
    }

    open fun post(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        requestBuilder.url(url)
        requestBuilder.post(createParams(params))
        setResponse(httpResponse)
    }

    open fun put(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        requestBuilder.url(url)
        requestBuilder.put(createParams(params))
        setResponse(httpResponse)
    }

    open fun patch(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        requestBuilder.url(url)
        requestBuilder.patch(createParams(params))
        setResponse(httpResponse)
    }

    open fun delete(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        requestBuilder.url(url)
        requestBuilder.delete(createParams(params))
        setResponse(httpResponse)
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
            result.append(URLEncoder.encode("$value", "UTF-8"))
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

    private fun setResponse(httpResponse: HttpResponse?) {

        Thread(Runnable {
            try {
                val response = httpClient.build().newCall(requestBuilder.build()).execute()

                if (httpResponse != null) {
                    val statusCode = response.code()
                    val responseContent = response.body()?.string()
                    val responseHeaders = response.headers()

                    val headers: Array<Header> = Array(responseHeaders.size()) { i ->
                        Header(responseHeaders.name(i), responseHeaders.value(i))
                    }

                    if (statusCode in 1..300) {
                        Handler(Looper.getMainLooper()).post {
                            httpResponse.onSuccess(statusCode, headers, responseContent)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            httpResponse.onFailure(statusCode, headers, responseContent, null)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Handler(Looper.getMainLooper()).post {
                    httpResponse?.onFailure(0, null, null, e)
                }
            }

        }).start()
    }

}
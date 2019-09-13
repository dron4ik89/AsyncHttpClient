package andrey.shpilevoy.http_client

import android.annotation.SuppressLint
import android.net.Proxy
import android.net.wifi.hotspot2.pps.Credential
import android.os.Handler
import android.os.Looper
import android.provider.Contacts
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
import okhttp3.Credentials.basic
import java.net.URL


open class AsyncHttpClient {

    private val httpClient = OkHttpClient.Builder()

    constructor() {}

    constructor(ignoreVerifier: Boolean) {
        this.ignoreVerifier = ignoreVerifier
    }

    fun setBasicAuth(login: String, password: String) {

        httpClient.authenticator(object : Authenticator {
            override fun authenticate(route: Route, response: Response): Request? {
                val credential = Credentials.basic(login, password)
                return response.request().newBuilder().header("Authorization", credential).build()
            }

            fun authenticateProxy(proxy: Proxy, url: URL, challenges: List<Challenge>): Credential? {
                return null
            }
        })

    }

    private fun getClient(): OkHttpClient {

        if (ignoreVerifier)
            setVerifier(httpClient)

        return httpClient.build()

    }

    private var ignoreVerifier = false
        get() = field
        set(value) {
            field = value
        }

    private val headers = HashMap<String, String>()

    fun putHeader(header: String, value: String): AsyncHttpClient {
        headers[header] = value
        return this
    }

    fun addHeader(header: String, value: String): AsyncHttpClient {
        return putHeader(header, value)
    }

    private fun setHeaders(builder: Request.Builder) {
        if (headers.size > 0)
            headers.forEach { (header, value) -> builder.header(header, value) }
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

    private fun setVerifier(httpClient: OkHttpClient.Builder) {
        val trustStore = KeyStore.getInstance(KeyStore.getDefaultType())
        trustStore.load(null, null)

        val trust = object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate>? {
                return arrayOf<X509Certificate>() //java.security.cert.X509Certificate[]{}
            }
        }

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf(trust), java.security.SecureRandom())
        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory

        httpClient.sslSocketFactory(sslSocketFactory, trust)
        httpClient.hostnameVerifier { _, _ -> true; };
    }


    private fun setResponse(client: OkHttpClient, request: Request, httpResponse: HttpResponse) {
        try {
            val response = client.newCall(request).execute()

            val statusCode = response.code()
            val responseContent = response.body()?.string()
            val responseHeaders = response.headers()

            val headers = ArrayList<Header>()

            for (i in 0 until responseHeaders.size()) {
                if (responseHeaders.name(i) != null)
                    headers.add(Header(responseHeaders.name(i), responseHeaders.value(i)))
            }

            val array = arrayOfNulls<Header>(headers.size)
            headers.toArray(array)

            if (statusCode in 1..300) {
                Handler(Looper.getMainLooper()).post {
                    httpResponse.onSuccess(statusCode, array, responseContent)
                }
            } else {
                Handler(Looper.getMainLooper()).post {
                    httpResponse.onFailure(statusCode, array, responseContent, null)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Handler(Looper.getMainLooper()).post {
                httpResponse.onFailure(0, null, null, e)
            }
        }
    }

    fun get(url: String, params: RequestParams, httpResponse: HttpResponse) {
        Thread(Runnable {
            val client = getClient()
            val builder = Request.Builder()
            setHeaders(builder)
            builder.url("$url?${getParams(params)}")
            builder.get()
            val request = builder.build()
            setResponse(client, request, httpResponse)
        }).start()
    }

    fun head(url: String, params: RequestParams, httpResponse: HttpResponse) {
        Thread(Runnable {
            val client = getClient()
            val builder = Request.Builder()
            setHeaders(builder)
            builder.url("$url?${getParams(params)}")
            builder.head()
            val request = builder.build()
            setResponse(client, request, httpResponse)
        }).start()
    }

    fun post(url: String, params: RequestParams, httpResponse: HttpResponse) {
        Thread(Runnable {
            val client = getClient()
            val builder = Request.Builder()
            setHeaders(builder)
            builder.url(url)
            if (params.json) {
                builder.post(createJsonParams(params))
            } else {
                builder.post(createFormParams(params))
            }
            val request = builder.build()
            setResponse(client, request, httpResponse)
        }).start()
    }

    fun put(url: String, params: RequestParams, httpResponse: HttpResponse) {
        Thread(Runnable {
            val client = getClient()
            val builder = Request.Builder()
            setHeaders(builder)
            builder.url(url)
            if (params.json) {
                builder.put(createJsonParams(params))
            } else {
                builder.put(createFormParams(params))
            }
            val request = builder.build()
            setResponse(client, request, httpResponse)
        }).start()
    }

    fun patch(url: String, params: RequestParams, httpResponse: HttpResponse) {
        Thread(Runnable {
            val client = getClient()
            val builder = Request.Builder()
            setHeaders(builder)
            builder.url(url)
            if (params.json) {
                builder.patch(createJsonParams(params))
            } else {
                builder.patch(createFormParams(params))
            }
            val request = builder.build()
            setResponse(client, request, httpResponse)
        }).start()
    }

    fun delete(url: String, params: RequestParams, httpResponse: HttpResponse) {
        Thread(Runnable {
            val client = getClient()
            val builder = Request.Builder()
            setHeaders(builder)
            builder.url(url)
            if (params.json) {
                builder.delete(createJsonParams(params))
            } else {
                builder.delete(createFormParams(params))
            }
            val request = builder.build()
            setResponse(client, request, httpResponse)
        }).start()
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

}
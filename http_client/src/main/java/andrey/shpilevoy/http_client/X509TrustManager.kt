package andrey.shpilevoy.http_client

import android.annotation.SuppressLint
import java.security.cert.CertificateException
import java.security.cert.X509Certificate

class X509TrustManager : javax.net.ssl.X509TrustManager {
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
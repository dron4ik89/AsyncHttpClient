package andrey.shpilevoy.http_client

open class AsyncHttpClient : HttpClient() {

    override fun setBasicAuth(login: String, password: String) {
        super.setBasicAuth(login, password)
    }

    override fun addHeader(header: String, value: String): AsyncHttpClient {
        super.addHeader(header, value)
        return this
    }

    override fun setHeaders(map: Map<String, String>): AsyncHttpClient {
        super.setHeaders(map)
        return this
    }

    override fun isVerifierSSl(flag: Boolean): AsyncHttpClient {
        super.isVerifierSSl(flag)
        return this
    }

    fun get(url: String) {
        super.get(url, null, null)
    }

    fun get(url: String, httpResponse: HttpResponse?) {
        super.get(url, null, httpResponse)
    }

    fun get(url: String, params: RequestParams?) {
        super.get(url, params, null)
    }

    override fun get(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        super.get(url, params, httpResponse)
    }

    fun head(url: String) {
        super.head(url, null, null)
    }

    fun head(url: String, httpResponse: HttpResponse?) {
        super.head(url, null, httpResponse)
    }

    fun head(url: String, params: RequestParams?) {
        super.head(url, params, null)
    }

    override fun head(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        super.head(url, params, httpResponse)
    }

    fun post(url: String) {
        super.post(url, null, null)
    }

    fun post(url: String, httpResponse: HttpResponse?) {
        super.post(url, null, httpResponse)
    }

    fun post(url: String, params: RequestParams?) {
        super.post(url, params, null)
    }

    override fun post(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        super.post(url, params, httpResponse)
    }

    fun put(url: String) {
        super.put(url, null, null)
    }

    fun put(url: String, httpResponse: HttpResponse?) {
        super.put(url, null, httpResponse)
    }

    fun put(url: String, params: RequestParams?) {
        super.put(url, params, null)
    }

    override fun put(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        super.put(url, params, httpResponse)
    }

    fun patch(url: String) {
        super.patch(url, null, null)
    }

    fun patch(url: String, httpResponse: HttpResponse?) {
        super.patch(url, null, httpResponse)
    }

    fun patch(url: String, params: RequestParams?) {
        super.patch(url, params, null)
    }

    override fun patch(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        super.patch(url, params, httpResponse)
    }

    fun delete(url: String) {
        super.delete(url, null, null)
    }

    fun delete(url: String, httpResponse: HttpResponse?) {
        super.delete(url, null, httpResponse)
    }

    fun delete(url: String, params: RequestParams?) {
        super.delete(url, params, null)
    }

    override fun delete(url: String, params: RequestParams?, httpResponse: HttpResponse?) {
        super.delete(url, params, httpResponse)
    }
}
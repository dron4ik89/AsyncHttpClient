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

    fun get(url: String, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.get(url, null, httpCodeResponseHelper)
    }

    fun get(url: String, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.get(url, null, httpHeadResponseHelper)
    }

    fun get(url: String, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.get(url, null, httpTextResponseHelper)
    }

    fun get(url: String, httpResponseHelper: HttpResponseHelper?) {
        super.get(url, null, httpResponseHelper)
    }

    fun get(url: String, params: RequestParams?) {
        super.get(url, params, null)
    }

    fun get(url: String, params: RequestParams?, httpCodeResponseHelper: HttpCodeResponseHelper) {
        super.get(url, params, httpCodeResponseHelper)
    }

    fun get(url: String, params: RequestParams?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.get(url, params, httpHeadResponseHelper)
    }

    fun get(url: String, params: RequestParams?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.get(url, params, httpTextResponseHelper)
    }

    fun get(url: String, params: RequestParams?, httpResponseHelper: HttpResponseHelper?) {
        super.get(url, params, httpResponseHelper)
    }

    fun head(url: String) {
        super.head(url, null, null)
    }

    fun head(url: String, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.head(url, null, httpCodeResponseHelper)
    }

    fun head(url: String, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.head(url, null, httpHeadResponseHelper)
    }

    fun head(url: String, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.head(url, null, httpTextResponseHelper)
    }

    fun head(url: String, httpResponseHelper: HttpResponseHelper?) {
        super.head(url, null, httpResponseHelper)
    }

    fun head(url: String, params: RequestParams?) {
        super.head(url, params, null)
    }

    fun head(url: String, params: RequestParams?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.head(url, params, httpCodeResponseHelper)
    }

    fun head(url: String, params: RequestParams?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.head(url, params, httpHeadResponseHelper)
    }

    fun head(url: String, params: RequestParams?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.head(url, params, httpTextResponseHelper)
    }

    fun head(url: String, params: RequestParams?, httpResponseHelper: HttpResponseHelper?) {
        super.head(url, params, httpResponseHelper)
    }

    fun post(url: String) {
        super.post(url, null, null)
    }

    fun post(url: String, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.post(url, null, httpCodeResponseHelper)
    }

    fun post(url: String, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.post(url, null, httpHeadResponseHelper)
    }

    fun post(url: String, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.post(url, null, httpTextResponseHelper)
    }

    fun post(url: String, httpResponseHelper: HttpResponseHelper?) {
        super.post(url, null, httpResponseHelper)
    }

    fun post(url: String, params: RequestParams?) {
        super.post(url, params, null)
    }

    fun post(url: String, params: RequestParams?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.post(url, params, httpCodeResponseHelper)
    }

    fun post(url: String, params: RequestParams?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.post(url, params, httpHeadResponseHelper)
    }

    fun post(url: String, params: RequestParams?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.post(url, params, httpTextResponseHelper)
    }

    fun post(url: String, params: RequestParams?, httpResponseHelper: HttpResponseHelper?) {
        super.post(url, params, httpResponseHelper)
    }

    fun put(url: String) {
        super.put(url, null, null)
    }

    fun put(url: String, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.put(url, null, httpCodeResponseHelper)
    }

    fun put(url: String, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.put(url, null, httpHeadResponseHelper)
    }

    fun put(url: String, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.put(url, null, httpTextResponseHelper)
    }

    fun put(url: String, httpResponseHelper: HttpResponseHelper?) {
        super.put(url, null, httpResponseHelper)
    }

    fun put(url: String, params: RequestParams?) {
        super.put(url, params, null)
    }

    fun put(url: String, params: RequestParams?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.put(url, params, httpCodeResponseHelper)
    }

    fun put(url: String, params: RequestParams?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.put(url, params, httpHeadResponseHelper)
    }

    fun put(url: String, params: RequestParams?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.put(url, params, httpTextResponseHelper)
    }

    fun put(url: String, params: RequestParams?, httpResponseHelper: HttpResponseHelper?) {
        super.put(url, params, httpResponseHelper)
    }

    fun patch(url: String) {
        super.patch(url, null, null)
    }

    fun patch(url: String, httpResponseHelper: HttpResponseHelper?) {
        super.patch(url, null, httpResponseHelper)
    }

    fun patch(url: String, params: RequestParams?) {
        super.patch(url, params, null)
    }

    fun patch(url: String, params: RequestParams?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.patch(url, params, httpCodeResponseHelper)
    }

    fun patch(url: String, params: RequestParams?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.patch(url, params, httpHeadResponseHelper)
    }

    fun patch(url: String, params: RequestParams?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.patch(url, params, httpTextResponseHelper)
    }

    fun patch(url: String, params: RequestParams?, httpResponseHelper: HttpResponseHelper?) {
        super.patch(url, params, httpResponseHelper)
    }

    fun delete(url: String) {
        super.delete(url, null, null)
    }

    fun delete(url: String, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.delete(url, null, httpCodeResponseHelper)
    }

    fun delete(url: String, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.delete(url, null, httpHeadResponseHelper)
    }

    fun delete(url: String, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.delete(url, null, httpTextResponseHelper)
    }

    fun delete(url: String, httpResponseHelper: HttpResponseHelper?) {
        super.delete(url, null, httpResponseHelper)
    }

    fun delete(url: String, params: RequestParams?) {
        super.delete(url, params, null)
    }

    fun delete(url: String, params: RequestParams?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.delete(url, params, httpCodeResponseHelper)
    }

    fun delete(url: String, params: RequestParams?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.delete(url, params, httpHeadResponseHelper)
    }

    fun delete(url: String, params: RequestParams?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.delete(url, params, httpTextResponseHelper)
    }

    fun delete(url: String, params: RequestParams?, httpResponseHelper: HttpResponseHelper?) {
        super.delete(url, params, httpResponseHelper)
    }
}
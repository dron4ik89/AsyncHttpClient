package andrey.shpilevoy.http_client

open class AsyncHttpClient : HttpClient() {

    override fun setBasicAuth(login: String, password: String): AsyncHttpClient {
        super.setBasicAuth(login, password)
        return this
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

    fun get(url: String, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.get(url, null, httpBytesResponseHelper)
    }

    fun get(url: String, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.get(url, null, httpByteStreamResponseHelper)
    }

    fun get(url: String, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.get(url, null, httpCharStreamResponseHelper)
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

    fun get(url: String, params: RequestParams?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.get(url, params, httpBytesResponseHelper)
    }

    fun get(url: String, params: RequestParams?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.get(url, params, httpByteStreamResponseHelper)
    }

    fun get(url: String, params: RequestParams?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.get(url, params, httpCharStreamResponseHelper)
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

    fun head(url: String, params: RequestParams?) {
        super.head(url, params, null)
    }

    fun head(url: String, params: RequestParams?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.head(url, params, httpCodeResponseHelper)
    }

    fun head(url: String, params: RequestParams?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.head(url, params, httpHeadResponseHelper)
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

    fun post(url: String, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.post(url, null, httpBytesResponseHelper)
    }

    fun post(url: String, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.post(url, null, httpByteStreamResponseHelper)
    }

    fun post(url: String, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.post(url, null, httpCharStreamResponseHelper)
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

    fun post(url: String, params: RequestParams?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.post(url, params, httpBytesResponseHelper)
    }

    fun post(url: String, params: RequestParams?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.post(url, params, httpByteStreamResponseHelper)
    }

    fun post(url: String, params: RequestParams?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.post(url, params, httpCharStreamResponseHelper)
    }


    fun post(url: String, body: String?, json: Boolean, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.postBody(url, body, json, httpCodeResponseHelper)
    }

    fun post(url: String, body: String?, json: Boolean, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.postBody(url, body, json, httpHeadResponseHelper)
    }

    fun post(url: String, body: String?, json: Boolean, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.postBody(url, body, json, httpTextResponseHelper)
    }

    fun post(url: String, body: String?, json: Boolean, httpResponseHelper: HttpResponseHelper?) {
        super.postBody(url, body, json, httpResponseHelper)
    }

    fun post(url: String, body: String?, json: Boolean, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.postBody(url, body, json, httpBytesResponseHelper)
    }

    fun post(url: String, body: String?, json: Boolean, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.postBody(url, body, json, httpByteStreamResponseHelper)
    }

    fun post(url: String, body: String?, json: Boolean, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.postBody(url, body, json, httpCharStreamResponseHelper)
    }


    fun post(url: String, json: String?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.postBody(url, json, httpCodeResponseHelper)
    }

    fun post(url: String, json: String?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.postBody(url, json, httpHeadResponseHelper)
    }

    fun post(url: String, json: String?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.postBody(url, json, httpTextResponseHelper)
    }

    fun post(url: String, json: String?, httpResponseHelper: HttpResponseHelper?) {
        super.postBody(url, json, httpResponseHelper)
    }

    fun post(url: String, json: String?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.postBody(url, json, httpBytesResponseHelper)
    }

    fun post(url: String, json: String?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.postBody(url, json, httpByteStreamResponseHelper)
    }

    fun post(url: String, json: String?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.postBody(url, json, httpCharStreamResponseHelper)
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

    fun put(url: String, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.put(url, null, httpBytesResponseHelper)
    }

    fun put(url: String, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.put(url, null, httpByteStreamResponseHelper)
    }

    fun put(url: String, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.put(url, null, httpCharStreamResponseHelper)
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

    fun put(url: String, params: RequestParams?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.put(url, params, httpBytesResponseHelper)
    }

    fun put(url: String, params: RequestParams?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.put(url, params, httpByteStreamResponseHelper)
    }

    fun put(url: String, params: RequestParams?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.put(url, params, httpCharStreamResponseHelper)
    }

    fun put(url: String, body: String?, json: Boolean, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.putBody(url, body, json, httpCodeResponseHelper)
    }

    fun put(url: String, body: String?, json: Boolean, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.putBody(url, body, json, httpHeadResponseHelper)
    }

    fun put(url: String, body: String?, json: Boolean, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.putBody(url, body, json, httpTextResponseHelper)
    }

    fun put(url: String, body: String?, json: Boolean, httpResponseHelper: HttpResponseHelper?) {
        super.putBody(url, body, json, httpResponseHelper)
    }

    fun put(url: String, body: String?, json: Boolean, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.putBody(url, body, json, httpBytesResponseHelper)
    }

    fun put(url: String, body: String?, json: Boolean, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.putBody(url, body, json, httpByteStreamResponseHelper)
    }

    fun put(url: String, body: String?, json: Boolean, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.putBody(url, body, json, httpCharStreamResponseHelper)
    }


    fun put(url: String, json: String?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.putBody(url, json, httpCodeResponseHelper)
    }

    fun put(url: String, json: String?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.putBody(url, json, httpHeadResponseHelper)
    }

    fun put(url: String, json: String?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.putBody(url, json, httpTextResponseHelper)
    }

    fun put(url: String, json: String?, httpResponseHelper: HttpResponseHelper?) {
        super.putBody(url, json, httpResponseHelper)
    }

    fun put(url: String, json: String?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.putBody(url, json, httpBytesResponseHelper)
    }

    fun put(url: String, json: String?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.putBody(url, json, httpByteStreamResponseHelper)
    }

    fun put(url: String, json: String?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.putBody(url, json, httpCharStreamResponseHelper)
    }



    fun patch(url: String) {
        super.patch(url, null, null)
    }

    fun patch(url: String, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.patch(url, null, httpCodeResponseHelper)
    }

    fun patch(url: String, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.patch(url, null, httpHeadResponseHelper)
    }

    fun patch(url: String, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.patch(url, null, httpTextResponseHelper)
    }

    fun patch(url: String, httpResponseHelper: HttpResponseHelper?) {
        super.patch(url, null, httpResponseHelper)
    }

    fun patch(url: String, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.patch(url, null, httpBytesResponseHelper)
    }

    fun patch(url: String, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.patch(url, null, httpByteStreamResponseHelper)
    }

    fun patch(url: String, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.patch(url, null, httpCharStreamResponseHelper)
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

    fun patch(url: String, params: RequestParams?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.patch(url, params, httpBytesResponseHelper)
    }

    fun patch(url: String, params: RequestParams?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.patch(url, params, httpByteStreamResponseHelper)
    }

    fun patch(url: String, params: RequestParams?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.patch(url, params, httpCharStreamResponseHelper)
    }

    fun patch(url: String, body: String?, json: Boolean, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.patchBody(url, body, json, httpCodeResponseHelper)
    }

    fun patch(url: String, body: String?, json: Boolean, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.patchBody(url, body, json, httpHeadResponseHelper)
    }

    fun patch(url: String, body: String?, json: Boolean, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.patchBody(url, body, json, httpTextResponseHelper)
    }

    fun patch(url: String, body: String?, json: Boolean, httpResponseHelper: HttpResponseHelper?) {
        super.patchBody(url, body, json, httpResponseHelper)
    }

    fun patch(url: String, body: String?, json: Boolean, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.patchBody(url, body, json, httpBytesResponseHelper)
    }

    fun patch(url: String, body: String?, json: Boolean, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.patchBody(url, body, json, httpByteStreamResponseHelper)
    }

    fun patch(url: String, body: String?, json: Boolean, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.patchBody(url, body, json, httpCharStreamResponseHelper)
    }


    fun patch(url: String, json: String?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.patchBody(url, json, httpCodeResponseHelper)
    }

    fun patch(url: String, json: String?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.patchBody(url, json, httpHeadResponseHelper)
    }

    fun patch(url: String, json: String?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.patchBody(url, json, httpTextResponseHelper)
    }

    fun patch(url: String, json: String?, httpResponseHelper: HttpResponseHelper?) {
        super.patchBody(url, json, httpResponseHelper)
    }

    fun patch(url: String, json: String?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.patchBody(url, json, httpBytesResponseHelper)
    }

    fun patch(url: String, json: String?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.patchBody(url, json, httpByteStreamResponseHelper)
    }

    fun patch(url: String, json: String?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.patchBody(url, json, httpCharStreamResponseHelper)
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

    fun delete(url: String, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.delete(url, null, httpBytesResponseHelper)
    }

    fun delete(url: String, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.delete(url, null, httpByteStreamResponseHelper)
    }

    fun delete(url: String, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.delete(url, null, httpCharStreamResponseHelper)
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

    fun delete(url: String, params: RequestParams?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.delete(url, params, httpBytesResponseHelper)
    }

    fun delete(url: String, params: RequestParams?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.delete(url, params, httpByteStreamResponseHelper)
    }

    fun delete(url: String, params: RequestParams?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.delete(url, params, httpCharStreamResponseHelper)
    }

    fun delete(url: String, body: String?, json: Boolean, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.deleteBody(url, body, json, httpCodeResponseHelper)
    }

    fun delete(url: String, body: String?, json: Boolean, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.deleteBody(url, body, json, httpHeadResponseHelper)
    }

    fun delete(url: String, body: String?, json: Boolean, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.deleteBody(url, body, json, httpTextResponseHelper)
    }

    fun delete(url: String, body: String?, json: Boolean, httpResponseHelper: HttpResponseHelper?) {
        super.deleteBody(url, body, json, httpResponseHelper)
    }

    fun delete(url: String, body: String?, json: Boolean, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.deleteBody(url, body, json, httpBytesResponseHelper)
    }

    fun delete(url: String, body: String?, json: Boolean, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.deleteBody(url, body, json, httpByteStreamResponseHelper)
    }

    fun delete(url: String, body: String?, json: Boolean, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.deleteBody(url, body, json, httpCharStreamResponseHelper)
    }


    fun delete(url: String, json: String?, httpCodeResponseHelper: HttpCodeResponseHelper?) {
        super.deleteBody(url, json, httpCodeResponseHelper)
    }

    fun delete(url: String, json: String?, httpHeadResponseHelper: HttpHeadResponseHelper?) {
        super.deleteBody(url, json, httpHeadResponseHelper)
    }

    fun delete(url: String, json: String?, httpTextResponseHelper: HttpTextResponseHelper?) {
        super.deleteBody(url, json, httpTextResponseHelper)
    }

    fun delete(url: String, json: String?, httpResponseHelper: HttpResponseHelper?) {
        super.deleteBody(url, json, httpResponseHelper)
    }

    fun delete(url: String, json: String?, httpBytesResponseHelper: HttpBytesResponseHelper?) {
        super.deleteBody(url, json, httpBytesResponseHelper)
    }

    fun delete(url: String, json: String?, httpByteStreamResponseHelper: HttpByteStreamResponseHelper?) {
        super.deleteBody(url, json, httpByteStreamResponseHelper)
    }

    fun delete(url: String, json: String?, httpCharStreamResponseHelper: HttpCharStreamResponseHelper?) {
        super.deleteBody(url, json, httpCharStreamResponseHelper)
    }
}
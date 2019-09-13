package andrey.shpilevoy.http_client

interface HttpResponse {

    fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?)

    fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?)

}
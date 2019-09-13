package andrey.shpilevoy.http_client

interface HttpResponse {

    fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?)

    fun onFailure(statusCode: Int, headers: Array<out Header>?, responseString: String?, throwable: Throwable?)

}
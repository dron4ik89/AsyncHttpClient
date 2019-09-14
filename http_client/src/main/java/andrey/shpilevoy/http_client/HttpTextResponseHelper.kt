package andrey.shpilevoy.http_client

interface HttpTextResponseHelper : ResponseHelper {

    fun onSuccess(statusCode: Int, responseString: String?)

    fun onFailure(statusCode: Int, responseString: String?, throwable: Throwable?)

}
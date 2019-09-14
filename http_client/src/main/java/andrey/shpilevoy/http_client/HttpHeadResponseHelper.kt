package andrey.shpilevoy.http_client

interface HttpHeadResponseHelper : ResponseHelper {

    fun onSuccess(statusCode: Int, headers: Array<out Header>?)

    fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?)

}
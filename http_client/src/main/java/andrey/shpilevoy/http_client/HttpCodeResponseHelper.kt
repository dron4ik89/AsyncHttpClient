package andrey.shpilevoy.http_client

interface HttpCodeResponseHelper : ResponseHelper {

    fun onFinal(statusCode: Int, throwable: Throwable?)

}
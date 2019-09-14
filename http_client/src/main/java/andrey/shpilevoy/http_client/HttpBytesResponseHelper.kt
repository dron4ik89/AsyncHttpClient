package andrey.shpilevoy.http_client

interface HttpBytesResponseHelper : ResponseHelper {

    fun onSuccess(statusCode: Int, responseBytes: ByteArray?)

    fun onFailure(statusCode: Int, responseBytes: ByteArray?, throwable: Throwable?)

}
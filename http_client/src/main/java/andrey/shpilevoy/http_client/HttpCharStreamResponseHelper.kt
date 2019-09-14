package andrey.shpilevoy.http_client

import java.io.Reader

interface HttpCharStreamResponseHelper : ResponseHelper {

    fun onSuccess(statusCode: Int, responseCharStream: Reader?)

    fun onFailure(statusCode: Int, responseCharStream: Reader?, throwable: Throwable?)

}
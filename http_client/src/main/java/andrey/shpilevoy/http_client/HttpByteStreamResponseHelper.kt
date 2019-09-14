package andrey.shpilevoy.http_client

import java.io.InputStream

interface HttpByteStreamResponseHelper : ResponseHelper {

    fun onSuccess(statusCode: Int, responseByteStream: InputStream?)

    fun onFailure(statusCode: Int, responseByteStream: InputStream?, throwable: Throwable?)

}
package andrey.shpilevoy.sample

import andrey.shpilevoy.http_client.AsyncHttpClient
import andrey.shpilevoy.http_client.Header
import andrey.shpilevoy.http_client.HttpResponseHelper
import andrey.shpilevoy.http_client.RequestParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paramsGet = RequestParams()
            .put("a", 1)
            .put("b", "two")
            .put("c", true)
            .put("d", 3.14F)

        AsyncHttpClient()
            //.isVerifierSSl(false)
            .addHeader("auth", "token")
            //.get("https://apimobile.welcash.kiev.ua/v1/user/", paramsGet, object : HttpResponseHelper{
            .get("http://prog.net.ua/test.php", paramsGet, object : HttpResponseHelper {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")
                    get.text = responseString
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")
                    get.text = responseString
                }

            })


        val paramsPost = RequestParams()
            .put("a", 1)
            .put("b", "two")
            .put("c", true)
            .put("d", 3.14F)
        paramsPost.useJson(false)

        AsyncHttpClient()
            .addHeader("auth", "token")
            .post("http://prog.net.ua/test.php", paramsPost, object : HttpResponseHelper {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")
                    post.text = responseString
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")
                    post.text = responseString
                }

            })


        val paramsPostJson = RequestParams()
            .put("a", 1)
            .put("b", "two")
            .put("c", true)
            .put("d", 3.14F)
            .put("e", 'c')
        paramsPostJson.useJson(true)

        AsyncHttpClient()
            .addHeader("auth", "token")
            .post("http://prog.net.ua/test.php", paramsPostJson, object : HttpResponseHelper {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")
                    post_json.text = responseString
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")
                    post_json.text = responseString
                }

            })


        val paramsPut = RequestParams()
            .put("a", 1)
            .put("b", "two")
            .put("c", true)
            .put("d", 3.14F)
        paramsPut.useJson(true)

        AsyncHttpClient()
            .addHeader("auth", "token")
            .put("http://prog.net.ua/test.php", paramsPut, object : HttpResponseHelper {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")
                    put.text = responseString
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")
                    put.text = responseString
                }

            })


        val paramsPatch = RequestParams()
            .put("a", 1)
            .put("b", "two")
            .put("c", true)
            .put("d", 3.14F)
        paramsPatch.useJson(true)

        AsyncHttpClient()
            .addHeader("auth", "token")
            .patch("http://prog.net.ua/test.php", paramsPatch, object : HttpResponseHelper {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")
                    patch.text = responseString
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")
                    patch.text = responseString
                }

            })


        val paramsDelete = RequestParams()
            .put("a", 1)
            .put("b", "two")
            .put("c", true)
            .put("d", 3.14F)
        paramsDelete.useJson(true)

        AsyncHttpClient()
            .addHeader("auth", "token")
            .delete("http://prog.net.ua/test.php", paramsDelete, object : HttpResponseHelper {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")
                    delete.text = responseString
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")
                    delete.text = responseString
                }

            })


        val paramsHead = RequestParams()
            .put("a", 1)
            .put("b", "two")
            .put("c", true)
            .put("d", 3.14F)
            .useJson(true)

        AsyncHttpClient()
            .addHeader("auth", "token")
            .head("http://prog.net.ua/test.php", paramsHead, object : HttpResponseHelper {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    val sb = StringBuffer()
                    sb.append(responseString)

                    headers?.forEach {
                        sb.append("\t")
                        sb.append(it.header)
                        sb.append(":")
                        sb.append(it.value)
                        sb.append("\n\r")
                    }

                    head.text = sb.toString()

                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseString: String?,
                    throwable: Throwable?
                ) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    val sb = StringBuffer()
                    sb.append(responseString)

                    headers?.forEach {
                        sb.append("\t")
                        sb.append(it.header)
                        sb.append(":")
                        sb.append("'")
                        sb.append(it.value)
                        sb.append("'")
                        sb.append("\n\r")
                    }

                    head.text = sb.toString()

                }

            })


    }

}

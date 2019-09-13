package andrey.shpilevoy.sample

import andrey.shpilevoy.http_client.AsyncHttpClient
import andrey.shpilevoy.http_client.Header
import andrey.shpilevoy.http_client.HttpResponse
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
        paramsGet.put("a", "1")
        paramsGet.put("b", "2")
        paramsGet.put("c", "3")

        AsyncHttpClient()
            //.setSSLContext(trustCert())
            .putHeader("auth", "token")
            //.get("https://apimobile.welcash.kiev.ua/v1/user/", params, object : HttpResponse{
            .get("http://prog.net.ua/test.php", paramsGet, object : HttpResponse {
                override fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    runOnUiThread {
                        get.text = responseString
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    runOnUiThread {
                        get.text = responseString
                    }
                }

            })


        val paramsPost = RequestParams()
        paramsPost.put("a", "1")
        paramsPost.put("b", "2")
        paramsPost.put("c", "3")
        paramsPost.json = false

        AsyncHttpClient()
            .putHeader("auth", "token")
            .post("http://prog.net.ua/test.php", paramsPost, object : HttpResponse {
                override fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    runOnUiThread {
                        post.text = responseString
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    runOnUiThread {
                        post.text = responseString
                    }
                }

            })


        val paramsPostJson = RequestParams()
        paramsPostJson.put("a", "1")
        paramsPostJson.put("b", "2")
        paramsPostJson.put("c", "3")
        paramsPostJson.json = true

        AsyncHttpClient()

            .putHeader("auth", "token")
            .post("http://prog.net.ua/test.php", paramsPostJson, object : HttpResponse {
                override fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    runOnUiThread {
                        post_json.text = responseString
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    runOnUiThread {
                        post_json.text = responseString
                    }
                }

            })



        val paramsPut = RequestParams()
        paramsPut.put("a", "1")
        paramsPut.put("b", "2")
        paramsPut.put("c", "3")
        paramsPut.json = true

        AsyncHttpClient()
            .putHeader("auth", "token")
            .put("http://prog.net.ua/test.php", paramsPut, object : HttpResponse {
                override fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    runOnUiThread {
                        put.text = responseString
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    runOnUiThread {
                        put.text = responseString
                    }
                }

            })



        val paramsPatch = RequestParams()
        paramsPatch.put("a", "1")
        paramsPatch.put("b", "2")
        paramsPatch.put("c", "3")
        paramsPatch.json = true

        AsyncHttpClient()
            .putHeader("auth", "token")
            .patch("http://prog.net.ua/test.php", paramsPatch, object : HttpResponse {
                override fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    runOnUiThread {
                        patch.text = responseString
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    runOnUiThread {
                        patch.text = responseString
                    }
                }

            })



        val paramsDelete = RequestParams()
        paramsDelete.put("a", "1")
        paramsDelete.put("b", "2")
        paramsDelete.put("c", "3")
        paramsDelete.json = true

        AsyncHttpClient()
            .putHeader("auth", "token")
            .delete("http://prog.net.ua/test.php", paramsDelete, object : HttpResponse {
                override fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    runOnUiThread {
                        delete.text = responseString
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    runOnUiThread {
                        delete.text = responseString
                    }
                }

            })



        val paramsHead = RequestParams()
        paramsHead.put("a", "1")
        paramsHead.put("b", "2")
        paramsHead.put("c", "3")
        paramsHead.json = true

        AsyncHttpClient()
            .putHeader("auth", "token")
            .head("http://prog.net.ua/test.php", paramsHead, object : HttpResponse {
                override fun onSuccess(statusCode: Int, headers: Array<Header?>?, responseString: String?) {
                    Log.d("AsyncHttpClient", "onSuccess $statusCode")
                    Log.d("AsyncHttpClient", "onSuccess $responseString")

                    runOnUiThread {

                        val sb = StringBuffer()
                        sb.append(responseString)

                        headers?.forEach {
                            sb.append("\t")
                            sb.append(it?.header)
                            sb.append(":")
                            sb.append(it?.value)
                            sb.append("\n\r")
                        }

                        head.text = sb.toString()
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<Header?>?, responseString: String?, throwable: Throwable?) {
                    Log.d("AsyncHttpClient", "onFailure $statusCode")
                    Log.d("AsyncHttpClient", "onFailure $responseString")

                    runOnUiThread {
                        val sb = StringBuffer()
                        sb.append(responseString)

                        headers?.forEach {
                            sb.append("\t")
                            sb.append(it?.header)
                            sb.append(":")
                            sb.append("'")
                            sb.append(it?.value)
                            sb.append("'")
                            sb.append("\n\r")
                        }

                        head.text = sb.toString()
                    }
                }

            })


    }

}

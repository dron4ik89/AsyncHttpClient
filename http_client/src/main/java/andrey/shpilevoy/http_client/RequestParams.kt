package andrey.shpilevoy.http_client

import java.io.File

class RequestParams {

    internal val map = HashMap<String, Any>()
    internal var json = false

    fun put(map: Map<String, Any>): RequestParams{
        this.map.putAll(map)
        return this
    }

    fun put(key: String, value: String) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: Int) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: Long) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: Short) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: Float) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: Double) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: File) : RequestParams{
        map[key] = value
        return this
    }

    fun useJson(value: Boolean) : RequestParams{
        json = value
        return this
    }

}
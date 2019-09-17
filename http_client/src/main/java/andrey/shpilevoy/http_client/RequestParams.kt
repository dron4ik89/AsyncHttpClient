package andrey.shpilevoy.http_client

import java.io.File

class RequestParams {

    internal val map = HashMap<String, Any>()
    internal var json = false

    fun putAll(map: Map<String, Any>): RequestParams{
        this.map.putAll(map)
        return this
    }

    fun put(key: String, value: String) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: Char) : RequestParams{
        map[key] = value
        return this
    }
    fun put(key: String, value: Byte) : RequestParams{
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
    fun put(key: String, value: Boolean) : RequestParams{
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

    fun remove(key: String) : Any?{
        return map.remove(key)
    }

    fun remove(key: String, value: Any) : Boolean{
        if(map[key] == value) {
            map.remove(key)
            return true
        }
        return false
    }

    fun clear(){
        map.clear()
    }

    fun clone() : RequestParams{
        val cloneParams = RequestParams()
        cloneParams.putAll(map)
        return cloneParams
    }

    fun size() : Int{
        return map.size
    }

    fun get(key: String) : Any?{
        return map[key]
    }

}
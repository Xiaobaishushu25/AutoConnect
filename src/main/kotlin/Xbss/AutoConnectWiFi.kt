package Xbss

import kong.unirest.Unirest
import kong.unirest.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


/**
 * @author  Xbss
 * @create 2022-09-16-12:41
 * @version  1.0
 * @describe
 */
fun main() {
    val url ="http://10.255.255.34/api/v1/login"
    val ipPath = "http://10.255.255.34/api/v1/ip"
    var ip = ""
    val data = readData()
    Unirest.get(ipPath).asString().body.apply {
        val regex = Regex("(?<=data\":\").*?(?=\"})")
        ip =regex.find(this)!!.value
    }
    val bodyData = mutableMapOf<String, Any>().apply {
        put("channel", getServicer(data[0]))
        put("ifautologin", "2")
        put("pagesign", "secondauth")
        put("password", data[2])
        put("username", data[1])
        put("usripadd", ip)
    }
    print(ip)
    println(data[0])
    println(data[1])
    println(data[2])
    val json = JSONObject(bodyData)
    println(Unirest.post(url).body(json).asString().body)
}
/**
 * TODO
 *
 * @return :一个列表，依次是：运营商、账号、密码
 */
fun readData():MutableList<String>{
    val path = "${System.getProperty("user.dir")}\\config.txt"
    val reader = BufferedReader(FileReader(File(path)))
    return mutableListOf<String>().apply {
        while (true){
            val data = reader.readLine()?:break
            add(data)
        }
    }
}
fun getServicer(servicer:String):Int{
    return when(servicer){
        "移动" -> 2
        "电信" -> 3
        "联通" -> 4
        else -> 0
    }
}
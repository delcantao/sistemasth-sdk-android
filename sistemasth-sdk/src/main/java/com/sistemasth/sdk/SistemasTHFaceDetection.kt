package com.sistemasth.sdk

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.Keep
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import br.com.nxcd.facedetection.NxcdFaceDetection
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


@Keep
class SistemasTHFaceDetection : NxcdFaceDetection {
    constructor(i: Int, s: String?) : super(i, s) {
    }

    constructor(i: Int, s: String?, @StyleRes res: Int) : super(i, s, res) {}



    @Keep
    companion object {

        @Keep
        const val RESULT = "result"

        @Keep
        const val THROWABLE = "throwable"

        @Keep
        const val IMAGE_RESULT = "image_result"

    }


    @Keep
    public override fun setHomologation() {
        super.setHomologation();
    }

    @Keep
    public override fun setDevelopment() {
        super.setDevelopment()
    }
    @Keep
    public override fun startFaceDetection(var1: Activity) {
        super.startFaceDetection(var1);
    }

    @Keep
    public override fun startFaceDetection(var1: Fragment) {
        super.startFaceDetection(var1)
    }

    @Keep
    public override fun startFaceDetection(var1: Context, var2: ActivityResultLauncher<Intent>) {
        super.startFaceDetection(var1, var2)
    }

    @Keep
    public override fun startDocumentDetection(var1: Activity) {
       super.startDocumentDetection(var1)
    }

    public override fun startDocumentDetection(var1: Fragment) {
        super.startDocumentDetection(var1)
    }

    @Keep
    public override fun startDocumentDetection(var1: Context, var2: ActivityResultLauncher<Intent>) {
        super.startDocumentDetection(var1, var2)
    }

    @Keep
    public override fun setTimeout(var1: Int) {
        super.setTimeout(var1)
    }

    private fun GravaTotais():String {
        return "Ola"
    }
    public fun TesteLF(t: String):String {
        return t + GravaTotais()
    }
    public fun GetRequest(GET_URL: String): String {
        val obj = URL(GET_URL)
        val con = obj.openConnection() as HttpURLConnection
        con.requestMethod = "GET"
//        con.setRequestProperty("User-Agent", USER_AGENT)
        val responseCode = con.responseCode
        println("GET Response Code :: $responseCode")
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            val `in` = BufferedReader(
                InputStreamReader(
                    con.inputStream
                )
            )
            var inputLine: String?
            val response = StringBuffer()
            while (`in`.readLine().also { inputLine = it } != null) {
                response.append(inputLine)
            }
            `in`.close()

            // print result
            println(response.toString())

            return response.toString();
        } else {
            println("GET request not worked")
        }
        return responseCode.toString();
    }
    public fun PostRequest(targetURL :String, urlParameters: String): String {
        var connection: HttpURLConnection? = null
        try {
            //Create connection
            val url = URL(targetURL)
            connection = url.openConnection() as HttpURLConnection?
            connection!!.requestMethod = "POST"
            connection.setRequestProperty(
                "Content-Type",
                "application/x-www-form-urlencoded"
            )
//            connection.setRequestProperty(
//                "Content-Length",
//                Integer.toString(urlParameters.getBytes().length)
//            )

            connection.setRequestProperty("Content-Language", "en-US")
            connection.useCaches = false
            connection.doOutput = true

            //Send request
            val wr = DataOutputStream(
                connection.outputStream
            )
            wr.writeBytes(urlParameters)
            wr.close()

            //Get Response
            val `is`: InputStream = connection.inputStream
            val rd = BufferedReader(InputStreamReader(`is`))
            val response = StringBuilder() // or StringBuffer if Java version 5+
            var line: String?
            while (rd.readLine().also { line = it } != null) {
                response.append(line)
                response.append('\r')
            }
            rd.close()
            return response.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            connection?.disconnect()
        }
        return ""
    }

}
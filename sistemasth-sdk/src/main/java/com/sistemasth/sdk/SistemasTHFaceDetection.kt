package com.sistemasth.sdk

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.Keep
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import br.com.nxcd.facedetection.NxcdFaceDetection
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager


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

    public fun factoryFaceDetection(i: Int, s: String?, @StyleRes res: Int) : NxcdFaceDetection {
        return NxcdFaceDetection(i, s, res)
    }
    public fun factoryFaceDetection(i: Int, s: String?) : NxcdFaceDetection {
        return NxcdFaceDetection(i, s)
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

    public fun IniciaDeteccaoFacial() {

        var request = Request()
        request.cliente = "TH"
        request.usuario = "TI"
        request.senha = "teste"
        gravaTotais(request)

    }

    private fun gravaTotais(request: Request): String {

        try {

            var dbHost = "(localdb)\\mssqllocaldb"
            var dbPort = "1433"
            var dbUsername = "sa"
            var dbPassword = "lalakaka"
            var dbName = "BIOMETRIA"
            var dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"

            var jdbcUrl = "jdbc:sqlserver://$dbHost:$dbPort;databaseName=$dbName"
    //        var sql = new SQLServerDriver(jdbcUrl, dbUsername, dbPassword, dbDriver)
            var con = DriverManager.getConnection("jdbc:jtds:sqlserver://$dbHost;databaseName=$dbName;user=$dbUsername;password=$dbPassword")
            var query = con.createStatement()
            query.executeQuery("INSERT INTO TOTAIS (CLIENTE, USUARIO, SENHA, CONSULTA) SELECT '${request.cliente}','${request.usuario}','${request.senha}','FACEDETECTION' ")
        } catch (ex: Exception) {
            return ex.message.toString()
        }
        return "success"
    }



    public class Request {
        var cliente: String = ""
        var usuario: String = ""
        var senha: String = ""


    }



}
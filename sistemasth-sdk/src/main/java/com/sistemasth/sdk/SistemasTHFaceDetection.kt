package com.sistemasth.sdk

import androidx.annotation.Keep
import androidx.annotation.StyleRes
import androidx.compose.runtime.Composable
import br.com.nxcd.facedetection.NxcdFaceDetection
import com.google.android.gms.common.annotation.KeepName
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import com.google.gson.annotations.Expose
import dagger.Module

@Keep
class SistemasTHFaceDetection : NxcdFaceDetection {
    constructor(i: Int, s: String?) : super(i, s) {
    }

    constructor(i: Int, s: String?, @StyleRes res: Int) : super(i, s, res) {}
}
class Teste {
    @Keep
    fun Teste():String{
        return "Teste";
    }
}
@KeepName
fun Teste(t: String): String {
    return t + "Hello";
}

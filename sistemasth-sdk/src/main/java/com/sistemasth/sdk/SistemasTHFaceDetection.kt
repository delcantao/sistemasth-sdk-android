package com.sistemasth.sdk

import androidx.annotation.Keep
import androidx.annotation.StyleRes
import br.com.nxcd.facedetection.NxcdFaceDetection

@Keep
class SistemasTHFaceDetection : NxcdFaceDetection {
    constructor(i: Int, s: String?) : super(i, s) {
    }

    constructor(i: Int, s: String?, @StyleRes res: Int) : super(i, s, res) {}

    @Keep
    val RESULT = "result"

    @Keep
    val THROWABLE = "throwable"

    @Keep
    val IMAGE_RESULT = "image_result"

}
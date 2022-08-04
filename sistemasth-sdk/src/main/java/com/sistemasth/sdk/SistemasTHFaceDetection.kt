package com.sistemasth.sdk

import androidx.annotation.StyleRes
import br.com.nxcd.facedetection.NxcdFaceDetection

class SistemasTHFaceDetection : NxcdFaceDetection {
    constructor(i: Int, s: String?) : super(i, s) {
    }

    constructor(i: Int, s: String?, @StyleRes res: Int) : super(i, s, res) {}
}

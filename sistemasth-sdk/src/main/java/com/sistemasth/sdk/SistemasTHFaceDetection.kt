package com.sistemasth.sdk

import androidx.annotation.Keep
import androidx.annotation.StyleRes
import br.com.nxcd.facedetection.NxcdFaceDetection

import a.a.a.a.b.a.a
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import br.com.nxcd.facedetection.features.documentdetection.activities.DocumentDetectionActivity
import br.com.nxcd.facedetection.features.facedetection.activities.FaceDetectionActivity


@Keep
class SistemasTHFaceDetection : NxcdFaceDetection {
    constructor(i: Int, s: String?) : super(i, s) {
    }

    constructor(i: Int, s: String?, @StyleRes res: Int) : super(i, s, res) {}


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
        super.startDocumentDetection(var1)
    }

    @Keep
    public override fun startFaceDetection(var1: Context, var2: ActivityResultLauncher<Intent>) {
        super.startFaceDetection(var1, var2)
    }

    @Keep
    public override fun startDocumentDetection(var1: Activity) {
       super.startFaceDetection(var1)
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




}
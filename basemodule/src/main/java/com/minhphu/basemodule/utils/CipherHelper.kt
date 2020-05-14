package com.minhphu.basemodule.utils

import android.util.Base64

import com.scottyab.aescrypt.AESCrypt

import java.security.GeneralSecurityException

import javax.crypto.spec.SecretKeySpec

object CipherHelper {

    private var ivParam: String? = null
    private var secretKeySpec: SecretKeySpec? = null

    fun init(devPage: String,key:String) {
        ivParam = devPage.substring(devPage.length - 16, devPage.length)
        secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
    }

    fun decrypt(str: String): String {
        try {
            val mess = Base64.decode(str, Base64.DEFAULT)
            val res = AESCrypt.decrypt(secretKeySpec, ivParam!!.toByteArray(), mess)
            return String(res)
        } catch (e: GeneralSecurityException) {
            e.printStackTrace()
        }

        return ""
    }
}

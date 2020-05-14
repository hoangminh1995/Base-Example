package com.minhphu.basemodule.extensions

import android.net.Uri
import android.util.Base64
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.io.File
fun ImageView.loadImageBase64(base64ImageString:String){
    try {
        Glide.with(context)
                .asBitmap()
                .load(Base64.decode(base64ImageString, Base64.DEFAULT))
                .into(this)
    }
    catch (ex: Exception){}
}

fun ImageView.loadImageUrl(url: String) {
    Glide.with(context)
            .load(url)
            .into(this)
}

fun ImageView.loadImageFromFilePath(filePath: String) {
    val file = File(filePath)
    if(file.exists()) {
        Glide.with(context)
                .setDefaultRequestOptions(RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                .load(Uri.fromFile(File(filePath)))
                .into(this)
    }else{
        Log.e("minh","file not exist "+filePath)
    }
}
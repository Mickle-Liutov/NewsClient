package com.sample.newsclient.core.context

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.startWebIntent(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    try {
        startActivity(intent)
    } catch (ignored: Exception) {
    }
}
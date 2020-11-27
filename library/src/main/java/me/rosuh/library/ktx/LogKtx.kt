package me.rosuh.library.ktx

import me.rosuh.library.Logger

fun lgi(tag: String?, msg: String?) {
    Logger.i(tag, msg)
}

fun lgd(tag: String?, msg: String?) {
    Logger.d(tag, msg)
}

fun lgv(tag: String?, msg: String?) {
    Logger.v(tag, msg)
}

fun lge(tag: String?, msg: String?) {
    Logger.e(tag, msg)
}
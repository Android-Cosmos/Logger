package me.rosuh.library.delegate

import android.util.Log
import me.rosuh.library.delegate.LogDelegate


class SysLogDelegate : LogDelegate() {
    override fun init() {

    }

    override fun enable(isEnable: Boolean) {

    }

    override fun v(tag: String?, msg: String?) {
        if (isEnable) {
            Log.v(tag, msg ?: "")
        }
    }

    override fun d(tag: String?, msg: String?) {
        if (isEnable) {
            Log.d(tag, msg ?: "")
        }
    }

    override fun i(tag: String?, msg: String?) {
        if (isEnable) {
            Log.i(tag, msg ?: "")
        }
    }

    override fun w(tag: String?, msg: String?) {
        if (isEnable) {
            Log.w(tag, msg ?: "")
        }
    }

    override fun e(tag: String?, msg: String?) {
        if (isEnable) {
            Log.e(tag, msg ?: "")
        }
    }

    override fun wtf(tag: String?, msg: String?) {
        if (isEnable) {
            Log.wtf(tag, msg)
        }
    }

    override fun write(tag: String?, msg: String?) {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

}
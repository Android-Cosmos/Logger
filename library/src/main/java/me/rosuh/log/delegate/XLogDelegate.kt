package me.rosuh.log.delegate

import com.tencent.mars.xlog.Log
import com.tencent.mars.xlog.Xlog
import me.rosuh.log.Logger
import java.lang.IllegalStateException

class XLogDelegate : LogDelegate() {
    override fun init() {
        if (Logger.cacheDir.isBlank()) {
            throw IllegalStateException("Cache Dir could't be null if you want to using XLog.")
        }
        // do noting
        System.loadLibrary("c++_shared")
        System.loadLibrary("marsxlog")
        val xLog = Xlog()
        Log.setLogImp(xLog)
        Log.appenderOpen(
            convertXLogLevel(),
            Xlog.ZLIB_MODE,
            Logger.cacheDir,
            Logger.outPutDir,
            Logger.namePrefix,
            1
        )
        Log.setConsoleLogOpen(true)
    }

    private fun convertXLogLevel(): Int {
        return when (Logger.level) {
            2 -> Xlog.LEVEL_VERBOSE
            3 -> Xlog.LEVEL_DEBUG
            4 -> Xlog.LEVEL_INFO
            5 -> Xlog.LEVEL_WARNING
            6 -> Xlog.LEVEL_ERROR
            7 -> Xlog.LEVEL_ERROR
            else -> {
                Xlog.LEVEL_ALL
            }
        }
    }

    override fun enable(isEnable: Boolean) {
        this.isEnable = isEnable
    }

    override fun v(tag: String?, msg: String?) {
        if (isEnable) {
            Log.v(tag, msg)
        }
    }

    override fun d(tag: String?, msg: String?) {
        if (isEnable) {
            Log.d(tag, msg)
        }
    }

    override fun i(tag: String?, msg: String?) {
        if (isEnable) {
            Log.i(tag, msg)
        }
    }

    override fun w(tag: String?, msg: String?) {
        if (isEnable) {
            Log.w(tag, msg)
        }
    }

    override fun e(tag: String?, msg: String?) {
        if (isEnable) {
            Log.e(tag, msg)
        }
    }

    override fun wtf(tag: String?, msg: String?) {
        if (isEnable) {
            Log.e(tag, msg)
        }
    }

    override fun write(tag: String?, msg: String?) {
        TODO("Not yet implemented")
    }

    override fun close() {
        Log.appenderClose()
    }

    override fun clear() {
        Log.appenderClose()
    }
}
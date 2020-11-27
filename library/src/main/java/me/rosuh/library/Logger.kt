package me.rosuh.library

import androidx.annotation.IntRange
import me.rosuh.library.delegate.ILogger
import me.rosuh.library.delegate.LogDelegate

object Logger : ILogger {

    internal var enable: Boolean = true

    private lateinit var delegate: LogDelegate


    @IntRange(from = 2, to = 7)
    internal var level: Int = 2


    internal var outPutDir: String = ""

    internal var cacheDir: String = ""


    internal var type: LoggerType = LoggerType.XLog


    internal var encrypt: Boolean = false

    internal var namePrefix: String = ""

    private fun internalInit() {
        delegate = LogDelegate.delegateBy(type)
        LogDelegate.delegateBy(type).init()
    }

    fun rebuild(): Initialize {
        return Initialize()
    }

    data class Initialize(
        internal var enable: Boolean = true,
        @IntRange(from = 2, to = 7) var level: Int = 2,
        internal var cacheDir: String = "",
        internal var outPutDir: String = "",
        internal var type: LoggerType = LoggerType.XLog,
        internal var encrypt: Boolean = false,
        internal var namePrefix: String = ""
    ) {
        fun enable(enable: Boolean) = apply { this.enable = enable }
        fun level(level: Int) = apply { this.level = level }
        fun outputDir(outPutDir: String) = apply { this.outPutDir = outPutDir }
        fun cacheDir(cacheDir: String) = apply { this.cacheDir = cacheDir }
        fun type(type: LoggerType) = apply { this.type = type }
        fun encrypt(isEncrypt: Boolean) = apply { this.encrypt = isEncrypt }
        fun namePrefix(namePrefix: String) = apply { this.namePrefix = namePrefix }

        fun init() {
            Logger.also {
                Logger.enable = enable
                Logger.encrypt = encrypt
                Logger.outPutDir = outPutDir
                Logger.cacheDir = cacheDir
                Logger.level = level
                Logger.type = type
                Logger.namePrefix = namePrefix
                internalInit()
            }
        }

    }

    override fun enable(isEnable: Boolean) {
        delegate.enable(isEnable)
    }

    override fun v(tag: String?, msg: String?) {
        delegate.v(tag, msg)
    }

    override fun d(tag: String?, msg: String?) {
        delegate.d(tag, msg)
    }

    override fun i(tag: String?, msg: String?) {
        delegate.i(tag, msg)
    }

    override fun w(tag: String?, msg: String?) {
        delegate.w(tag, msg)
    }

    override fun e(tag: String?, msg: String?) {
        delegate.e(tag, msg)
    }

    override fun wtf(tag: String?, msg: String?) {
        delegate.wtf(tag, msg)
    }

    override fun write(tag: String?, msg: String?) {
        delegate.write(tag, msg)
    }

    override fun close() {
        delegate.close()
    }

    override fun clear() {
        delegate.clear()
    }


    sealed class LoggerType {
        object XLog : LoggerType()
        object SysLog : LoggerType()
    }
}
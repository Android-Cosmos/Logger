package me.rosuh.library.delegate

import me.rosuh.library.Logger

abstract class LogDelegate : ILogger {

    protected var isEnable = true

    abstract fun init()

    companion object {
        fun delegateBy(type: Logger.LoggerType): LogDelegate {
            return when (type) {
                Logger.LoggerType.XLog -> {
                    XLogDelegate()
                }
                Logger.LoggerType.SysLog -> {
                    SysLogDelegate()
                }
            }
        }
    }
}
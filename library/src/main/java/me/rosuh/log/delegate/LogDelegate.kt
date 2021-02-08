package me.rosuh.log.delegate

import me.rosuh.log.Logger

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
package me.rosuh.log.delegate

interface ILogger {
    fun enable(isEnable: Boolean)

    fun v(tag: String?, msg: String?)

    fun d(tag: String?, msg: String?)

    fun i(tag: String?, msg: String?)

    fun w(tag: String?, msg: String?)

    fun e(tag: String?, msg: String?)

    fun wtf(tag: String?, msg: String?)

    fun write(tag: String?, msg: String?)

    fun close()

    fun clear()
}
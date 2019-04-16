package com.frame.mvp.common.http

import java.lang.Exception

open class BusinessException : Exception {
    private var code: Int? = null
        get() = code

    constructor(code: Int, message: String?, exception: Exception) : super(message, exception) {
        this.code = code
    }

    constructor(code: Int, message: String?) : super(message) {
        this.code = code
    }

    constructor(message: String?) : super(message)

    constructor(message: String?, exception: Exception) : super(message, exception)

}
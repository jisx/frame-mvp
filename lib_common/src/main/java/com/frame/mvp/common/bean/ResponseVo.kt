package com.frame.mvp.common.bean

/**
 * Created by jsx on 2019/2/28.
 */
data class ResponseVo<T>(
    var code: Int = 0,
    var message: String?,
    var data: T?,
    var page: PageModel?,
    var throwable: Throwable?
) {
    fun isSuccess(): Boolean {
        return code == 0
    }
}

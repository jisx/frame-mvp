package com.frame.mvp.common.http.progress

/**
 * 文件上传进度监听
 *
 * @author jisx
 */
interface UploadProgressListener {
    fun onProgress(bytesWritten: Long, contentLength: Long, hasFinish: Boolean)
}

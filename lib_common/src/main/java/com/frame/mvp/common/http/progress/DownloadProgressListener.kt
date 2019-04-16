package com.frame.mvp.common.http.progress

/**
 * 文件下载进度监听
 */
interface DownloadProgressListener {
    fun onLoading(totalLength: Long, totalBytesRead: Long)
}

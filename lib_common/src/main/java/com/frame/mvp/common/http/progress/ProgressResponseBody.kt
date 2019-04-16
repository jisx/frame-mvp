package com.frame.mvp.common.http.progress

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.*

import java.io.IOException

/**
 * 文件下载
 *
 * @author jisx
 */
class ProgressResponseBody(
    private val mResponseBody: ResponseBody,
    private val mProgressListener: DownloadProgressListener
) : ResponseBody() {
    private var mBufferedSource: BufferedSource? = null

    override fun contentType(): MediaType? {
        return mResponseBody.contentType()
    }

    override fun contentLength(): Long {
        return mResponseBody.contentLength()
    }

    override fun source(): BufferedSource? {
        if (mBufferedSource == null) {
            mBufferedSource = Okio.buffer(source(mResponseBody.source()))
        }
        return mBufferedSource
    }

    /**
     * 回调进度接口
     *
     * @param source source
     * @return Source
     */
    private fun source(source: Source): Source {
        return object : ForwardingSource(source) {
            var totalBytesRead = 0L

            @Throws(IOException::class)
            override fun read(sink: Buffer, byteCount: Long): Long {
                val bytesRead = super.read(sink, byteCount)
                totalBytesRead += if (bytesRead != -1L) {
                    bytesRead
                } else 0
                mProgressListener.onLoading(mResponseBody.contentLength(), totalBytesRead)
                return bytesRead
            }
        }
    }
}

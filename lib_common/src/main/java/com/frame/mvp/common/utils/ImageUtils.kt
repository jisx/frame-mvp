package com.frame.mvp.common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 *
 *  图片加载工具类
 *
 * @name ImageUtils
 */
object ImageUtils {

    /**
     * 默认加载
     */
    fun loadImageView(path: String, mImageView: ImageView) {
        Glide.with(mImageView.context).load(path).into(mImageView)
    }

    fun loadImageWithError(path: String, errorRes: Int, mImageView: ImageView) {
        Glide.with(mImageView.context)
            .load(path).dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(errorRes)
            .into(mImageView)
    }

    /**
     * 设置加载中以及加载失败图片
     */
    fun loadImageWithLoading(path: String, mImageView: ImageView, lodingImage: Int, errorRes: Int) {
        Glide.with(mImageView.context).load(path).placeholder(lodingImage).error(errorRes).into(mImageView)
    }

    /**
     * 设置加载动画
     * api也提供了几个常用的动画：比如crossFade()
     */
    fun loadImageViewAnim(path: String, mImageView: ImageView) {
        Glide.with(mImageView.context).load(path).dontAnimate().into(mImageView)
    }

}
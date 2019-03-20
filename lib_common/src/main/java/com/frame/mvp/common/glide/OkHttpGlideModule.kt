package com.frame.mvp.common.glide

import android.content.Context

import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.module.GlideModule

/**
 * A [GlideModule] implementation to replace Glide's default
 * [java.net.HttpURLConnection] based [com.bumptech.glide.load.model.ModelLoader] with an OkHttp based
 * [com.bumptech.glide.load.model.ModelLoader].
 *
 *
 *
 *
 * If you're using gradle, you can include this module simply by depending on the aar, the module will be merged
 * in by manifest merger. For other build systems or for more more information, see
 * [GlideModule].
 *
 */
class OkHttpGlideModule : GlideModule {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {

        val calculator = MemorySizeCalculator.Builder(context).build();
        val defaultMemoryCacheSize = calculator.memoryCacheSize
        val defaultBitmapPoolSize = calculator.bitmapPoolSize

        val customMemoryCacheSize = (1.2 * defaultMemoryCacheSize).toInt()
        val customBitmapPoolSize = (1.2 * defaultBitmapPoolSize).toInt()

        builder.setMemoryCache(LruResourceCache(customMemoryCacheSize.toLong()))
        builder.setBitmapPool(LruBitmapPool(customBitmapPoolSize.toLong()))
    }

}

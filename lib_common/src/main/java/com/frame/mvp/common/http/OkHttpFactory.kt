package com.frame.mvp.common.http


import com.frame.mvp.common.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.io.InputStream
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

/**
 * Created by jisx on 2017/6/20.
 */

internal object OkHttpFactory {

    fun httpRetrofit(baseUrlEnum: BaseUrlEnum): Retrofit {
        return createRetrofit(okHttpClient, baseUrlEnum)
    }

    fun httpsRetrofit(inputStream: InputStream?, baseUrlEnum: BaseUrlEnum): Retrofit {
        return createRetrofit(getOkHttpsClient(inputStream), baseUrlEnum)
    }

    private fun createRetrofit(okHttpClient: OkHttpClient, baseUrlEnum: BaseUrlEnum): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrlEnum.url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private val okHttpClient: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(loggingInterceptor)
            }
            builder.connectTimeout(HttpConfig.timeOut, TimeUnit.SECONDS)
            return builder.build()
        }


    @Throws(
        CertificateException::class,
        NoSuchAlgorithmException::class,
        KeyStoreException::class,
        KeyManagementException::class,
        IOException::class
    )

    private fun getOkHttpsClient(inputStream: InputStream?): OkHttpClient {

        var keyStore: KeyStore? = null

        if (inputStream != null) {
            //提供证书的情况下
            val certificateFactory = CertificateFactory.getInstance("X.509")
            val certificate = certificateFactory.generateCertificate(inputStream)

            keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
            keyStore!!.load(null)
            keyStore.setCertificateEntry("trust", certificate)

            inputStream.close()
        }

        val sslContext = SSLContext.getInstance("TLS")

        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(keyStore)

        val trustManagers = trustManagerFactory.trustManagers

        if (trustManagers.size != 1 || trustManagers[0] !is X509TrustManager) {
            throw IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers))
        }

        val trustManager = trustManagers[0] as X509TrustManager
        sslContext.init(null, arrayOf<TrustManager>(trustManager), SecureRandom())
        val builder = OkHttpClient.Builder()
            .sslSocketFactory(sslContext.socketFactory, trustManager)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }
        builder.connectTimeout(15, TimeUnit.SECONDS)
        builder.hostnameVerifier { _, _ -> true }
        return builder.build()
    }

    /**
     * 打印日志
     */
    private val loggingInterceptor: HttpLoggingInterceptor
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return loggingInterceptor
        }

}

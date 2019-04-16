package com.frame.mvp.common.http

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.before(doOnSubscribe: () -> Unit): Single<T> {
    return this.subscribeOn(Schedulers.io())
        .doOnSubscribe { doOnSubscribe() }
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())
}
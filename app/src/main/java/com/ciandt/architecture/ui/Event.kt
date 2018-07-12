package com.ciandt.architecture.ui

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

fun <T> LiveData<Event<T>>.subscribe(owner: LifecycleOwner, body: (T) -> Unit) {
    observe(owner, Observer {
        it?.getContentIfNotHandled()?.let { body(it) }
    })
}
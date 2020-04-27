package com.cazimir.utilitieslibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

// observe once until a true is delivered then terminate (remove observer)
fun <T> LiveData<T>.observeOnceWithTrue(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            if (t as Boolean) {
                observer.onChanged(t)
                removeObserver(this)
            }

        }
    })
}

// observe once until a non empty list is delivered then terminate (remove observer)
fun <T> LiveData<T>.observeOnceOnListNotEmpty(observer: Observer<T>) {
    observeForever(object : Observer<T> {
        override fun onChanged(t: T?) {
            val list = t as List<*>
            if (list.isNotEmpty()) {
                observer.onChanged(t)
                removeObserver(this)
            }

        }
    })
}

// observe once until a non empty list is delivered then terminate (remove observer)
fun <T> LiveData<T>.observeOnceOnListNotEmptyWithOwner(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            val list = t as List<*>
            if (list.isNotEmpty()) {
                observer.onChanged(t)
                removeObserver(this)
            }

        }
    })
}
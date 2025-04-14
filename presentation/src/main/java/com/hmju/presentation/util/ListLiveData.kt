package com.hmju.presentation.util

import androidx.lifecycle.MutableLiveData

class ListLiveData<T> : MutableLiveData<List<T>>() {
    private val temp: MutableList<T> by lazy { mutableListOf() }

    init {
        value = temp
    }

    override fun getValue() = super.getValue()!!
    val size: Int get() = value.size
    operator fun get(idx: Int) =
        if (size > idx) value[idx] else throw ArrayIndexOutOfBoundsException("Index $idx Size $size")

    fun add(item: T) {
        temp.add(item)
        value = temp
    }

    fun addAll(list: List<T>) {
        temp.addAll(list)
        value = temp
    }

    fun removeAt(idx: Int) {
        temp.removeAt(idx)
        value = temp
    }

    fun clear() {
        temp.clear()
        value = temp
    }
}
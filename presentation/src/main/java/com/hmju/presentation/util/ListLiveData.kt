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

    fun add(index: Int, item: T) {
        temp.add(index, item)
        value = temp
    }

    fun addAll(list: List<T>) {
        temp.addAll(list)
        value = temp
    }

    fun remove(item: T) {
        temp.remove(item)
        value = temp
    }

    fun removeAll(item: List<T>) {
        temp.removeAll(item)
        value = temp
    }

    fun removeAt(index: Int) {
        temp.removeAt(index)
        value = temp
    }

    fun contains(item: T): Boolean {
        return value.contains(item)
    }

    fun data(): List<T> {
        return temp.toList()
    }

    fun indexOf(item: T): Int {
        return value.indexOf(item)
    }

    fun set(idx: Int, item: T) {
        temp[idx] = item
        value = temp
    }

    fun filter(predicate: (T) -> Boolean): List<T> {
        value = temp.filter(predicate).toMutableList()
        return value
    }

    fun filtered(predicate: (T) -> Boolean): List<T> {
        val filterList = temp.filter(predicate)
        temp.clear()
        temp.addAll(filterList)
        value = temp
        return temp
    }

    fun clear() {
        temp.clear()
        value = temp
    }
}
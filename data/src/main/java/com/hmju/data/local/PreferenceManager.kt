package com.hmju.data.local

interface PreferenceManager {
    fun setString(key: String, value: String?)
    fun getString(key: String): String

    companion object {
        const val KEY_PRODUCT_LIKE = "product_like"
    }
}

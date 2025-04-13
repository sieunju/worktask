package com.hmju.data.impl

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.hmju.data.local.PreferenceManager


internal class PreferenceManagerImpl(
    context: Context
) : PreferenceManager {

    private val pref: SharedPreferences by lazy {
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    override fun setString(key: String, value: String?) {
        pref.edit { putString(key, value) }
    }

    override fun getString(key: String): String {
        return pref.getString(key, "") ?: ""
    }

    override fun removeKey(key: String) {
        pref.edit { removeKey(key) }
    }
}

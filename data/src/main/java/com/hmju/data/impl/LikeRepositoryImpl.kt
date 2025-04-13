package com.hmju.data.impl

import com.hmju.data.local.PreferenceManager
import com.hmju.data.local.PreferenceManager.Companion.KEY_PRODUCT_LIKE
import com.hmju.domain.repository.LikeRepository
import java.util.prefs.Preferences
import javax.inject.Inject

internal class LikeRepositoryImpl @Inject constructor(
    private val prefManager: PreferenceManager
) : LikeRepository {

    override suspend fun fetchIds(): List<Long> {
        val str = prefManager.getString(KEY_PRODUCT_LIKE)
        if (str.isEmpty()) return listOf()
        return str.split(",").mapNotNull { it.toLongOrNull() }
    }

    override suspend fun add(id: Long): Boolean {
        val ids = fetchIds().toMutableList()
        if (ids.contains(id)) {
            ids.remove(id)
        }
        ids.add(id)
        var value = ids.joinToString(",")
        // SharedPreferences 에서 저장 가능한 범위를 초과하는 경우 가장 오래된 찜하기 제거
        while (value.length > Preferences.MAX_VALUE_LENGTH && ids.isNotEmpty()) {
            ids.removeAt(0)
            value = ids.joinToString(",")
        }
        prefManager.setString(KEY_PRODUCT_LIKE, value)
        return true
    }

    override suspend fun remove(id: Long): Boolean {
        val ids = fetchIds().toMutableList()
        ids.remove(id)
        prefManager.setString(KEY_PRODUCT_LIKE, ids.joinToString(","))
        return true
    }
}

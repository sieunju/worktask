package com.hmju.domain.shared

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Description : 좋아요한 상품 매니저 클래스
 *
 * Created by juhongmin on 2025. 4. 14.
 */
object LikeManager {

    private val _sharedState = MutableSharedFlow<Int>(replay = 0, extraBufferCapacity = 1)

    private val ids: HashSet<Int> by lazy { hashSetOf() }

    fun addAll(ids: List<Int>) {
        this.ids.addAll(ids)
    }

    fun add(id: Int) {
        ids.add(id)
        _sharedState.tryEmit(id)
    }

    fun remove(id: Int) {
        ids.remove(id)
        _sharedState.tryEmit(id)
    }

    fun isLike(id: Int): Boolean {
        return ids.contains(id)
    }

    fun observer(): SharedFlow<Int> {
        return _sharedState.asSharedFlow()
    }
}
package com.hmju.presentation.listener

/**
 * Description : 찜하기 리스너 인터페이스
 *
 * Created by juhongmin on 2025. 4. 13.
 */
interface LikeListener {
    fun onAddLike(id: Int)
    fun onRemoveLike(id: Int)
}
package com.hmju.domain.enums

enum class ProductViewType(
    val key: String
) {
    VERTICAL("vertical"),
    HORIZONTAL("horizontal"),
    GRID("grid");

    companion object {
        fun from(
            type: String
        ): ProductViewType? {
            return entries.firstOrNull { it.key == type }
        }
    }
}
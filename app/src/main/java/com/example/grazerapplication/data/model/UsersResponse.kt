package com.example.grazerapplication.data.model

data class UsersResponse(
    val status: Int,
    val status_desc: String,
    val data: UsersData
) {
    data class UsersData(
        val users: List<User>,
        val meta: Meta
    ) {
        data class Meta(
            val item_count: Int,
            val total_pages: Int,
            val current_page: Int
        )
    }
}
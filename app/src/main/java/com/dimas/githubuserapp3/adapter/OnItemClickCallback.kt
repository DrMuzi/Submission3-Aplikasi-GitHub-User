package com.dimas.githubuserapp3.adapter

import com.dimas.githubuserapp3.datasource.UserResponse

interface OnItemClickCallback {
    fun onItemClicked(user: UserResponse)
}
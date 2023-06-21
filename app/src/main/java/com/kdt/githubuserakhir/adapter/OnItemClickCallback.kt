package com.kdt.githubuserakhir.adapter

import com.kdt.githubuserakhir.datasource.UserResponse

interface OnItemClickCallback {
    fun onItemClicked(user: UserResponse)
}
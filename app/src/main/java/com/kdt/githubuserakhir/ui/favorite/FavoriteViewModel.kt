package com.kdt.githubuserakhir.ui.favorite

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kdt.githubuserakhir.database.FavoriteEntity
import com.kdt.githubuserakhir.repository.FavoriteRepository

class FavoriteViewModel(application : Application) : ViewModel() {
    private val mFavRepository : FavoriteRepository = FavoriteRepository(application)
    fun getAllFavorites() : LiveData<List<FavoriteEntity>> = mFavRepository.getAllFavorites()
}
package com.kdt.githubuserakhir.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.kdt.githubuserakhir.database.FavoriteDao
import com.kdt.githubuserakhir.database.FavoriteEntity
import com.kdt.githubuserakhir.database.FavoriteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteRepository(application: Application) {
    private val favDao: FavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FavoriteRoomDatabase.getDatabase(application)
        favDao = db.favDao()
    }

    fun getAllFavorites(): LiveData<List<FavoriteEntity>> = favDao.getAllFavorite()
    fun getUserFavoriteById(id: Int): LiveData<List<FavoriteEntity>> =
        favDao.getUserFavoriteById(id)

    fun insert(fav: FavoriteEntity) {
        executorService.execute { favDao.insert(fav) }
    }

    fun delete(fav: FavoriteEntity) {
        executorService.execute { favDao.delete(fav) }
    }
}

package com.kdt.githubuserakhir.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kdt.githubuserakhir.datasource.UserResponse
import com.kdt.githubuserakhir.repository.UserRepository
import com.kdt.githubuserakhir.ui.setting.SettingPreferences
import kotlinx.coroutines.launch

class MainViewModel(private val pref: SettingPreferences) : ViewModel() {

    val user: LiveData<ArrayList<UserResponse>?> = UserRepository.user
    val searchUser: LiveData<ArrayList<UserResponse>?> = UserRepository.userSearch
    val isLoading: LiveData<Boolean> = UserRepository.isLoading
    val isDataFailed: LiveData<Boolean> = UserRepository.isDataFailed

    init {
        viewModelScope.launch{
            UserRepository.getListUser()
        }

    }
    fun getThemeSettings(): LiveData<Boolean> {
        return pref.getThemeSetting().asLiveData()
    }
    override fun onCleared() {
        super.onCleared()
        UserRepository.viewModelJob.cancel()
    }
}
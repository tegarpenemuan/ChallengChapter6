package com.tegarpenemuan.challengchapter6.repository

import com.tegarpenemuan.challengchapter6.data.api.auth.AuthApi
import com.tegarpenemuan.challengchapter6.data.api.auth.SignInRequest
import com.tegarpenemuan.challengchapter6.data.api.auth.SignInResponse
import com.tegarpenemuan.challengchapter6.data.api.auth.SignUpResponse
import com.tegarpenemuan.challengchapter6.data.local.UserDAO
import com.tegarpenemuan.challengchapter6.data.local.UserEntity
import com.tegarpenemuan.challengchapter6.datastore.DataStoreManager
import retrofit2.Response

/**
 * com.tegarpenemuan.challengchapter6.repository
 *
 * Created by Tegar Penemuan on 31/05/2022.
 * https://github.com/tegarpenemuanr3
 *
 */

class AuthRepository(
    private val dataStoreManager: DataStoreManager,
    private val api: AuthApi,
    private val dao: UserDAO,
) {
    suspend fun setUsername(value: String) {
        dataStoreManager.setPrefUsername(value)
    }

    suspend fun getUsername(): String? {
        return dataStoreManager.getPrefUsername()
    }

    suspend fun setPassword(value: String) {
        dataStoreManager.setPrefPassword(value)
    }

    suspend fun getPassword(): String? {
        return dataStoreManager.getPrefPassword()
    }

    suspend fun setPrefLogin(value: Boolean) {
        dataStoreManager.setPrefLogin(value)
    }

    suspend fun insertUser(userEntity: UserEntity): Long {
        return dao.insertUser(userEntity)
    }

//    suspend fun signIn(request: SignInRequest): Response<SignInResponse> {
//        return api.login(request)
//    }
}
package com.example.core.session.di

import com.example.core.session.api.SessionRepository
import com.example.core.session.api.TokenStorage
import com.example.core.session.data.TokenStorageImpl
import com.example.core.session.impl.SessionRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [StorageModule::class])
interface SessionModule {

    @Binds
    fun bindsSessionRepository(impl: SessionRepositoryImpl): SessionRepository

    @Binds
    fun bindTokenStorage(impl: TokenStorageImpl): TokenStorage

}

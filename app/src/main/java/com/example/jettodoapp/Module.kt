package com.example.jettodoapp

import android.content.Context
import androidx.room.Room
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {
    //AppDatabaseのインスタンスを生成
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, AppDatabase::class.java, "task_database").build()

    //taskDaoのインスタンを作成
    @Provides
    fun provideDao(db: AppDatabase) = db.taskDao()
}
package com.example.movieapp.core.source.local

import com.example.movieapp.core.source.local.dao.Authdao
import com.example.movieapp.core.source.local.entity.AuthEntity
import com.example.movieapp.util.Constans

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        AuthEntity::class,
    ], version = Constans.DB_VERSION, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun authDao(): Authdao
}
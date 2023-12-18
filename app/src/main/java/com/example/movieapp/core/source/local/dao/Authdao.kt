package com.example.movieapp.core.source.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.example.movieapp.core.source.local.entity.AuthEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Authdao {
    @Insert(onConflict = REPLACE)
    fun insert(data: AuthEntity)

    @Insert(onConflict = REPLACE)
    fun insert(data: List<AuthEntity>)

    @Update
    fun update(data: AuthEntity)

    @Query("SELECT * from AuthEntity ORDER BY id ASC")
    fun getAll(): Flow<List<AuthEntity>>

}
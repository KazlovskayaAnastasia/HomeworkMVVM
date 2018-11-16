package com.nastia.administrator.data.dao

import android.arch.persistence.room.*
import com.nastia.administrator.data.OwlDb
import io.reactivex.Observable

@Dao
interface OwlDao {

    @Insert
    fun insert(vararg student: List<OwlDb>)

    @Update
    fun update(student: OwlDb)

    @Delete
    fun delete(student: OwlDb) // удалить одного студента

    @Query("DELETE FROM owl")
    fun deleteAll() // удалить всех студентов

    @Query("DELETE FROM owl WHERE id = :id")
    fun deleteById(id: String) // удалить по id

    @Query("SELECT * FROM owl ORDER BY name")
    fun getAll(): Observable<List<OwlDb>>

    @Query("SELECT * FROM owl WHERE id = :id LIMIT 1")
    fun getById(id: String): Observable<List<OwlDb>>
}
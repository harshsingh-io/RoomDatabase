package com.codeenemy.roomdatabases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Insert
    suspend fun insert(employeeEntity: EmployeeEntity)

    @Update
    suspend fun update(employeeEntity: EmployeeEntity)

    @Delete
    suspend fun delete(employeeEntity: EmployeeEntity)

    @Query("SELECT*FROM `employee-table`")
    fun fetchAllEmployees():Flow<List<EmployeeEntity>> // By this flow we don't have to tell the
    // recvcler View to update the value as it has inbuilt property of updating the list by itself
    @Query("SELECT*FROM `employee-table` where id=:id")
    fun fetchEmployeeById(id: Int):Flow<EmployeeEntity>
}
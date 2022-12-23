package com.upax.androidproject.core.domain.repositoryabstraction

interface BasicLocalRepository<M> {

    suspend fun insert(model: M): Long

    suspend fun insert(models: List<M>)

    suspend fun update(model: M)

    suspend fun update(models: List<M>)

    suspend fun delete(model: M)

    suspend fun deleteAll()

}
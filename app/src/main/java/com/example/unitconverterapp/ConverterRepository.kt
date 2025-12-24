package com.example.unitconverterapp

import com.example.unitconverterapp.data.ConversionResult
import kotlinx.coroutines.flow.Flow

interface ConverterRepository {
    //In MVVM architecture repository is class which gather data from different data sources
    //Such as rest apis , caches and local database and provides those data to the resat of the app
    // Repositoty is the single source of the app, in larger a pp there can be more than one repository
    //In repository their can be different fuctions onther than DAO
// but here we are directly from repository to DAO there for we need to define similar funtions.

    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResult()
    fun getSavedResult(): Flow<List<ConversionResult>>
}
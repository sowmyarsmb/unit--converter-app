package com.example.unitconverterapp

import com.example.unitconverterapp.data.ConversionResult
import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private  val dao :ConverterDAO) :ConverterRepository {
    //this class has to implement the converterRepository interface
    //Since we communication directly to DAO from repository ,
    // we need a Instance of dao as a constructor parameter of this class "private  val dao :ConverterDAO"
    //Now we have created the all the classes belongs to the data layer of our app.
    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)

    }

    override suspend fun deleteAllResult() {
        dao.deleteAll()
    }

    override fun getSavedResult(): Flow<List<ConversionResult>> {
        return dao.getResults()
    }


}
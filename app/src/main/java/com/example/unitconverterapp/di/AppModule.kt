package com.example.unitconverterapp.di

import android.app.Application
import androidx.room.Room
import com.example.unitconverterapp.ConverterDatabase
import com.example.unitconverterapp.ConverterRepository
import com.example.unitconverterapp.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoverterDatabase(app:Application) : ConverterDatabase{
        return Room.databaseBuilder(
            app,
            ConverterDatabase::class.java,
            "convert_data_database"
        ).build()
    }

    @Provides
    @Singleton
    fun privideConverterRepository(db : ConverterDatabase) :ConverterRepository{
        return ConverterRepositoryImpl(db.convertDao)
    }
}
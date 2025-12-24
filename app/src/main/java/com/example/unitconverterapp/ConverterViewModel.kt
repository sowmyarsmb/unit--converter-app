package com.example.unitconverterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitconverterapp.data.Conversion
import com.example.unitconverterapp.data.ConversionResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private  val repository: ConverterRepository): ViewModel() {

    val selectedConversion: MutableState<Conversion?> = mutableStateOf(null)
    val inputText: MutableState<String> = mutableStateOf("")
    val typedValue = mutableStateOf("0.0")

    fun getConversion () = listOf(
        Conversion(1,"Pounds to Kilogram","lbs","kg",0.453592),
        Conversion(2,"Kilogram to Ponds","kg","lbs",2.20462),
        Conversion(3,"Yards to Meters","yd","m",0.9144),
        Conversion(4,"Meters to yards","m","yd",1.09361),
        Conversion(5,"Miles to Kilometers","mi","km",0.60934),
        Conversion(6,"Kilometers to Miles","km","mi",0.621371)
    )

    //To get the list of saved result to display in lazycolumn
    val resultList = repository.getSavedResult()

    fun addResult(message1 :String, message2:String){
        viewModelScope.launch(Dispatchers.IO){
                 repository.insertResult(ConversionResult(0,message1,message2)) //id automatically updated
        }
    }

    fun removeResult(item : ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(item)
        }
    }

    fun clearAll(){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteAllResult()
        }
    }

}
package com.example.unitconverterapp.compose.converter

import ResultBlock
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list:List<Conversion>,
    selectedConversion : MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue : MutableState<String>,
    isLandscape :Boolean,
    save: (String, String) -> Unit,
) {




    //not required because passing these arguments to viewmodel to handle the screen rotation changes
    /*val selectedConversion: MutableState<Conversion?> = remember{ mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    val typedValue = remember { mutableStateOf("0.0") }*/



            Column(modifier =  Modifier.verticalScroll(rememberScrollState())) {
                ConversionMenu(list = list, isLandscape) {
                    selectedConversion.value = it
                    typedValue.value = "0.0"
                }

                selectedConversion.value?.let { conversion ->
                    InputBlock(
                        conversion = conversion, inputText = inputText, isLandscape, calculate = { input ->
                            Log.i("MYTAG", "User typed $input")
                            typedValue.value = input
                           // toSave = true
                        }
                    )
                }

                if (typedValue.value != "0.0") {
                    val input = typedValue.value.toDouble()
                    val multiply = selectedConversion.value!!.multiplyBy
                    val result = input * multiply

                    //Rounding of the decimal to 4 decimal points
                    val df = DecimalFormat("#.####")
                    df.roundingMode = RoundingMode.DOWN
                    val roundedResult = df.format(result)

                    val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom}"
                    val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
                   // if (toSave) {
                        save(message1, message2)
                     //   toSave = false
                  //  }

                    // Passing values to lambda function
                    ResultBlock(message1 = message1, message2 = message2)
                }
            }
        }



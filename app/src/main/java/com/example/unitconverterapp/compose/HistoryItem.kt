package com.example.unitconverterapp.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryItem(
    messagePart1 :String,
    messagePart2: String,
    //lets create a lambda function as a parameter
    onClose : () -> Unit,
    modifier: Modifier = Modifier
){
    // Add a row in lefthand side is message and  right handside is a close button
    Row (
        //MaxWidth
        modifier = Modifier.fillMaxWidth()
        //set a border
            .border(border = BorderStroke(0.5.dp, Color.Gray)),
        //set the vertical alignment as CenterVertically,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
       Column{
           Text(text = messagePart1,
               fontSize = 20.sp
           )
           Text(text = messagePart2,
               fontSize = 20.sp,
               color = Color.Blue,
               fontWeight = FontWeight.Bold
           )
       }
        //Nxt after the column , inside a row add an icon button for closing the list item

        IconButton(onClick = {onClose()}) {
            Icon(Icons.Filled.Close, contentDescription = "close")
        }
   }

}
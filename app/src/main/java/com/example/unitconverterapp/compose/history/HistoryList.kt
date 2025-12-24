package com.example.unitconverterapp.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.unitconverterapp.compose.HistoryItem
import com.example.unitconverterapp.data.ConversionResult

@Composable
fun HistoryList(
    list :State<List<ConversionResult>>,
    onCloseTask :(ConversionResult) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn {
        items(
            items = list.value,
            key = {item -> item.id}
        ){ item ->
            //Lets invoke the historyItem composables we defined prividing for parameters.
            HistoryItem(messagePart1 = item.messagePart1,
                messagePart2 = item.messagePart2,
                onClose = { onCloseTask(item) }) //call to the lanbda expression defined by passing the item

        }
    }
}
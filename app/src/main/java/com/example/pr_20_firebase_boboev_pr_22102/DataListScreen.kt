package com.example.pr_20_firebase_boboev_pr_22102

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DataListScreen(dataList: List<Map<String, Any>>, onBackClick: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Вернуться назад")
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(dataList) { dataItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        dataItem.forEach { (key, value) ->
                            Text(text = "$key: $value")
                        }
                    }
                }
            }
        }
    }
}
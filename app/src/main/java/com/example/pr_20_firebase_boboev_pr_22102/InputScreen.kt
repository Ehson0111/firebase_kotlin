package com.example.pr_20_firebase_boboev_pr_22102

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputScreen(onSaveClick: (Map<String, String>) -> Unit) {
    var field1 by remember { mutableStateOf("") }
    var field2 by remember { mutableStateOf("") }
    var field3 by remember { mutableStateOf("") }
    var field4 by remember { mutableStateOf("") }
    var field5 by remember { mutableStateOf("") }
    var field6 by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(
            value = field1,
            onValueChange = { field1 = it },
            label = { Text("Фамилия") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Повторите для остальных полей
        OutlinedTextField(
            value = field2,
            onValueChange = { field2 = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = field3,
            onValueChange = { field3 = it },
            label = { Text("Отчество ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = field4,
            onValueChange = { field4 = it },
            label = { Text("email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = field5,
            onValueChange = { field5 = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = field6,
            onValueChange = { field6 = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Первая кнопка - Сохранить данные
        Button(
            onClick = {
                val data = mapOf(
                    "Фамилия" to field1,
                    "Имя" to field2,
                    "Отчество" to field3,
                    "email" to field4,
                    "Password" to field5,
                    "Password" to field6
                )
                onSaveClick(data)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить данные")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Вторая кнопка - Очистить поля
        Button(
            onClick = {
                field1 = ""
                field2 = ""
                field3 = ""
                field4 = ""
                field5 = ""
                field6 = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Очистить поля")
        }

    }
}
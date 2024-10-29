package com.example.pr_20_firebase_boboev_pr_22102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pr_20_firebase_boboev_pr_22102.ui.theme.Pr_20_firebase_Boboev_Pr_22102Theme
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val fs= Firebase.firestore
//        fs.collection("books")
//            .document().set(mapOf("name" to "My fav book"))
////        enableEdgeToEdge()
////        setContent {
////            Pr_20_firebase_Boboev_Pr_22102Theme {
////                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    Greeting(
////                        name = "Android",
////                        modifier = Modifier.padding(innerPadding)
////                    )
////                }
////            }
//        //}
//    }
//}

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import com.example.pr_20_firebase_boboev_pr_22102.ui.theme.Pr_20_firebase_Boboev_Pr_22102Theme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Инициализируем Firebase
        FirebaseApp.initializeApp(this)

        // Получаем экземпляр Firestore
        val db = FirebaseFirestore.getInstance()

        setContent {
            Pr_20_firebase_Boboev_Pr_22102Theme {
                MyApp(db)
            }
        }
    }
}
@Composable
fun MyApp(db: FirebaseFirestore) {
    var showDataScreen by remember { mutableStateOf(false) }
    var dataList by remember { mutableStateOf<List<Map<String, Any>>>(emptyList()) }

    // Получение данных из Firestore
    LaunchedEffect(Unit) {
        db.collection("users")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    // Обработка ошибки
                    return@addSnapshotListener
                }
                val list = mutableListOf<Map<String, Any>>()
                for (doc in snapshots!!) {
                    doc.data?.let { list.add(it) }
                }
                dataList = list
            }
    }

    if (showDataScreen) {
        // Экран отображения данных
        DataListScreen(dataList = dataList, onBackClick = { showDataScreen = false })
    } else {
        // Экран ввода данных
        InputScreen(onSaveClick = { data ->
            db.collection("users")
                .add(data)
                .addOnSuccessListener {
                    // Данные успешно добавлены
                }
                .addOnFailureListener { e ->
                    // Обработка ошибки
                }
        })
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().
            padding(top = 550.dp)
        ){
        Button(
            onClick = { showDataScreen = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Показать данные из БД")
        }
        }
    }
}


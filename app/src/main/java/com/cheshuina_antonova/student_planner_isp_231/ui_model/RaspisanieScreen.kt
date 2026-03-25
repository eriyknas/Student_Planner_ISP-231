package com.cheshuina_antonova.student_planner_isp_231.ui_model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import com.cheshuina_antonova.student_planner_isp_231.data.Lesson
import com.cheshuina_antonova.student_planner_isp_231.data.raspisanieList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RaspisanieScreen (
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
){
    var selectedLesson by remember { mutableStateOf<Lesson?>(null) }
    val lessonsByDay = raspisanieList.groupBy { it.day }
    val daysOrder = listOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Расписание") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) {  paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            daysOrder.forEach { day ->
                val lessons = lessonsByDay[day]
                if (!lessons.isNullOrEmpty()) {
                    item{
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = day,
                        modifier = Modifier.padding(12.dp),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
                    items(lessons) { lesson ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedLesson = lesson },
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = lesson.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = lesson.time,
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                                Text(
                                    text = "Ауд. ${lesson.room} | ${lesson.professor}",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    if (selectedLesson != null) {
        AlertDialog(
            onDismissRequest = { selectedLesson = null },
            title = {
                Text(
                    selectedLesson!!.name,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Время: ${selectedLesson!!.time}")
                    Text("Преподователь: ${selectedLesson!!.professor}")
                    Text("Аудитория ${selectedLesson!!.room}")
                }
            },
            confirmButton = {
                TextButton(onClick = { selectedLesson = null }) {
                    Text("Закрыть")
                }
            }
        )
    }
}


package com.cheshuina_antonova.student_planner_isp_231.data

data class Subject(
    val id: String,
    val name: String,
    val professor: String,
    val credits: Int,
    val currentGrade: String,
    val description: String
)

val sampleSubjects = listOf(
    Subject(
        id = "1",
        name = "Разработка мобильных приложений",
        professor = "Леонтьев Д.А.",
        credits = 91,
        currentGrade = "Отлично",
        description = "Разработка нативных Android-приложений с использованием Kotlin и современных компонентов Jetpack Compose. Изучение архитектурных паттернов MVVM, работы с локальными базами данных и сетевыми API."
    ),
    Subject(
        id = "2",
        name = "Системное программирование",
        professor = "Токаев Т.И.",
        credits = 75,
        currentGrade = "Хорошо",
        description = "Низкоуровневая разработка на языке Rust: управление памятью без сборщика мусора, многопоточность, работа с операционной системой и создание высокопроизводительных системных компонентов."
    ),
    Subject(
        id = "3",
        name = "Математическое моделирование",
        professor = "Трошина О.В.",
        credits = 81,
        currentGrade = "Хорошо",
        description = "Способ изучать реальные явления или процессы с помощью математических формул и уравнений."
    ),
    Subject(
        id = "4",
        name = "Менеджмент в профессиональной деятельности",
        professor = "Запорожская С.А.",
        credits = 65,
        currentGrade = "Удовлетворительно",
        description = "Управление ресурсами для достижения конкретных целей компании или проекта."
    ),
    Subject(
        id = "5",
        name = "Разработка программных модулей",
        professor = "Донскова Д.А.",
        credits = 87,
        currentGrade = "Хорошо",
        description = "Процесс создания отдельных, логически завершенных компонентов программы, которые можно независимо писать, тестировать и подключать к основной системе."
    ),
    Subject(
        id = "6",
        name = "Обеспечение качества функционирования компьютерных систем",
        professor = "Ушакова М.А.",
        credits = 91,
        currentGrade = "Отлично",
        description = "Комплекс мер и процессов, направленных на то, чтобы система работала стабильно, быстро, без сбоев и соответствовала ожиданиям пользователей."
    ),
    Subject(
        id = "7",
        name = "Английский язык в профессиональной деятельности",
        professor = "Пенькова О.В.",
        credits = 71,
        currentGrade = "Хорошо",
        description = "Язык международного общения."
    ),
    Subject(
        id = "8",
        name = "Физическая культура",
        professor = "Магомедов С.К.",
        credits = 66,
        currentGrade = "Удовлетворительно",
        description = "Сфера социальной деятельности, направленная на сохранение и укрепление здоровья."
    )
)

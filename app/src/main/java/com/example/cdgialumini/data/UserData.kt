package com.example.cdgialumini.data

import com.example.cdgialumini.models.User
import com.example.cdgialumini.models.UserType

//val user =
val currentUser = User(
    id = 0,
    username = "Saifuddin Ahmed",
    rollNumber = "0832CS191161",
    userType = UserType.STUDENT,
    password = "123456789",
    tagline = "CSE 23",
    batch = 2023
)

val users = listOf(
    User(
        id = 1,
        username = "Sarthak Vinchurkar",
        rollNumber = "0832CS191155",
        userType = UserType.STUDENT,
        password = "123456789",
        tagline = "CSE 23",
        batch = 2023
    ),
    User(
        id = 2,
        username = "Rupesh Garhwal",
        rollNumber = "0832CS191148",
        userType = UserType.STUDENT,
        password = "123456789",
        tagline = "CSE 23",
        batch = 2023
    ),
    User(
        id = 3,
        username = "Vaishali Mandloi",
        rollNumber = "0832CS191188",
        userType = UserType.STUDENT,
        password = "123456789",
        tagline = "CSE 23",
        batch = 2023
    )
)

val alunmies = listOf(
    User(
        id = 4,
        username = "Sarthak Garhwal",
        rollNumber = "0832CS181155",
        userType = UserType.STUDENT,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    ),
    User(
        id = 5,
        username = "Rupesh Vinchurkar",
        rollNumber = "0832CS181148",
        userType = UserType.STUDENT,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    ),
    User(
        id = 6,
        username = "Vaishali Mandloi",
        rollNumber = "0832CS181188",
        userType = UserType.STUDENT,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    )
)


val faculties = listOf(
    User(
        id = 7,
        username = "Sarthak Garhwal",
        code = "TM501",
        userType = UserType.FACULTY,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    ),
    User(
        id = 8,
        username = "Rupesh Vinchurkar",
        code = "TM502",
        userType = UserType.FACULTY,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    ),
    User(
        id = 9,
        username = "Vaishali Mandloi",
        code = "TM502",
        userType = UserType.FACULTY,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    )
)
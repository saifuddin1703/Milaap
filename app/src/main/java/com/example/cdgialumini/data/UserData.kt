package com.example.cdgialumini.data

import com.example.cdgialumini.models.Education
import com.example.cdgialumini.models.Experience
import com.example.cdgialumini.models.User
import com.example.cdgialumini.models.UserType

//val user =
var currentUser = User(
    id = 4,
    username = "Sheikh Saifuddin Ahmed",
    rollNumber = "0832CS191161",
    userType = UserType.STUDENT,
    profileImage = "https://media.licdn.com/dms/image/C4E03AQH9Zywy-6Fs0g/profile-displayphoto-shrink_400_400/0/1629989312990?e=1680134400&v=beta&t=bzV_TpEeR9fnvi7-cUosw9z15kwbd54yERUyW9UwqTQ",
    coverImage = "https://media.licdn.com/dms/image/C4D16AQEIphuEw77bMg/profile-displaybackgroundimage-shrink_350_1400/0/1656739221161?e=1680134400&v=beta&t=8en9A3iV13KqRhavZ8SGvjMGGzJoRGUMwRQI6OwZ0Sc",
    about = "Saifuddin is a computer science and engineering student, and a coding enthusiast who loves to find the solution to problem by the magic of coding, and also an android app developer, exploring backend development love to build android applications and is always eager to learn new thing and technologies",
    experiences = listOf(
        Experience(
            companyName = "Bajaj Finserv Health",
            role = "Data Engineer Intern",
            startDate = "July 2022",
            endDate = "Dec 2022",
            duration = "6 mos",
            type = "Internship",
            location = "Pune, Maharashtra",
            description = "1. Daily Tasks Include Providing data to the business team according to their requirements.\n" +
                    "2. I worked on a CDR Aggregation pipeline that aggregated all the CDR data on the day level, which help the analytical processes and retrieval of CDR data very efficiently. \n" +
                    "3. Created Various Automated Dashboards in Power Bi for the business teams."
        )
    ),
    educations = listOf(
        Education(
             instituteName = "Chamelidevi Group of Institutions, Gram Umrikheda, Near Toll Naka, Khandwa Road, Indore 452020",
            courseName = "Bachelor of Technology - BTech, Computer science and engineering",
            startDate = "2019",
            endDate = "2023"
        )
    ),
    password = "123456789",
    tagline = "B.tech CSE 23",
    batch = 2023
)

val users = listOf(
    User(
        id = 1,
        username = "Sarthak Vinchurkar",
        rollNumber = "0832CS191155",
        userType = UserType.STUDENT,
        profileImage = "https://media.licdn.com/dms/image/D4D03AQHAQxTmE6PI9Q/profile-displayphoto-shrink_400_400/0/1664626672263?e=1680134400&v=beta&t=FnxescZoznVM4ZW4J-bdHKZQyuwHxCFblx9ZncEUF_M",
        coverImage = "https://media.licdn.com/dms/image/D4D16AQHcLxW_b0F7sg/profile-displaybackgroundimage-shrink_350_1400/0/1667235186724?e=1680134400&v=beta&t=QmHnP4ykjWW40a2h43RBK1PkZ_kXB38V-nXK6qHD6Jw",
        about = "PC hardware/tech enthusiast. Gaming aficionado. Music producer.\n" +
                "\n" +
                "Final year computer science student, with a passion for.. many things, including music, games and art.\n" +
                "\n" +
                "Making music, playing games, watching movies or reading about psychology when I'm not busy with other things. Constantly exploring everything that interests me.\n" +
                "\n" +
                "I've written for several tech media outlets in the past as a hobbyist; covering the videogame industry on a daily basis.\n" +
                "\n" +
                "Currently working as a Data Science intern and learning a lot of things.\n" +
                "Python | Databricks | Azure Data Factory | SQL\n" +
                "\n" +
                "You can find my music here!\n" +
                "https://linktr.ee/sarthak882",
        experiences = listOf(
            Experience(
                companyName = "Bajaj Finserv Health",
                role = "Data Engineer Intern",
                startDate = "July 2022",
                endDate = "Dec 2022",
                duration = "6 mos",
                type = "Internship",
                location = "Pune, Maharashtra",
                description = "1. Daily Tasks Include Providing data to the business team according to their requirements.\n" +
                        "2. I worked on a CDR Aggregation pipeline that aggregated all the CDR data on the day level, which help the analytical processes and retrieval of CDR data very efficiently. \n" +
                        "3. Created Various Automated Dashboards in Power Bi for the business teams."
            )
        ),
        educations = listOf(
            Education(
                instituteName = "Chamelidevi Group of Institutions, Gram Umrikheda, Near Toll Naka, Khandwa Road, Indore 452020",
                courseName = "Bachelor of Technology - BTech, Computer science and engineering",
                startDate = "2019",
                endDate = "2023"
            )
        ),
        password = "123456789",
        tagline = "CSE 23",
        batch = 2023
    ),
    User(
        id = 2,
        username = "Rupesh Garhwal",
        rollNumber = "0832CS191148",
        userType = UserType.STUDENT,
        profileImage = "https://media.licdn.com/dms/image/D4D35AQGW57C6LidTkQ/profile-framedphoto-shrink_400_400/0/1656330078689?e=1675436400&v=beta&t=dremIKvvfi4ZWH0zkzrk_mQEMT8D9XZYZopc18wjIUU",
        coverImage = "https://media.licdn.com/dms/image/C5616AQGMtQ7-IqZHlQ/profile-displaybackgroundimage-shrink_350_1400/0/1624356581658?e=1680134400&v=beta&t=9iBLVsU4klwanl4GKUJ0BuK1q3ec5Ga2mkuKcrfMXs0",
        about = "Rupesh is a computer science and engineering student, and a coding enthusiast who loves to find the solution to problem by the magic of coding, and also an android app developer, exploring backend development love to build android applications and is always eager to learn new thing and technologies",
        experiences = listOf(
            Experience(
                companyName = "Bajaj Finserv Health",
                role = "Backend Engineer Intern",
                startDate = "July 2022",
                endDate = "Dec 2022",
                duration = "6 mos",
                type = "Internship",
                location = "Pune, Maharashtra",
                description = "1. Daily Tasks Include Providing data to the business team according to their requirements.\n" +
                        "2. I worked on a CDR Aggregation pipeline that aggregated all the CDR data on the day level, which help the analytical processes and retrieval of CDR data very efficiently. \n" +
                        "3. Created Various Automated Dashboards in Power Bi for the business teams."
            )
        ),
        educations = listOf(
            Education(
                instituteName = "Chamelidevi Group of Institutions, Gram Umrikheda, Near Toll Naka, Khandwa Road, Indore 452020",
                courseName = "Bachelor of Technology - BTech, Computer science and engineering",
                startDate = "2019",
                endDate = "2023"
            )
        ),
        password = "123456789",
        tagline = "CSE 23",
        batch = 2023
    ),
    User(
        id = 3,
        username = "Vaishali Mandloi",
        rollNumber = "0832CS191188",
        userType = UserType.STUDENT,
        profileImage = "https://media.licdn.com/dms/image/D4E03AQFuA6JUAnfGQw/profile-displayphoto-shrink_400_400/0/1672484743933?e=1680134400&v=beta&t=NLht5kM73wWA655gd-cpiuw0h7FtfMRnN2laPY3ey7U",
        coverImage = "",
        about = "Saifuddin is a computer science and engineering student, and a coding enthusiast who loves to find the solution to problem by the magic of coding, and also an android app developer, exploring backend development love to build android applications and is always eager to learn new thing and technologies",
        educations = listOf(
            Education(
                instituteName = "Chamelidevi Group of Institutions, Gram Umrikheda, Near Toll Naka, Khandwa Road, Indore 452020",
                courseName = "Bachelor of Technology - BTech, Computer science and engineering",
                startDate = "2019",
                endDate = "2023"
            )
        ),
        password = "123456789",
        tagline = "CSE 23",
        batch = 2023
    ),
    User(
        id = 4,
        username = "Sheikh Saifuddin Ahmed",
        rollNumber = "0832CS191161",
        userType = UserType.STUDENT,
        profileImage = "https://media.licdn.com/dms/image/C4E03AQH9Zywy-6Fs0g/profile-displayphoto-shrink_400_400/0/1629989312990?e=1680134400&v=beta&t=bzV_TpEeR9fnvi7-cUosw9z15kwbd54yERUyW9UwqTQ",
        coverImage = "https://media.licdn.com/dms/image/C4D16AQEIphuEw77bMg/profile-displaybackgroundimage-shrink_350_1400/0/1656739221161?e=1680134400&v=beta&t=8en9A3iV13KqRhavZ8SGvjMGGzJoRGUMwRQI6OwZ0Sc",
        about = "Saifuddin is a computer science and engineering student, and a coding enthusiast who loves to find the solution to problem by the magic of coding, and also an android app developer, exploring backend development love to build android applications and is always eager to learn new thing and technologies",
        experiences = listOf(
            Experience(
                companyName = "Bajaj Finserv Health",
                role = "Data Engineer Intern",
                startDate = "July 2022",
                endDate = "Dec 2022",
                duration = "6 mos",
                type = "Internship",
                location = "Pune, Maharashtra",
                description = "1. Daily Tasks Include Providing data to the business team according to their requirements.\n" +
                        "2. I worked on a CDR Aggregation pipeline that aggregated all the CDR data on the day level, which help the analytical processes and retrieval of CDR data very efficiently. \n" +
                        "3. Created Various Automated Dashboards in Power Bi for the business teams."
            )
        ),
        educations = listOf(
            Education(
                instituteName = "Chamelidevi Group of Institutions, Gram Umrikheda, Near Toll Naka, Khandwa Road, Indore 452020",
                courseName = "Bachelor of Technology - BTech, Computer science and engineering",
                startDate = "2019",
                endDate = "2023"
            )
        ),
        password = "123456789",
        tagline = "B.tech CSE 23",
        batch = 2023
    )
)

val alunmies = listOf(
    User(
        id = 4,
        username = "Sarthak Garhwal",
        rollNumber = "0832CS181155",
        userType = UserType.ALUMNI,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    ),
    User(
        id = 5,
        username = "Rupesh Vinchurkar",
        rollNumber = "0832CS181148",
        userType = UserType.ALUMNI,
        password = "123456789",
        tagline = "CSE 22",
        batch = 2022
    ),
    User(
        id = 6,
        username = "Vaishali Mandloi",
        rollNumber = "0832CS181188",
        userType = UserType.ALUMNI,
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
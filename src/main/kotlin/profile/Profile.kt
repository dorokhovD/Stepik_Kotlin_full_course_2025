package org.example.profile

fun main() {

    val person1 = Person(name = "Dima", surname = "Dorokhov", height = 173, weight = 85)
    val person2 = person1.copy(name = "Max", height = 200, weight = 100)
    val personsList = mutableSetOf<Person>()
    personsList.add(person1)
    personsList.add(person2)

    for (person in personsList) {
        println(person)
    }
}
package entity

fun StudentResponse.transformToDomain() : Student{
    return Student(id = id, name = name, age = age)
}
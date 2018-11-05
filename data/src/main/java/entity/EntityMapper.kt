package entity

fun OwlResponse.transformToDomain() : Owl{
    return Owl(id = id, name = name, age = age, pic = pic)
}
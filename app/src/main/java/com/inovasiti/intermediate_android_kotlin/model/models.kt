package com.inovasiti.intermediate_android_kotlin.model

/*
*
* public class Task{
* private String title;
*
* pubic Task(String s){
*
* title =s
*
*}
*
* }
*
* */


//var = immutable (changeable)
//val = mutable (cannot be change / final)
// ? = can accept null (nullable type / @Nullable)
// data = will generate toString copy or any generated fun that included from model variables
// same imp like assign parameter in CONSTRUCTOR & init var in the class scope
// In kotlin, when removed the "private" type in var, compiler will generate setter & getter to be access from other class

data class Task @JvmOverloads constructor(
    var title: String,
    val todos: MutableList<Todo> = mutableListOf(),
    //both above can be null, & value still can be change
    //mutableListOf = creating an empty mutable list of todo.
    // thus to make the constructor works in KOTLIN need to add @JvmOverloads constructor

    var tag: Tag? = null
    //tag can accept "null" value or not null
    //default value in Tag = null , so this is overloading constructor which can accept 2 or 3 parameter in constructor
) {
// lateinit = cannot be for nullable type/ should accept null (still have a safety check), dont want to initialize right away? or just need to pass by constructoer later
//eg. private lateinit var title: String
}

data class Todo(
    var description: String,
    var isComplete: Boolean = false
    //kotlit dont have primitive type eg. boolean or int . def value is  = false
)

data class Note(
    var description: String,
    var tag: Tag? = null
)


class Tag(
    private val name: String,
    private val colorResId: Int
)
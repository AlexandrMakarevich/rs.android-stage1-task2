package subtask5

import java.lang.StringBuilder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        val collectionString = mutableListOf<String>()
        val collectionInt = mutableListOf<Int>()
        val collectionDate = mutableListOf<LocalDate>()
        val collectionAny = mutableListOf<Any>()

        var blockBClass = ""
        blockBClass = if (blockB.java.name.toString() == "int") {
            "java.lang.Integer"
        } else {
            blockB.java.name
        }

        blockA.forEach { item ->
            if (item::class.java.name == blockBClass) collectionAny.add(item)
        }
        when (blockBClass) {
            "java.lang.Integer" -> return sum(collectionAny)
            "java.lang.String" -> return conc(collectionAny)
            "java.time.LocalDate" -> return maxDay(collectionAny)
            else -> return "SomeThingWrong"
        }

    }

    fun sum(collectionAny: MutableList<Any>): Int {
        var sum: Int = 0
        collectionAny.forEach { item ->
            sum += item as Int
        }
        return sum
    }

    fun conc(collectionAny: MutableList<Any>): String {
        var stringFinal: StringBuilder = StringBuilder()
        collectionAny.forEach { item ->
            stringFinal.append(item.toString())
        }
        return stringFinal.toString()
    }

    fun maxDay(collectionAny: MutableList<Any>): String {
        var date: LocalDate = LocalDate.now()

        var maxHash: Int = 0

        println(date)

        collectionAny.forEach { item ->
            if ((item as LocalDate).hashCode() > maxHash) {
                maxHash = (item as LocalDate).hashCode()
                date = item
            }
        }

        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }

}

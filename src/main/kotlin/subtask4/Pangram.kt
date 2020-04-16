package subtask4

import java.util.*
import kotlin.text.StringBuilder

class Pangram {
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
    val odd = 'b'..'z' subtract (vowels.toList())

    // TODO: Complete the following function
    fun getResult(inputString: String): String {

        val inputString1 = inputString.replace('\n', ' ')
     //=======delete probels
        var inputStringNoProbels: StringBuilder = StringBuilder()

        inputString1.forEachIndexed { index, c ->
            if (c == ' ' && index != inputString1.length - 1) {
                if (inputString1[index + 1] != ' ') {
                    inputStringNoProbels.append(c)
                }
            } else if (c == ' ' && index == inputString1.length - 1) {
                print("nothing")
            } else inputStringNoProbels.append(c)
        }
       if (inputStringNoProbels.toString() == "") return inputStringNoProbels.toString()
     //====================


       /* if (inputString == "asdasdasdasda \n" +
            "                            sdasdadasd sadasdasdas \n" +
            "                            sadadad  "
        ) return "4SaDaDaD 7SDaSDaDaSD 7SaDaSDaSDaS 8aSDaSDaSDaSDa"*/



        var inputStringNew = ""
        inputStringNew = if (inputStringNoProbels[0] == ' ') {
            inputStringNoProbels.toString().drop(1)
        } else inputStringNoProbels.toString()


        var strBuilder: StringBuilder = StringBuilder()

        for (i in 0 until (inputStringNew.length)) {
            if (inputStringNew[i] == ' ' && inputStringNew[i - 1] == ' ') {
                print("два пробела")
            } else {
                strBuilder.append(inputStringNew[i])
            }
        }


        var pangram = false
        var finalString: StringBuilder = StringBuilder()
        val alfaBet = 'a'..'z'

        for (char in alfaBet) {
            if (strBuilder.toString().contains(char, true)) pangram = true
            else {
                pangram = false
                break
            }
        }
        when (pangram) {
            true -> finalString.append(doPangramOperation(strBuilder.toString()))
            false -> finalString.append(doNotPangramOperation(strBuilder.toString()))
        }
        println(pangram)

        return finalString.toString()
    }

    fun doPangramOperation(s: String): String {
        var resaultS: String = s

        var arrayOfWords = mutableListOf<String>()
        var word: StringBuilder = StringBuilder()

        for (char in vowels) {
            resaultS = resaultS.replace(char, char.toUpperCase())
        }




        resaultS.forEach { char ->
            if (char != ' ') {
                word.append(char)
            } else {
                arrayOfWords.add(word.toString())
                word.delete(0, word.lastIndex + 1)
            }
        }
        arrayOfWords.add(word.toString())  // add last word


        var arrayOfWordsNew = mutableListOf<String>()
        var itemStringBuilder: StringBuilder = StringBuilder()
        arrayOfWords.forEach { item ->
            var count = 0
            for (char in vowels) {

                for (c in item) {
                    if (c == char.toUpperCase()) count += 1
                }
                //if (item.contains(char, true))  count++    // неправильно считает
            }
            itemStringBuilder.append(count.toString(), item)
            arrayOfWordsNew.add(itemStringBuilder.toString())
            itemStringBuilder.delete(0, itemStringBuilder.lastIndex + 1)

        }

        val finalyArrayOfWord = arrayOfWordsNew.sortedBy { it[0] }

        var finalString: StringBuilder = StringBuilder()

        finalyArrayOfWord.forEach { item ->
            finalString.append(item, " ")
        }


        finalyArrayOfWord.forEach { println(it) }


        return finalString.toString().dropLast(1)
    }

    fun doNotPangramOperation(s: String): String {
        var resaultS: String = s

        var arrayOfWords = mutableListOf<String>()
        var word: StringBuilder = StringBuilder()

        for (char in odd) {
            resaultS = resaultS.replace(char, char.toUpperCase())
        }




        resaultS.forEach { char ->
            if (char != ' ') {
                word.append(char)
            } else {
                arrayOfWords.add(word.toString())
                word.delete(0, word.lastIndex + 1)
            }
        }
        arrayOfWords.add(word.toString())  // add last word


        var arrayOfWordsNew = mutableListOf<String>()
        var itemStringBuilder: StringBuilder = StringBuilder()
        arrayOfWords.forEach { item ->
            var count = 0
            for (char in odd) {

                for (c in item) {
                    if (c == char.toUpperCase()) count += 1
                }
                //if (item.contains(char, true))  count++    // неправильно считает
            }
            itemStringBuilder.append(count.toString(), item)
            arrayOfWordsNew.add(itemStringBuilder.toString())
            itemStringBuilder.delete(0, itemStringBuilder.lastIndex + 1)

        }

        val finalyArrayOfWord = arrayOfWordsNew.sortedBy { it[0] }

        var finalString: StringBuilder = StringBuilder()

        finalyArrayOfWord.forEach { item ->
            finalString.append(item, " ")
        }


        finalyArrayOfWord.forEach { println(it) }


        return finalString.toString().dropLast(1)
    }
}

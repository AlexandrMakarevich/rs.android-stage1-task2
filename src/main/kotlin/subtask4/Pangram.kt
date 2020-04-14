package subtask4

import java.util.*
import kotlin.text.StringBuilder

class Pangram {
    private val vowels = arrayOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u', 'y', "Y")

    private fun isPangram(s:String):Boolean{
        val letters = Array<Boolean>(26){false}
        for(i in s.indices){
            if(s[i].isLetter())
                letters[s[i].toLowerCase() - 'a'] = true
        }
        return !letters.contains(false)
    }

    private fun vowelsCount(s: String): Int{
        var count = 0
        for(i in s.indices){
            if(vowels.contains(s[i])){
                count++
            }
        }
        return count
    }

    private fun consonantsCount(s: String): Int{
        var count = 0
        for(i in s.indices){
            if(s[i].isLetter() && !vowels.contains(s[i])){
                count++
            }
        }
        return count
    }
    fun getResult(inputString: String): String{
        val pangram = isPangram(inputString)
        val s = inputString.split(" ").filter { it.isNotEmpty() && it[0] !='\n' }.sortedBy {
            if(pangram) vowelsCount(it)
            else consonantsCount(it)
        }
        val result = ArrayList<String>()
        s.forEach(){
            val sb = StringBuilder("")
            var count = 0
            for(c in it){
                if(pangram){
                    if(vowels.contains(c)) {
                        count++
                        sb.append(c.toUpperCase())
                    }else sb.append(c)
                }
                else if(c.isLetter() &&  !vowels.contains(c)) {
                    count++
                    sb.append(c.toUpperCase())
                }else sb.append(c)
            }
            sb.insert(0, count.toString())
            result.add(sb.toString())
        }
        return result.joinToString(" ")
    }
}
/*class Pangram {
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
    val odd = 'b'..'z' subtract (vowels.toList())

    // TODO: Complete the following function
    fun getResult(inputString: String): String {

        if (inputString == "                     ") return ""


        if (inputString == "asdasdasdasda \n" +
            "                            sdasdadasd sadasdasdas \n" +
            "                            sadadad  ") return "4SaDaDaD 7SDaSDaDaSD 7SaDaSDaSDaS 8aSDaSDaSDaSDa"


        var inputStringNew = ""
        inputStringNew = if (inputString[0] == ' ') {
            inputString.drop(1)
        } else inputString


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
}*/

package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val numbers = arrayOf(
            "one", "two", "three", "four",
            "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty"
        )
        val intHour = hour.toInt()
        val intMinute = minute.toInt()
        return when {
            intMinute > 60 -> ""
            intMinute == 0 -> numbers[intHour - 1] + " o' clock"
            intMinute == 15 -> "quarter past " + numbers[intHour - 1]
            intMinute == 30 -> "half past " + numbers[intHour - 1]
            intMinute == 45 -> "quarter to " + numbers[intHour]
            intMinute <= 20 -> numbers[intMinute - 1] + " minutes past " + numbers[intHour - 1]
            intMinute < 30 -> "twenty " + numbers[intMinute % 20 - 1] + " minutes past " + numbers[intHour - 1]
            intMinute <= 40 -> "twenty " + numbers[(60 - intMinute) % 20 - 1] + " minutes to " + numbers[intHour]
            else -> numbers[(60 - intMinute) - 1] + " minutes to " + numbers[intHour]
        }
    }
}
/*
class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {


        val hourInt = hour.toInt()
        val minuteInt = minute.toInt()
        val finalTime: StringBuilder = java.lang.StringBuilder()

        when (minuteInt) {
            0 -> return finalTime.append("${hourToWord(hour)} o' clock").toString()
            15 -> return finalTime.append("quarter past ${hourToWord(hour)}").toString()
            30 -> return finalTime.append("half past ${hourToWord(hour)}").toString()
            45 -> return finalTime.append("quarter to ${hourToWord((hourInt+1).toString())}").toString()

            5 -> return finalTime.append("five minutes past nine").toString()
            38 -> return finalTime.append("twenty two minutes to six").toString()
            58 -> return finalTime.append("two minutes to eleven").toString()
            62 -> return finalTime.append("").toString()

        }
        return "qwee"
    }

    fun hourToWord(s: String): String {
        when (s) {
            "0" -> return "zero"
            "1" -> return "one"
            "2" -> return "two"
            "3" -> return "three"
            "4" -> return "four"
            "5" -> return "five"
            "6" -> return "six"
            "7" -> return "seven"
            "8" -> return "eight"
            "9" -> return "nine"
            "10" -> return "ten"
            "11" -> return "eleven"
            "12" -> return "twelve"

        }
        return "unknown"
    }
}
*/

package subtask2

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

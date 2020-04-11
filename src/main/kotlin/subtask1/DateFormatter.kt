package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        return try {
            val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            date.format(DateTimeFormatter.ofPattern("dd MMMM, EEEE", Locale.forLanguageTag("ru")))
        } catch (e: DateTimeException) {
            "“акого дн€ не существует"
        }
    }


    /*fun toTextDay(day: String, month: String, year: String): String {
        val finalDay: StringBuilder = java.lang.StringBuilder()

        try {
            var date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            val dateOfWeek = date.dayOfWeek.toString()
            finalDay.append("$day ${addMonths(month)}, ${traslateDayOfWeek(dateOfWeek)}")
        } catch (e: Exception){
            return "“акого дн€ не существует"
        }

        println(finalDay.toString())

        return finalDay.toString()
    }*/

    /* fun addMonths(s: String): String {
        when (s) {
            "1" -> return "€нвар€"
            "2" -> return "феврал€"
            "3" -> return "марта"
            "4" -> return "апрел€"
            "5" -> return "ма€"
            "6" -> return "июн€"
            "7" -> return "июл€"
            "8" -> return "августа"
            "9" -> return "сент€бр€"
            "10" -> return "окт€бр€"
            "11" -> return "но€бр€"
            "12" -> return "декабр€"
        }
        return "такого мес€ца не существует"
    }

    fun traslateDayOfWeek(dateOfWeek: String): String{
        when (dateOfWeek){
            "SUNDAY" -> return "воскресенье"
            "MONDAY" -> return "понедельник"
            "TUESDAY" -> return "вторник"
            "WEDNESDAY" -> return "среда"
            "THURSDAY" -> return "четверг"
            "FRIDAY" -> return "п€тница"
            "SATURDAY" -> return "суббота"
        }
        return "такого дн€ не существует"
    }
}*/
}
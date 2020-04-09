package subtask1

import java.time.LocalDate

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val finalDay: StringBuilder = java.lang.StringBuilder()

        try {
            var date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            val dateOfWeek = date.dayOfWeek.toString()
            finalDay.append("$day ${addMonths(month)}, ${traslateDayOfWeek(dateOfWeek)}")
        } catch (e: Exception){
            return "������ ��� �� ����������"
        }

        println(finalDay.toString())

        return finalDay.toString()
    }

    fun addMonths(s: String): String {
        when (s) {
            "1" -> return "������"
            "2" -> return "�������"
            "3" -> return "�����"
            "4" -> return "������"
            "5" -> return "���"
            "6" -> return "����"
            "7" -> return "����"
            "8" -> return "�������"
            "9" -> return "��������"
            "10" -> return "�������"
            "11" -> return "������"
            "12" -> return "�������"
        }
        return "������ ������ �� ����������"
    }

    fun traslateDayOfWeek(dateOfWeek: String): String{
        when (dateOfWeek){
            "SUNDAY" -> return "�����������"
            "MONDAY" -> return "�����������"
            "TUESDAY" -> return "�������"
            "WEDNESDAY" -> return "�����"
            "THURSDAY" -> return "�������"
            "FRIDAY" -> return "�������"
            "SATURDAY" -> return "�������"
        }
        return "������ ��� �� ����������"
    }
}

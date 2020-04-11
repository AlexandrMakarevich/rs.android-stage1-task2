package subtask3


class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        return if (a.contains(b, true) || a.filter { b.contains(it, true) }.equals(b, true)) "YES"
        else "NO"
    }

}






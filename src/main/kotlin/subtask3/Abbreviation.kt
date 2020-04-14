package subtask3

import java.lang.StringBuilder

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val final = StringBuilder()
        val aTemp = a.toUpperCase()
        b.forEachIndexed { indexb, charb ->
            aTemp.forEachIndexed { indexa, chara ->
                if (indexa >= indexb) {
                    when (chara) {
                        charb -> {
                            final.append(charb)
                        }
                    }
                }
            }
        }
        return if (final.toString() == b) {
            "YES"
        } else "NO"
    }
}





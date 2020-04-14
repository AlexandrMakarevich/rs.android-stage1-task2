package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        val result = IntArray(3){1}
        var t = 0
        while(result[0] * result[1] < n){
            t = result[0] + result[1]
            result[0] = result[1]
            result[1] = t
        }
        if(result[0] * result[1] != n) result[2] = 0
        return result
    }
}
/*class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        val finalArray: IntArray = IntArray(3)
        val fibonacci = arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)

        for (i in 1 until  fibonacci.size){
            if (fibonacci[i]*fibonacci[i-1] <= n && fibonacci[i]*fibonacci[i+1] > n){
                if (fibonacci[i]*fibonacci[i-1] == n) {
                    finalArray[0] = fibonacci[i-1]
                    finalArray[1] = fibonacci[i]
                    finalArray[2] = 1
                }
                else {
                    finalArray[0] = fibonacci[i]
                    finalArray[1] = fibonacci[i+1]
                    finalArray[2] = 0
                }
            }
        }

        finalArray.forEach { println(it) }

return finalArray
    }
}*/

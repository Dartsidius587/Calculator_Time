package com.example.calculator_time

open class Translation {

    fun timeToInt(time:String): Int{
        var arrayHour: Array<Int> = arrayOf()
        var arrayMinutes: Array<Int> = arrayOf()
        var arraySec: Array<Int> = arrayOf()

        for (j in time.indices) {
            when(time[j]){
                'h' -> {
                    var count = 0
                    for (i in time.indices) {
                        if (time[i].lowercase() == "h") break
                        arrayHour += time[i].toInt() - 48
                    }
                    count = arrayHour.size + 1
                    for (i in count..<time.length) {
                        if (time[i].lowercase() == "m") break
                        arrayMinutes += time[i].toInt() - 48
                    }
                    count += arrayMinutes.size + 1
                    for (i in count..<time.length) {
                        if (time[i].lowercase() == "s") break
                        arraySec += time[i].toInt() - 48
                    }
                    return toInt(arrayHour) * 3600 + toInt(arrayMinutes) * 60 + toInt(arraySec)
                }
                'm' -> {
                    var count = 0
                    for (i in count..<time.length) {
                        if (time[i].lowercase() == "m") break
                        arrayMinutes += time[i].toInt() - 48
                    }
                    count += arrayMinutes.size + 1
                    for (i in count..<time.length) {
                        if (time[i].lowercase() == "s") break
                        arraySec += time[i].toInt() - 48
                    }
                    return toInt(arrayMinutes) * 60 + toInt(arraySec)
                }
                's' -> {
                    var count = 0
                    for (i in count..<time.length) {
                        if (time[i].lowercase() == "s") break
                        arraySec += time[i].toInt() - 48
                    }
                    return toInt(arraySec)
                }
                }
            }

        return 0
    }

    fun toInt(array: Array<Int>): Int{
        var count = 1
        var result = 0
        for (i in array.size - 1 downTo 0){
            result += array[i] * count
            count *= 10
        }
        return result
    }

    fun toTime(number: Int): String{
        var result =""
        val hour = number / 3600
        val minute = (number - hour * 3600) / 60
        val second = number - hour * 3600 - minute * 60
        result = "${hour}h${minute}m${second}s"
        return result
    }
}
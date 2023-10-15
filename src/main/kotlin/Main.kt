fun main() {

    val timeAgo = 60*60*24*6.0
    val result = "был(а) " + agoToText(timeAgo)
    println(result)
}

fun agoToText(time: Double): String {
    val compare: Boolean = true
    return when (compare) {
        0 < time && time<=60 -> "только что"
        60 < time && time<= 60 * 60 -> "была в сети " + time/60 + " "+ fixMinutes(time) + " назад"
        60 * 60 < time && time <= 24*60*60 -> "была в сети " + time/(60*60) + " " +fixHours(time)+ " назад"
        24*60*60 < time && time <= 2*24*60*60 -> "была в сети вчера"
        2*24*60*60 < time && time <= 3*24*60*60 -> "была в сети позавчера"
        else -> "была в сети давно"

    }
}

fun fixMinutes(time: Double): String {
return if (time/60 == 11.0) "минут" else
    when ((time/60).toString().takeLast(1)) {
    "1" -> "минуту"
    "2", "3", "4" -> "минуты"
    else -> "минут"
}
}

fun fixHours(time: Double): String {
    val hours = time/(60*60)
    return if (hours == 11.0) "часов" else
        when (hours.toString().takeLast(1)) {
            "1" -> "час"
            "2", "3", "4" -> "часа"
            else -> "часов"
        }


}



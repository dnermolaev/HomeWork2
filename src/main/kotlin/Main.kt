fun main() {

    val timeAgo = 14*60
    val result = "был(а) " + agoToText(timeAgo)
    println(result)
}

fun agoToText(time: Int): String {
    val compare: Boolean = true
    return when (compare) {
        0 < time && time <= 60 -> "только что"
        60 < time && time <= 60 * 60 -> "в сети " + time / 60 + " " + fixMinutes(time) + " назад"
        60 * 60 < time && time <= 24 * 60 * 60 -> "в сети " + time / (60 * 60) + " " + fixHours(time) + " назад"
        24 * 60 * 60 < time && time <= 2 * 24 * 60 * 60 -> "в сети вчера"
        2 * 24 * 60 * 60 < time && time <= 3 * 24 * 60 * 60 -> "в сети позавчера"
        else -> "в сети давно"

    }
}

fun fixMinutes(time: Int): String {
    val minutes = time / 60
    return if ((minutes == 11) || (minutes == 12) || (minutes == 13) || (minutes == 14)) "минут" else
        when ((time / 60).toString().takeLast(1)) {
            "1" -> "минуту"
            "2", "3", "4" -> "минуты"
            else -> "минут"
        }
}

fun fixHours(time: Int): String {
    val hours = time / (60 * 60)
    return if ((hours == 11) || (hours == 12) || (hours == 13) || (hours == 14)) "часов" else
        when (hours.toString().takeLast(1)) {
            "1" -> "час"
            "2", "3", "4" -> "часа"
            else -> "часов"
        }


}



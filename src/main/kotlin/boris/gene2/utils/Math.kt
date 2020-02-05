package boris.gene2.utils

fun round(d: Double, decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(d * multiplier) / multiplier
}
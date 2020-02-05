package boris.gene2.utils

/**
 * Быстрый Генератор случайных чисел для униформного распределения
 */
sealed class UniformRandoms(private val start_seed: Int = 397341824) {

    //randomizer

    private val m2 = 1073741824
    private val mic = 1693666955
    private val ia = 843314861
    private val ic = 453816693
    private val s = 4.65661287307739E-10

    private var seed = start_seed

    //получить случайное число в униформном распределении
    fun urand(): Double {
        //static seed=397341824;
        seed = seed * ia
        if (seed > mic) seed = seed - m2 - m2
        seed = seed + ic
        if (ic shr 1 > m2) seed = seed - m2 - m2
        if (seed < 0) seed = seed + m2 + m2
        return seed * s
    }

    fun reset() {
        seed = start_seed
    }

}

object Urand : UniformRandoms()

fun urand() = Urand.urand()

//Функция возвращаеь случайное целое число в интервале [0, count-1]
fun getRandomInt(count: Int): Int {
    return (count * Urand.urand()).toInt()
}

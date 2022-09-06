package ru.netology

import kotlin.math.roundToInt

class CommissionCalc {
    companion object {
        fun calcCommission(
            cardType: String = "VK Pay",
            sumInMonth: Int = 0,
            amountTransfer: Int
        ): Int = when (cardType) {
            "Mastercard", "Maestro" -> {
                when (sumInMonth + amountTransfer) {
                    in 0 until 600_000_00 -> when (amountTransfer) {
                        in 1 until 75_000_00 -> 0
                        in 75_000_00 until 150_000_00 -> (amountTransfer * 0.006 + 20_00).roundToInt()
                        else -> -1
                    }
                    else -> -1
                }
            }
            "Visa", "Мир" -> {
                when (sumInMonth + amountTransfer) {
                    in 0 until 600_000_00 -> when (amountTransfer) {
                        in 75_000_00 until 150_000_00 -> (amountTransfer * 0.0075).roundToInt()
                        in 35_00 until 75_000_00 -> (amountTransfer * 0.0075).roundToInt()
                        else -> -1
                    }
                    else -> -1
                }
            }
            "VK Pay" -> {
                when (sumInMonth + amountTransfer) {
                    in 0 until 40_000_00 -> when (amountTransfer) {
                        in 1 until 15_000_00 -> 0
                        else -> -1
                    }
                    else -> -1
                }
            }
            else -> -1
        }
    }
}
package ru.netology

import kotlin.math.roundToInt

class CommissionCalc {
    companion object {
        const val TYPE_CARD_MASTERCARD = "Mastercard"
        const val TYPE_CARD_MAESTRO = "Maestro"
        const val TYPE_CARD_VISA = "Visa"
        const val TYPE_CARD_MIR = "Mir"
        const val TYPE_CARD_VK_PAY = "VK Pay"
        const val MIN_TRANSFER_AMOUNT = 35_00
        const val DAY_TRANSFER_LIMIT = 150_000_00
        const val DAY_TRANSFER_LIMIT_VK_PAY = 15_000_00
        const val MONTH_TRANSFER_LIMIT = 600_000_00
        const val MONTH_TRANSFER_LIMIT_VK_PAY = 40_000_00
        const val TRANSFER_ERROR = -1
        const val TRANSFER_LIMIT_ERROR = -2
        const val CARD_TYPE_ERROR = -3

        fun calcCommission(
            cardType: String = TYPE_CARD_VK_PAY,
            sumInMonth: Int = 0,
            amountTransfer: Int
        ): Int = when (cardType) {
            TYPE_CARD_MASTERCARD, TYPE_CARD_MAESTRO -> {
                when (sumInMonth + amountTransfer) {
                    in 0 until MONTH_TRANSFER_LIMIT -> when (amountTransfer) {
                        in 1 until 75_000_00 -> 0
                        in 75_000_00 until DAY_TRANSFER_LIMIT -> (amountTransfer * 0.006 + 20_00).roundToInt()
                        else -> TRANSFER_ERROR
                    }
                    else -> TRANSFER_LIMIT_ERROR
                }
            }
            TYPE_CARD_VISA, TYPE_CARD_MIR -> {
                when (sumInMonth + amountTransfer) {
                    in 0 until MONTH_TRANSFER_LIMIT -> when (amountTransfer) {
                        in MIN_TRANSFER_AMOUNT until 75_000_00 -> (amountTransfer * 0.0075).roundToInt()
                        in 75_000_00 until DAY_TRANSFER_LIMIT -> (amountTransfer * 0.0075).roundToInt()
                        else -> TRANSFER_ERROR
                    }
                    else -> TRANSFER_LIMIT_ERROR
                }
            }
            TYPE_CARD_VK_PAY -> {
                when (sumInMonth + amountTransfer) {
                    in 0 until MONTH_TRANSFER_LIMIT_VK_PAY ->
                        if (amountTransfer in 1 until DAY_TRANSFER_LIMIT_VK_PAY) 0 else TRANSFER_ERROR
                    else -> TRANSFER_LIMIT_ERROR
                }
            }
            else -> CARD_TYPE_ERROR
        }
    }
}
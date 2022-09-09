package ru.netology

fun main() {
//    "Mastercard", "Maestro", "Visa", "Мир", "VK Pay"
    val cardType = "Mastercard"
    val sumInMonth = 430_000_00
    val amountTransfer = 143_000_00

    when {
        CommissionCalc.calcCommission(cardType, sumInMonth, amountTransfer) == CommissionCalc.TRANSFER_ERROR -> println("Ошибка перевода!")
        CommissionCalc.calcCommission(cardType, sumInMonth, amountTransfer) == CommissionCalc.TRANSFER_LIMIT_ERROR -> println("Превышен лимит перевода")
        CommissionCalc.calcCommission(cardType, sumInMonth, amountTransfer) == CommissionCalc.CARD_TYPE_ERROR -> println("Неподдерживаемый тип карты")
        else -> println("Комиссия составлет: ${CommissionCalc.calcCommission(cardType, sumInMonth, amountTransfer)} коп.")
    }
}
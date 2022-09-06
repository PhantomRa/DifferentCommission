package ru.netology

fun main() {
//    "Mastercard", "Maestro", "Visa", "Мир", "VK Pay"
    val cardType = "Mastercard"
    val sumInMonth = 430_000_00
    val amountTransfer = 143_000_00

    if (CommissionCalc.calcCommission(cardType, sumInMonth, amountTransfer) != -1)
        println("Комиссия составлет: ${CommissionCalc.calcCommission(cardType, sumInMonth, amountTransfer)} коп.")
    else println("Ошибка перевода!")
}
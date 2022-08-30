package ru.netology

fun main() {
//    "Mastercard", "Maestro", "Visa", "Мир", "VK Pay"
    val cardType = "Mastercard"
    val sumInMonth = 430_000_00
    val money = 143_000_00

    if (CommissionCalc.calcCommission(cardType, sumInMonth, money) != money)
        println("Комиссия составлет: ${CommissionCalc.calcCommission(cardType, sumInMonth, money)} коп.")
    else println("Ошибка перевода!")
}
import org.junit.Test

import org.junit.Assert.*
import ru.netology.CommissionCalc.Companion.calcCommission

class MainKtTest {

    @Test
    fun calcCommissionTest() {

//        "Mastercard" & "Maestro"
        assertEquals(-1, calcCommission("Maestro", amountTransfer = 0))
        assertEquals(0, calcCommission("Maestro", 150_000_00, 45_000_00))
        assertEquals(890_00, calcCommission("Maestro", 150_000_00, 145_000_00))
        assertEquals(-1, calcCommission("Mastercard", amountTransfer = 245_000_00))
        assertEquals(-1, calcCommission("Maestro", 570_000_00, 45_000_00))

//        "Visa" & "Мир"
        assertEquals(-1, calcCommission("Visa", amountTransfer = 30_00))
        assertEquals(337_50, calcCommission("Visa", 150_000_00, 45_000_00))
        assertEquals(1_087_50, calcCommission("Visa", amountTransfer = 145_000_00))
        assertEquals(-1, calcCommission("Visa", 570_000_00, 45_000_00))

//        "VK Pay"
        assertEquals(-1, calcCommission(amountTransfer = 0))
        assertEquals(0, calcCommission("VK Pay", 20_000_00, 12_000_00))
        assertEquals(-1, calcCommission(amountTransfer = 25_000_00))
        assertEquals(-1, calcCommission(sumInMonth = 35_000_00, amountTransfer = 10_000_00))

//        Другие карты
        assertEquals(-1, calcCommission("Тинькофф", amountTransfer = 15_000_00))

//        Отрицательный перевод или 0
        assertEquals(-1, calcCommission(amountTransfer = -15_000_00))
        assertEquals(-1, calcCommission(amountTransfer = 0))

//        Ломает сборку
//        assertEquals(1, calcCommission(amountTransfer = 0))
    }
}
import org.junit.Test

import org.junit.Assert.*
import ru.netology.CommissionCalc.Companion.CARD_TYPE_ERROR
import ru.netology.CommissionCalc.Companion.TRANSFER_ERROR
import ru.netology.CommissionCalc.Companion.TRANSFER_LIMIT_ERROR
import ru.netology.CommissionCalc.Companion.TYPE_CARD_MAESTRO
import ru.netology.CommissionCalc.Companion.TYPE_CARD_MASTERCARD
import ru.netology.CommissionCalc.Companion.TYPE_CARD_MIR
import ru.netology.CommissionCalc.Companion.TYPE_CARD_VISA
import ru.netology.CommissionCalc.Companion.TYPE_CARD_VK_PAY
import ru.netology.CommissionCalc.Companion.calcCommission

class MainKtTest {

    @Test
    fun zeroTransferTest() {
        assertEquals(TRANSFER_ERROR, calcCommission(TYPE_CARD_MASTERCARD, amountTransfer = 0))
        assertEquals(TRANSFER_ERROR, calcCommission(TYPE_CARD_VISA, amountTransfer = 0))
        assertEquals(TRANSFER_ERROR, calcCommission(amountTransfer = 0))
    }

    @Test
    fun limitTransferTest() {
        assertEquals(TRANSFER_LIMIT_ERROR, calcCommission(TYPE_CARD_MASTERCARD, 550_000_00, 70_000_00))
        assertEquals(TRANSFER_ERROR, calcCommission(TYPE_CARD_MAESTRO, amountTransfer = 170_000_00))
        assertEquals(TRANSFER_LIMIT_ERROR, calcCommission(TYPE_CARD_VISA, 550_000_00, 70_000_00))
        assertEquals(TRANSFER_ERROR, calcCommission(TYPE_CARD_MIR, amountTransfer = 170_000_00))
        assertEquals(TRANSFER_LIMIT_ERROR, calcCommission(sumInMonth = 50_000_00, amountTransfer = 7_000_00))
        assertEquals(TRANSFER_ERROR, calcCommission(amountTransfer = 20_000_00))
        assertEquals(TRANSFER_ERROR, calcCommission(TYPE_CARD_VISA, amountTransfer = 20_00))
        assertEquals(TRANSFER_LIMIT_ERROR, calcCommission(TYPE_CARD_MASTERCARD, amountTransfer = -50_000_00))
        assertEquals(TRANSFER_LIMIT_ERROR, calcCommission(TYPE_CARD_VISA, amountTransfer = -50_000_00))
        assertEquals(TRANSFER_LIMIT_ERROR, calcCommission(TYPE_CARD_VK_PAY, amountTransfer = -5_000_00))
    }

    @Test
    fun cardTypeErrorTest() {
        assertEquals(CARD_TYPE_ERROR, calcCommission("CARD", amountTransfer = 500))
    }

    @Test
    fun transferTest() {
        assertEquals(0, calcCommission(TYPE_CARD_MASTERCARD, amountTransfer = 50_000_00))
        assertEquals(620_00, calcCommission(TYPE_CARD_MAESTRO, amountTransfer = 100_000_00))
        assertEquals(37_50, calcCommission(TYPE_CARD_VISA, amountTransfer = 5_000_00))
        assertEquals(562_50, calcCommission(TYPE_CARD_MIR, amountTransfer = 75_000_00))
        assertEquals(0, calcCommission(amountTransfer = 5_000_00))
    }

    @Test
    fun brokenBuildTest() {
//        Ломает сборку
//        assertEquals(1, calcCommission(amountTransfer = 0))
    }
}
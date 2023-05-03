package strings.tests;

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.*;

public class TelegramPaymentReceiptTest {
    @Test
    public void testTelegramPaymentReceipt() {
        String telegram = "STOP. ARRIVING PARIS 9 A.M. THURSDAY. CAN-NOT MEET YOU. REGRET. MARY.";
        double pricePerWord = 0.05;
        double expectedCost = 0.55;
        double result = StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord);
        assertEquals(expectedCost, result, 0.0001);
    }

    @Test
    public void testTelegramPaymentReceiptEmptyTelegram() {
        String telegram = "";
        double pricePerWord = 0.1;
        double expectedCost = 0.0;
        double result = StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord);
        assertEquals(expectedCost, result, 0.0001);
    }

    @Test
    public void testTelegramPaymentReceiptZeroPricePerWord() {
        String telegram = "URGENT. NEED HELP. STOP.";
        double pricePerWord = 0.0;
        double expectedCost = 0.0;
        double result = StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord);
        assertEquals(expectedCost, result, 0.0001);
    }

    @Test
    public void testTelegramPaymentReceiptNegativePricePerWord() {
        String telegram = "URGENT. NEED HELP. STOP.";
        double pricePerWord = -0.05;
        assertThrows(IllegalArgumentException.class, () -> StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord));
    }

}

import org.junit.jupiter.api.Test;
import strings.StringTaskSolver;

import static org.junit.jupiter.api.Assertions.*;

public class TelegramPaymentReceiptTest {
    @Test
    public void TelegramPaymentReceiptTest() {
        String telegram = "STOP. ARRIVING PARIS 9 A.M. THURSDAY. CAN-NOT MEET YOU. REGRET. MARY.";
        double pricePerWord = 0.05;
        double expectedCost = 0.55;
        double result = StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord);
        assertEquals(expectedCost, result, 0.0001);
    }

    @Test
    public void TelegramPaymentReceiptEmptyTelegramTest() {
        String telegram = "";
        double pricePerWord = 0.1;
        double expectedCost = 0.0;
        double result = StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord);
        assertEquals(expectedCost, result, 0.0001);
    }

    @Test
    public void TelegramPaymentReceiptZeroPricePerWordTest() {
        String telegram = "URGENT. NEED HELP. STOP.";
        double pricePerWord = 0.0;
        double expectedCost = 0.0;
        double result = StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord);
        assertEquals(expectedCost, result, 0.0001);
    }

    @Test
    public void TelegramPaymentReceiptNegativePricePerWordTest() {
        String telegram = "URGENT. NEED HELP. STOP.";
        double pricePerWord = -0.05;
        assertThrows(IllegalArgumentException.class, () -> StringTaskSolver.telegramPaymentReceipt(telegram, pricePerWord));
    }

}

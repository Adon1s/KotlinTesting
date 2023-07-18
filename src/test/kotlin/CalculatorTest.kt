import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun testAdd() {
        assertEquals(4, calculator.add(2, 2))
        assertEquals(0, calculator.add(-2, 2))
    }

    @Test
    fun testSubtract() {
        assertEquals(0, calculator.subtract(2, 2))
        assertEquals(-4, calculator.subtract(-2, 2))
    }

    @Test
    fun testMultiply() {
        assertEquals(4, calculator.multiply(2, 2))
        assertEquals(-4, calculator.multiply(-2, 2))
    }

    @Test
    fun testDivide() {
        assertEquals(1, calculator.divide(2, 2))
        assertNull(calculator.divide(2, 0))
    }

    @Test
    fun testIsPositive() {
        assertTrue(calculator.isPositive(1))
        assertFalse(calculator.isPositive(-1))
    }
}
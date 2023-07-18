class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val calculator = Calculator()
            val a = 5
            val b = 3

            println("Running calculations for $a and $b")

            val sum = calculator.add(a, b)
            println("Sum: $sum")

            val difference = calculator.subtract(a, b)
            println("Difference: $difference")

            val product = calculator.multiply(a, b)
            println("Product: $product")

            val quotient = calculator.divide(a, b)
            println("Quotient: $quotient")
        }
    }
}

import calculate.*;

import java.util.List;

public class Calculator {
    private static List<newArithmeticOperator> arithmeticOperators = List.of(
            new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicationOperator(),
            new DivisionOperator());
    public static int calculate(int operand1, String arithmetic, int operand2) {
        // using enum
        // return ArithmeticOperator.calculate(operand1, arithmetic, operand2);
        // using interface
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(arithmetic))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1,operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operator was given"));

    }
}

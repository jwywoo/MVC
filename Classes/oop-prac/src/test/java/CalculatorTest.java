import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    @DisplayName("Addition")
    @Test
    public void additionTest() {
        int result = Calculator.calculate(1,"+",2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Subtraction")
    @Test
    public void subtractionTest() {
        int result = Calculator.calculate(1, "-",2);
        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("Calculation test")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    public void calculationTest(int operand1, String operator, int operand2, int result){
        int testResult = Calculator.calculate(operand1,operator,operand2);

        assertThat(testResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1,"+",1,2),
                arguments(1,"-",1,0),
                arguments(1,"*",2,2),
                arguments(4,"/",1,4)
        );
    }

    @DisplayName("Raise an error if user tried to divide it by 0")
    @Test
    void calculationExceptionTest() {
        assertThatCode(() ->Calculator.calculate(10,"/",0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't do zero division");
    }
}

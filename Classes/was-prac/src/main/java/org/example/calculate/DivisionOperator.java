package calculate;

public class DivisionOperator implements newArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if (operand1 == 0|| operand2 == 0) {
            throw new IllegalArgumentException("Can't do zero division");
        } else {
            return operand1 / operand2;
        }
    }
}

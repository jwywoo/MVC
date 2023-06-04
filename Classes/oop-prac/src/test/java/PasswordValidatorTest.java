import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/**
 * Password length has to be 8 to 12 inclusive
 * **/
public class PasswordValidatorTest {
    @DisplayName("Doesn't raise an error if password is longer than 8 and shorter than 12")
    @Test
    void validatePasswordTest1() {
        assertThatCode(()->PasswordValidator.validate("12345678"))
                .doesNotThrowAnyException();
    }

    @DisplayName("Raise an error if password is shorter than 8 and longer than 12")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567899999"})
    void validatePasswordTest2(String passwords) {
        assertThatCode(()->PasswordValidator.validate(passwords))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Password is too long or short");
    }
}

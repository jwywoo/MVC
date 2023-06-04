public class PasswordValidator {

    public static final String PASSWORD_WRONG = "Password is too long or short";

    public static void validate(String password) {
        int pLength = password.length();

        if (pLength < 7 || pLength > 12){
            throw new IllegalArgumentException(PASSWORD_WRONG);
        }
    }
}

package Password;

public class ValidatePasswordLength implements PasswordCriteria {

    @Override
    public Boolean validatePassword (String password) {

        int minLength = 8;
        int maxLength = 32;

        return password.length() >= minLength && password.length() <= maxLength;

    }
}

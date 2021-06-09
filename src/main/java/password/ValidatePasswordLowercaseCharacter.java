package password;

import java.util.regex.Pattern;

public class ValidatePasswordLowercaseCharacter implements PasswordCriteria {

    @Override
    public Boolean validatePassword(String password) {

        return Pattern.matches(".*[a-z].*", password);

    }
}


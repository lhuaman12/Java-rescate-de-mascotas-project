package Password;

import java.util.regex.Pattern;

public class ValidatePasswordCapitalLetter implements PasswordCriteria {

    @Override
    public Boolean validatePassword(String password) {

        return Pattern.matches(".*[A-Z].*", password);

    }
}


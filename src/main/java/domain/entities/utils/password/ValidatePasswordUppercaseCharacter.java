package domain.entities.utils.password;

import java.util.regex.Pattern;

public class ValidatePasswordUppercaseCharacter implements PasswordCriteria {

    @Override
    public Boolean validatePassword(String password) {

        return Pattern.matches(".*[A-Z].*", password);

    }
}


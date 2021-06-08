package password;

import java.util.regex.Pattern;

public class ValidatePasswordNumber implements PasswordCriteria {

    @Override
    public Boolean validatePassword (String password) {

        return Pattern.matches(".*[0-9].*", password);

    }
}

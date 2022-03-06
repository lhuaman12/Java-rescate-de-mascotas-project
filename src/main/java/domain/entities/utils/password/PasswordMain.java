package domain.entities.utils.password;

import java.io.IOException;
import java.util.ArrayList;

public class PasswordMain {

    public static void main(String[] args) throws IOException {

        ValidatePassword validatePassword = new ValidatePassword();
        ValidatePasswordLength validatePasswordLength = new ValidatePasswordLength();
        ValidatePasswordNumber validatePasswordNumber = new ValidatePasswordNumber();
        ValidatePasswordLowercaseCharacter validatePasswordLowercaseCharacter = new ValidatePasswordLowercaseCharacter();
        ValidatePasswordUppercaseCharacter validatePasswordUppercaseCharacter = new ValidatePasswordUppercaseCharacter();
        ValidatePasswordSpecialCharacter validatePasswordSpecialCharacter = new ValidatePasswordSpecialCharacter();
        ValidatePasswordDictionary validatePasswordDictionary = new ValidatePasswordDictionary();

        ArrayList<PasswordCriteria> passwordCriteria = new ArrayList<>();

        passwordCriteria.add(validatePasswordLength);
        passwordCriteria.add(validatePasswordNumber);
        passwordCriteria.add(validatePasswordLowercaseCharacter);
        passwordCriteria.add(validatePasswordUppercaseCharacter);
        passwordCriteria.add(validatePasswordSpecialCharacter);
        passwordCriteria.add(validatePasswordDictionary);

        validatePassword.setPasswordCriteria(passwordCriteria);
        String password = "P4ssw0rd?";

        // Test Utils.password
        if ( validatePassword.validatePassword(password) )
            System.out.println("Password OK");
        else
            System.out.println("Password NOT OK");

        // Test Utils.password length
        if ( validatePasswordLength.validatePassword(password) )
            System.out.println("Password length OK");
        else
            System.out.println("Password length NOT OK");

        // Test Utils.password number
        if ( validatePasswordNumber.validatePassword(password) )
            System.out.println("Password number OK");
        else
            System.out.println("Password number NOT OK");

        // Test Utils.password lowercase character
        if ( validatePasswordLowercaseCharacter.validatePassword(password))
            System.out.println("Password lowercase character OK");
        else
            System.out.println("Password lowercase character NOT OK");

        // Test Utils.password uppercase character
        if ( validatePasswordUppercaseCharacter.validatePassword(password) )
            System.out.println("Password uppercase character OK");
        else
            System.out.println("Password uppercase character NOT OK");

        // Test Utils.password special character
        if (validatePasswordSpecialCharacter.validatePassword(password))
            System.out.println("Password special character OK");
        else
            System.out.println("Password special character NOT OK");

        // Test dictionary
        if ( validatePasswordDictionary.validatePassword(password) )
            System.out.println("Password dictionary OK");
        else
            System.out.println("Password dictionary NOT OK");

    }
}

package Password;

import java.io.IOException;
import java.util.ArrayList;

public class PasswordMain {

    public static void main(String[] args) throws IOException {

        ValidatePassword validatePassword = new ValidatePassword();
        ValidatePasswordLength validatePasswordLength = new ValidatePasswordLength();
        ValidatePasswordNumber validatePasswordNumber = new ValidatePasswordNumber();
        ValidatePasswordCapitalLetter validatePasswordCapitalLetter = new ValidatePasswordCapitalLetter();
        ValidatePasswordSpecialCharacter validatePasswordSpecialCharacter = new ValidatePasswordSpecialCharacter();
        //ValidatePasswordDictionary validatePasswordDictionary = new ValidatePasswordDictionary();

        ArrayList<PasswordCriteria> passwordCriteria = new ArrayList<>();

        passwordCriteria.add(validatePasswordLength);
        passwordCriteria.add(validatePasswordNumber);
        passwordCriteria.add(validatePasswordCapitalLetter);
        passwordCriteria.add(validatePasswordSpecialCharacter);
        //passwordCriteria.add(validatePasswordDictionary);

        validatePassword.setPasswordCriteria(passwordCriteria);
        String password = "P4ssw0rd?";

        // Test password
        if ( validatePassword.validatePassword(password) )
            System.out.println("Password OK");
        else
            System.out.println("Password NOT OK");

        // Test password length
        if ( validatePasswordLength.validatePassword(password) )
            System.out.println("Password length OK");
        else
            System.out.println("Password length NOT OK");

        // Test password number
        if ( validatePasswordNumber.validatePassword(password) )
            System.out.println("Password number OK");
        else
            System.out.println("Password number NOT OK");

        // Test password capital letter
        if ( validatePasswordCapitalLetter.validatePassword(password) )
            System.out.println("Password capital letter OK");
        else
            System.out.println("Password capital letter NOT OK");

        // Test password special character
        if (validatePasswordSpecialCharacter.validatePassword(password))
            System.out.println("Password special character OK");
        else
            System.out.println("Password special character NOT OK");

        /*
        // Test dictionary
        if ( validatePasswordDictionary.validatePassword(password) )
            System.out.println("Password dictionary OK");
        else
            System.out.println("Password dictionary NOT OK");
        */
    }
}

package domain.entities.utils.password;

import java.io.IOException;
import java.util.List;

public class ValidatePassword {

    private List<PasswordCriteria> passwordCriteria;

    public Boolean validatePassword(String password) {
        return this.passwordCriteria.stream()
                .map(criteria -> {
                    try {
                        return criteria.validatePassword(password);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    return null;
                })
                .reduce(Boolean::logicalAnd).get();
    }

    public List<PasswordCriteria> getPasswordCriteria() {

        return passwordCriteria;
    }

    public void setPasswordCriteria(List<PasswordCriteria> passwordCriteria) {

        this.passwordCriteria = passwordCriteria;

    }

    public void addCriteria(PasswordCriteria passwordCriteria) {

        this.passwordCriteria.add(passwordCriteria);

    }
}


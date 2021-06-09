package Usuarios;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Cuenta {
    private String user;
    private String password;

    public Cuenta(String user, String password){
        this.user=user;
        this.password=password;
    }

    public Boolean esIgual(String user) {
        if (this.user == user) {
            return true;
        }else{
            return false;
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package domain.Usuarios;

import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;

public class Cuenta {
    private String username;
    private String password;

    public Cuenta(String user, String password){
        this.username=user;
        this.password=password;
    }

    public Boolean esIgual(String user) {
        if (this.username == user) {
            return true;
        }else{
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

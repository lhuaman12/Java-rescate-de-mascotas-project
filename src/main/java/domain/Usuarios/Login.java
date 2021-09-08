package domain.Usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "login")
public class Login {

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Date lastSuccessLogin;
    @Column
    private int loginFailCounter;
    @Column
    private Date passwordLastSet;
    @Column
    private Date dateCreated;
    @Column
    private char status;


    public Login(String username,
                 String password,
                 Date lastSuccessLogin,
                 int loginFailCounter,
                 Date passwordLastSet,
                 Date dateCreated,
                 char status) {

        this.username = username;
        this.password = password;
        this.lastSuccessLogin = lastSuccessLogin;
        this.loginFailCounter = loginFailCounter;
        this.passwordLastSet = passwordLastSet;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastSuccessLogin() {
        return lastSuccessLogin;
    }

    public void setLastSuccessLogin(Date lastSuccessLogin) {
        this.lastSuccessLogin = lastSuccessLogin;
    }

    public int getLoginFailCounter() {
        return loginFailCounter;
    }

    public void setLoginFailCounter(int loginFailCounter) {
        this.loginFailCounter = loginFailCounter;
    }

    public Date getPasswordLastSet() {
        return passwordLastSet;
    }

    public void setPasswordLastSet(Date passwordLastSet) {
        this.passwordLastSet = passwordLastSet;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}

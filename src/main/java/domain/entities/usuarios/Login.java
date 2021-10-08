package domain.entities.usuarios;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(columnDefinition = "DATE")
    private Date lastSuccessLogin;

    @Column
    private int loginFailCounter;

    @Column(columnDefinition = "DATE")
    private Date passwordLastSet;

    @Column(columnDefinition = "DATE")
    private Date dateCreated;

    @Column
    private char status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Password> passwords;       // Password history


    // Constructor

    public Login() {
        this.passwords = new ArrayList<>();
    }

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

        this.passwords = new ArrayList<>();

    }


    // Getters and Setters

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

    // ToDo
    public void setPasswords(List<Password> passwords) {
        this.passwords = passwords;
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

    public List<Password> getPasswords() {
        return passwords;
    }

    //

}

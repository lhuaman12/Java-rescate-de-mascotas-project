package domain.entities.usuarios;

import com.twilio.rest.api.v2010.account.incomingphonenumber.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "password_history")
public class Password {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String password;

    @Column(columnDefinition = "DATE")
    private LocalDate setDate;


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getSetDate() {
        return setDate;
    }

    public void setSetDate(LocalDate setDate) {
        this.setDate = setDate;
    }

    //
}

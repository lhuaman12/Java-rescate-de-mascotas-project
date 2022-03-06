package domain.entities.utils.QR;

import javax.persistence.*;

@Entity
@Table(name = "QR")
public class QR {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String URL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

}

package it.paleocapa.mastroiannim.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
CREATE TABLE bot_user(objectId SERIAL PRIMARY KEY, username TEXT NOT NULL, firstname TEXT NOT NULL, lastname TEXT NOT NULL, value REAL);
INSERT INTO bot_user(username, firstname, lastname, value)
SELECT LEFT(md5(i::TEXT), 10), LEFT(md5(i::TEXT), 10), LEFT(md5(i::TEXT), 10), random() FROM generate_series(1, 10) s(i);
SELECT * FROM bot_user;
 */

@Entity
@Table(name = "bot_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objectid")
    private Long objectId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String userName;

    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public User() {
        // Costruttore vuoto
    }

    public User(Long objectId, String userName, String firstName, String lastName) {
        this.objectId = objectId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getObjectId() {
        return objectId;
    }

    public String toString(){
        return userName;
    }
}


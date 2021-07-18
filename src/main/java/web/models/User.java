package web.models;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private long id;

    @NotEmpty(message = "Поле имя не может быть пустым")
    @Size(max = 30, message = "Некорректное имя")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Поле фамилия не может быть пустым")
    @Size(max = 30, message = "Некорректная фамилия")
    @Column(name = "surname")
    private String surname;

    @Min(value = 0, message = "Поле возраст не может быть отрицательным")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Поле email не должно быть пустым")
    @Email(message = "email введен некорректно")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(long id, String name, String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package ru.chedmitriy.models;

import java.util.Objects;

public class User {
    /**
     * перечисление ролей
     * */
    public enum Role {
        ADMINISTRATOR,USER,GUEST
    }

    /**
     * идентификатор
     * пользователя
     */
    private  int id;
    /**
     * имя пользователя
     */
    private  String name;
    /**
     * почта пользователя
     */
    private  String email;
    /**
     * дата регистрации
     */
    private  String create;
    /**
     * пароль
     */
    private  String password;
    /**
     * логин
     */
    private  String login;
    /**
     * роль
     */
    private Role role = Role.GUEST;


    /**
     * конструктор
     * без ролей для отображения
     * незарегистрированным
     * пользователям
     * @param id
     * @param name
     * @param email
     * @param create
     */
    public User(int id, String name, String email, String create) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.create = create;

    }

    /**
     * конструктор
     * с ролями для отображения
     * полей администратору
     * и пользователю
     * @param id
     * @param name
     * @param email
     * @param create
     * @param login
     * @param password
     * @param role
     */
    public User(int id, String name, String email, String create, String login, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.create = create;
        this.password = password;
        this.login = login;
        this.role = role;
    }

    /**
     * метод сравненния
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(create, user.create) &&
                Objects.equals(password, user.password) &&
                Objects.equals(login, user.login) &&
                role == user.role;
    }

    /**
     * получаем хэшкод
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, create, password, login, role);
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreate() {
        return create;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Role getRole() {
        return role;
    }
    @Override
    public String toString() {
        return "User  "+id+": "+"name"+" "+name+" "+"email"+" "+email+" "+"login"+" "+login+" "+"password"+" "+password+" "+"role"+" "+role;
    }
}

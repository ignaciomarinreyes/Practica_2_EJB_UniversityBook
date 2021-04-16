package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private static int idUser = 0;
    private int id;
    private List<Post> posts;
    private Set<Subject> subjects;
    private String nickname;
    private String password;
    private String name;
    private String surname;
    private Rol rol;
    private Address address;
    private University university;
    private Degree degree;

    public User(String nickname, String password, String name, String surname, Rol rol, Address address, University university, Degree degree) {
        this.id = idUser++;
        this.posts = new ArrayList<Post>();
        this.subjects = new HashSet<Subject>();
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.address = address;
        this.university = university;
        this.degree = degree;
    }

    public User(String nickname, String password, String name, String surname, Rol rol, Address address) {
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.address = address;
        this.subjects = new HashSet<Subject>();
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public int getId() {
        return id;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nickname=" + nickname + ", password=" + password + ", name=" + name + ", surname=" + surname + ", rol=" + rol + ", address=" + address + ", university=" + university + ", degree=" + degree + '}';
    }

}

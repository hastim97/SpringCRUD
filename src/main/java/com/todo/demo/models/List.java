package com.todo.demo.models;
import javax.persistence.*;

@Entity
@Table(name="list")
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="list_name")
    String listName;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public List(){}

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", listName='" + listName + '\'' +
                ", user=" + user +
                '}';
    }

    public List(String listName, User user) {
        this.listName = listName;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

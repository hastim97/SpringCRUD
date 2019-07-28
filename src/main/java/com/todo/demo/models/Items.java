package com.todo.demo.models;

import javax.persistence.*;

@Entity
@Table(name="items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="data")
    String data;

    @Column(name = "is_checked")
    int checked;

    @ManyToOne
    @JoinColumn(name = "list_id",referencedColumnName = "id")
    private List list;

    public Items(String data, int checked, List list) {
        this.data = data;
        this.checked = checked;
        this.list = list;
    }

    public Items(){}


    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", checked=" + checked +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}

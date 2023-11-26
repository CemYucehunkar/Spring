package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "color")

public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id", columnDefinition = "serial")
    private  int id;

@Column(name = "color_name",nullable = false)
    private  String  name;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @ManyToMany(mappedBy = "colorList")// sen kendini birleştirip maplerken bu colorList tablosuna göre maplyeceksin demek
private List<Product> productList;

    public Color() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

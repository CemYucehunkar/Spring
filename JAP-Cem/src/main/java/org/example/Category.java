package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)// cascade illişkisinde kodlar arasındaki ilişkiler düşünülmeli
    private List<Product> productList; // eğer bir cascade iiçin o category de yapılan değişiklik karşısında başka şeyler boşa düşüyor mu başka şeylerin tamamı etkileniyor m diye düşünmek lazm.

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' + '}';
    }
}

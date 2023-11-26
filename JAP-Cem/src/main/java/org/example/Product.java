package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, columnDefinition = "serial")
    private int id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private double price;
    @Column(name = "product_stock")
    private int stock;


    // Aralarında bir joinleme işlemi yapacağımız yapıları birbirinden forenkey alacak yapıları aşağıdaki gibi bağlarız
    // Aralarındaki ilişki birebir bir ilişki ise @onetone etiketi ekleyip
    // product tablosundaki sütun adını verirken JoinColumn diye oluştururruz.
    // önce product tablosunda ismini oluşturup sonra referans olarak hangi geldiği tablodaki sütun adını alcak
    @OneToOne
    @JoinColumn(name = "product_code_id", referencedColumnName = "code_id")
    private Code code;// vee geldiği yeri bu prodcta bir  değişken gibi tanımlayacağız.
    // ------->>>> sonra Code classna gidip orada da maplememiz lazm. 20 .satıra bak.

    @ManyToOne// çoktan aza bir ilişki var. Yani  bir satıcının birden çok ürünü olabilir.
    //Ama bir ürünün bir satıcısı olur.
    @JoinColumn(name = "product_supplier_id", referencedColumnName = "supplier_id")
// supplier kısmına gidip bunun oradan maplendiğini de belirtmemiz lazm
    private Supplier supplier;// supplier kısmında 25.satıra bak

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id")
    private Category category;


    @ManyToMany(fetch = FetchType.LAZY)/// MANY TO MANY ilişkilerde  bu tarz bir yapı kuracağız.// fetch LAZY yapısı ile de ihtiyaç olduğu zaman sorgu yapması için kkomut veriyoruz .
    //Eğer bunu lazy yapmazsak boş bırakırsak otomatik o varsayılan olan EAGER ı kendi yapıyor. Bu da her seferinde gereksiz join yapıları kurup sistem yükünü artırıyor.
    @JoinTable(  //Join colom da sütun   yerine artık tablo birleştiriyoruz.
            name = "pro2colors",// oluşacak tablonun adını belirtiyoruz.
            joinColumns = {@JoinColumn(name = "pro2color_product_id")},// Hangi tablo asılsa o buraya
            inverseJoinColumns = {@JoinColumn(name = "pro2color_color_id")} // hangi tablo diğerinin alt özelliği ise o da buraya
    )
    private List<Color> colorList;// Bunlar birden fazla renk olabileceği içi LİST olacak
    // şimdi karşılığı olan yer COLOR a gidip orada da tanımlamak llazm

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Product() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", code=" + code +
                ", supplier=" + supplier +
                ", category=" + category +
                ", colorList=" + colorList +
                '}';
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

}

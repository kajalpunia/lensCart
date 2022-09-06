package com.lenscart.productms.entity;


import javax.persistence.*;
import java.util.Objects;

@Table(name = "products")
public class Products {
    @GeneratedValue
    @Id
    @Column(name = "productId")
    private Long id;

    @Column(name = "productType", nullable = false)
    private String type;

    @Column(name = "productName", nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String colour;

    @Column(name = "lensPower")
    private String power;

    @Column(nullable = false)
    private String shape;

    @Column(name = "description")
    private Long description;

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getBrand() { return brand;}

    public void setBrand(String brand) { this.brand = brand;}

    public String getColour() { return colour;}

    public void setColour(String colour) { this.colour = colour;}

    public String getPower() { return power;}

    public void setPower(String power) { this.power = power;}

    public String getShape() { return shape;}

    public void setShape(String shape) { this.shape = shape;}

    public Long getDescription() { return description;}

    public void setDescription(Long description) { this.description = description;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id.equals(products.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

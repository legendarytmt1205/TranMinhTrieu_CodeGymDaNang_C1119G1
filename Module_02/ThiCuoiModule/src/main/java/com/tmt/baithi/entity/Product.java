package com.tmt.baithi.entity;

import org.springframework.format.Formatter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "not empty")
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @NotNull(message = "not empty")
    @Column(name = "price")
    private int price;

    @NotNull(message = "not empty")
    @Column(name = "quantily")
    private int quantily;

    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "create_day")
    private LocalDate create_day;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name = "des")
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public LocalDate getCreate_day() {
        return create_day;
    }

    public void setCreate_day(LocalDate create_day) {
        this.create_day = create_day;
    }

    public Product() {
    }
}

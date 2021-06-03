package com.projeto.bootcamp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="stock")
public class Stock {

//    @GeneratedValue(strategy= GenerationType.AUTO)
// faz o autoincrement mas caso o auto_invremente seha feito na banco
 //   use GenerationType.IDENTIFY
  //  @Column(name ="id")

    @Id     //diz que é chave primaria
    @GeneratedValue(strategy= GenerationType.AUTO)  //faz o autoincrement caso o auto_invremente seha feito na banco
    @Column(name ="id")
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="price")
    private Double price;
    @Column(name ="date")
    private LocalDate date;
    @Column(name ="variation")
    private Double variation;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}

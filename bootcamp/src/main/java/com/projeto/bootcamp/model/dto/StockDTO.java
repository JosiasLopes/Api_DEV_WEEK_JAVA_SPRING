package com.projeto.bootcamp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

//o dto é a classe que faz a interação com o servidor
//a anotation @NotNull vem da lib validation e erve para validar os campos dizendo que não podem vir null
//@DecimalMin(value="0.00") essa anotation define o minimo para que um parametro seja passado
//@Digits(integer = 6,fraction = 2) permite somente numeros de 6 digitos na parte decimal e 2 na fração
//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
//os parametros são 1 formata a data como string
//2 pattern o padrao em string no caso foi dd/MM/yyyy padrão brasileiro de datas
public class StockDTO {
    private Long ID;

    @NotNull
    private String name;
    @NotNull
    @DecimalMin(value="0.00")
    @Digits(integer = 6,fraction = 2)
    private Double price;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate date;
    @NotNull
    @Digits(integer = 3,fraction = 2)
    private Double variation;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

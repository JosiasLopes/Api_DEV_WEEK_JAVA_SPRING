package com.projeto.bootcamp.mapper;


import com.projeto.bootcamp.model.Stock;
import com.projeto.bootcamp.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component //tem a mesma fun~ção de repository
public class StockMapper {

    //essa é responsavel por transformar um dto em entidade
    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getID());
        stock.setName(dto.getName());
        stock.setDate(dto.getDate());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        return stock;
    }


    public StockDTO ToDto(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setID(stock.getId());
        dto.setName(stock.getName());
        dto.setDate(stock.getDate());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        return dto;
    }

    public List<StockDTO> ToDto(List<Stock> lstEstock) {
        return lstEstock.stream().map(this::ToDto).collect(Collectors.toList());
    }
}

package com.projeto.bootcamp.repository;

import com.projeto.bootcamp.model.Stock;
import com.projeto.bootcamp.model.dto.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository  //essa anotation permite que o spring gerencia as instancia automaticamente
public interface StockRepository extends JpaRepository<Stock,Long> {
    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    @Query("SELECT stock "+
            "From Stock stock"+
    " WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

    @Query("SELECT stock "+
            "From Stock stock"+
            " WHERE stock.date = :date")
    Optional<List<Stock>> findByToday(LocalDate date);
}


package com.projeto.bootcamp.service;


//a camada service é a camada intermediaria e ela quem conversa
//com os repositories

import com.projeto.bootcamp.exception.BusinessException;
import com.projeto.bootcamp.exception.NotFoundException;
import com.projeto.bootcamp.mapper.StockMapper;
import com.projeto.bootcamp.model.Stock;
import com.projeto.bootcamp.model.dto.StockDTO;
import com.projeto.bootcamp.repository.StockRepository;
import com.projeto.bootcamp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    //a classe service conversa com repository
    @Autowired
    private StockRepository repository;
    @Autowired
    private StockMapper mapper;

    @Transactional //é o responsavel pelos commit e rolbacks que teriamos de fazer manualmente no jpa
    //o mapper transforma o dto em entidade e depois fazemos
    // o retorno de um dto ja que o controler não recebe e não retorna entidade
    public StockDTO save(StockDTO dto) {

        //os optionals surgiram no java 8 e servem para diminuir o numero de if e else na programação
        Optional<Stock> opt = repository.findByNameAndDate(dto.getName(),dto.getDate());
        //se ele encontrou algo com o conteudo do dto ele vai retornar uma exception
        if(opt.isPresent()){
            throw new BusinessException(MessageUtil.STOCK_ALREADY_EXISTIS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.ToDto(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> opt = repository.findByStockUpdate(dto.getName(),dto.getDate(),dto.getID());
        if(opt.isPresent()){
            throw new BusinessException(MessageUtil.STOCK_ALREADY_EXISTIS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.ToDto(stock);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> lstEstock = repository.findAll();
        return mapper.ToDto(lstEstock);
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::ToDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO stockdto = this.findById(id);
         repository.deleteById(stockdto.getID());
         return stockdto;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::ToDto).orElseThrow(NotFoundException::new);
    }
}

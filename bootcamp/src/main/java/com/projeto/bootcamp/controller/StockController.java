package com.projeto.bootcamp.controller;

import com.projeto.bootcamp.model.dto.StockDTO;
import com.projeto.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//a primeira anotation diz que a classe é um controller
//a segunda diz que é atraves desse caminho que o endpoint é acessado
//a anotation @Valid serve para validar o requestBody
//a camada controoler recebe um dto
//a anotation crossOrigin nos ajuda a evitar erros no navegador quando formos solicitar os dados
@CrossOrigin   //ela permite o acesso para a conexão via fontes externas sem ela a api não funciona
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    //NA ARQUITETURA É O SERVICE QUE FAZ AS LIGAÇÕES COM OS REPOSITORIES
    @Autowired
    private StockService stockservice;
    //ele retorna um stockdto pegando um request de stockdto como parametro
    //no postMapping esta dizendo que o metodo vai consumir um json e produzir um json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save( @Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(stockservice.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update( @Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(stockservice.update(dto));
    }

    //o metodo findAll não recebe argumentos e produz um json
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(stockservice.findAll());
    }

    //aqui no mapping pegaresmos o Id da url Variable
    //e como parametro usamos Path
    @GetMapping(value ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){

        //o compareto tem 3 retorno 0 para igual, 1 e -1
       // StockDTO sele = lista.stream().filter(x -> x.getID().compareTo(id)==0).findFirst().get();
        return ResponseEntity.ok(stockservice.findById(id));
    }

    @DeleteMapping(value ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(stockservice.delete(id));
    }

    @GetMapping(value ="/today",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(stockservice.findByToday());
    }


}

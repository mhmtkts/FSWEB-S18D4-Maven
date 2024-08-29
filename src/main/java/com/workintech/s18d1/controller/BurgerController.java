package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping()
    public List<Burger> findAll(){
        return burgerDao.findAll();

    }

    @GetMapping("/{id}")
    public Burger find(@PathVariable long id){
        return burgerDao.findById(id);
    }

    @PostMapping()
    public Burger save(@RequestBody Burger burger){
        return burgerDao.save(burger);
    }

    @PutMapping()
    public Burger update(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable long id){
       return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType){
        BreadType btype = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(btype);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("content/{content}")
    public List<Burger> findByContents(@PathVariable("content") String content){
        return burgerDao.findByContent(content);
    }



}

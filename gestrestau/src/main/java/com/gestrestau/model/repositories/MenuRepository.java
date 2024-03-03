package com.gestrestau.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gestrestau.model.Entities.Dish;
import com.gestrestau.model.Entities.Menu;


public interface MenuRepository extends CrudRepository<Menu,Long>{
    List<Dish> findDishsById(long menuId);
}

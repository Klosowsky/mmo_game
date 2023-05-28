package com.to.backend.repository;

import com.to.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByRequiredClass(String requiredClass);

    List<Item> findAllByRequiredLevelLessThan(int requiredLevel);

    List<Item> findAllByRequiredLevelLessThanAndRequiredClassAndItemType(int requiredLevel, String requiredClass, String itemType);



}

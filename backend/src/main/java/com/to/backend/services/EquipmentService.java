package com.to.backend.services;

import com.to.backend.model.Equipment;
import com.to.backend.repository.EquipmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class EquipmentService  {


    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository){

        this.equipmentRepository=equipmentRepository;
    }

    public Equipment saveEquipment(Equipment equipment){
        System.out.println("here");
        return equipmentRepository.save(equipment);
    }


}

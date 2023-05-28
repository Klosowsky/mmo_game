package com.to.backend.builder;

import com.to.backend.model.*;

public class EquipmentBuider {

    Equipment equipment;

    public EquipmentBuider(Equipment equipment){
        this.equipment = equipment;
    }

    public EquipmentBuider setArmor(Armor armor) {
        this.equipment.setArmor(armor);
        return this;
    }

    public EquipmentBuider setWeapon(Weapon weapon) {
        this.equipment.setWeapon(weapon);
        return this;
    }

    public EquipmentBuider setHelmet(Helmet helmet) {
        this.equipment.setHelmet(helmet);
        return this;
    }

    public Equipment build(){
        return equipment;
    }


}

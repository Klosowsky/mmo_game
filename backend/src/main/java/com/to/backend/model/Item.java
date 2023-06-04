package com.to.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Table(name="items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@JsonDeserialize(as = ItemProxy.class)
@DiscriminatorColumn(name="item_type")
@Entity
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected int requiredLevel=0;
    protected int bonusAgility=0;
    protected int bonusStrength=0;
    protected int bonusIntellect = 0;
    protected String requiredClass;

    @Column(name="item_type", insertable = false, updatable = false)
    protected String itemType;
    @Column(name = "item_name", unique = true, nullable = false)
    protected String itemName;

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getBonusAgility() {
        return bonusAgility;
    }

    public void setBonusAgility(int bonusAgility) {
        this.bonusAgility = bonusAgility;
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public void setBonusStrength(int bonusStrength) {
        this.bonusStrength = bonusStrength;
    }

    public int getBonusIntellect() {
        return bonusIntellect;
    }

    public void setBonusIntellect(int bonusIntellect) {
        this.bonusIntellect = bonusIntellect;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRequiredClass() {
        return requiredClass;
    }

    public void setRequiredClass(String requiredClass) {
        this.requiredClass = requiredClass;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

}

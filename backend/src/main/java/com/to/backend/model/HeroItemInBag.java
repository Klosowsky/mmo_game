package com.to.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="bag")
public class HeroItemInBag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "item_id")
    Item item;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "hero_id")
    Hero hero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}

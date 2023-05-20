package com.to.backend.enums;

public enum HeroClassesEnum {
    MAGE(1),
    WARRIOR(2),
    ARCHER(3);

    private final int value;

    HeroClassesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

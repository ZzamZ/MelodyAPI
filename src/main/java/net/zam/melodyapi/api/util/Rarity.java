package net.zam.melodyapi.api.util;

public enum Rarity {
    COMMON(0xFF3498DB),
    UNCOMMON(0xFF8A2BE2),
    RARE(0xFFFF69B4),
    VERY_RARE(0xFFE74C3C),
    ULTRA_RARE(0xFFD700);

    private final int color;

    Rarity(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
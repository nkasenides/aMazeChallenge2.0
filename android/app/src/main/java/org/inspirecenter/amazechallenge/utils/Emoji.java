package org.inspirecenter.amazechallenge.utils;

public class Emoji {

    // https://apps.timwhitlock.info/emoji/tables/unicode#note1

    public static final int BOMB = 0x1F4A3;
    public static final int TRAP = 0x1F4A5;
    public static final int FOOD = 0x1F34E;
    public static final int STRONG = 0x1F4AA;
    public static final int SPEEDHACK = 0x1F489;
    public static final int COINS = 0x1F4B0;

    public static String getEmojiAsString(int emoji) {
        return new String(Character.toChars(emoji));
    }

}

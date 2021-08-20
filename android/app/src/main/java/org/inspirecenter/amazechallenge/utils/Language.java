package org.inspirecenter.amazechallenge.utils;

public enum Language {

    ENGLISH("English", "en"),
    GREEK("Greek", "el")

    ;

    private final String name;
    private final String locale;

    Language(String name, String locale) {
        this.name = name;
        this.locale = locale;
    }

    public String getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return name;
    }

}

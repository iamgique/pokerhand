package com.iamgique.pokerhand.model;

public enum Value {
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    T("10"),
    J("Jack"),
    Q("Queen"),
    K("King"),
    A("Ace");

    public static final Value values[] = values();

    private final String content;

    Value(String value) {
        content = value;
    }

    public String getContent() {
        return content;
    }
}

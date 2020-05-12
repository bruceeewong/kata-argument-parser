package main.java.cn.bruski.kata;

import java.util.TreeMap;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
public class Parser {
    private TreeMap<String, String> argumentMap;
    private Schema schema;

    public Parser(Schema schema, String[] argumentsAsStrings) {
        this.schema = schema;
        argumentMap = new TreeMap<>();

        for (int i = 0; i < argumentsAsStrings.length; i += 2) {
            String key = argumentsAsStrings[i].replaceFirst("-", "");
            String value = argumentsAsStrings[i + 1];
            argumentMap.put(key, value);
        }
    }

    public int size() {
        return argumentMap.size();
    }

    public Object valueOf(String key) {
        if (typeEquals(key, "boolean")) {
            return parseBoolean(argumentMap.get(key));
        }
        if (typeEquals(key, "integer")) {
            return parseInt(argumentMap.get(key));
        }
        return argumentMap.get(key);
    }

    private boolean typeEquals(String key, String typeAsText) {
        return schema.typeOf(key).equals(typeAsText);
    }
}

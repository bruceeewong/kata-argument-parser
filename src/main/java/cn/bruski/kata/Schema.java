package main.java.cn.bruski.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Schema {
    private TreeMap<String, String> schemaMap;
    public Schema(String schemaAsText) {
        schemaMap = new TreeMap<>();

        String[] stringArray = schemaAsText.split(" ");
        for (String strPair: stringArray) {
            String[] keyValue = strPair.split(":");
            schemaMap.put(keyValue[0], keyValue[1]);
        }
    }

    public int size() {
       return schemaMap.size();
    }

    public String typeOf(String key) {
        return schemaMap.get(key);
    }
}

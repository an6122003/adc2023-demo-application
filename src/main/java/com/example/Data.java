package com.example;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private static HashMap<Integer,String> captureDataHashMap = new HashMap<>();
    private static HashMap<Integer,String> summaryDataHashMap = new HashMap<>();
    
    public static void addCaptureData(String data) {
        captureDataHashMap.put(captureDataHashMap.size(),data);
    }

    public static void addCaptureData(String[] data) {
        for (String s : data) {
            captureDataHashMap.put(captureDataHashMap.size(),s);
        }
    }

    public static void addSummaryData(String data) {
        summaryDataHashMap.put(summaryDataHashMap.size(),data);
    }

    public static void addSummaryData(String[] data) {
        for (String s : data) {
            summaryDataHashMap.put(summaryDataHashMap.size(),s);
        }
    }

    public static <K, V> boolean swapValues(Map<K, V> map, K key1, K key2) {
        if (map.containsKey(key1) && map.containsKey(key2)) {
            V value1 = map.get(key1);
            V value2 = map.get(key2);

            map.put(key1, value2);
            map.put(key2, value1);
            return true;
        }
        return false;
    }

    //Getters and setters
    public static String getCaptureData(Integer key) {
        return captureDataHashMap.get(key);
    }

    public static HashMap<Integer,String> getCaptureData() {
        return captureDataHashMap;
    }

    public static String getSummaryData(Integer key) {
        return summaryDataHashMap.get(key);
    }

    public static HashMap<Integer,String> getSummaryData() {
        return summaryDataHashMap;
    }
}

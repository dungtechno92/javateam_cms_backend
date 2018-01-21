package com.ntq.javateam.cms.backend.infrastructure.number;

public class NumberParser {
    
    public static int getInt(String text, int defaultValue) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}

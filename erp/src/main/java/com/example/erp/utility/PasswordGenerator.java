package com.example.erp.utility;

import java.util.UUID;

public class PasswordGenerator {
    public static String generate(){
        return UUID.randomUUID().toString();
    }
}

package com.guzova;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Service service = new Service();
            service.readMainFile();
            service.split();
            service.sort();
            service.outToFile();
            service.printCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
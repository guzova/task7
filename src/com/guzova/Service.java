package com.guzova;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Service {

    private List<String> list;
    private List<String> numbers;
    private List<String> nonumbers;

    public Service() {
        list = new ArrayList<>();
        numbers = new ArrayList<>();
        nonumbers = new ArrayList<>();
    }

    public void readMainFile() throws Exception {
        Scanner readFile = new Scanner(new File("input.txt")).useDelimiter("[\\s.,]+");
        while (readFile.hasNext()) {
            list.add(readFile.next());
        }
    }

    public void split() {
        for (String token : list) {
            if (token.matches("\\d+"))
                numbers.add(token);
            else if (token.matches("\\D+"))
                nonumbers.add(token);
        }
    }

    public void sort() {
        Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        };
        Collections.sort(numbers, comparator);
        Collections.sort(nonumbers, comparator);
    }


    public void outToFile() throws IOException {
        FileWriter fw = new FileWriter("output1.txt");
        for (String token : numbers)
            fw.write(token + " ");
        fw.close();
        fw = new FileWriter("output2.txt");
        for (String token : nonumbers)
            fw.write(token + " ");
        fw.close();
    }

    public void printCount() {
        System.out.println("Количество лексем в output1.txt: "+numbers.size());
        System.out.println("Количество лексем в output2.txt: "+nonumbers.size());
    }
}


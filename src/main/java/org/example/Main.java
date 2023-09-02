package org.example;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        IntegerListImpl integerList = new IntegerListImpl(0);

   int[] integerList1 = IntStream.generate(() -> new Random().nextInt(100)).limit(100000).toArray();
        System.out.println(IntegerListImpl.binarySearch(integerList1, 99));
    }
}
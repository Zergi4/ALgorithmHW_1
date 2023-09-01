package org.example;

public class Main {
    public static void main(String[] args) {

        StringListImpl strings = new StringListImpl(0);
        System.out.println(strings.toString());
        strings.add("Hello");
        strings.add("Hello");
        strings.add("Hello");
        System.out.println(strings.toString());
        strings.add(1, "bye");
        System.out.println(strings.toString());
        strings.set(2, "set");
      /*  System.out.println(strings.toString());
       strings.remove("Hello");
        System.out.println(strings.toString());
        strings.remove(0);*/
        System.out.println(strings.toString());
        System.out.println(strings.contains("bye"));
        System.out.println(strings.indexOf("Hello"));
        System.out.println(strings.lastIndexOf("Hello"));
        System.out.println(strings.size());
        System.out.println(strings.isEmpty());
        strings.clear();
        System.out.println(strings.toString());



    }
}
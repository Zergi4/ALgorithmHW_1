package org.example;

import org.example.Exception.InvalidIndexException;
import org.example.Exception.NotExistException;

import java.util.Arrays;

public class StringListImpl/* implements StringList*/ {

    private String[] strings;

    public StringListImpl() {
        strings = new String[0];
    }

    public StringListImpl(int size) {
        strings = new String[size];
    }

    /*
        @Override
    */
    public String add(String item) {
        String[] array = new String[strings.length + 1];
        System.arraycopy(strings, 0, array, 0, strings.length);
        array[strings.length] = item;
        strings = array;
        return item;
    }

    // @/*Override*/
    public String add(int index, String item) {
        if (index > strings.length || index < 0) {
            throw new InvalidIndexException();
        }
        String[] srcArray = strings;
        String[] destArray = new String[srcArray.length + 1];
        int j = 0;
        for (int i = 0; i < destArray.length; i++) {

            if (i == index) {
                destArray[i] = item;
            } else {
                destArray[i] = srcArray[j];
                j++;
            }
        }
        strings = destArray;
        return item;
    }


    /*    @Override*/
    public String set(int index, String item) {
        if (index > strings.length || index < 0) {
            throw new InvalidIndexException();
        }
        String[] srcArray = strings;
        String[] destArray = new String[srcArray.length];

        for (int i = 0; i < destArray.length; i++) {

            if (i == index) {
                destArray[i] = item;

            } else {
                destArray[i] = srcArray[i];
            }
        }
        strings = destArray;
        return item;
    }

    /*   @Override*/
    public String remove(String item) {
//проверка на наличие элемента
        boolean notExist = true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) {
                notExist= false;
            } else if(notExist) throw new NotExistException();
        }
        //
        String[] destArray = Arrays.stream(strings)
                .filter(s -> !s.equals(item))
                .toArray(String[]::new);

        strings = destArray;
        return item;
    }

    /*@Override*/
    public String remove(int index) {
        String result = strings[index];
        String[] destArray = new String[strings.length - 1];
        for (int i = 0;(i < index); i++) {
            destArray[i] = strings[i];
        }

        for (int i = index; i < destArray.length; i++) {
            destArray[i] = strings[i + 1];
        }
        strings = destArray;
        return result;
    }

  /*   @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }*/

    @Override
    public String toString() {
        return "StringListImpl{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}

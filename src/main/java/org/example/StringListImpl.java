package org.example;

import org.example.Exception.InvalidIndexException;
import org.example.Exception.InvalidItemException;
import org.example.Exception.NotExistException;
import org.example.Exception.NullException;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

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
        checkItem(item);

        String[] array = new String[strings.length + 1];
        System.arraycopy(strings, 0, array, 0, strings.length);
        array[strings.length] = item;
        strings = array;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkItem(item);

        checkIndex(index);
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


    @Override
    public String set(int index, String item) {
        checkItem(item);

        checkIndex(index);
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

    @Override
    public void checkIndex(int index) {
        if (index > strings.length || index < 0) {
            throw new InvalidIndexException();
        }
    }

    @Override

    public String remove(String item) {
//проверка на наличие элемента
        boolean notExist = true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) {
                notExist = false;
            }
        }
        if (notExist) throw new NotExistException();
        //
        String[] destArray = Arrays.stream(strings)
                .filter(s -> !s.equals(item))
                .toArray(String[]::new);

        strings = destArray;
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String result = strings[index];
        String[] destArray = new String[strings.length - 1];
        for (int i = 0; (i < index); i++) {
            destArray[i] = strings[i];
        }

        for (int i = index; i < destArray.length; i++) {
            destArray[i] = strings[i + 1];
        }
        strings = destArray;
        return result;
    }

    @Override

    public boolean contains(String item) {
        checkItem(item);

        boolean notExist = true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) {
                notExist = false;
            }
        }
        return !notExist;
    }

    @Override

    public int indexOf(String item) {
        checkItem(item);

        for (int i = 0; i < strings.length; i++) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override

    public int lastIndexOf(String item) {
        checkItem(item);
        for (int i = strings.length - 1; i >= 0; i--) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override

    public String get(int index) {
        checkIndex(index);
        return strings[index];

    }

    @Override

    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override

    public int size() {
        return strings.length;
    }

    @Override

    public boolean isEmpty() {
        return strings.length == 0;
    }

    @Override

    public void clear() {
/*
        strings= new StringListImpl(0).toArray();
*/
        strings = new String[0];
    }

    @Override

    public String[] toArray() {
        return Arrays.copyOf(strings, strings.length);
    }

    private void checkItem(String item) {
        if (Objects.isNull(item)) {
            throw new InvalidItemException();
        }
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}

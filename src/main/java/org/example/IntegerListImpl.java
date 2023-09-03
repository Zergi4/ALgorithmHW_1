package org.example;

import org.example.Exception.InvalidIndexException;
import org.example.Exception.InvalidItemException;
import org.example.Exception.NotExistException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {


    private Integer[] storage;
    private int size = 0;

    public IntegerListImpl() {
        storage = new Integer[5];
    }

    public IntegerListImpl(int size) {
        storage = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {

        checkItem(item);
        checkSize();
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkSize();
        checkIndex(index);
        checkItem(item);
        if (index == size) {
            add(item);
        }

        size++;
        for (int i = size - 1; i > index; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        if (contains(item)) {
            return remove(indexOf(item));
        }
        throw new NotExistException();
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer result = storage[index];
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return result;
    }

    @Override
    public boolean contains(Integer item) {
        checkItem(item);
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return storage[index];
    }


    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void checkItem(Integer item) {
        if (Objects.isNull(item)) {
            throw new InvalidItemException();
        }
    }

    private void checkSize() {
        if (size == storage.length) {
            storage = Arrays.copyOf(storage, (int) (size * 1.5 + 1));
        }
    }


    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static boolean binarySearch(int[] arr, int element) {
        sortInsertion(arr);
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;


            if (element == arr[mid]) {
                return true;
            }
            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "storage=" + Arrays.toString(storage) +
                ", size=" + size +
                '}';
    }
}

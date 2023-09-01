package org.example;

import org.example.Exception.InvalidIndexException;
import org.example.Exception.InvalidItemException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    StringListImpl strings = new StringListImpl();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        strings.add("Hello");
        strings.add("World");
        strings.add("Bye");
        strings.add("Set");

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        strings.clear();
    }

    @Test
    void add_success() {
        //входные данные
        String expectedResult = "Test";
        String actualResult = strings.add("Test");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addNull() {
        assertThrows(InvalidItemException.class, () -> strings.add(null));
    }

    @Test
    void addWithIndex_success() {
        //входные данные

        //ожидаемый результат
        String expectedResult = "Test";
        String expectedResult2 = "Hello";
        //тест
        strings.add(0, "Test");
        assertEquals(expectedResult, strings.get(0));
        assertEquals(expectedResult2, strings.get(1));
    }

    @Test
    void InvalidIndexAdd_success() {
        assertThrows(InvalidIndexException.class, () -> strings.add(7, "string"));
    }

    @org.junit.jupiter.api.Test
    void set_success() {
        //входные данные

        //ожидаемый результат
        String expectedResult = "Test";
        //тест
        strings.set(0, "Test");
        assertEquals(expectedResult, strings.get(0));
        assertEquals("World", strings.get(1));

    }


    @org.junit.jupiter.api.Test
    void checkIndex_success() {

        assertThrows(InvalidIndexException.class, () -> strings.set(7, "string"));
    }

    @org.junit.jupiter.api.Test
    void removeItem_success() {
        //входные данные
        //ожидаемый результат
        String expectedResult = "Hello";
        //тест
        String actualResult = strings.remove("Hello");
        assertEquals(expectedResult, actualResult);
        assertEquals("World", strings.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeWithIndex_seccess() {
        //входные данные
        //ожидаемый результат
        String expectedResult = "World";
        //тест
        String actualResult = strings.remove(1);
        assertEquals(expectedResult, actualResult);
        assertEquals("Bye", strings.get(1));
    }

    @org.junit.jupiter.api.Test
    void contains_success() {
        assertTrue(strings.contains("Set"));
        assertFalse(strings.contains("Sky"));
    }

    @org.junit.jupiter.api.Test
    void indexOf_success() {
        //входные данные
        //ожидаемый результат
        int expectedIndex = 3;
        //тест
        int actualResult = strings.indexOf("Set");
        assertEquals(expectedIndex,actualResult);
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf_success() {
        //входные данные
        strings.add("Set");
        //ожидаемый результат
        int expectedIndex = 4;
        //тест
        int actualResult = strings.lastIndexOf("Set");
        assertEquals(expectedIndex,actualResult);


    }

    @org.junit.jupiter.api.Test
    void get_success() {
        //входные данные
        //ожидаемый результат
        String expectedResult = "Bye";
        //тест
        String actualResult = strings.get(2);
        assertEquals(expectedResult,actualResult);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        //входные данные
        //ожидаемый результат
        //тест
        StringListImpl testList = strings;
        StringListImpl testList2 = new StringListImpl();


        assertTrue(strings.equals(testList));
        assertFalse(strings.equals(testList2));
    }

    @org.junit.jupiter.api.Test
    void size() {
        //входные данные
        //ожидаемый результат
        int expectedSize = 4;

        //тест
        assertEquals(expectedSize, strings.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        //входные данные
        //ожидаемый результат

        //тест
        assertFalse(strings.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        //входные данные
        //ожидаемый результат

        //тест
        strings.clear();
        assertEquals(0, strings.size());
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        String[] array = new String[]{"Hello", "World", "Bye", "Set"};
        assertArrayEquals(array,strings.toArray());
    }


}
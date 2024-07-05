package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testReverseEmptyArray() {
        int[] array = {};
        Main.reverseArray(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void testReverseSingleElementArray() {
        int[] array = {1};
        Main.reverseArray(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    void testReverseTwoElementArray() {
        int[] array = {1, 2};
        Main.reverseArray(array);
        assertArrayEquals(new int[]{2, 1}, array);
    }

    @Test
    void testReverseMultipleElementArray() {
        int[] array = {1, 2, 3, 4, 5};
        Main.reverseArray(array);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, array);
    }

    @Test
    void testReverseEvenNumberOfElementsArray() {
        int[] array = {1, 2, 3, 4};
        Main.reverseArray(array);
        assertArrayEquals(new int[]{4, 3, 2, 1}, array);
    }

    @Test
    void testNullArray() {
        int[] array = null;
        Main.reverseArray(array);
        assertNull(array);
    }

    // Boundary value tests
    @Test
    void testBoundaryValueEmptyArray() {
        int[] array = {};
        Main.reverseArray(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void testBoundaryValueSingleElementArray() {
        int[] array = {1};
        Main.reverseArray(array);
        assertArrayEquals(new int[]{1}, array);
    }
}



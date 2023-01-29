package com.heaven.junit;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {

    @Test
    void calculateSum() {
        int[] nums = {1,2,3};
        MyMath math = new MyMath();
        assertEquals(6,math.calculateSum(nums));
    }

    
}
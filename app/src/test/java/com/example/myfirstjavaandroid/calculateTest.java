package com.example.myfirstjavaandroid;


import junit.framework.TestCase;

import static junit.framework.TestCase.assertEquals;


public class calculateTest extends TestCase {

    public void testAdd()  {
        int expected = 30;
        int actual = calculate.add(10,20);

        assertEquals(expected,actual);
    }

}


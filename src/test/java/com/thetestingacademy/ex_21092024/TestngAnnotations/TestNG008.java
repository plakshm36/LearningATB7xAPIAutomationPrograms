package com.thetestingacademy.ex_21092024.TestngAnnotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG008 {
    @Parameters("browser")
    @Test
    void demo1(String value){
        System.out.println("Browser is " +value);
        // Open the Browser and select dadadada

    }
}

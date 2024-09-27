package com.thetestingacademy.ex_15092024_CRUD.TestngAnnotations;

import org.testng.annotations.*;

public class Test002 {
   /* @BeforeSuite-Perform setup actions before all test suites
    @BeforeTest-Similar to suite-level annotations, @BeforeTest and @AfterTest in your test configuration XML indicate the test methods
    that are run before and after all other test methods within a certain <test> element.
    @BeforeClass- Perform setup actions before all test methods in this class
    @BeforeMethod-Perform setup actions before each test method
    @Test- This annotation designates a method as a test case*/

    @BeforeSuite
    void demo1()
    {
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    void demo2(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    void demo3(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("BeforeMethod");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo6(){
        System.out.println("AfterMethod");
    }

    @AfterClass
    void demo7(){
        System.out.println("AfterClass");
    }

    @AfterTest
    void demo8(){
        System.out.println("AfterTest");
    }
    @AfterSuite
    void demo9(){
        System.out.println("AfterSuite");
    }
}


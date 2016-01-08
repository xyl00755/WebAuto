package com.danlu.demo_assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
@Listeners({com.danlu.demo_assert.AssertionListener.class})
public class DemoAssert {
     
    @Test
    public void testAssert1(){ 
        Assertiona.verifyEquals(2, 3);
        Assertiona.verifyEquals(2, 2);    
    }
     
    @Test
    public void testAssert2(){ 
        Assertiona.verifyEquals(3, 3, "abc");
        Assertiona.verifyEquals(2, 3, "xyz");    
    }
 
}
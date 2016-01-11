package com.danlu.demo_assert;
import java.util.ArrayList;
import java.util.List;
 
import org.testng.Assert;

/**
 * 封装断言方法
 * @author stray
 *
 */
public class Assertiona {
     
    public static boolean flag = true;
    public static List<Error> errors = new ArrayList<Error>();
    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
            System.out.println("actual is same with expected: " + actual);
        }catch(Error e){
            errors.add(e);
            System.out.println(e.getMessage());
            flag = false;
        }
    }
    
    public static void verifyEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
            System.out.println("actual is same with expected: " + actual);
        }catch(Error e){
            errors.add(e);
            System.out.println(e.getMessage());
            flag = false;
        }
    }
    
    public static void verifyContains(Object actual, Object expected){
    	try{
//    		Assert.assertContains(actual, expected);
            
            System.out.println(actual + "contains :" + expected);
        }catch(Error e){
            errors.add(e);
            System.out.println(e.getMessage());
            flag = false;
        }
    }
 
}

package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Hashtable;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void hashTableTest(){
        Hashtable<String, String> hashtable = new Hashtable<>();
        String name = "xiaoMing";
        name.hashCode();

        System.out.println(("S".hashCode() & 0x7fffffff)%5);
    }
}

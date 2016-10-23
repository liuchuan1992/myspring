package myspring;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testGetResource(){
        System.out.println(AppTest.class.getSimpleName());
        System.out.println(AppTest.class.getResource(AppTest.class.getSimpleName()+".class").getFile());
    }
}

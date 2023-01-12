package test.helloworld;

import main.helloworld.HelloWorld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    @Test
    void testSayHello() {
        String str = new HelloWorld().sayHello();

        assertEquals("Hello World!", str);
    }
}

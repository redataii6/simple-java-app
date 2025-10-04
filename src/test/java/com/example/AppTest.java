package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testGreetWithName() {
        App app = new App();
        assertEquals("Hello, Jenkins!", app.greet("Jenkins"));
    }

    @Test
    public void testGreetWithNull() {
        App app = new App();
        assertEquals("Hello, World!", app.greet(null));
    }

    @Test
    public void testGreetWithEmptyString() {
        App app = new App();
        assertEquals("Hello, World!", app.greet(""));
    }
}
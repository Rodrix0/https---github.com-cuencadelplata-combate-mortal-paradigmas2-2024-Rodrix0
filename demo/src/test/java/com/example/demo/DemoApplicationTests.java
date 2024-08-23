package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    public void Test(){
        DemoApplication hol=new DemoApplication();
        assertEquals("hola",hol);  



}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibra.spring.core;

import com.ibra.spring.core.DependencyInjectionConfiguration;
import com.ibra.spring.core.data.Bar;
import com.ibra.spring.core.data.Foo;
import com.ibra.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author IIISI
 */
public class DependencyInjectionTest {
    
    private ApplicationContext applicationContext;
    
    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }
    
    @Test
    void testDI() {
        
        Foo foo = applicationContext.getBean("fooSecond", Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);
        
        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
        
    }
    
    @Test
    void testNoDI(){
        
        var foo = new Foo();
        var bar = new Bar();
        
        var fooBar = new FooBar(foo, bar);
        
        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}

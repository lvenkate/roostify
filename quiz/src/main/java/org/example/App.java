package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "org.roostify",
        "org.roostify.process.writer",
        "org.roostify.process.processor",
        "org.roostify.repository"
})
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

package com.sfg.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sfg.qa.util.WebEventListener;


/**
 * Setting up the test base
 *
 */
public class testBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

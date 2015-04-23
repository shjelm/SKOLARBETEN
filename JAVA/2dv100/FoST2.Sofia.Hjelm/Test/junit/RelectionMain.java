/*
 * File: RelectionMain.java
 * Author: Jonas Lundberg
 * Date: 9 feb 2014
 */
package Test.junit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import Test.junit.TestIntList;

/**
 * A simple example using reflection to 
 * extract information from a class
 * 
 * @author jlnmsi
 *
 */
public class RelectionMain {


	public static void main(String[] args) throws Exception{
		//Class clz = Class.forName("TestIntList");     
		Class clz = TestIntList.class;        // Simplified version
		System.out.println(clz.getName());    // Class name

		for (Method m : clz.getDeclaredMethods()) {
			System.out.println("\t"+m.getName());  // Method names 
			for (Annotation a : m.getAnnotations()) {
				String str = a.toString();
				int stop = str.indexOf('(');
				System.out.println("\t\t"+str.substring(0, stop));  // Annotation names
			}
		}

		invokeToString("java.util.Date");  // Previous slide
	}

	public static void invokeToString(String class_name) throws Exception {
		Class cl = Class.forName(class_name);  // Get class instance
		Method m = cl.getMethod("toString");      // Find toString() method
		Object obj = cl.newInstance();            // Create new instance
		System.out.println(cl.getName()+"\t"+m.invoke(obj));  // Make call o.m()		
	}
}

package com.oracle.entity;
/**
 * 演示类的用法
 * @author 黄sir
 *
 */
public class Teacher {
   //属性
   public String name;
   public int age;
   //构造方法
   public Teacher(){
	   System.out.println("这是父类的构造方法");
   }
public Teacher(String name, int age) {
     System.out.println("这是父类带参的方法");
	this.name = name;
	this.age = age;
}
   
   //方法
   public void sayHi(){
	   System.out.println("大家好，我是你们的老师！");
	   
   }
}

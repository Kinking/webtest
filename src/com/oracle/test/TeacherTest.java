package com.oracle.test;

import com.oracle.entity.Teacher;

public class TeacherTest {

	public static void main(String[] args) {
		//创建对象并引用方法
		Teacher tea =new Teacher();
        //给对象的属性赋值
		tea.name="大叔";
		tea.age=38;
		//访问方法
		tea.sayHi();
		
	}

}

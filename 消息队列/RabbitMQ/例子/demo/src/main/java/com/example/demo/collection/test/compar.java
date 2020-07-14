package com.example.demo.collection.test;

import java.util.ArrayList;
import java.util.List;

public class compar {

	public static void main(String[] args) {
		
		List<Info> list = new ArrayList<>();
//		list.add(new Info("", age))
		
//		list.indexOf(o)
		
		String str1 = "Strings";
        String str2 = "Strings";
        String str3 = "Strings123";
        String str4 = "strings";

        int result = str1.compareTo( str2 );
        System.out.println(result);

        result = str2.compareTo( str3 );
        System.out.println(result);

        result = str3.compareTo( str1 );
        System.out.println(result);
        
        result = str4.compareTo( str1 );
        System.out.println(result);
	}

}

class Info implements Comparable<Info> {
	
	public String name;
	public int age;

	public Info(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Info o) {
		// TODO Auto-generated method stub
		return o.name.compareTo(this.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Info)obj).age == this.age;
	}
	
}

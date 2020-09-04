## 1 SpringMVC的工作原理？

## 2 这段代码的问题

```
	public static void main(String[] args) {
		String[] ss = new String[2];
		ss[0] = "1";
		Object[] object = ss;
		object = ss;
		object[2] = "2";
	}
```
## 3 实现swap函数

```
	public static void main(String[] args) {
		
		int a = 1,b = 2;
		System.out.println(a +" --> "+b);
		swap(a, b);
		System.out.println(a +" --> "+b);
	}
	
	public static void swap(int a, int b) {
		// 如何实现
	}
```

## 4 hashCode()和equals()之间的联系？

## 5 mybatis和hibernate的优缺点？

## 6 mysql的索引什么时候不生效，外键表和主键表的依赖？
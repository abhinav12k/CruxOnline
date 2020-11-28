package CruxOnline.Inheritance;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("/********************CASE-1**********************/");
		C child1 = new C();
		System.out.println(child1.d);
		System.out.println(child1.d1);
		System.out.println(child1.d2);
		
		child1.fun();
		child1.fun1();
		child1.fun2();
		
		System.out.println("/********************CASE-2**********************/");
//		C child = new P(); -> Java Doesn't allow this
		
		System.out.println("/********************CASE-3**********************/");
		P parent = new P();
		System.out.println(parent.d1);
		System.out.println(parent.d2);
		
		parent.fun();
		parent.fun1();
		
		
		System.out.println("/********************CASE-4**********************/");
		P parent2 = new C();
		System.out.println(((C)parent2).d);	//Type casting
		System.out.println(parent2.d1);
		System.out.println(parent.d2);
		
		((C)parent2).fun2();
		parent2.fun();
		parent2.fun1();
	}
	
}

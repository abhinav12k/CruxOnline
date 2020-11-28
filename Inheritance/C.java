package CruxOnline.Inheritance;

public class C extends P{
	
	int d = 100;
	int d2 = 200;
	
	@Override
	public void fun() {
		System.out.println("Inside C in fun");
	}
	
	public void fun2() {
		System.out.println("Inside C in fun2");
	}
	
}

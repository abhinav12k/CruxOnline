package CruxOnline.Interface_and_generics.Generics;

public class Bikes implements Comparable<Bikes> {

	public int speed;
	public int price;
	public String color;

	public Bikes(int speed, int price, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	@Override
	public int compareTo(Bikes other) {
//		more speed more priority
//		return this.speed - other.speed;
		
		//Lesser the price more the priority!
		return other.price - this.price;
//		return this.color.compareTo(other.color);
	}

	@Override
	public String toString() {
		return "Speed: " + this.speed + " Price: " + this.price + " Color: " + this.color+"\n";
	}

}

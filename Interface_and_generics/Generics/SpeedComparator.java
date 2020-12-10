package CruxOnline.Interface_and_generics.Generics;

import java.util.Comparator;

public class SpeedComparator implements Comparator<Bikes> {

	@Override
	public int compare(Bikes bike1, Bikes bike2) {
		return bike1.speed - bike2.speed;
	}

}

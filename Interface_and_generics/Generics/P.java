package CruxOnline.Interface_and_generics.Generics;

//Making classes Generic
public class P<K, V> {

	public K key;
	public V val;

	@Override
	public String toString() {
		return "P{ Key: " + this.key + " , " + "Val: " + this.val + "}";
	}
}

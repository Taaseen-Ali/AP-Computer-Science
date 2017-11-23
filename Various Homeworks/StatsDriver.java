public class StatsDriver{
	public static void main(String args[]){
		System.out.println(Stats.mean(2,3));
		System.out.println(Stats.mean(2.5,3.5));
		System.out.println(Stats.max(10,2));
		System.out.println(Stats.max(1,1));
		System.out.println(Stats.max(5.5,6));
		System.out.println(Stats.geoMean(3,3,3));
		System.out.println(Stats.geoMean(10,10, 10));
	}
}
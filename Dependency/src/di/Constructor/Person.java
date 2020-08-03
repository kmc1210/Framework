package di.Constructor;

import di.tire.GoldTire;
import di.tire.SilverTire;

public class Person {
	public static void main(String[] args) {
		
		Car car = new Car( new SilverTire());
		
		System.out.println( car.getTire() );
	}
}

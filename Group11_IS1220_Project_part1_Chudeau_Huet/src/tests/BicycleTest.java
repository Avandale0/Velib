package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.BicycleType;

public class BicycleTest {

	@Test
	public void testBicycle() {
		
		Bicycle bike_meca = new Bicycle(BicycleType.Mechanical);
		System.out.println(bike_meca.getType());
		System.out.println(bike_meca.getID());
		assertTrue(bike_meca.type == BicycleType.Mechanical);
		
		Bicycle bike_elec = new Bicycle(BicycleType.Electrical);
		System.out.println(bike_elec.getType());
		System.out.println(bike_elec.getID());
		assertTrue(bike_elec.type == BicycleType.Electrical);
	}

}

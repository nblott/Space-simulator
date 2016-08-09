package com.openet.nblott;

import org.junit.Test;
import org.junit.*;
import org.junit.Assert.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.*;
import org.junit.experimental.categories.*;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import com.openet.nblott.Vector;
import com.openet.nblott.DynVector;

import java.util.Arrays;
import java.util.Collection;

  //      public interface BasicFunctionalityTest {}
  //      public interface ExtraFunctionalityTest {}

@RunWith(Parameterized.class)
public class VectorRunner {

	public interface BasicFunctionalityTest {}
	public interface ExtraFunctionalityTest {}

	private double a;
	private double b;

	public VectorRunner(double x,double y) {
		a = x;
		b = y;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {{1,7},{-1,-2},{10,13},{-10,98},{0,0},{-0,231}, {20,-99}};
		return Arrays.asList(data);
	}

	@Test
	public void getShouldGiveCorrectValues() {
		Vector v = new Vector(a,b);
		Assert.assertTrue("X getter broken", a == v.getX());
		Assert.assertTrue("Y getter broken", b == v.getY());
	}

	@Test
	public void setShouldSetCorrectly() {
		Vector v = new Vector();
		v.setX(a);
		v.setY(b);
		Assert.assertTrue("X setter broken", v.getX() == a);
		Assert.assertTrue("Y setter broken", v.getY() == b);
	}

	@Test
	public void shouldObtainCorrectMagnitude() {
		Vector v = new Vector(a,b);
		double output = Math.sqrt(a*a + b*b);
		Assert.assertTrue("getMagnitude() broken", output == v.getMagnitude());
	}

	@Test
	public void shouldGetCorrectAngle() {
		Vector v = new Vector(a,b);
		double correctOutput = Math.atan2(b,a);
		Assert.assertTrue("Angle calculation incorrect",correctOutput == v.getAngle());
	}
}

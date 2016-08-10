package space.sim.nblott;

import space.sim.nblott.Entity;

public class Point extends Entity {
	
	public Point(Vector pos) {
		super(1,pos,new Vector(0,0), new Vector(0,0), new Vector(0,0));
	}

	public Point(double mass, Vector pos) {
		super(mass,pos,new Vector(0,0), new Vector(0,0), new Vector(0,0));
	}

	public Point() {
		super();
	}
	@Override
	public void setVelocity(Vector v) {}

	@Override
	public void setAcceleration(Vector v) {}
	
	@Override
	public void setForce(Vector v) {}


	@Override
	public Vector getVelocity() {
		return velocity.clone();
	}
	
	@Override
	public Vector getAcceleration() {
		return velocity.clone();
	}
	

	@Override
	public Vector getForce() {
		return velocity.clone();
	}

}

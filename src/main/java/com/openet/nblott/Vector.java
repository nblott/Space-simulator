package com.openet.nblott;

// Idea: 
// It would be neat if you could describe a Vector as 
// pointing towards an entity! or point! I could jsut
// make a point class (extends entity) to make this 
// achievable and then have bistate vectors (dynamic (y/n))
// which redirect themselves every tick; this would mean 
// they would also have to be added to the sim draw list.

public class Vector {

	protected double x;
	protected double y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector() {
		this.x = 0;
		this.y = 0;
	}


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}


	public double getMagnitude() {
		return Math.sqrt(x*x + y*y);
	}

	public double getAngle() {
		return Math.atan2(y,x);
	}
	
	public Vector add(Vector v) {
		this.x += v.getX();
		this.y += v.getY();
		return this;
	}

	public Vector sub(Vector v) {
		this.x -= v.getX();
		this.y -= v.getY();
		return this;
	}

	public Vector times(double d) {
		this.x = this.x * d;
		this.y = this.y * d;
		return this;
	}

	public Vector div(double d) {
		this.x = this.x / d;
		this.y = this.y /d;
		return this;
	}
	
	public Vector invert() {
		this.x = -this.x;
		this.y = -this.y;
		return this;
	}

        public Vector simplify() {
                double max = Math.abs(x);
                if (Math.abs(y) > max)
                        max = Math.abs(y);
		this.x /= max;
		this.y /= max;
		return this;
        }

	public Vector zero() {
		this.x = 0;
		this.y = 0;
		return this;
	}

	public Vector update() {
		return this;
	}
	
	public Vector vectorClone() {
		return new Vector(this.x,this.y);
	}

	public Vector clone() {
		return new Vector(this.x,this.y);
	}

	@Override
	public String toString() {
		return ("(" + (float)this.x + " ," + (float)this.y + ")");
	}
}

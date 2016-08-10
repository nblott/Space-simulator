package space.sim.nblott;

public class Entity {
	
	protected double mass;
	protected Vector position;
	protected Vector velocity;
	protected Vector acceleration;	
	protected Vector force;

	private static final double MAX_VELOCITY =4.5; 

	public Entity(double m, Vector pos, Vector vel, Vector accel, Vector force) {
		mass = m;
		position = pos;
		velocity = vel;
		accel = acceleration;
		this.force = force;
	}

	public Entity() {
		mass = 1;
		position =  new Vector();
		velocity = new Vector();
		acceleration = new Vector();
		force = new Vector();
	}

	public void setMass(double m) {
		mass = m;
	}

	public void setForce(Vector v) {
		force = v;
	}
	public void setPosition(Vector v) {
		position = v;
	}

	public void setVelocity(Vector v) {
		velocity = v;
	}

	public void setAcceleration(Vector v) {
		acceleration = v;
	}

	public double getMass() {
		return mass;
	}

	public Vector getPosition() {
		return position;
	}
	
	public Vector getVelocity() {
		return velocity;
	}

	public Vector getAcceleration() {
		return acceleration;
	}
	
	public Vector getForce() {
		return force;
	}

	public Entity addForce(Vector f) {
		this.force.add(f);
		return this;
	}

	public Entity update() {
		acceleration.update();
		if(mass != 0)
		{
			acceleration.add(force.div(mass));
		}
		velocity.add(acceleration);
		if(Math.abs(velocity.getX()) > MAX_VELOCITY)
		{
			velocity.setX((velocity.getX() / Math.abs(velocity.getX())) * MAX_VELOCITY);
		}
		if(Math.abs(velocity.getY()) > MAX_VELOCITY)
		{
                        velocity.setY((velocity.getY() / Math.abs(velocity.getY())) * MAX_VELOCITY);

		}
		position.add(velocity);
		return this;
	}

	public void print() {
		System.out.println("Position: " + position.toString() + 
					" Velocity" + velocity.toString() +
					" Acceleration: " + acceleration.toString() +
					" Force: " + force.toString());
	}
}

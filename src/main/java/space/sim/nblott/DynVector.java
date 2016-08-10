package space.sim.nblott;

import space.sim.nblott.Entity;
import space.sim.nblott.Point;

/*	Description of a DynVector:
 *
 *	A DynVector is a normal Vector but it automatically points itself at its endpoint.
 */



public class DynVector extends Vector {
	
	private Entity endPoint;
	private Entity parentEntity;

	public DynVector() {
		endPoint = new Point();
		parentEntity = new Point();
		update();
	}

	public DynVector(Entity parent, Entity end) {
		endPoint = end;
		parentEntity = parent;
		update();
	}

	@Override
	public Vector update() {
		x = (endPoint.getPosition().getX() - parentEntity.getPosition().getX());
		y = (endPoint.getPosition().getY() - parentEntity.getPosition().getY());
		return this;	
	}
	
	@Override
	public Vector clone() {
		return new DynVector(parentEntity,endPoint);
	}
}

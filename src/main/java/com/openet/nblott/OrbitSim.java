package com.openet.nblott;

import java.util.ArrayList;

public class OrbitSim extends Sim {

	// CONSTANTS

	public static final double G = 5;// 6 * Math.pow(10,-4);

	public OrbitSim() {
		super();
	}

	public OrbitSim(ArrayList<Entity> ents) {
		super(ents);
	}


	public void applyGravity() {
                for(int i = 0 ; i < parts.size() - 1 ; i++)
                {
                        Entity temp = parts.get(i);
                        Vector accel = temp.getAcceleration();
                        Vector vel = temp.getVelocity();
                        Vector position = temp.getPosition();
                        double m = temp.getMass();
                        for (int j = i + 1 ;j < parts.size() ; j++)
                        {
                                Entity e = parts.get(j);
                                DynVector relativePos = new DynVector(temp,e);

                                double productGMass = G * e.getMass() * temp.getMass();
                                double dSquared = relativePos.getMagnitude() * relativePos.getMagnitude();            

                                Vector v = (relativePos.simplify().times(productGMass).div(dSquared));
                                temp.getForce().add(v);
                                Vector inverse = v.vectorClone().invert();
                                e.getForce().add(inverse);
                        }
                }
	}

	@Override
	public void update() {

		for(int i = 0 ; i < parts.size() ; i++)
		{
			parts.get(i).getForce().zero();
			parts.get(i).getAcceleration().zero();
		}
                for(int i = 0 ; i < parts.size() - 1 ; i++)
                {
                        Entity temp = parts.get(i);
                        Vector accel = temp.getAcceleration();
                        Vector vel = temp.getVelocity();
                        Vector position = temp.getPosition();
                        double m = temp.getMass();
                        for (int j = i + 1 ;j < parts.size() ; j++)
                        {
                                Entity e = parts.get(j);
                                DynVector relativePos = new DynVector(temp,e);

                                double productGMass = G * e.getMass() * temp.getMass();
                                double dSquared = relativePos.getMagnitude() * relativePos.getMagnitude();

                                Vector v = (relativePos.simplify().times(productGMass).div(dSquared));
                                temp.getForce().add(v);
                                Vector inverse = v.vectorClone().invert();
                                e.getForce().add(inverse);
                        }
                }

		for(int i = 0 ; i < parts.size(); i++)
		{
			parts.get(i).update();
		}

	}
}	

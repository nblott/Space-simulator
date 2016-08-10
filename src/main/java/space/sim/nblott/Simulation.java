package space.sim.nblott;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {

        final static String ANSI_CLS = "\u001b[2J";
        final static String ANSI_HOME = "\u001b[H";

	public static void main(String[] args) throws Exception {
		ArrayList<Entity> parts = new ArrayList<Entity>();


		Entity Mercury = new Entity();
		Entity Venus = new Entity();
		Entity Earth = new Entity();
		Entity Mars = new Entity();
		Entity Jupiter = new Entity();
		Entity Saturn = new Entity();
		Entity Neptune = new Entity();
		Entity Uranus = new Entity();
		Entity Pluto = new Entity();

		Earth.setMass(1);
		Mercury.setMass(0.055);
		Venus.setMass(0.815);

		Earth.setPosition(new Vector(60,0));
		Earth.setVelocity(new Vector(0,1));

		Mercury.setPosition(new Vector(-20,0));
		Mercury.setVelocity(new Vector(0,2));

		Venus.setPosition(new Vector(-42.96,0));
		Venus.setVelocity(new Vector(0,2));
		Point Sun = new Point();
		Sun.setMass(10);
		
		Jupiter.setPosition(new Vector(0,-50));
		Jupiter.setVelocity(new Vector(-3,0));

		Saturn.setPosition(new Vector(80,-20));
		Saturn.setVelocity(new Vector(-2,-1));

		Neptune.setPosition(new Vector(-30,40));
		Neptune.setVelocity(new Vector(1,1));

		Uranus.setPosition(new Vector(-50,-15));
		Uranus.setVelocity(new Vector(-0,-0.5));


		parts.add(Sun);
		parts.add(Earth);
		parts.add(Mercury);
	//	parts.add(Venus);
	//	parts.add(Jupiter);
	//	parts.add(Saturn);
		parts.add(Uranus);
	//	parts.add(Neptune);
	

		ArrayList<Entity> randomSpaceObjs = new ArrayList<Entity>();
		
		Random gen = new Random();

		for(int i = 0 ; i < 100 ; i++)
		{
			Entity temp = new Entity();
			temp.setMass(gen.nextInt(70));
			temp.setPosition(new Vector(gen.nextInt(160)-80, gen.nextInt(100) - 50));

			temp.setVelocity(new Vector(gen.nextInt(2)-1, gen.nextInt(1) - 0.5));

			randomSpaceObjs.add(temp);
		}


		OrbitSim s = new OrbitSim(parts);

		SimDraw d = new SimDraw(s);

		for(int i = 0 ;true; i++)
		{
			Thread.sleep(10);
			s.update();
			d.updateMap();
			d.fancyDraw(true);
		}
	}
}



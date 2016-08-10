package space.sim.nblott;
import java.util.ArrayList;

public class SimDraw {

	private int[][] map;
	private Sim s;
	//MAP DEFAULT DIMENSIONS	

	public static final int DEFAULT_WIDTH = 208;
	public static final int DEFAULT_HEIGHT = 64;
	public static final int SCALE = 1;

	//MAP POINT CONSTANTS	

	public static final int PARTICLE_AT_POINT = -1;
	public static final int NOTHING_AT_POINT = 0;	
	public static final int POINT = 1;

        public static final String ANSI_CLS = "\u001b[2J";
        public static final String ANSI_HOME = "\u001b[H";

	// ICONS

	public static final String ICON_POINT = "o";
	public static final String ICON_ENTITY = "*";

	public SimDraw() {
		map = new int[DEFAULT_HEIGHT][DEFAULT_WIDTH];
		s = new Sim();
	}

	public SimDraw(int[][] m, Sim sim) {
		map = m;
		s = sim;
	}
	
	public SimDraw(int[][] m) {
		map = m;
		s = new Sim();
	}

	public SimDraw(Sim sim) {
		s = sim;
		map = new int[DEFAULT_HEIGHT][DEFAULT_WIDTH];

	}
	
	public int[][] getMap() {
		return map;
	}

	public Sim getSim() {
		return s;
	}

	public void setSim(Sim sim) {
		s = sim;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public void resetMap() {
                for (int i = 0 ; i < map.length; i++)
                {
                        for (int j = 0 ; j < map[i].length ;j++)
                        {
                                map[i][j] = NOTHING_AT_POINT;
                        }
                }

	}

	public void updateMap() {
		ArrayList<Entity> ents = s.getEnts();
		for (int i = 0 ; i< ents.size() ; i++)
		{
			Vector pos = ents.get(i).getPosition();
			if(pos.getY() > -(map.length / 2) && pos.getY() < (map.length / 2) &&
			   pos.getX() > - (map[0].length / 2) && pos.getX() < (map[0].length / 2))
			{
				if(!ents.get(i).getClass().equals(Point.class))
				{
					map[DEFAULT_HEIGHT / 2 + (int)pos.getY() / SCALE][DEFAULT_WIDTH / 2 +
						 (int)pos.getX() / SCALE] = PARTICLE_AT_POINT;
				}
				else
				{
                                        map[DEFAULT_HEIGHT / 2 + (int)pos.getY() / SCALE ][DEFAULT_WIDTH / 2 +
                                                 (int)pos.getX() / SCALE] = POINT;
				}
			}
		}
	}

	public void draw() {
                for(int i = map.length -1 ; i >= 0 ; i--)
                {
                        for(int j = 0 ; j < map[i].length ; j++)
                        {
                                if(map[i][j] == NOTHING_AT_POINT)
                                {
                                        System.out.print(" ");
                                }
                                else if (map[i][j] == PARTICLE_AT_POINT)
                                {
                                        System.out.print(ICON_ENTITY);
                                }
				else if(map[i][j] == POINT)
				{
					System.out.print(ICON_POINT);
				}
                        }
                        System.out.print("\n");
                }
	}

	public void draw(boolean resetAfter) {
		draw();	
		if(resetAfter)
		{
			resetMap();
		}
	}



	public void fancyDraw(boolean resetAfter) {

		fancyDraw();
		
		//s.print();
		//System.out.println();

		if(resetAfter)
                {
			resetMap();
                }
	}


	public void fancyDraw() {
		System.out.print(ANSI_CLS + ANSI_HOME);
		draw();
	}
}

public class NBody{
	public static double readRadius(String filename){
		In in= new In (filename);
		int number_of_planet= in.readInt();
		double radius = in.readDouble();
		return radius;

	}
	
	public static Planet [] readPlanets(String filename){
		In in= new In (filename);
		int number_of_planet= in.readInt();
		double radius = in.readDouble();
		Planet [] planets = new Planet [number_of_planet];
			
		while (!in.isEmpty()) {
			 /*double xxPos = Double.parseDouble(in.readString());
			 double yyPos = Double.parseDouble(in.readString());
            double xxVel = Double.parseDouble(in.readString());
            double yyVel = Double.parseDouble(in.readString());
            double mass = Double.parseDouble(in.readString());
            String imgFileName = in.readString();*/

			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();

			Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			for (int i = 0; i < planets.length; i++) {
    			planets[i] = p;
			}
		}
		return planets;
	}
	
	public static void main(String[] args){
		double T =Double.parseDouble(args[0]);
		double dt =Double.parseDouble(args[1]);
		String filename=args[2];
		double radius=readRadius(filename);
		Planet [] planets =readPlanets(filename);

		//stdDraw- set scale and background img
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius,radius);
		StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg");
		//draw all planet

		double time=0;
		for (int t = 0; t <= T; t += dt) {
			double [] xForces = new double [planets.length];
			double [] yForces = new double [planets.length];
			for (int i = 0; i < planets.length; i++) {
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
			}
			for (int i = 0; i < planets.length; i++) {
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			for (int i=0; i< planets.length; i++){
			planets[i].draw();
			}
		}

		StdDraw.show();
		StdDraw.pause(10);
	}
	
	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n", radius);
	for (int i = 0; i < planets.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
	}
}
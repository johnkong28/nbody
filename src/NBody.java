import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {


    public static void main(String[] args) {
        double time = 0;
        double totalTime = 1577880000000000000000000.0;
        double dt = 25000.0;
        String pfile = "data/twin-binaries.txt";
        if (args.length > 2) {
            totalTime = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
            pfile = args[2];
        }

        String fname = pfile;



		Planet[] planets = readPlanets(fname); // readPlanets(fname);

        double radius = readRadius(fname); // readRadius(fname);



		System.out.printf("%d\n", planets.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		              planets[i].xPos, planets[i].yPos,
		                      planets[i].xvel, planets[i].yvel,
		                      planets[i].mass, planets[i].fileName);
		}


        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
    double[] xForces = new double[planets.length];
    double[] yForces = new double[planets.length];
        for (double t = 0.0; t < totalTime; t += dt) {
                dt = dt*1.001;
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);}
            for (int i = 0; i < planets.length; i++){
                planets[i].draw();
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.show(10);
        }
    }
    public static double readRadius(String fname){
        try {
            Scanner scan = new Scanner(new File(fname));
            scan.nextInt();
            double radius = scan.nextDouble();
            scan.close();
            return radius;
        } catch (FileNotFoundException e){
            System.out.println("Bumbaclatt");
            return 0;
        }



    }
    public static Planet[] readPlanets(String fname){
        try {
            Scanner scan = new Scanner(new File(fname));
            int num = scan.nextInt();
            scan.nextDouble();
            Planet[] planets = new Planet[num];

            for (int i =0; i<num;i++){
                double xPos = scan.nextDouble();
                double yPos = scan.nextDouble();
                double xvel = scan.nextDouble();
                double yvel = scan.nextDouble();
                double mass = scan.nextDouble();
                String filename = scan.next();
                Planet newplanet = new Planet(xPos,yPos,xvel,yvel,mass,filename);
                planets[i] = newplanet;
            }
            scan.close();
            return planets;

        } catch (FileNotFoundException e){
            System.out.println("Bumbaclatt");
            Planet[] test = new Planet[0];
            return test;
        }
    }
}

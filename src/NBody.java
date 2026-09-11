import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {


    public static void main(String[] args) {
        double totalTime = 157788000.0;
        double dt = 25000.0;
        String pfile = "data/planets.txt";
        if (args.length > 2) {
            totalTime = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
            pfile = args[2];
        }

        String fname = "./data/planets.txt";



		Planet[] planets = null; // readPlanets(fname);

        double radius = 0.0; // readRadius(fname);



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

        for (double t = 0.0; t < totalTime; t += dt) {

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
            scan.nextLine();
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

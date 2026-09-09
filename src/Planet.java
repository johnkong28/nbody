public class Planet {
    double xPos;
    double yPos;
    double xvel;
    double yvel;
    double mass;
    String fileName;

    public Planet(double xp, double yp, double xv, double yv, double mass, String filename){
        xPos = xp;
        yPos = yp;
        xvel = xv;
        yvel = yv;
        this.mass = mass;
        fileName = filename;

    }
    public Planet(Planet p) {
        fileName = p.fileName;
        xPos = p.xPos;
        yPos = p.yPos;
        xvel = p.xvel;
        yvel = p.yvel;
        mass = p.mass;

    }
}

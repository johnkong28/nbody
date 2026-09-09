public class Planet {
    public final double g = 6.67*Math.pow(10, -11);
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
    public double calcDistance(Planet other){
        double dist = Math.pow(Math.pow(this.xPos-other.xPos,2)+Math.pow(this.yPos-other.yPos,2),0.5);
        return dist;

    }
    public double calcForceExertedBy(Planet other){
        return (g*this.mass*other.mass)/calcDistance(other);
    }
    public void movePlanet(Planet p) {

    }
}

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
        return (g*mass*other.mass)/Math.pow(calcDistance(other),2);
    }
    public double calcForceExertedByX(Planet other){
        return (other.xPos-xPos)*calcForceExertedBy(other)/calcDistance(other);
    }
    public double calcForceExertedByY(Planet other){
        return (other.yPos-yPos)*calcForceExertedBy(other)/calcDistance(other);
    }
    public void update(double seconds, double xforce, double yforce){
        double xaccel=xforce/mass; double yaccel = yforce/mass;
        double newxvel = xvel+seconds*xaccel; double newyvel = yvel + seconds*yaccel;
        xvel = newxvel; yvel = newyvel;
        double newxpos = xPos+xvel*seconds; double newypos = yPos+yvel*seconds;
        xPos = newxpos; yPos = newypos;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netx = 0;
        for (int i = 0; i < allPlanets.length; i++){
            Planet other = allPlanets[i];
            if (!other.equals(this)){
                netx += calcForceExertedByX(other);

            }

        }
        return netx;

    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netx = 0;
        for (int i = 0; i < allPlanets.length; i++){
            Planet other = allPlanets[i];
            if (!other.equals(this)){
                netx += calcForceExertedByY(other);

            }

        }
        return netx;

    }
}

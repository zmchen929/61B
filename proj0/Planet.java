public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double deltax = this.xxPos-p.xxPos;
        double deltay = this.yyPos-p.yyPos;
        return Math.sqrt(deltax*deltax + deltay*deltay);
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return G * this.mass * p.mass / r / r;
    }

    public double calcForceExertedByX(Planet p){
        double F = this.calcForceExertedBy(p);
        double r =  this.calcDistance(p);
        return F*(p.xxPos-this.xxPos)/r;
    }

    public double calcForceExertedByY(Planet p){
        double F = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return F*(p.yyPos-this.yyPos)/r;
    }

    public double calcNetForceExertedByX(Planet[] allp) {
        double netx = 0.0;
        for (Planet p : allp) {
            if(this.equals(p)){
                continue;
            }
            netx += this.calcForceExertedByX(p);
        }
        return netx;
    }

    public double calcNetForceExertedByY(Planet[] allp){
        double nety = 0.0;
        for (Planet p : allp) {
            if(this.equals(p)){
                continue;
            }
            nety += this.calcForceExertedByY(p);
        }
        return nety;
    }

    public void update(double dt, double fX, double fY) {
        double Ax = fX / this.mass;
        double Ay = fY / this.mass;
        this.xxVel = this.xxVel + dt * Ax;
        this.yyVel = this.yyVel + dt * Ay;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        String filename = "/images/"+imgFileName;
        StdDraw.picture(xxPos, yyPos,filename);
    }

}

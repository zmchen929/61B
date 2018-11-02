public class NBody {

    public static double readRadius(String s) {
        In in = new In(s);
        in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int N = in.readInt();
        in.readDouble();
        Planet[] allp = new Planet[N];
        for(int i=0; i<N; i++){
            allp[i] = new Planet(0,0,0,0,0, "");
            allp[i].xxPos = in.readDouble();
            allp[i].yyPos = in.readDouble();
            allp[i].xxVel = in.readDouble();
            allp[i].yyVel = in.readDouble();
            allp[i].mass = in.readDouble();
            allp[i].imgFileName = in.readString();
        }
        return allp;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double universeR = readRadius(filename);
        Planet[] allplanet = readPlanets(filename);

        /*StdDraw.setCanvasSize((int)universeR, (int)universeR);*/
        StdDraw.setScale(0-universeR,universeR);
        StdDraw.enableDoubleBuffering();
        //StdDraw.picture(0, 0,"./images/starfield.jpg");
        //for(Planet p: allplanet) {
        //    p.draw();
        //}
        double time = 0;
        while(time<T){
            StdDraw.picture(0, 0,"./images/starfield.jpg");
            double[] xForce = new double[allplanet.length];
            double[] yForce = new double[allplanet.length];
            for(int i=0; i<allplanet.length; i++) {
                xForce[i] = allplanet[i].calcNetForceExertedByX(allplanet);
                yForce[i] = allplanet[i].calcNetForceExertedByY(allplanet);
            }
            for(int i=0; i<allplanet.length; i++){
                allplanet[i].update(dt, xForce[i], yForce[i]);
                allplanet[i].draw();
            }
            StdDraw.show(10);
            time = time+dt;
        }





    }
}

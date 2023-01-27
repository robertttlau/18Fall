public class NBody {
    public static double readRadius(String pathway){
        In in = new In(pathway);
        int N = in.readInt();
		double R = in.readDouble();
        return R;
    }
    public static Planet[] readPlanets(String pathway){
        In in = new In(pathway);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] array_planets=new Planet[N];
        for (int i=0; i<N ; i=i+1){
            double xxPos= in.readDouble();
            double yyPos= in.readDouble();
            double xxVel=in.readDouble();
            double yyVel=in.readDouble();
            double mass=in.readDouble();
            String imgFileName=in.readString();
            Planet P1=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
            array_planets[i]=P1;
        }
        return array_planets;
    }
    
public static void main(String[] args){
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename=args[2];
    Planet[] planets=readPlanets(filename);
    double radius=readRadius(filename);
    StdDraw.setScale(radius,-radius);
    StdDraw.picture(0, 0, "images/starfield.jpg");
    for (Planet p:planets){
        p.draw();
    }
    StdDraw.enableDoubleBuffering();
double time=0;
int num=planets.length;
while (time <= T) {
   double[] xForces=new double[num];
   double[] yForces=new double[num];
   for (int i=0;i<num;i=i+1){
   for (Planet p:planets){
   xForces[i]=planets[i].calcNetForceExertedByX(planets);
   yForces[i]=planets[i].calcNetForceExertedByY(planets);
   }
   }
for (int i=0;i<num;i=i+1){
    planets[i].update(dt,xForces[i],yForces[i]);
}
StdDraw.picture(0, 0, "images/starfield.jpg");
for (Planet p:planets){
    p.draw();
}
StdDraw.show();
StdDraw.pause(10);
    time += dt;
}
}


}

public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV,
    double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;  
    }
    public Planet(Planet p){
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;  
}
public double calcDistance(Planet p){
    double r=0;
    double r_2=0;
    double dx=0;
    double dy=0;
    dx= this.xxPos-p.xxPos;
    dy= this.yyPos-p.yyPos;
    r_2=dx*dx+dy*dy;
    r=Math.sqrt(r_2);
    return r;
}
public static final double G = 6.67e-11;

public double calcForceExertedBy(Planet P){
    double F=0;
    double r=0;
    r=this.calcDistance(P);
    F=(G*(this.mass)*(P.mass))/(r*r);
    return F;
}
public double calcForceExertedByX(Planet P){
    double Fx=0;
    Fx=this.calcForceExertedBy(P)*(P.xxPos-this.xxPos)/this.calcDistance(P);
    return Fx;
}
public double calcForceExertedByY(Planet P){
    double Fy=0;
    Fy=this.calcForceExertedBy(P)*(P.yyPos-this.yyPos)/this.calcDistance(P);
    return Fy;
}
public double calcNetForceExertedByX(Planet planets[]){
    double NetFx=0;
    for (Planet p:planets){
        if (this.equals(p)){
            continue;
        }
        NetFx=NetFx+this.calcForceExertedByX(p);
    }
    return NetFx;
}
public double calcNetForceExertedByY(Planet planets[]){
    double NetFy=0;
    for (Planet p:planets){
        if (this.equals(p)){
            continue;
        }
        NetFy=NetFy+this.calcForceExertedByY(p);
    }
    return NetFy;
}

public void update(double dt,double fX,double fY){
    double a_netx=0;
    double a_nety=0;
    a_netx=fX/this.mass;
    a_nety=fY/this.mass;
    xxVel=this.xxVel+dt*a_netx;
    yyVel=this.yyVel+dt*a_nety;
    xxPos=this.xxPos+dt*xxVel;
    yyPos=this.yyPos+dt*yyVel;
}
public void draw(){
    StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
}



}
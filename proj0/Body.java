import java.lang.Math;

public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        return Math.sqrt((this.xxPos - b.xxPos)*(this.xxPos - b.xxPos) +
                (this.yyPos - b.yyPos)*(this.yyPos - b.yyPos));
    }

    public double calcForceExertedBy(Body B) {
        return (6.67e-11)*this.mass*B.mass/(this.calcDistance(B)*this.calcDistance(B));
    }

    public double calcForceExertedByX(Body B) {
        double force = calcForceExertedBy(B) * (this.xxPos - B.xxPos) / this.calcDistance(B);
        if (force < 0){
            return -force;
        } else {
            return force;
        }

    }

    public double calcForceExertedByY(Body B) {
        double force = calcForceExertedBy(B) * (this.yyPos - B.yyPos) / this.calcDistance(B);
        if (force < 0){
            return -force;
        } else {
            return force;
        }
    }

    public double calcNetForceExertedByX(Body[] allBodies) {
        double netForce = 0;
        for (Body B : allBodies) {
            netForce += this.calcForceExertedByX(B);
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Body[] allBodies) {
        double netForce = 0;
        for (Body B : allBodies) {
            netForce += this.calcForceExertedByY(B);
        }
        return netForce;
    }
}








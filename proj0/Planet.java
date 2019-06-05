public class Planet {
	public double g_constant=6.67e-11;

	public double xxPos;

	public double yyPos;

	public double xxVel;

	public double yyVel;

	public double mass;

	public String imgFileName;

	public Planet(double xP, double yP, double xV,
              	  double yV, double m, String img){
		//this(1,2,3,4,5,"jupiter.gif");
		/*this.xP=1;
		this.yP=2;
		this.xV=3;
		this.yV=4;
		this.m=5;
		this.img="jupiter.gif";*/
		double xxPos=xP;
		double yyPos=yP;
		double xxVel=xV;
		double yyVel=yV;
		double mass=m;
		String imgFileName=img;
	}

    public Planet(Planet p){
    	xxPos=p.xxPos;
    	yyPos=p.yyPos;
    	xxVel=p.xxVel;
    	yyVel=p.yyVel;
    	mass=p.mass;
    	imgFileName=p.imgFileName;
    }

	public double calcDistance(Planet p){
		double r=Math.sqrt((xxPos-this.xxPos)*(xxPos-this.xxPos)+(yyPos-this.yyPos)*(yyPos-this.yyPos));
		return r;
	}


	public double calcForceExertedBy(Planet p){
		double force=g_constant*this.mass*mass/calcDistance(this);
		return force;
	}

	public double calcForceExertedByX(Planet p){
		double forceX=calcForceExertedBy(this)*(xxPos-this.xxPos)/calcDistance(this);
		return forceX;
	}

	public double calcForceExertedByY(Planet p){
		double forceY=calcForceExertedBy(this)*(yyPos-this.yyPos)/calcDistance(this);
		return forceY;
	}

}


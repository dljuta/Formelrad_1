package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		this.leistung = pAusUundR(this.spannung, this.widerstand);
		this.strom = iAusUundR(this.spannung, this.widerstand);
	}
	
	public double pAusUundR (double u, double r) {
		
		return (u*u)/r;
	}
	
	public double iAusUundR (double u, double r) {
		
		return u/r;
	
	}
	
	public double pAusUundI (double u, double i) {
		
		return u*i;
	}

	public double rAusUundI (double u, double i) {
	
		return u/i;
	}
	
	public double pAusRundI (double i, double r) {
		System.out.println("(i*i)*r");
		return (i*i)*r;
	}
	
	public double UAusRundI (double r, double i) {
		System.out.println("r*i");
		return r*i;
	}
	

	public double iAusPundR (double p, double r) {
		System.out.println("Math.sqrt(p/r)");
		return Math.sqrt(p/r);
	}
	
	public double UAusRundP (double r, double p) {
		System.out.println("Math.sqrt(p/r)");
		return Math.sqrt(p/r);
	}

	public double iAusAundB (double a, double b) {
		System.out.println("a/b");
		return a/b;
	}
	
	public double rAusAundB (double a, double b) {
		System.out.println("(b*b)/a");
		return (b*b)/a;
	}
	
	
}

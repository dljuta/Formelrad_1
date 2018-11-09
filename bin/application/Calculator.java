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
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	
}

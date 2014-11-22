public class Vagoni extends LinkedList
{
	public double Volume; //volumen m^3
	public boolean TypeCargo; //tip tovora (false - tekoci) - (true - kosovni)
	public String Name;
	public double SpecificWeight; // kg/m^3
	public double SpecificValue; // €/m^3
	
	public Vagoni(final double mw, final boolean tc, final String n, final double sw, final double sv)
	{
		Volume = mw;
		TypeCargo = tc;
		Name = n;
		SpecificWeight = sw;
		SpecificValue = sv;
	}
}

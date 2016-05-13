import java.util.Random;

public class Stocks {
	
	int numOfShares;
	String symbol;
	
	public  Stocks(String symbol)
	{
		setSymbol(symbol);
		setnumOfShares();
	}
	public int RandomValues()
	{
		int randomVal;
		Random random = new Random();
		randomVal= random.nextInt(10000);
		return randomVal;
	}
	public void setSymbol(String symbol)
	{
		this.symbol=symbol;
	}
	public void setnumOfShares()
	{
		this.numOfShares=(RandomValues()%80);
	}
	public String getSymbol()
	{
		return this.symbol;
	}
	public int getnumOfShares()
	{
		return this.numOfShares;
	
	}
	public String getAllValues()
	{
		return this.symbol+","+this.numOfShares;
	}
}
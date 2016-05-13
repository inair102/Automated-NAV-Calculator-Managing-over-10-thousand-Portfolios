import java.io.*;
import java.util.*;


public class PortfolioGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line;
		int i=0;
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		
		try
		{	
			BufferedReader csv = new BufferedReader(new FileReader("/home/cloudera/Downloads/companylist.csv"));
			while((line = csv.readLine())!=null)
			{
				String tokens[]=line.split(",");
				map.put(i,tokens[0]);
				i++;
			}	
			System.out.println(i);
			System.out.println(map.get(809));
			int count =0;
			for(;count<10000;count++)
			{
				String path="/home/cloudera/Downloads/PortfolioGenerator/Portfolios/Portfolio"+count+".txt";
				PrintWriter pw = new PrintWriter(new FileWriter(path));
				Random random = new Random();
				for(int j=0;j<25;j++)
				{
					int symref = random.nextInt(3277);
					Stocks stock = new Stocks(map.get(symref));
					pw.println(stock.getAllValues());
				}
				pw.close();
			}
			csv.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
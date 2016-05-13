import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class EODStockStreamer {
	
	public static void main( String[] args ){
		try{
			BufferedReader br1 = new BufferedReader(new FileReader("/home/cloudera/Downloads/companylist.csv"));
			HashMap<Integer,String> map = new HashMap<Integer,String>();
			String line;
			int i=0;
			while((line=br1.readLine())!=null){
				if(i!=0){
					String tokens[]=line.split(",");
					tokens[0] = tokens[0].replaceAll("\\s+", "");
					map.put(i,tokens[0]);
					System.out.println(map.get(i));
					i++;
				}
				else
					i++;
			}
			br1.close();
			PrintWriter pw = new PrintWriter(new FileWriter("/home/cloudera/Downloads/currentquotes.txt"));
			for(i=1;i<map.size();i++){
				Stock stock = StockFetcher.getStock(map.get(i));
				pw.println(map.get(i)+","+stock.getPrice());
			}
			pw.close();
		}
		catch(Exception e){
			System.out.println(e);
    	}
	}
}

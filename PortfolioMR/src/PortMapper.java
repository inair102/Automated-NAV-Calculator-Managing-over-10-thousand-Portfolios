import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class PortMapper extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {

	public void map(LongWritable ikey, Text ivalue, Context context)
			throws IOException, InterruptedException {
		String tokens[] =ivalue.toString().split(",");
		File dir = new File("/home/cloudera/Downloads/PortfolioGenerator/Portfolios");
		File[] files = dir.listFiles();
		int count =0;
		for(File f : files){
			if(f.isFile()){
				BufferedReader bR = null;
				try{
					bR = new BufferedReader(new FileReader(f));
					String lines;
					while((lines = bR.readLine()) != null){
						String[] vals = lines.split(",");
						String symbols = vals[0];
						String shares = vals[1];
						
						if(symbols.equalsIgnoreCase(tokens[0]))
						{
							Double finalval = Double.parseDouble(shares)*Double.parseDouble(tokens[1]);
							context.write(new IntWritable(count), new DoubleWritable(finalval));
						}
						else {
							context.write(new IntWritable(count), new DoubleWritable(0));
						}
					}
				}
				finally{
					if (bR != null){
						bR.close();
					}
				}	
			}
			count++;
		}
	}
}

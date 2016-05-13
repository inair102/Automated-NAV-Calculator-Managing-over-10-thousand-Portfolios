import java.io.IOException;


import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;


public class PortReducer extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

	public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context)
			throws IOException, InterruptedException {
		
		double sum=0;
		for(DoubleWritable d : values)
		{
			sum+=d.get();
		}
		context.write(key,new DoubleWritable(sum));
	}
}

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class PortDriver {

	public static void main(String[] args) throws Exception {
	
		Path ipath = new Path("/home/cloudera/Downloads/currentquotes(1).txt");
		Path opath = new Path("/home/cloudera/Downloads/FinalValuation");
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "PortfolioMR");
		job.setJarByClass(PortDriver.class);
		job.setMapperClass(PortMapper.class);
		job.setReducerClass(PortReducer.class);
		
		// TODO: specify output types
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(DoubleWritable.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, ipath);
		FileOutputFormat.setOutputPath(job, opath);

		if (!job.waitForCompletion(true))
			return;
	}
}

/*
 * This class is the main class which applies the main method 
 * and calls the mapper and reducer class
 * 
 * 
 */
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MainClass {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: MainClass <input path> <output path>");
      System.exit(-1);
    }
    
    Job job = new Job();
    job.setJarByClass(MainClass.class);
    job.setJobName("Max temperature");

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(MaxTemperatureMapper.class);
    job.setReducerClass(Reducer.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
    
	Job job2 = new Job(conf, "HotColdDay");			
	job2.setJarByClass(Map.class);			
	job2.setMapperClass(Map.class);					
	//job.setReducerClass(Reduce.class);
	
	job2.setMapOutputKeyClass(Text.class);
	job2.setMapOutputValueClass(Text.class);				
	job2.setOutputKeyClass(Text.class);				
	job2.setOutputValueClass(Text.class);					
	
	job2.setInputFormatClass(TextInputFormat.class);					
	job2.setOutputFormatClass(TextOutputFormat.class);
	
	job2.setNumReduceTasks(0);
	
   	Path outputPath = new Path(args[1]);	
    
    FileInputFormat.addInputPath(job, new Path(args[0]));
	FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
	
	outputPath.getFileSystem(conf).delete(outputPath);
	
	System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
// ^^ MainClass

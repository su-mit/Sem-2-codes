/*
 * This class implements the mapper class for the problem statement
 * for finding out which day was hot or cold [hot temp>35; cold temp <10](Q.2)
 * 
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.StringTokenizer; 
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
 
	public static class Map extends
	Mapper<LongWritable, Text, Text, Text> {
		
		static long counter = 0; 
    	
        @Override 
        public void map(LongWritable key, Text value, Context context)
		throws IOException, InterruptedException {
        	
        	counter++;
        	
        	String line = value.toString();
        	String[] lineInputs = line.split("\\s+");
        	
        	Text date = new Text();
        	date.set(lineInputs[1]);
        	
        	Double maxTemp = Double.parseDouble(lineInputs[5]);
        	Double minTemp = Double.parseDouble(lineInputs[6]);
        	
        	System.out.println("counter=" + counter +"date="+ date + "minTemp=" + minTemp + "maxTemp=" + maxTemp);
        	
        	String coldDay = "";
        	
        	if(minTemp < 10 ) {
        		coldDay = "Cold Day";
        	}
        	else if (maxTemp > 35)
        		coldDay = "Hot Day";
        	else coldDay = "Normal Day";
        	
        	Text coldDayText = new Text();
        	coldDayText.set(coldDay);
            	            	
            context.write(date, coldDayText); 
 
        } 
    
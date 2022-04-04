import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main 
{

	public static void main (String []args) {
	
	BufferedReader reader = null;

	try
	{
		reader = new BufferedReader(new FileReader("stops.txt"));
    	Scanner scanner = new Scanner(reader);
    	
    	while(scanner.hasNextLine())
    	{
    		String [] line = scanner.nextLine().trim().split(",");
    		int stopId = Integer.parseInt(line[0]);
    		int stopCode = Integer.parseInt(line[1]);
    		String stopName = line[2];
    		String stopDesc = line[3];
    		double stopLat = Double.parseDouble(line[4]);
    		double stopLong = Double.parseDouble(line[5]);
    		String zoneId = line[6];
    		String stopURL = line[7];
    		int locationType = Integer.parseInt(line[8]);
    		int parentStation = Integer.parseInt(line[9]);
    	}
	}
	catch(Exception x)
	{
	
	}
	
	try
	{
		reader = new BufferedReader(new FileReader("stop_times.txt"));
    	Scanner scanner = new Scanner(reader);
    	
    	while(scanner.hasNextLine())
    	{
    		String [] line = scanner.nextLine().trim().split(",");
    		int stopId = Integer.parseInt(line[0]);
    		int stopCode = Integer.parseInt(line[1]);
    		String stopName = line[2];
    		String stopDesc = line[3];
    		double stopLat = Double.parseDouble(line[4]);
    		double stopLong = Double.parseDouble(line[5]);
    		String zoneId = line[6];
    		String stopURL = line[7];
    		int locationType = Integer.parseInt(line[8]);
    		int parentStation = Integer.parseInt(line[9]);
    	}
	}
	catch(Exception x)
	{
	
	}
	
	try
	{
		reader = new BufferedReader(new FileReader("stops.txt"));
    	Scanner scanner = new Scanner(reader);
    	
    	while(scanner.hasNextLine())
    	{
    		String [] line = scanner.nextLine().trim().split(",");
    		int stopId = Integer.parseInt(line[0]);
    		int stopCode = Integer.parseInt(line[1]);
    		String stopName = line[2];
    		String stopDesc = line[3];
    		double stopLat = Double.parseDouble(line[4]);
    		double stopLong = Double.parseDouble(line[5]);
    		String zoneId = line[6];
    		String stopURL = line[7];
    		int locationType = Integer.parseInt(line[8]);
    		int parentStation = Integer.parseInt(line[9]);
    	}
	}
	catch(Exception x)
	{
	
	}
	
	}
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{
	static ArrayList<busStopTransfers> transfersList = new ArrayList<busStopTransfers>();
	static ArrayList<busStops> stopList = new ArrayList<busStops>();
	static ArrayList<busStopTimes> stopTimesList = new ArrayList<busStopTimes>();
	
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
    		stopList.add(new busStops(stopId, stopCode, stopName, stopDesc, stopLat, stopLong, zoneId, stopURL, locationType, parentStation ));
    
    	}
	}
	catch(Exception x)
	{
	System.out.print("Error: File will not read in");
	}
	
	try
	{
		reader = new BufferedReader(new FileReader("stop_times.txt"));
    	Scanner scanner = new Scanner(reader);
    	
    	while(scanner.hasNextLine())
    	{
    		String [] line = scanner.nextLine().trim().split(",");
    		
    		int tripId = Integer.parseInt(line[0]);
    		String arrivalTime = line[2];
    		String departureTime = line[3];
    		int stopId = Integer.parseInt(line[4]);
    		int stopSequence = Integer.parseInt(line[5]);
    		int stopHeadSign = Integer.parseInt(line[6]);
    		int pickupType = Integer.parseInt(line[7]);
    		int dropOffType = Integer.parseInt(line[8]);
    		int shapeDistTraveled = Integer.parseInt(line[9]);
    		
    		stopTimesList.add(new busStopTimes(tripId, arrivalTime, departureTime, stopId, stopSequence, stopHeadSign, pickupType, dropOffType, shapeDistTraveled));
 
    	}
 	
	}
	catch(Exception x)
	{
		System.out.print("Error: File will not read in");
	}
	
	try
	{
		reader = new BufferedReader(new FileReader("transfers.txt"));
    	Scanner scanner = new Scanner(reader);
    	
    	while(scanner.hasNextLine())
    	{
    		String [] line = scanner.nextLine().trim().split(",");
    		
    		int fromStopID = Integer.parseInt(line[0]);
    		int toStopId = Integer.parseInt(line[1]);
    		int transferTime = Integer.parseInt(line[1]);
    		int minTransferTime = Integer.parseInt(line[2]);
    		transfersList.add(new busStopTransfers(fromStopID,toStopId,transferTime,minTransferTime));
    	}
	}
	catch(Exception x)
	{
		System.out.print("Error: File will not read in");
	}
	
	}
	
	
	
	
}

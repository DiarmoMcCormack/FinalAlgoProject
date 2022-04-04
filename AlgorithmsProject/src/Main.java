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
		reader = new BufferedReader(new FileReader("/Users/diarmomccormack/git/FinalAlgoProject/AlgorithmsProject/stops.txt"));
    	Scanner scanner = new Scanner(reader);
    	scanner.nextLine();
    	
    	while(scanner.hasNextLine())
    	{
    		String [] line = scanner.nextLine().trim().split(",");
    	
    		int stopId;
    		if(!line[0].equals(" ")) 
    		{
    			stopId = Integer.parseInt(line[0]);	
    		}
    		else 
    		{
    			stopId=0;
    		}
    		int stopCode;
    		if(!line[1].contains(" ")) 
    		{
    			stopCode = Integer.parseInt(line[1]);
    		}
    		else 
    		{
    			stopCode=0;
    		}
    		String stopName;
    		if(!line[2].equals(" ")) 
    		{
    			stopName = line[2];
    		}
    		else 
    		{
    			stopName = null;
    		}
    		String stopDesc;
    		if(!line[3].equals(" ")) 
    		{
    			stopDesc = line[3];
    		}
    		else 
    		{
    			stopDesc = null;
    		}
    		double stopLat;
    		if(!line[4].equals(" ")) 
    		{
    			stopLat = Double.parseDouble(line[4]);	
    		}
    		else 
    		{
    			stopLat=0;
    		}
    		double stopLong;
    		if(!line[5].equals(" ")) 
    		{
    			stopLong = Double.parseDouble(line[5]);	
    		}
    		else 
    		{
    			stopLong=0;
    		}
    		String zoneId;
    		if(!line[6].equals(" ")) 
    		{
    			zoneId = line[6];
    		}
    		else 
    		{
    			zoneId = null;
    		}
    		String stopURL;
    		if(!line[7].equals(" ")) 
    		{
    			stopURL = line[7];
    		}
    		else 
    		{
    			stopURL = null;
    		}
    		int locationType;
    		if(!line[8].equals(" ")) 
    		{
    			locationType = Integer.parseInt(line[8]);
    		}
    		else 
    		{
    			locationType=0;
    		}
    		//parent statiion?
    		stopList.add(new busStops(stopId, stopCode, stopName, stopDesc, stopLat, stopLong, zoneId, stopURL, locationType));
    	}
	}
	catch(Exception x)
	{
	System.out.print("Error: File will not read in");
	}
	
	
	try
	{
		reader = new BufferedReader(new FileReader("/Users/diarmomccormack/git/FinalAlgoProject/AlgorithmsProject/stop_times.txt"));
    	Scanner scanner = new Scanner(reader);
    	scanner.nextLine();
    	
    	while(scanner.hasNextLine()){
    		String [] line = scanner.nextLine().trim().split(",");
    	
    		
    		int tripId;
    		if(!line[0].equals(" ")) 
    		{
    			tripId = Integer.parseInt(line[0]);
    		}
    		else 
    		{
    			tripId=0;
    		}
 
    		String arrivalTime;
    		if(!line[1].equals(" ")) 
    		{
    			arrivalTime = line[1];
    		}
    		else 
    		{
    			arrivalTime = null;
    		}
    		String departureTime;
    		if(!line[2].equals(" ")) 
    		{
    			departureTime = line[2];
    		}
    		else 
    		{
    			departureTime = null;
    		}
    		int stopId;
    		if(!line[3].equals(" ")) 
    		{
    			stopId = Integer.parseInt(line[3]);
    		}
    		else 
    		{
    			stopId=0;
    		}
    		int stopSequence;
    		if(!line[4].equals("")) 
    		{
    			stopSequence = Integer.parseInt(line[4]);
    		}
    		else 
    		{
    			stopSequence=0;
    		}
    		int stopHeadSign;
    		if(!line[5].equals("")) 
    		{
    			stopHeadSign = Integer.parseInt(line[5]);
    		}
    		else 
    		{
    			stopHeadSign=0;
    		}
    		int pickupType;
    		if(!line[6].equals(" ")) 
    		{
    			pickupType = Integer.parseInt(line[6]);
    		}
    		else 
    		{
    			pickupType=0;
    		}
    		int dropOffType;
    		if(!line[7].equals(" ")) 
    		{
    			dropOffType = Integer.parseInt(line[7]);
    		}
    		else 
    		{
    			dropOffType=0;
    		}
    		/*int shapeDistTraveled;
    		if(!line[8].equals(" ")) 
    		{
    			shapeDistTraveled = Integer.parseInt(line[8]);
    		}
    		else 
    		{
    			shapeDistTraveled=0;
    		}
    		*/
    		stopTimesList.add(new busStopTimes(tripId, arrivalTime, departureTime, stopId, stopSequence, stopHeadSign, pickupType, dropOffType));
 
    	}
 	
	}
	catch(Exception x)
	{
		System.out.print("Error: File will not read in");
	}
	
	try
	{
		reader = new BufferedReader(new FileReader("/Users/diarmomccormack/git/FinalAlgoProject/AlgorithmsProject/transfers.txt"));
    	Scanner scanner = new Scanner(reader);
    	scanner.nextLine();
    	
    	while(scanner.hasNextLine())
    	{
    		
    		String [] line = scanner.nextLine().trim().split(",");
    		
    		for (int i = 0; i<line.length;i++) 
    		{
    		System.out.println(line[i]);
    		}
    		
    		int fromStopID;
    		if(!line[0].equals(" ")) 
    		{
    			fromStopID = Integer.parseInt(line[0]);
    		}
    		else 
    		{
    			fromStopID=0;
    		}
    		
    		int toStopId;
    		if(!line[1].equals(" ")) 
    		{
    			toStopId = Integer.parseInt(line[1]);
    		}
    		else 
    		{
    			toStopId=0;
    		}
    		
    		int transferType;
    		if(!line[2].equals(" ")) 
    		{
    			transferType = Integer.parseInt(line[2]);
    		}
    		else 
    		{
    			transferType=0;
    		}
    		
    		/*int minTransferTime;
    		if(!line[3].equals(" ")) 
    		{
    			minTransferTime= Integer.parseInt(line[3]);
    		}
    		else 
    		{
    			minTransferTime=0;
    		}*/
    		
    		transfersList.add(new busStopTransfers(fromStopID,toStopId,transferType));
    		
    	}
	}
	catch(Exception x)
	{
		System.out.print("Error: File will not read in");
	}
	
	}
}

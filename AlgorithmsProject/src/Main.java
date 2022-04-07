import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
	static ArrayList<busStopTransfers> transfersList = new ArrayList<busStopTransfers>();
	static ArrayList<busStops> stopList = new ArrayList<busStops>();
	static ArrayList<busStopTimes> stopTimesList = new ArrayList<busStopTimes>();
	
	static ArrayList<DirectedEdge> edgeList = new ArrayList<DirectedEdge>();
	
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
 // checking if arrival time is valid, the object will only be created if so
    		String arrivalTime1 = line[1];
    		if (checkTimes(arrivalTime1)==true) 
    		{
    			String arrivalTime = arrivalTime1;
    			//System.out.print("done");
    		
    		String departureTime1 = line[2];
    		if (checkTimes(departureTime1)==true) 
    		{
    			String departureTime = departureTime1;
 
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
    		double shapeDistTraveled=0;
    		if(line.length<9) 
    		{
    			shapeDistTraveled = 0;
    		}
    		else if(!line[8].equals(" ")) 
    		{
    			shapeDistTraveled = Double.parseDouble(line[8]);
    		}
    		else 
    		{
    			shapeDistTraveled=0;
    		}
    		String [] delimiter = arrivalTime.trim().split(":");

    		//if(Integer.parseInt(delimiter[0]) < 24 && Integer.parseInt(delimiter[1]) < 60 && Integer.parseInt(delimiter[2])<60) 
    		
    			stopTimesList.add(new busStopTimes(tripId, arrivalTime, departureTime, stopId, stopSequence, stopHeadSign, pickupType, dropOffType, shapeDistTraveled));
    		
    	}}
 	
	}}
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
    		
    		int minTransferTime;
    		if(line.length < 4)
    		{
    			minTransferTime = 0;
    		}
    		else if((!line[3].equals(" "))  )
    		{
    			minTransferTime= Integer.parseInt(line[3]);
    		}
    		else 
    		{
    			minTransferTime=0;
    		}
    		  		transfersList.add(new busStopTransfers(fromStopID,toStopId,transferType, minTransferTime));
    	}
	}
	catch(Exception x)
	{
		System.out.print("Error: File will not read in");
	}
	
	System.out.println("Welcome to the Vancouver Bus System");
	
	boolean quit = false;
	while(!quit)
	{
	
	System.out.println("Please enter 1 to find the shortest routes, enter 2 to search for a bus stop by name, enter 3 to search for all trips "
			+ "with a given arrival time, Enter 4 to quit");
	//System.out.print(stopTimesList.size());
	
	Scanner scanner = new Scanner(System.in);
	int input = 0;
	if(scanner.hasNextInt())
	{
	input=scanner.nextInt()	;
	}
	if(input==1)
	{
		System.out.println("Enter your beginning StopID");
		int beginningStop;
		beginningStop = scanner.nextInt();
		
		System.out.println("Enter your final StopID");
		int finalStop;
		finalStop = scanner.nextInt();
		
		ShortestPaths(beginningStop, finalStop);
	}
	else if(input==2)
	{
		
		System.out.println("Enter your bus stop or even the first few letters");
		String busStop;
		busStop = scanner.next();
		busStop = busStop.toUpperCase();
		
		searchByName(busStop);	
		
	}
	else if(input==3) 
	{
		System.out.println("Enter your arrival time in the format of hh:mm:ss ");
		String arrivalTime;
		arrivalTime = scanner.next();
		
		searchByArrivalTime(arrivalTime, stopTimesList);
		
	}
	else if(input==4)
	{
		quit = true;
		System.out.print("Thank you and Goodbye!");
	}
	else	
	{
		System.out.println("Please enter a valid input of 1,2,3 or 4 to quit.");
	}
	}
	}
	
public static void ShortestPaths(int beginning, int end)	
{
	
	for(int i = 0;i<transfersList.size();i++)
	{
		double weight = 0;
		if(transfersList.get(i).transferType == 0) 
		{
			weight = 2;
		}
		else 
		{
			weight=transfersList.get(i).minTransferTime/100;
		}
		edgeList.add(new DirectedEdge(transfersList.get(i).fromStopID, transfersList.get(i).toStopId,weight));
	}
	
	for(int i =0 ; i< stopTimesList.size()-1; i++) 
	{
		if(stopTimesList.get(i).tripId==stopTimesList.get(i+1).tripId) 
		{
			edgeList.add(new DirectedEdge(stopTimesList.get(i).stopId, stopTimesList.get(i+1).stopId,1));
		}	
	}
	
	EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(edgeList.size());
	for(int i=0; i<edgeList.size(); i++) 
	{
		digraph.addEdge(edgeList.get(i));
	}
	
	DijkstraSP sp = new DijkstraSP(digraph, beginning);
	if(!sp.hasPathTo(end))
	{
		System.out.print("There is no route in this case.");
	}
	else 
	{
		System.out.print("shortest distance is " + sp.distTo(end));	
	}	
}
	

public static void searchByName(String search) 
{
	
	TST tst = new TST();
	
	for(int i = 0; i<stopList.size();i++) 
	{
		tst.put(stopList.get(i).stopName, stopList.get(i));
	}	
	Queue<String> containsMatchingString = (Queue<String>) tst.keysWithPrefix(search);
	
	for(int i =0 ; i<containsMatchingString.size();i++) 
	{
		busStops stops = null;
		String temporaryStopName = containsMatchingString.dequeue();
		for(int j =0 ; j< stopList.size(); j++) 
		{
			if(temporaryStopName.equals(stopList.get(j).stopName))
			{
				stops = stopList.get(j);
				break;
			}
		}
		System.out.println("Stop ID = " + stops.stopId);
		System.out.println("Stop Name = " + stops.stopName);
		System.out.println("Stop Destination = " + stops.stopDesc);
		System.out.println("Stop Latitude = " + stops.stopLat);
		System.out.println("Stop Longitude = " +stops.stopLong);
		System.out.println("Zone ID =  " + stops.zoneId);
		System.out.println("Stop URL = " + stops.stopURL);
		System.out.println("Location Type = " + stops.locationType);
		System.out.println("Parent Station = " + stops.parentStation);
		System.out.println("\n");
		
	}
	
}

public static void searchByArrivalTime(String arrivalTime1, ArrayList<busStopTimes> stopTimes) 
{
	//TST tst = new TST();
	
	//for(int i = 0; i<stopTimesList.size();i++) 
	//{
	//	tst.put(stopTimesList.get(i).arrivalTime, stopTimesList.get(i));
	//}
	
	
	//Queue<String> containsMatchingString = (Queue<String>) tst.keysWithPrefix(arrivalTime);
	ArrayList<busStopTimes> stopsWithTimes = new ArrayList<busStopTimes>();
	for (int i =0 ; i<stopTimes.size() ; i++)
	{
		String myTime = stopTimes.get(i).arrivalTime;
		//System.out.println(stopTimes.get(i).arrivalTime);
		if(myTime.equals(arrivalTime1)) 
		{
			stopsWithTimes.add(stopTimes.get(i));
		}
	}
	for (int i =0 ; i<stopsWithTimes.size() ; i++) 
	{
		System.out.println("Trip ID = " + stopsWithTimes.get(i).tripId);
		System.out.println("Arrival Time = " + stopsWithTimes.get(i).arrivalTime);
		System.out.println("Departure Time " + stopsWithTimes.get(i).departureTime);
		System.out.println("Stop ID = " + stopsWithTimes.get(i).stopId);
		System.out.println("Stop Sequence = " + stopsWithTimes.get(i).stopSequence);
		System.out.println("Stop Headsign = " + stopsWithTimes.get(i).stopHeadSign);
		System.out.println("Pickup Type = " + stopsWithTimes.get(i).pickuptype);
		System.out.println("Drop off Type = " + stopsWithTimes.get(i).dropOffType);
		System.out.println("Shape Distance Travelled = " + stopsWithTimes.get(i).shapeDistTraveled);
		System.out.println("\n");
		
	}
	
// double for loop , brute force method. TST would be quicker but harder to implement.

}

public static boolean checkTimes(String times) 
{
	char c1 = '1';
	char c2 = '2';
	if(times.charAt(0) == ' ')
	{
		String timeUpdated = addzero(times);
		try {
			LocalTime.parse(timeUpdated);
			return true;
		}
		catch(DateTimeParseException | NullPointerException e)
		{
			return false;
		}
	}
	else if (times.charAt(0) == c1 || times.charAt(0) == c2) 
	{
		try {
			LocalTime.parse(times);
			return true;
		}
		catch(DateTimeParseException | NullPointerException e)
		{
			return false;
		}
	}
	else return false;
}
public static String addzero(String time) {
	//String start = time.substring(0);
	String NewString = "0" + time.substring(1);
	//System.out.println(NewString);
	return NewString;
}

}




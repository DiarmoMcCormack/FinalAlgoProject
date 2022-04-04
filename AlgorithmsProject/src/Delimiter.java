import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class Delimiter {
	
static String stopId;
static String stopCode;
static String stopName;
static String stopDesc;
static String stopLat;
static String stopLon;
static String zoneId;
static String stopURL;
static String locationType;
static String parentStation;
	
	public static void main(String args[])throws ParseException, IOException
	{
		File file = new File("stops.txt");
		BufferedReader buffered = new BufferedReader(new FileReader (file));
		try {
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter(",");
			scanner.nextLine();
			
			String variable = scanner.next();
						
			
			while (scanner.hasNextLine())
			{
			stopId = scanner.next();
			stopCode = scanner.next();
			stopName = scanner.next();
			stopDesc = scanner.next();
			stopLat =  scanner.next();
			stopLon =  scanner.next();
			zoneId = scanner.next();
			stopURL = scanner.next();
			locationType = scanner.next();
			parentStation = scanner.next();
			
			String splitName[] = stopName.split(" ");
			
			scanner.useDelimiter(pattern)
			
			
			
			
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
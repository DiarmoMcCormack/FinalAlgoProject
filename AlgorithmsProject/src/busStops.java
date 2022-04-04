
public class busStops {

	int stopId;
	int stopCode;
	String stopName;
	String stopDesc;
	double stopLat;
	double stopLong;
	String zoneId;
	String stopURL;
	int locationType;
	int parentStation;
	
	busStops( int stopId, int stopCode, String stopName, String stopDesc, double stopLat, double stopLong, String ZoneId, String stopURL, int locationType, int parentStation){
		this.stopId = stopId;
		this.stopCode = stopCode;
		this.stopName = stopName;
		this.stopDesc = stopDesc;
		this.stopLat = stopLat;
		this.stopLong = stopLong;
		this.zoneId = zoneId;
		this.stopURL = stopURL;
		this.locationType = locationType;
		this.parentStation = parentStation;
		}
	



	
}

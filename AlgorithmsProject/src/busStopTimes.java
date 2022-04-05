public class busStopTimes {
	
int tripId;
String arrivalTime;
String departureTime;
int stopId;
int stopSequence;
int stopHeadSign;
int pickuptype;
int dropOffType;
double shapeDistTraveled;

busStopTimes( int tripId, String arrivalTime, String departureTime, int stopId, int stopSequence, int stopHeadSign, int pickuptype, int dropOffType, double shapeDistTraveled){
this.tripId = tripId;
this.arrivalTime = arrivalTime;
this.departureTime = departureTime;
this.stopId = stopId;
this.stopSequence = stopSequence;
this.stopHeadSign = stopHeadSign;
this.pickuptype = pickuptype;
this.dropOffType = dropOffType;
this.shapeDistTraveled = shapeDistTraveled;
}


}


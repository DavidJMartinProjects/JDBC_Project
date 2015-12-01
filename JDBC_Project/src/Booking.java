import java.io.Serializable;

public class Booking implements Serializable {

	String flight_Id;
	String departure_Time;
	String arrival_Time;
	String origin;
	String destination;
	String customer_Id;
	String customer_Fname;
	String customer_Sname;
	String customer_Photo;
	String customer_ContactNo;
	Booking_Type booking_Type;

	// enumerator for booking_type variable
	public static enum Booking_Type {
		Not_Selected, Economy, Business
	}

	// constructors
	public Booking() {
		this.flight_Id = "";
		this.departure_Time = "";
		this.arrival_Time = "";
		this.origin = "";
		this.destination = "";
		this.customer_Id = "";
		this.customer_Fname = "";
		this.customer_Sname = "";
		this.customer_Photo = "";
		this.customer_ContactNo = "";
		this.booking_Type = Booking_Type.Not_Selected;
	}

	public Booking(String aFlightId, String deptTime, String arrTime, String anOrigin, String aDest, String aCustId,
			String aFname, String aSname, String aPhoto, String aPhoneNo, Booking_Type aBookingType) {
		this.flight_Id = aFlightId;
		this.departure_Time = deptTime;
		this.arrival_Time = arrTime;
		this.origin = anOrigin;
		this.destination = aDest;
		this.customer_Id = aCustId;
		this.customer_Fname = aFname;
		this.customer_Sname = aSname;
		this.customer_Photo = aPhoto;
		this.customer_ContactNo = aPhoneNo;
		this.booking_Type = aBookingType;
	}

	// getters and setters
	public String getFlight_Id() {
		return flight_Id;
	}

	public void setFlight_Id(String flight_Id) {
		this.flight_Id = flight_Id;
	}

	public String getDeparture_Time() {
		return departure_Time;
	}

	public void setDeparture_Time(String departure_Time) {
		this.departure_Time = departure_Time;
	}

	public String getArrival_Time() {
		return arrival_Time;
	}

	public void setArrival_Time(String arrival_Time) {
		this.arrival_Time = arrival_Time;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Fname() {
		return customer_Fname;
	}

	public void setCustomer_Fname(String customer_Fname) {
		this.customer_Fname = customer_Fname;
	}

	public String getCustomer_Sname() {
		return customer_Sname;
	}

	public void setCustomer_Sname(String customer_Sname) {
		this.customer_Sname = customer_Sname;
	}

	public String getCustomer_Photo() {
		return customer_Photo;
	}

	public void setCustomer_Photo(String customer_Photo) {
		this.customer_Photo = customer_Photo;
	}

	public String getCustomer_ContactNo() {
		return customer_ContactNo;
	}

	public void setCustomer_ContactNo(String customer_ContactNo) {
		this.customer_ContactNo = customer_ContactNo;
	}

	public Booking_Type getBooking_Type() {
		return booking_Type;
	}

	public Booking_Type getBooking_String() {
		return booking_Type;
	}

	public void setBooking_Type(String type) {
		this.booking_Type = Booking_Type.valueOf(type);
	}

	@Override
	public String toString() {
		return "Booking [flight_Id=" + flight_Id + ", departure_Time=" + departure_Time + ", arrival_Time="
				+ arrival_Time + ", origin=" + origin + ", destination=" + destination + ", customer_Id=" + customer_Id
				+ ", customer_Fname=" + customer_Fname + ", customer_Sname=" + customer_Sname + ", customer_Photo="
				+ customer_Photo + ", customer_ContactNo=" + customer_ContactNo + ", booking_Type=" + booking_Type
				+ "]";
	}
}

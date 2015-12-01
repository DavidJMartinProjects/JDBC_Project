import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

public class MainMenu extends JFrame implements ActionListener {
	private JLabel flightIdLbl;
	private JLabel deptTimeLbl;
	private JLabel arrivalTimeLbl;
	private JLabel originLbl;
	private JLabel destinationlbl;
	private JLabel custIdLbl;
	private JLabel fnameLbl;
	private JLabel snameLbl;
	private JLabel contactNoLbl;
	private JLabel bookingType;
	private static JTextField flightIdTf;
	private static JTextField depTimeTf;
	private static JTextField arrTimeTf;
	private static JTextField originTf;
	private static JTextField destTf;
	private static JTextField custIdTf;
	private static JTextField fnameTf;
	private static JTextField surnameTf;
	private static JTextField contactNoTf;
	private static JTextField bookingTypeTf;
	private JButton prevBtn;
	private JButton nextBtn;
	private JButton createBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JButton closeBtn;
	private JButton backupBtn;
	private JButton reportBtn;
	private static JLabel imageLabel;
	private JLabel clockLbl;
	private JLabel dateLbl;
	private JLabel userLbl;
	private JLabel loggedDescLbl;
	private JLabel timeDescLbl;
	private JLabel dateDescLbl;
	private JLabel logoLbl;

	// create a Booking object
	public static Booking myBooking = new Booking();

	// record navigation variables
	public static int count = 0;
	public static int current = 0;

	public MainMenu() {
		// construct components
		flightIdLbl = new JLabel("Flight ID :");
		deptTimeLbl = new JLabel("Departure Time :");
		arrivalTimeLbl = new JLabel("Arrival Time :");
		originLbl = new JLabel("Origin :");
		destinationlbl = new JLabel("Destination :");
		custIdLbl = new JLabel("Customer ID :");
		fnameLbl = new JLabel("First Name :");
		snameLbl = new JLabel("Surname :");
		contactNoLbl = new JLabel("Contact No :");
		bookingType = new JLabel("Booking Type :");
		flightIdTf = new JTextField(5);
		depTimeTf = new JTextField(5);
		arrTimeTf = new JTextField(5);
		originTf = new JTextField(5);
		destTf = new JTextField(5);
		custIdTf = new JTextField(5);
		fnameTf = new JTextField(5);
		surnameTf = new JTextField(5);
		contactNoTf = new JTextField(5);
		bookingTypeTf = new JTextField(5);
		prevBtn = new JButton("Previous");
		nextBtn = new JButton("Next");
		createBtn = new JButton("Create");
		updateBtn = new JButton("Update");
		deleteBtn = new JButton("Delete");
		closeBtn = new JButton("Close");
		imageLabel = new JLabel("");
		backupBtn = new JButton("Backup Record");
		reportBtn = new JButton("View Report");
		clockLbl = new JLabel();
		dateLbl = new JLabel();
		userLbl = new JLabel(Login.user);
		loggedDescLbl = new JLabel("User : ");
		timeDescLbl = new JLabel("Time : ");
		dateDescLbl = new JLabel("Date : ");

		// Add logo image to label
		ImageIcon image = new ImageIcon("C:\\JDBCImages\\AerLingus.jpg"); // ImageIcon
		logoLbl = new JLabel("", image, JLabel.CENTER); // embed image into
														// imageLabel

		// adjust size and set layout
		setSize(840, 335);
		setLayout(null);

		// add components
		add(flightIdLbl);
		add(deptTimeLbl);
		add(arrivalTimeLbl);
		add(originLbl);
		add(destinationlbl);
		add(custIdLbl);
		add(fnameLbl);
		add(snameLbl);
		add(contactNoLbl);
		add(bookingType);
		add(flightIdTf);
		add(depTimeTf);
		add(arrTimeTf);
		add(originTf);
		add(destTf);
		add(custIdTf);
		add(fnameTf);
		add(surnameTf);
		add(contactNoTf);
		add(bookingTypeTf);
		add(prevBtn);
		add(nextBtn);
		add(createBtn);
		add(updateBtn);
		add(deleteBtn);
		add(closeBtn);
		add(imageLabel);
		add(backupBtn);
		add(reportBtn);
		add(clockLbl);
		add(dateLbl);
		add(userLbl);
		add(loggedDescLbl);
		add(timeDescLbl);
		add(dateDescLbl);
		add(logoLbl);

		// add border to customerImage label
		Border border = BorderFactory.createLineBorder(Color.gray, 1);
		imageLabel.setBorder(border);

		// set component bounds (only needed by Absolute Positioning)
		flightIdLbl.setBounds(50, 105, 100, 25);
		deptTimeLbl.setBounds(50, 130, 100, 25);
		arrivalTimeLbl.setBounds(50, 155, 100, 25);
		originLbl.setBounds(50, 180, 100, 25);
		destinationlbl.setBounds(50, 205, 100, 25);
		custIdLbl.setBounds(270, 105, 100, 25);
		fnameLbl.setBounds(270, 130, 100, 25);
		snameLbl.setBounds(270, 155, 100, 25);
		contactNoLbl.setBounds(270, 180, 100, 25);
		bookingType.setBounds(270, 205, 100, 25);
		flightIdTf.setBounds(150, 105, 100, 25);
		depTimeTf.setBounds(150, 130, 100, 25);
		arrTimeTf.setBounds(150, 155, 100, 25);
		originTf.setBounds(150, 180, 100, 25);
		destTf.setBounds(150, 205, 100, 25);
		custIdTf.setBounds(370, 105, 100, 25);
		fnameTf.setBounds(370, 130, 100, 25);
		surnameTf.setBounds(370, 155, 100, 25);
		contactNoTf.setBounds(370, 180, 100, 25);
		bookingTypeTf.setBounds(370, 205, 100, 25);
		prevBtn.setBounds(210, 255, 85, 25);
		nextBtn.setBounds(320, 255, 85, 25);
		createBtn.setBounds(655, 100, 100, 25);
		updateBtn.setBounds(655, 130, 100, 25);
		deleteBtn.setBounds(655, 160, 100, 25);
		closeBtn.setBounds(670, 255, 70, 25);
		imageLabel.setBounds(485, 105, 120, 125);
		backupBtn.setBounds(640, 190, 125, 25);
		reportBtn.setBounds(640, 220, 125, 25);
		clockLbl.setBounds(681, 30, 110, 25);
		dateLbl.setBounds(681, 50, 110, 25);
		userLbl.setBounds(681, 10, 100, 25);
		loggedDescLbl.setBounds(640, 10, 100, 25);
		timeDescLbl.setBounds(640, 30, 45, 25);
		dateDescLbl.setBounds(640, 50, 45, 25);
		logoLbl.setBounds(160, 10, 300, 80);

		// add actionlisteners to buttons
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		createBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		backupBtn.addActionListener(this);
		reportBtn.addActionListener(this);

		// populate textfields
		initialise();

		// create & initialise timer for real-time clock
		new Timer(1000, this).start();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null); // center Frame on screen
		setVisible(true);
	}

	public static void initialise() {
		try {
			ConnectionHelper.rs = ConnectionHelper.st.executeQuery("SELECT * FROM booking_info");

			// count number of booking records
			count = 0;
			while (ConnectionHelper.rs.next())
				count++;
			System.out.println("No. of Booking Records : " + count);

			// navigate the rescordSet back to the first record
			ConnectionHelper.rs.first();
			current = 1;

			myBooking.setFlight_Id(ConnectionHelper.rs.getString("Flight_id"));
			myBooking.setDeparture_Time(ConnectionHelper.rs.getString("Departure_Time"));
			myBooking.setArrival_Time(ConnectionHelper.rs.getString("Arrival_Time"));
			myBooking.setOrigin(ConnectionHelper.rs.getString("Origin"));
			myBooking.setDestination(ConnectionHelper.rs.getString("Destination"));
			myBooking.setCustomer_Id(ConnectionHelper.rs.getString("Customer_Id"));
			myBooking.setCustomer_Fname(ConnectionHelper.rs.getString("Customer_Fname"));
			myBooking.setCustomer_Sname(ConnectionHelper.rs.getString("Customer_Sname"));
			myBooking.setCustomer_Photo(ConnectionHelper.rs.getString("Customer_Photo"));
			myBooking.setCustomer_ContactNo(ConnectionHelper.rs.getString("Customer_ContactNo"));
			myBooking.setBooking_Type(ConnectionHelper.rs.getString("Booking_Type"));
			myBooking.setCustomer_Photo(ConnectionHelper.rs.getString("Customer_Photo"));

			flightIdTf.setText("" + myBooking.flight_Id);
			depTimeTf.setText("" + myBooking.departure_Time);
			arrTimeTf.setText("" + myBooking.arrival_Time);
			originTf.setText("" + myBooking.origin);
			destTf.setText("" + myBooking.destination);
			custIdTf.setText("" + myBooking.customer_Id);
			fnameTf.setText("" + myBooking.customer_Fname);
			surnameTf.setText("" + myBooking.customer_Sname);
			contactNoTf.setText("" + myBooking.customer_ContactNo);
			bookingTypeTf.setText("" + myBooking.booking_Type);

			imageLabel.setIcon(new ImageIcon("C:\\JDBCImages\\" + myBooking.getCustomer_Photo()));

		} catch (Exception ex) {
			System.out.println("Exception - initialise method : " + ex);
		}
	}

	@Override
    public void actionPerformed(ActionEvent event) {
        Object target = event.getSource();
        
        //set Date  
        String todaysDate = getDate();
        dateLbl.setText(""+todaysDate); 
        //set Time
        SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm:ss");
        String timeString = myFormat.format(new Date());
        clockLbl.setText("" +timeString); //Update label text
        
        if(target == nextBtn) {
            try {
                if (current != count) {
                    moveToRow(current + 1);
                }
            } catch (Exception ex) {
                System.out.println("Error in next button : " + ex);
            }   
        }
        
        if(target == prevBtn) {
            try {
                if (current != 1) {
                    moveToRow(current - 1);
                }
            } catch (Exception ex) {
                System.out.println("Error in previous button : " + ex);
            }
        }   
        
        if(target == createBtn) {
            Create myCreate = new Create();
        }
        
        if(target == updateBtn) {
            Update myUpdate = new Update();
        }
        
        if(target == deleteBtn) {
            try
            {
                int confirm = JOptionPane.showConfirmDialog(null, "Confirm Delete Record", 
			"Choose", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String flightID = flightIdTf.getText();
                    //prepared statement
                    PreparedStatement pstmt = ConnectionHelper.con.prepareStatement("DELETE FROM booking_info WHERE Flight_Id = ?");
                    pstmt.setString(1, flightID); 
                    pstmt.executeUpdate(); // execute delete
                    JOptionPane.showMessageDialog(null, "Record Deleted");
                    // display first record in database
                    moveToRow(1); 
                    current = 1;
                    System.out.println("Flight ID :" + flightID + " deleted from database");
                }
            } catch (Exception ex) {
                System.out.println("Error in delete button" + ex);
            }
            count--;
        }
        
        if(target == backupBtn) {
            buildBookingObject();
            Serialization.serialize(myBooking);     
            JOptionPane.showMessageDialog(null, "Record Successfully Updated");
        }
        
        if(target == reportBtn) {
            Serialization.deSerialize();            
        }
        
        if(target == closeBtn) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you wish to EXIT?", "Choose", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    ConnectionHelper.rs.close();
                    dispose();
                    System.exit(0); 
                } catch (Exception ex) {
                    System.out.println("Exit Button Error " + ex);
                }
            }
        }
    }

	public static void moveToRow(int index) {
		try {
			System.out.println("Moving To Row");
			ConnectionHelper.rs = ConnectionHelper.st.executeQuery("SELECT * FROM booking_info");

			for (int i = 0; i < index; i++)
				ConnectionHelper.rs.next(); // move to specific row in table (at
											// index)

			buildBookingObject();

			flightIdTf.setText("" + myBooking.flight_Id);
			depTimeTf.setText("" + myBooking.departure_Time);
			arrTimeTf.setText("" + myBooking.arrival_Time);
			originTf.setText("" + myBooking.origin);
			destTf.setText("" + myBooking.destination);
			custIdTf.setText("" + myBooking.customer_Id);
			fnameTf.setText("" + myBooking.customer_Fname);
			surnameTf.setText("" + myBooking.customer_Sname);
			contactNoTf.setText("" + myBooking.customer_ContactNo);
			bookingTypeTf.setText("" + myBooking.booking_Type);

			imageLabel.setIcon(new ImageIcon("C:\\JDBCImages\\" + myBooking.getCustomer_Photo()));

			current = index;
		} catch (Exception ex) {
			System.out.println("Exception - moveToRow method : " + ex);
		}
	}

	public static void buildBookingObject() {
		try {
			myBooking.setFlight_Id(ConnectionHelper.rs.getString("Flight_id"));
			myBooking.setDeparture_Time(ConnectionHelper.rs.getString("Departure_Time"));
			myBooking.setArrival_Time(ConnectionHelper.rs.getString("Arrival_Time"));
			myBooking.setOrigin(ConnectionHelper.rs.getString("Origin"));
			myBooking.setDestination(ConnectionHelper.rs.getString("Destination"));
			myBooking.setCustomer_Id(ConnectionHelper.rs.getString("Customer_Id"));
			myBooking.setCustomer_Fname(ConnectionHelper.rs.getString("Customer_Fname"));
			myBooking.setCustomer_Sname(ConnectionHelper.rs.getString("Customer_Sname"));
			myBooking.setCustomer_Photo(ConnectionHelper.rs.getString("Customer_Photo"));
			myBooking.setCustomer_ContactNo(ConnectionHelper.rs.getString("Customer_ContactNo"));
			myBooking.setBooking_Type(ConnectionHelper.rs.getString("Booking_Type"));
			myBooking.setCustomer_Photo(ConnectionHelper.rs.getString("Customer_Photo"));
		} catch (Exception ex) {
			System.out.println("Exception in buildBookingObject Method : " + ex);
		}
	}

	public String getDate() // format todays Date and return it as a String
	{
		SimpleDateFormat myFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
		String dateString = myFormat.format(new Date());
		return dateString;
	}

	public static void main(String args[]) {
		MainMenu myMenu = new MainMenu();
	}
}

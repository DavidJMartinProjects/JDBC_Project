import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.sql.*;

public class Update extends JFrame implements Database_Interface, ActionListener {

	private JLabel flightIdLbl;
	private JLabel arrivalTimeLbl;
	private JLabel deptTimeLbl;
	private JLabel originLbl;
	private JLabel destinationlbl;
	private JLabel custIdLbl;
	private JLabel fnameLbl;
	private JLabel snameLbl;
	private JLabel contactNoLbl;
	private JLabel bookingType;
	private JTextField flightIdTf;
	private JTextField depTimeTf;
	private JTextField arrTimeTf;
	private JTextField custIdTf;
	private JTextField fnameTf;
	private JTextField surnameTf;
	private JTextField contactNoTf;
	private JButton updateBtn;
	private JButton cancelBtn;
	private JComboBox originCBox;
	private JComboBox destinationCBox;
	private JRadioButton econRadioBtn;
	private JRadioButton busRadioBtn;
	private ButtonGroup bg;

	public Update() {
		super("Update Booking");

		// construct preComponents
		String[] originCBoxItems = { "Ireland", "United Kingdom", "France", "Germany", "Spain", "Greece", "Poland",
				"Holland", "Sweden", "Norway", "Portugal", "Italy" };
		String[] destinationCBoxItems = { "United Kingdom", "France", "Germany", "Spain", "Greece", "Poland", "Holland",
				"Sweden", "Norway", "Portugal", "Italy" };

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
		custIdTf = new JTextField(5);
		fnameTf = new JTextField(5);
		surnameTf = new JTextField(5);
		contactNoTf = new JTextField(5);
		updateBtn = new JButton("Update");
		cancelBtn = new JButton("Cancel");
		originCBox = new JComboBox(originCBoxItems);
		destinationCBox = new JComboBox(destinationCBoxItems);
		econRadioBtn = new JRadioButton("Economy");
		busRadioBtn = new JRadioButton("Business");
		bg = new ButtonGroup();
		bg.add(econRadioBtn);
		bg.add(busRadioBtn);

		// adjust size and set layout
		setSize(690, 215);
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
		add(custIdTf);
		add(fnameTf);
		add(surnameTf);
		add(contactNoTf);
		add(updateBtn);
		add(cancelBtn);
		add(originCBox);
		add(destinationCBox);
		add(econRadioBtn);
		add(busRadioBtn);

		// set component bounds (only needed by Absolute Positioning)
		flightIdLbl.setBounds(50, 15, 100, 25);
		deptTimeLbl.setBounds(50, 40, 100, 25);
		arrivalTimeLbl.setBounds(50, 65, 100, 25);
		originLbl.setBounds(50, 90, 100, 25);
		destinationlbl.setBounds(50, 115, 100, 25);
		custIdLbl.setBounds(300, 15, 100, 25);
		fnameLbl.setBounds(300, 40, 100, 25);
		snameLbl.setBounds(300, 65, 100, 25);
		contactNoLbl.setBounds(300, 90, 100, 25);
		bookingType.setBounds(300, 125, 100, 25);
		flightIdTf.setBounds(150, 15, 125, 25);
		depTimeTf.setBounds(150, 40, 125, 25);
		arrTimeTf.setBounds(150, 65, 125, 25);
		custIdTf.setBounds(390, 15, 125, 25);
		fnameTf.setBounds(390, 40, 125, 25);
		surnameTf.setBounds(390, 65, 125, 25);
		contactNoTf.setBounds(390, 90, 125, 25);
		updateBtn.setBounds(540, 40, 100, 25);
		cancelBtn.setBounds(540, 70, 100, 25);
		originCBox.setBounds(150, 90, 125, 25);
		destinationCBox.setBounds(150, 115, 125, 25);
		econRadioBtn.setBounds(410, 115, 80, 25);
		busRadioBtn.setBounds(410, 140, 100, 25);

		// add ActionListeners to buttons
		updateBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// populate frame
		initialise();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null); // center Frame on screen
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object target = event.getSource();

		if (target == cancelBtn) {
			try {
				this.dispose();
			} catch (Exception ex) {
				System.out.println("Error " + ex);
			}
		}

		if (target == updateBtn) {
			try {
				String flightId = flightIdTf.getText();
				String deptTime = depTimeTf.getText();
				String arrTime = arrTimeTf.getText();
				String customer = custIdTf.getText();
				String fname = fnameTf.getText();
				String sname = surnameTf.getText();
				String contactNo = contactNoTf.getText();

				// cast comboBox selection to a String object
				String origin = (String) originCBox.getSelectedItem();
				String destination = (String) destinationCBox.getSelectedItem();

				// get radioGroup selected item
				String bookingType;
				if (econRadioBtn.isSelected())
					bookingType = "Economy";
				else if (busRadioBtn.isSelected())
					bookingType = "Business";
				else {
					JOptionPane.showMessageDialog(null, "Please Select a Booking Type");
					return; // stop current method
				}

				String newBooking = "UPDATE booking_info SET Departure_Time = '" + deptTime + "', " + "Arrival_Time = '"
						+ arrTime + "', Origin = '" + origin + "', Destination = '" + destination + "', "
						+ "Customer_Id = '" + customer + "', Customer_Fname = '" + fname + "', Customer_Sname = '"
						+ sname + "', " + "Customer_ContactNo = '" + contactNo + "', Booking_Type =  '" + bookingType
						+ "'WHERE Flight_Id = '" + flightId + "'";
				ConnectionHelper.st.executeUpdate(newBooking); // execute SQL
																// statement
				System.out.println("update complete!");
				JOptionPane.showMessageDialog(null, "Record Successfully Updated");
				MainMenu.initialise();
				MainMenu.current = 1;
				this.setVisible(false);
			} catch (Exception ex) {
				System.out.println("Exception : " + ex);
			}
		}
	}

	public void initialise() {
		moveToRecord(MainMenu.current);
	}

	public void moveToRecord(int current) {
		try {
			System.out.println("Moving To Row");
			ConnectionHelper.rs = ConnectionHelper.st.executeQuery("SELECT * FROM booking_info");

			for (int i = 0; i < current; i++)
				ConnectionHelper.rs.next(); // move to specific row in table (at
											// current)

			MainMenu.myBooking.setFlight_Id(ConnectionHelper.rs.getString("Flight_id"));
			MainMenu.myBooking.setDeparture_Time(ConnectionHelper.rs.getString("Departure_Time"));
			MainMenu.myBooking.setArrival_Time(ConnectionHelper.rs.getString("Arrival_Time"));
			MainMenu.myBooking.setOrigin(ConnectionHelper.rs.getString("Origin"));
			MainMenu.myBooking.setDestination(ConnectionHelper.rs.getString("Destination"));
			MainMenu.myBooking.setCustomer_Id(ConnectionHelper.rs.getString("Customer_Id"));
			MainMenu.myBooking.setCustomer_Fname(ConnectionHelper.rs.getString("Customer_Fname"));
			MainMenu.myBooking.setCustomer_Sname(ConnectionHelper.rs.getString("Customer_Sname"));
			MainMenu.myBooking.setCustomer_Photo(ConnectionHelper.rs.getString("Customer_Photo"));
			MainMenu.myBooking.setCustomer_ContactNo(ConnectionHelper.rs.getString("Customer_ContactNo"));
			MainMenu.myBooking.setBooking_Type(ConnectionHelper.rs.getString("Booking_Type"));

			flightIdTf.setText("" + MainMenu.myBooking.flight_Id);
			depTimeTf.setText("" + MainMenu.myBooking.departure_Time);
			arrTimeTf.setText("" + MainMenu.myBooking.arrival_Time);
			originCBox.setSelectedItem(MainMenu.myBooking.getOrigin());
			destinationCBox.setSelectedItem(MainMenu.myBooking.getDestination());
			custIdTf.setText("" + MainMenu.myBooking.customer_Id);
			fnameTf.setText("" + MainMenu.myBooking.customer_Fname);
			surnameTf.setText("" + MainMenu.myBooking.customer_Sname);
			contactNoTf.setText("" + MainMenu.myBooking.customer_ContactNo);
			// bg.setSelected(MainMenu.myBooking.booking_Type);

			if (MainMenu.myBooking.getBooking_String() == Booking.Booking_Type.Economy) {
				econRadioBtn.setSelected(true);
			} else {
				busRadioBtn.setSelected(true);
			}

		} catch (Exception ex) {
			System.out.println("Exception - moveToRow method : " + ex);
		}
	}
}

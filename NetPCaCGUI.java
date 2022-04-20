
/**
 * @title NetPCaCGUI
 * @description This particular Class is the Graphical User Interface for NetPCaC.
 * Essentially I have designed this to be the primary function for the program use,
 * it should run at initial startup and be the 'catalyst' for the rest of the 
 * programs function twined with user interaction.
 * @author Russell Clarke - i7694005 - Bournemouth University
 * Created 01/03/2015 - Semester 2 - Object Orientated Programming Assignment.
 * @version BaySix_0.9.4-Alpha
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * import java.io.*; //Originally used for the JFileChooser.showSaveDialog(), I took this out./
 */

@SuppressWarnings("serial")
public class NetPCaCGUI extends JPanel {

	// Scanner scan = new Scanner(System.in);/
	// File myFile = new File("temp.txt");/

	private JFrame frame;
	private JPanel primaryPanel, subPanel1, subPanel2, subPanel3, subPanel4, subPanel5, subPanel6;
	private JLabel banner, fileFormat, fileSize, outb, outB, outKB, outMB, outGB, netFormat, netFSize, netBitRate,
			netDistance, netVelocity, netVDistance, netState, insertion, propagation, totalDelay, actualBits, ps1, ps2,
			ps3, ps4, ps5;
	private JTextArea info, infoParam;
	private JTextField size, outbText, outBText, outKBText, outMBText, outGBText, netSize, netBitRateVal, netDistVal,
			netStateOut, insertionOut, propagationOut, totalDelayOut, actualBitsOut;
	private JButton convert, netConvert, /* save, */reset, exit;
	private JScrollPane scroll;
	private JSeparator separate1, separate2, separate3;
	private JComboBox<String> format, b, B, KB, MB, GB, netSizeFormat, velocity, wlan, lan, distance, M, KM;

	// Used later for assigning variable instances of insertion and propagation
	// from NetworkCalc./

	public NetPCaCGUI() { // Constructor for the class 'NetPCaCGUI'./
		creatForm(); // Constructor methods./
		addFields(); // Add additional Fields or Containers./

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Method to set the alignment of components and containers in the
		// panel./

		frame.add(Box.createRigidArea(new Dimension(0, 3)));

		// Method to set the dimensions of the alignment from the BoxLayout
		// Method above./

		frame.add(primaryPanel.add(banner));
		frame.add(Box.createRigidArea(new Dimension(0, 3)));
		frame.add(subPanel1);
		frame.add(Box.createRigidArea(new Dimension(0, 3)));
		frame.add(subPanel2);
		frame.add(Box.createRigidArea(new Dimension(0, 3)));
		frame.add(subPanel3);
		frame.add(Box.createRigidArea(new Dimension(0, 3)));
		frame.add(subPanel4);
		frame.add(Box.createRigidArea(new Dimension(0, 3)));
		frame.setVisible(true);

	}

	/**
	 * @param
	 * @return void
	 * @description A constructor to create the basic JFrame and JPanels.
	 */

	public void creatForm() { // Public method for the frame and the panel./

		frame = new JFrame();
		frame.setTitle("NetPCaC - Network Propagation delay Calculator and file size format Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(350, 50);
		frame.setSize(620, 690);

		primaryPanel = new JPanel();
		primaryPanel.setLayout(null);
		primaryPanel.setBackground(Color.gray);

		ImageIcon icon = new ImageIcon("NetPCaC_Banner.jpg");

		banner = new JLabel(icon); // Image Banner added./
		banner.setBounds(1, 0, 605, 96);
		banner.setVerticalTextPosition(SwingConstants.TOP);
		banner.setHorizontalTextPosition(SwingConstants.LEFT);
		banner.setLocation(0, 2);
		banner.setVisible(true);

		subPanel1 = new JPanel(); // Scroll enabled panel./
		subPanel1.setBounds(2, 97, 600, 125);
		subPanel1.setBorder(BorderFactory.createTitledBorder("NetPCaC Information"));
		subPanel1.setVisible(true);

		subPanel2 = new JPanel();
		subPanel2.setBounds(2, 220, 600, 85);
		subPanel2.setBorder(BorderFactory.createTitledBorder("File Size Format Conversion"));
		subPanel2.setVisible(true);

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // BoxLayout required
															// for additional
															// nested panels./
		subPanel3 = new JPanel();
		subPanel3.setBounds(2, 304, 600, 300);
		subPanel3.setBorder(BorderFactory.createTitledBorder("Network Delay Calculation"));
		subPanel3.setVisible(true);

		subPanel4 = new JPanel(); // Exit and reset buttons are assigned here./
		subPanel4.setBounds(4, 610, 596, 36);
		subPanel4.setBorder(BorderFactory.createEtchedBorder());
		subPanel4.setVisible(true);

	}

	/**
	 * @param
	 * @return void
	 * @description A constructor which adds Fields to the basic JFrame and
	 *              JPanels.
	 */

	public void addFields() {

		// ----------------Scroll enabled information about the
		// program----------------/

		info = new JTextArea(10, 80);
		info.setText(
				"NetPCaC - Network Propagation delay Calculator and file size Converter is not a file format converter. \n\nIt is designed for network engineers to calculate the transmission delays in a Computer Network medium such as Ethernet or Wireless transmission.\n\nTo use this Program, you may need to work out your file size format before hand. Algorithms for network calculation are designed to use the bit rate of transmission in a network, you can either use the converter directly or go straight ahead and use the network calculator.\n\nIt is a good idea to know your stated bit rate, the distance from point A to point B and the medium(s) which will be used.The calculator is fairly self-explanatory and unfortunately the output can not be saved to your local storage media or drive, yet.");
		info.setBackground(Color.lightGray);
		info.setAlignmentX(LEFT_ALIGNMENT);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);

		scroll = new JScrollPane(info);
		scroll.setPreferredSize(new Dimension(590, 95));
		subPanel1.add(scroll);
		scroll.setVisible(true);

		// ----------------Scroll Information End ----------------/

		// ----------------Format Conversion--------------/

		fileFormat = new JLabel();
		fileFormat.setText("File format");
		subPanel2.add(fileFormat);
		fileFormat.setVisible(true);

		format = new JComboBox<>(); // Drop down selection panel./
		format.addItem("b");
		format.addItem("B");
		format.addItem("KB");
		format.addItem("MB");
		format.addItem("GB");
		format.setPreferredSize(new Dimension(45, 20));
		subPanel2.add(format);
		format.setVisible(true);

		fileSize = new JLabel();
		fileSize.setText("File size");
		subPanel2.add(fileSize);
		fileSize.setVisible(true);

		size = new JTextField();
		size.setPreferredSize(new Dimension(160, 20));
		subPanel2.add(size);
		size.setVisible(true);

		convert = new JButton("convert");
		convert.setText("convert");
		convert.addActionListener(new UnitConversionHandler());
		convert.setPreferredSize(new Dimension(90, 20));
		subPanel2.add(convert);
		convert.setVisible(true);

		separate1 = new JSeparator(); // A centrally aligned separator for
										// presentation and section definition
										// purposes./
		separate1.setAlignmentX(CENTER_ALIGNMENT);
		separate1.setPreferredSize(new Dimension(590, 2));
		subPanel2.add(separate1);
		separate1.setVisible(true);

		// -------------END User Input-----------------------//

		// -------------Conversion Output start--------------//

		outb = new JLabel();
		outb.setText("bits");
		subPanel2.add(outb);
		outb.setVisible(true);

		outbText = new JTextField(); // Bits./
		outbText.setPreferredSize(new Dimension(80, 20));
		subPanel2.add(outbText);
		outbText.setVisible(true);

		outB = new JLabel();
		outB.setText("Bytes");
		subPanel2.add(outB);
		outB.setVisible(true);

		outBText = new JTextField(); // Bytes./
		outBText.setPreferredSize(new Dimension(60, 20));
		subPanel2.add(outBText);
		outBText.setVisible(true);

		outKB = new JLabel();
		outKB.setText("KiloBytes");
		subPanel2.add(outKB);
		outKB.setVisible(true);

		outKBText = new JTextField(); // Kilobytes./
		outKBText.setPreferredSize(new Dimension(60, 20));
		subPanel2.add(outKBText);
		outKBText.setVisible(true);

		outMB = new JLabel();
		outMB.setText("MegaBytes");
		subPanel2.add(outMB);
		outMB.setVisible(true);

		outMBText = new JTextField(); // Megabytes./
		outMBText.setPreferredSize(new Dimension(60, 20));
		subPanel2.add(outMBText);
		outMBText.setVisible(true);

		outGB = new JLabel();
		outGB.setText("GigaBytes");
		subPanel2.add(outGB);
		outGB.setVisible(true);

		outGBText = new JTextField(); // Gigabytes./
		outGBText.setPreferredSize(new Dimension(50, 20));
		subPanel2.add(outGBText);
		outGBText.setVisible(true);

		// ----------Format conversion and Output End----------/

		// ---------------Network Input------------------------/

		// ---------------Size of File Input-------------------/

		netFormat = new JLabel();
		netFormat.setText("File format");
		subPanel3.add(netFormat);
		netFormat.setVisible(true);

		netSizeFormat = new JComboBox<>(); // Drop down selection panel./
		netSizeFormat.addItem("b");
		netSizeFormat.addItem("B");
		netSizeFormat.addItem("KB");
		netSizeFormat.addItem("MB");
		netSizeFormat.addItem("GB");
		netSizeFormat.setPreferredSize(new Dimension(45, 20));
		subPanel3.add(netSizeFormat);
		netSizeFormat.setVisible(true);

		netFSize = new JLabel();
		netFSize.setText("Size");
		subPanel3.add(netFSize);
		netFSize.setVisible(true);

		netSize = new JTextField(); // File size or amount of data./
		netSize.setPreferredSize(new Dimension(40, 20));
		subPanel3.add(netSize);
		netSize.setVisible(true);

		// ---------------Size of File Input End---------------/

		// ---------------Bit Rate Input-----------------------/

		netBitRate = new JLabel();
		netBitRate.setText("b\\ps");
		subPanel3.add(netBitRate);
		netBitRate.setVisible(true);

		netBitRateVal = new JTextField(); // Network stated bit rate./
		netBitRateVal.setPreferredSize(new Dimension(40, 20));
		subPanel3.add(netBitRateVal);
		netBitRateVal.setVisible(true);

		// ---------------Bit Rate Input End-------------------/

		// ---------------Distance Input-----------------------/

		netVDistance = new JLabel();
		netVDistance.setText("K/Meters");
		subPanel3.add(netVDistance);
		netVDistance.setVisible(true);

		distance = new JComboBox<>(); // Drop down selection panel./
		distance.addItem("M");
		distance.addItem("KM");
		distance.setPreferredSize(new Dimension(50, 20));
		subPanel3.add(distance);
		distance.setVisible(true);

		netDistance = new JLabel();
		netDistance.setText("Distance");
		subPanel3.add(netDistance);
		netDistance.setVisible(true);

		netDistVal = new JTextField(); // Distance from point A to point B./
		netDistVal.setPreferredSize(new Dimension(40, 20));
		subPanel3.add(netDistVal);
		netDistVal.setVisible(true);

		// ---------------Distance Input End-------------------/

		// ---------------Network medium input-----------------/

		netVelocity = new JLabel();
		netVelocity.setText("W/LAN");
		subPanel3.add(netVelocity);
		netVelocity.setVisible(true);

		velocity = new JComboBox<>(); // Drop down selection panel./
		velocity.addItem("lan");
		velocity.addItem("wlan");
		velocity.setPreferredSize(new Dimension(60, 20));
		subPanel3.add(velocity);
		velocity.setVisible(true);

		// ---------------Network medium input-----------------/

		separate2 = new JSeparator();
		separate2.setAlignmentX(CENTER_ALIGNMENT);
		separate2.setPreferredSize(new Dimension(590, 2));
		subPanel3.add(separate2);
		separate2.setVisible(true);

		/*
		 * Here subPanel5 and 6 were added as they are nested into subPanel3.
		 * The only way for me to keep the layout harmony was to set another
		 * layout property and nest the panels in their respective location
		 * within the code. Example after all the other fields had been created,
		 * nest the Panels and proceed to add the required information.
		 */

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		subPanel5 = new JPanel();
		subPanel5.setBounds(2, 10, 295, 250);
		subPanel5.setPreferredSize(new Dimension(295, 233));
		subPanel5.setBorder(BorderFactory.createEtchedBorder());
		subPanel5.add(Box.createRigidArea(new Dimension(0, 3)));

		// Network Output code - moved based on the principal outlined above for
		// the nested panels./
		// ======//
		// Network Output code - moved./

		subPanel5.add(Box.createRigidArea(new Dimension(0, 3)));
		subPanel3.add(subPanel5);
		subPanel5.setVisible(true);

		// ---------------Network Input End--------------------/

		// ---------------Information and Parameters-----------/

		subPanel6 = new JPanel();
		subPanel6.setBounds(2, 25, 295, 250);
		subPanel6.setPreferredSize(new Dimension(285, 235));
		subPanel6.setBorder(BorderFactory.createTitledBorder("Parameters and Unit Reference"));
		subPanel3.add(subPanel6);
		subPanel6.setVisible(true);

		infoParam = new JTextArea(); // Information pane regarding parameters./
		infoParam.setBackground(Color.lightGray);
		infoParam.setText(
				"(1000 Meter = 1 KiloMeter)\nTime(s) and Rate(s) are in seconds or units per second.\n\nElectronic Transfer in Copper 200,000 KM/s assuming constant with no resistance.\n\nSignal transfer over airspace 300,000 KM/s assuming constant with no inteference.\n\n When entering numerical data, this should be entered with a decimal point I.e. 2.2, 2.0 .");
		infoParam.setAlignmentX(LEFT_ALIGNMENT);
		infoParam.setLineWrap(true);
		infoParam.setWrapStyleWord(true);
		infoParam.setPreferredSize(new Dimension(275, 200));
		infoParam.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		subPanel6.add(infoParam);
		infoParam.setVisible(true);

		// ---------------Information and Parameters End-------/

		// ---------------Network Output code------------------/

		subPanel5.add(Box.createRigidArea(new Dimension(0, 3))); // Part of the
																	// Box
																	// Layout
																	// for
																	// subPanel5,
																	// assists
																	// with the
																	// formatting
																	// of
																	// components./

		netConvert = new JButton();
		netConvert.setText("convert");
		netConvert.addActionListener(new netConvertHandler());
		netConvert.setPreferredSize(new Dimension(120, 20));
		subPanel5.add(netConvert);
		netConvert.setVisible(true);

		separate3 = new JSeparator();
		separate3.setAlignmentX(CENTER_ALIGNMENT);
		separate3.setPreferredSize(new Dimension(283, 2));
		subPanel5.add(separate3);
		separate3.setVisible(true);

		subPanel5.add(Box.createRigidArea(new Dimension(0, 3)));

		// -------------------END Convert button and separator --------------//

		setLayout(new GridLayout(25, 10));
		netState = new JLabel();
		netState.setText("Network State           ");
		subPanel5.add(netState);
		netState.setVisible(true);

		netStateOut = new JTextField();
		netStateOut.setPreferredSize(new Dimension(80, 20));
		subPanel5.add(netStateOut);
		netStateOut.setVisible(true);

		ps1 = new JLabel();
		ps1.setText("   per Second");
		subPanel5.add(ps1);
		ps1.setVisible(true);

		// -------------------END Network State -----------------------------//

		insertion = new JLabel();
		insertion.setText("  Insertion Delay           ");
		subPanel5.add(insertion);
		insertion.setVisible(true);

		insertionOut = new JTextField();
		insertionOut.setPreferredSize(new Dimension(80, 20));
		subPanel5.add(insertionOut);
		insertionOut.setVisible(true);

		ps2 = new JLabel();
		ps2.setText("  per Second");
		subPanel5.add(ps2);
		ps2.setVisible(true);

		// -------------------END Propagation -----------------------------//

		propagation = new JLabel();
		propagation.setText("  Propagation Delay     ");
		subPanel5.add(propagation);
		propagation.setVisible(true);

		propagationOut = new JTextField();
		propagationOut.setPreferredSize(new Dimension(80, 20));
		subPanel5.add(propagationOut);
		propagationOut.setVisible(true);

		ps3 = new JLabel();
		ps3.setText("  per Second");
		subPanel5.add(ps3);
		ps3.setVisible(true);

		// -------------------END Insertion -----------------------------//

		totalDelay = new JLabel();
		totalDelay.setText("  Total Delay                  ");
		subPanel5.add(totalDelay);
		totalDelay.setVisible(true);

		totalDelayOut = new JTextField();
		totalDelayOut.setPreferredSize(new Dimension(80, 20));
		subPanel5.add(totalDelayOut);
		totalDelayOut.setVisible(true);

		ps4 = new JLabel();
		ps4.setText("  per Second");
		subPanel5.add(ps4);
		ps4.setVisible(true);

		// -------------------END Total Delay --------------------------//

		actualBits = new JLabel();
		actualBits.setText("  Real bit Rate               ");
		subPanel5.add(actualBits);
		actualBits.setVisible(true);

		actualBitsOut = new JTextField();
		actualBitsOut.setPreferredSize(new Dimension(80, 20));
		subPanel5.add(actualBitsOut);
		actualBitsOut.setVisible(true);

		ps5 = new JLabel();
		ps5.setText("  per Second");
		subPanel5.add(ps5);
		ps5.setVisible(true);

		// -------------------END Actual Bits -------------------------//

		subPanel5.add(Box.createRigidArea(new Dimension(0, 3)));

		// ---------------END Network Output code---------------/

		// ---------------Additional Buttons--------------------/

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		subPanel4.add(Box.createRigidArea(new Dimension(35, 3)));

		exit = new JButton("exit");
		exit.setPreferredSize(new Dimension(100, 20));
		exit.addActionListener(new ExitHandler()); // Nested class./
		subPanel4.add(exit);
		exit.setVisible(true);

		subPanel4.add(Box.createRigidArea(new Dimension(35, 3)));

		reset = new JButton("reset");
		reset.setPreferredSize(new Dimension(100, 20));
		reset.addActionListener(new ResetHandler()); // Nested class./
		subPanel4.add(reset);
		reset.setVisible(true);

		subPanel4.add(Box.createRigidArea(new Dimension(35, 3)));

		/*
		 * Removed the save button for time purposes, if there is time I will
		 * work on this./ save = new JButton("save"); save.setPreferredSize(new
		 * Dimension(100, 20)); save.addActionListener(new SaveHandler());
		 * subPanel4.add(save); save.setVisible(true);
		 * subPanel4.add(Box.createRigidArea(new Dimension(35, 3)));
		 */

	}

	public class ExitHandler implements ActionListener {

		// Exit button Action: provide an option dialog./

		JFrame exitFrame;

		public ExitHandler() {

			exitFrame = new JFrame();
			exitFrame.setLocation(600, 400);
			exitFrame.setVisible(true);

		}

		/*
		 * Code below is from a power point lecture slide provided by Melanie
		 * Coles. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */

		@Override

		public void actionPerformed(ActionEvent e) {

			int n = JOptionPane.showConfirmDialog(exitFrame, "Are you sure you want to close the program?", "Close?",
					JOptionPane.YES_NO_OPTION);

			if (n == JOptionPane.YES_OPTION) {

				System.exit(0);

			}

		}

	}

	public class ResetHandler implements ActionListener {

		/*
		 * Thought to myself 'for a reset button, surely I just need to set all
		 * the visible data back to empty, therefore "" required'. Thus, it
		 * works perfectly. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */

		@Override

		public void actionPerformed(ActionEvent event) {

			size.setText("");
			outbText.setText("");
			outBText.setText("");
			outKBText.setText("");
			outMBText.setText("");
			outGBText.setText("");
			netSize.setText("");
			netBitRateVal.setText("");
			netDistVal.setText("");
			netStateOut.setText("");
			insertionOut.setText("");
			propagationOut.setText("");
			totalDelayOut.setText("");
			actualBitsOut.setText("");

		}

	}

	/*
	 * public class SaveHandler implements ActionListener {
	 * 
	 * JFrame saveFrame = new JFrame(); JFileChooser fileSave = new
	 * JFileChooser();
	 * 
	 * public SaveHandler() {
	 * 
	 * fileSave.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	 * fileSave.setDialogTitle("Save File As..... "); fileSave.setVisible(true);
	 * }
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { int n =
	 * fileSave.showSaveDialog(saveFrame); if
	 * (fileSave.showSaveDialog(saveFrame) == JFileChooser.APPROVE_OPTION) {
	 * getFile("temp.txt") = fileSave.getSelectedFile(); }
	 * 
	 * }
	 * 
	 * }
	 */

	public class UnitConversionHandler implements ActionListener { // Conversion
																	// button
																	// for file
																	// format
																	// size
																	// conversion./

		@Override

		public void actionPerformed(ActionEvent event) {

			Double num; // Set the variables to be passed to the external
						// class./
			String form;
			Double bi;
			Double by;
			Double ki;
			Double me;
			Double gi;

			form = (String) format.getSelectedItem(); // Acquire data cast to
														// string from the drop
														// down (JComboBox)./

			String text = size.getText(); // Acquire the text from the text
											// field and assign to a variable./
			num = Double.parseDouble(text); // Assign to a variable and parse to
											// required primitive [int, double
											// etc]./

			UnitConversion conv = new UnitConversion(); // New Instantiation./

			conv.setFormat(form); // Set the data./
			conv.setUserNum(num);
			conv.useData(form, num); // Pass it to the method./

			bi = conv.getBits();
			by = conv.getBytes();
			ki = conv.getKilobytes();
			me = conv.getMegabytes();
			gi = conv.getGigabytes();

			// Get the output and allocate it as text to text fields for user
			// display./

			outbText.setText(String.format("%.2f", bi).toString());
			outBText.setText(String.format("%.4f", by).toString());
			outKBText.setText(String.format("%.4f", ki).toString());
			outMBText.setText(String.format("%.6f", me).toString());
			outGBText.setText(String.format("%.9f", gi).toString());

		}

	}

	public class netConvertHandler implements ActionListener {

		// Network delay calculation conversion Actions./

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */

		@Override

		public void actionPerformed(ActionEvent event) {

			// User in variables./

			String sizeFormat;
			Double sizeNum;
			Double bitRate;
			String distFormat;
			Double distValue;
			String velValue;

			// Data output variables./

			double bits;
			double vel;
			double actualRate;
			double insertDelay;
			double propaDelay;
			double total;
			double realRate;

			// Get the user variables from the GUI and assign them to local
			// variables./

			sizeFormat = (String) netSizeFormat.getSelectedItem();
			distFormat = (String) distance.getSelectedItem();
			velValue = (String) velocity.getSelectedItem();

			String text = netSize.getText();
			String text1 = netBitRateVal.getText();
			String text2 = netDistVal.getText();

			// Convert from JTextField String return to Double values./

			sizeNum = Double.parseDouble(text);
			bitRate = Double.parseDouble(text1);
			distValue = Double.parseDouble(text2);

			NetworkCalc netConv = new NetworkCalc();

			netConv.setFormat(sizeFormat);
			netConv.setUserNum(sizeNum);
			netConv.setStatedRate(bitRate);
			netConv.setDistanceRatio(distFormat);
			netConv.setDistance(distValue);
			netConv.setSpeed(velValue);

			/*
			 * Start calling methods from NetworkCalc class using local
			 * variables and assign outputs to additional local variables.
			 */

			netConv.formatConvert(sizeFormat, sizeNum); // Need to get any value
														// converted to bits./
			bits = netConv.getBits();

			netConv.distanceCalc(distValue, distFormat, velValue); // Need to
																	// get the
																	// value for
																	// velocity
																	// based on
																	// user
																	// input./
			vel = netConv.getVelocity();

			netConv.netState(bits, bitRate);
			actualRate = netConv.getActualRate();

			netConv.insertionDelay(bits, actualRate);
			insertDelay = netConv.getInsertion();

			netConv.propagationDelay(distValue, vel);
			propaDelay = netConv.getPropagation();

			netConv.totalDelay(insertDelay, propaDelay);
			total = netConv.getTotalDelay();

			netConv.realState(bitRate, actualRate);
			realRate = netConv.getRealState();

			netStateOut.setText(String.format("%.4f", actualRate).toString());
			insertionOut.setText(String.format("%.4f", insertDelay).toString());
			propagationOut.setText(String.format("%.8f", propaDelay).toString());
			totalDelayOut.setText(String.format("%.2f", total).toString());
			actualBitsOut.setText(String.format("%.8f", realRate).toString());

			/*
			 * I was having major issues formatting the outputs so it does not
			 * output numE-7. I did manage to refactor the code to solve this
			 * issue though.
			 */

		}

	}

	public static void main(String[] args) throws Exception {

		new NetPCaCGUI(); // Main method to call the class and constructor./

	}

	// ---------------------getter and setter statements
	// start----------------------/

	/**
	 * @return the b, bits
	 */
	public JComboBox<String> getb() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setb(JComboBox<String> b) {
		this.b = b;
	}

	/**
	 * @return the B, bytes
	 */
	public JComboBox<String> getB() {
		return B;
	}

	/**
	 * @param B
	 *            the B to set
	 */
	public void setB(JComboBox<String> B) {
		this.B = B;
	}

	/**
	 * @return the kB, kilobytes
	 */
	public JComboBox<String> getKB() {
		return KB;
	}

	/**
	 * @param kB
	 *            the kB to set
	 */
	public void setKB(JComboBox<String> kB) {
		this.KB = kB;
	}

	/**
	 * @return the MB, megabytes
	 */
	public JComboBox<String> getMB() {
		return MB;
	}

	/**
	 * @param mB
	 *            the MB to set
	 */
	public void setMB(JComboBox<String> mB) {
		this.MB = mB;
	}

	/**
	 * @return the gB, gigabytes
	 */
	public JComboBox<String> getGB() {
		return GB;
	}

	/**
	 * @param gB
	 *            the gB to set
	 */
	public void setGB(JComboBox<String> GB) {
		this.GB = GB;
	}

	/**
	 * @return the wlan, Wireless Local Area Network
	 */
	public JComboBox<String> getWlan() {
		return wlan;
	}

	/**
	 * @param wlan
	 *            the wlan to set
	 */
	public void setWlan(JComboBox<String> wlan) {
		this.wlan = wlan;
	}

	/**
	 * @return the lan, Local Area Network
	 */
	public JComboBox<String> getLan() {
		return lan;
	}

	/**
	 * @param lan
	 *            the lan to set
	 */
	public void setLan(JComboBox<String> lan) {
		this.lan = lan;
	}

	/**
	 * @return the m, meters
	 */
	public JComboBox<String> getM() {
		return M;
	}

	/**
	 * @param m
	 *            the m to set
	 */
	public void setM(JComboBox<String> M) {
		this.M = M;
	}

	/**
	 * @return the kM, kilometers
	 */
	public JComboBox<String> getKM() {
		return KM;
	}

	/**
	 * @param kM
	 *            the kM to set
	 */
	public void setKM(JComboBox<String> KM) {
		this.KM = KM;
	}

	// ---------------------getter and setter statements
	// end----------------------/
}
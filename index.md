# NetPCaC
## Binary Calculator and Network Propogation delay Calculator

### First Year Final Programming Project
The purpose of the project was to demonstrate the skills we had been learning about encapsulation, programming, methods, helper methods and classses and the Interface building to complete a self-selected project from concept through to final piece.

some of the better parts of the code here were the propogation delays gathered from my networking lectures and seminars, I decided (although calculators weren't allowed to be coded for the project) to write a calculator of some kind because that is by definition what Computers do, calculate.

Probably the best component was and is the propogation delays and how they fed through to the interface.

### Propogation Delays
```
/**
 * @title NetworkCalc
 * @description This particular class is designed to calculate various network
 *              states and delays. The data is presented to the user is seconds.
 *              The user has the ability to select the file size format for
 *              example bits, bytes, kilobytes, megabytes and gigabytes. In
 *              order for the calculations to work the file size is first
 *              converted to bits using the UnitConversion class unless bits is
 *              already specified, then applied to the calculations in this
 *              class. Output is then generated and presented to the user.
 * @author Russell Clarke - i7694005 - Bournemouth University. Created
 *         01/03/2015 - Semester 2 - Object Orientated Programming Assignment.
 * @version BaySix_0.9.4-Alpha
 */

public class NetworkCalc { // Global and encapsulated./

	private double bits;
	private double statedRate;
	private String format;
	private double userNum;
	private String distanceRatio;
	private String KM = "KM";
	private String M = "M";
	private double distance;
	private String speed;
	private String wlan = "wlan";
	private String lan = "lan";
	private double velocity;
	private double actualRate;
	private double insertion;
	private double propagation;
	private double totalDelay;
	private double realState;

	public NetworkCalc() { // Constructor

		formatConvert(format, userNum);
		distanceCalc(distance, distanceRatio, speed);

	}

	public void formatConvert(String format, double userNum) {

		/**
		 * @description This Method is designed to take and use the values
		 *              presented by the user and convert the numerical data
		 *              entered for the packet size, file size [bytes,
		 *              kilobytes, mega.....] and convert them to bits before
		 *              performing the network delay calculation.
		 * @Param double size, double bits, String format
		 * @Return void sets the relevant data for processing in the
		 *         UnitConversion Class and finally gets and sets data to bits
		 *         variable.
		 */

		UnitConversion convert = new UnitConversion();

		if (format == "GB" && userNum > 0) {

			convert.setFormat(format);
			convert.setUserNum(userNum);
			convert.useData(format, userNum);
			double value = convert.getBits();

			bits = value;

			return;

		} else if (format == "MB" && userNum > 0) {

			convert.setFormat(format);
			convert.setUserNum(userNum);
			convert.useData(format, userNum);
			double value = convert.getBits();

			bits = value;

			return;

		} else if (format == "KB" && userNum > 0) {

			convert.setFormat(format);
			convert.setUserNum(userNum);
			convert.useData(format, userNum);
			double value = convert.getBits();

			bits = value;

			return;

		} else if (format == "B" && userNum > 0) {

			convert.setFormat(format);
			convert.setUserNum(userNum);
			convert.useData(format, userNum);
			double value = convert.getBits();

			bits = value;

			return;

		} else if (format == "b" && userNum > 0) {

			convert.setFormat(format);
			convert.setUserNum(userNum);
			convert.useData(format, userNum);
			double value = convert.getBits();

			bits = value;

			return;

		}

	}

	public void distanceCalc(double distance, String distanceRatio, String speed) {

		/**
		 * @description This method is used to calculate the distance the user
		 *              has entered with varying medium. It has five conditions
		 *              in total, for KiloMetres it has WLAN and LAN and the
		 *              same for Metres. The approximate speed of an air signal
		 *              is 300,000 KM per second and for electricity through
		 *              copper is 200000. This accounts for two of the
		 *              conditions the others are for Metres, again the same but
		 *              multiplied by 1000, as there are 1000 m/KM.
		 * @param double
		 *            distance, String distanceRatio, String speed.
		 * @return void statements returns the value of velocity to the Global
		 *         encapsulated vairable from data in the corresponding medium
		 *         and distance value [String M, KM & double distance, speed].
		 */

		String dr = distanceRatio;
		String s = speed;

		if (distance > 0 && dr == "KM" && s == "wlan") {

			// The approximate speed of radio signals through air without
			// interference in KM/s./
			distance = distance * 1000;
			velocity = 300;

			return;
		} else if (distance > 0 && dr == "KM" && s == "lan") {

			// The approximate speed of electricity through copper without
			// resistance in KM/s./
			distance = distance * 1000;
			velocity = 200;

			return;
		} else if (distance > 0 && dr == "M" && s == "wlan") {

			// The approximate speed of radio signals through air without
			// interference in M/s./

			velocity = 300000;

			return;
		} else if (distance > 0 && dr == "M" && s == "lan") {

			// The approximate speed of electricity through copper without
			// resistance in M/s./

			velocity = 200000;

			return;
		}

	}

	public void netState(double bits, double statedRate) {

		/**
		 * @description This method is designed to take in the amount of data to
		 *              be sent which is then converted to bits. The stated bit
		 *              rate is used with the converted data to perform a
		 *              calculation of actual network state. The output should
		 *              be converted to String by the NetPCaCGUI then presented
		 *              to the user.
		 * @param double
		 *            bits, double statedRate
		 * @return void actualRate returns the formated value of actualRate of
		 *         data transfer in the network to the global variable.
		 */

		double b = bits;
		double s = statedRate;

		double stime = b / s;

		actualRate = stime;

		return;

	}

	public void insertionDelay(double bits, double actualRate) {

		/**
		 * @description This method is designed to calculate the insertion delay
		 *              based on previous calculations from the netState method.
		 *              It receives the value of actualState and uses this in
		 *              the calculation. It will return the value of insertion
		 *              delay for the propagation delay method.
		 * @param double
		 *            bits, double actualRate: actual rate acquired from the
		 *            global variable
		 * @return void insertion returns the network insertion delay
		 */

		double b = bits;
		double a = actualRate;

		double itime = b / a;

		insertion = itime;

		return;

	}

	public void propagationDelay(double distance, double velocity) {

		/**
		 * @description This method is designed to calculate the propagation
		 *              delay in a network using the distance and the velocity.
		 *              Distance is taken from user entry/selection, upon
		 *              selection the velocity is returned as the correct value
		 *              according to the medium. Example: if distance is 34 and
		 *              KM is selected and the medium is wlan then propagation
		 *              is 34/300000 = 1.13333 recurring second delay.
		 * @param double
		 *            distance, double velocity acquired from Global variable
		 * @return propagation returns the network propagation delay
		 */

		double d = distance;
		double v = velocity;

		double ptime = d / v;

		propagation = ptime;

		return;

	}

	public void totalDelay(double insertion, double propagation) {

		/**
		 * @description This method is designed to calculate the total delay
		 *              time from point A when the data starts to send to point
		 *              B when the final piece of data is received. It will take
		 *              in the values of insertion and propagation stored in the
		 *              Global variables. The output returned is the total delay
		 *              in the specified network environment.
		 * @param double
		 *            insertion, double propagation both acquired from the
		 *            Global variable
		 * @return void totalDelay returns the totalDelay in the network
		 *         environment specified to Global variable.
		 */

		double tTime = insertion + propagation;

		totalDelay = tTime;

		return;

	}

	public void realState(double statedRate, double actualRate) {

		/**
		 * @description This method is designed to calculate the real network
		 *              state based on the stated rate of transfer possible
		 *              stated by the ISP and the actual calculated rate of
		 *              transfer. The method uses the user input to acquire the
		 *              value of the stated network rate and the value returned
		 *              for the actualRate calculated earlier in the netState
		 *              method. It should return the realState of the network.
		 * @param double
		 *            statedRate, double actualRate acquired from the Global
		 *            variable
		 * @return void realState the real transfer rate of the network assigned
		 *         to the Global variable.
		 */

		double s = statedRate;
		double a = actualRate;

		double rTime = s / a;

		realState = rTime;

		return;

	}

	public static void main(String[] args) {

	}

	// --------------------getter and setter methods
	// start----------------------//

	public double getBits() {
		return bits;
	}

	public void setBits(double bits) {
		this.bits = bits;
	}

	public double getStatedRate() {
		return statedRate;
	}

	public void setStatedRate(double statedRate) {
		this.statedRate = statedRate;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public double getUserNum() {
		return userNum;
	}

	public void setUserNum(double userNum) {
		this.userNum = userNum;
	}

	public String getDistanceRatio() {
		return distanceRatio;
	}

	public void setDistanceRatio(String distanceRatio) {
		this.distanceRatio = distanceRatio;
	}

	public String getKM() {
		return KM;
	}

	public void setKM(String KM) {
		this.KM = KM;
	}

	public String getM() {
		return M;
	}

	public void setM(String M) {
		this.M = M;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getWlan() {
		return wlan;
	}

	public void setWlan(String wlan) {
		this.wlan = wlan;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getActualRate() {
		return actualRate;
	}

	public void setActualRate(double actualRate) {
		this.actualRate = actualRate;
	}

	public double getInsertion() {
		return insertion;
	}

	public void setInsertion(double insertion) {
		this.insertion = insertion;
	}

	public double getPropagation() {
		return propagation;
	}

	public void setPropagation(double propagation) {
		this.propagation = propagation;
	}

	public double getTotalDelay() {
		return totalDelay;
	}

	public void setTotalDelay(double totalDelay) {
		this.totalDelay = totalDelay;
	}

	public double getRealState() {
		return realState;
	}

	public void setRealState(double realState) {
		this.realState = realState;
	}

	// --------------------getter and setter methods end----------------------//
}

/*
 * NetworkCalc *PSEUDO CODE* take values allocate to variable convert file
 * format to bits use variable in calculations convert to String. return values
 * as String.
 */
```
<head>
  <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta charset="UTF-8">
<meta name="description" content="Projects and Portfolio">
<meta name="keywords" content="HTML, CSS, JavaScript, PHP, MySQLi, Python, Java, C, C++, C#, Time, Shapes">
<meta name="author" content="Russell Clarke">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<footer class="w3-container w3-teal w3-center w3-margin-top">
  <p>Find me on social media.</p>
  <a href="https://www.facebook.com/profile.php?id=100075972987666"><i class="fa fa-facebook-official w3-hover-opacity"></i></a>
  <a href="https://www.instagram.com/russellclarke821"><i class="fa fa-instagram w3-hover-opacity"></i></a>
  <a href="https://www.pinterest.co.uk/russellclarke821/"><i class="fa fa-pinterest-p w3-hover-opacity"></i></a>
  <a href="https://twitter.com/Developing821"><i class="fa fa-twitter w3-hover-opacity"></i></a>
  <a href="https://www.linkedin.com/in/russell-clarke-09a1a5238"></a><i class="fa fa-linkedin w3-hover-opacity"></i>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>


/**
 * @author Russell Clarke - i7694005 - Bournemouth University
 * Created 01/03/2015 - Semester 2 - Object Orientated Programming Assignment.
 * @version BaySix_0.9.4-Alpha
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkCalcTest {

	String format;
	double userNum;
	double distance;
	String distanceRatio;
	String speed;
	double bits;
	double statedRate;
	double bitRate;
	double insertion;
	double propagation;
	double totalDelay;
	double realState;

	NetworkCalc calc = new NetworkCalc();

	@Test
	public void testFormatReturnValue() throws NumberFormatException {

		if (format == "MB" && userNum == 2) {

			assertEquals("2.384185791015625", calc.getBits());

		} else if (format == "b" && userNum == 2) {

			assertEquals("2", calc.getBits());

		} else if (format == "MB" && userNum == 2.5) {

			assertEquals("2.384185791015625", calc.getBits());

		} else if (format == "b" && userNum == 2.9) {

			assertEquals("2", calc.getBits());

		} else if (format == "GB" && userNum == Double.parseDouble("Two")) {

			fail("Not the correct data value entered, should be Double value");

		} else if (format == "GB" && userNum == Double.parseDouble("+")) {

			fail("Not the correct data value entered, should be Double value");

		} else if (format == "GB" && userNum == Double.parseDouble(null)) {

			fail("No data value entered, should be Double value");

		}

	}

	@Test
	public void testInvalidDataException() throws NumberFormatException {

		format = "MB";

		@SuppressWarnings("unused")
		double userNum;

		userNum = Double.parseDouble("siidkjh#+.)\nTwo");

		calc.getBits();
	}

	@Test
	public void testNullPointer() throws NullPointerException {

		format = "MB";

		@SuppressWarnings("unused")
		double userNum;

		calc.getBits();
	}

	@Test
	public void testInvalidDataETCF() {

		try {

			format = "MB";

			@SuppressWarnings("unused")
			double userNum;

			userNum = Double.parseDouble("siidkjh#+.)\nTwo");

			calc.getBits();

		} catch (NumberFormatException NFE) {

			System.err.println(NFE.getMessage().toString()
					+ ": Wrong data type entered for the file format option, expecting numerical value.");
		} finally {

			System.out.println(
					"Please try entering a numerical value. If this problem persists, Please send this error to the developer. ");
		}
	}

	@Test
	public void testNullDataETCF() {

		try {

			format = "MB";

			@SuppressWarnings("unused")
			double userNum;

			calc.getBits();

		} catch (NullPointerException NPE) {

			System.err.println(NPE.getMessage()
					+ ": You have not entered any Data value for the file format option, expecting numerical value.");
		} finally {

			System.out.println(
					"Please try entering a numerical value. If this problem persists, Please send this error to the developer. ");
		}
	}

	@Test
	public void testDistanceCalc() throws NumberFormatException {

		if (distance > 0 && distanceRatio == "KM" && speed == "lan") {

			assertEquals("200", calc.getVelocity());

			assertEquals("distance * 1000", calc.getDistance());

		} else if (distance > 0 && distanceRatio == "M" && speed == "lan") {

			assertEquals("200000", calc.getVelocity());

			assertEquals("distance", calc.getDistance());

		} else if (distance > 0 && distanceRatio == "KM" && speed == "wlan") {

			assertEquals("300", calc.getVelocity());

			assertEquals("distance * 1000", calc.getDistance());

		} else if (distance > 0 && distanceRatio == "M" && speed == "wlan") {

			assertEquals("300000", calc.getVelocity());

			assertEquals("distance", calc.getDistance());

		} else if (distance > 2 && distanceRatio == "KM" && speed == "wlan") {

			assertEquals("300000", calc.getVelocity());

			assertEquals("2000", calc.getDistance());

		} else if (distanceRatio == "KM" && speed == "wlan" && distance == Double.parseDouble("Two")) {

			fail("Invalid data entered, Double numerical value expected for distance.");

		} else if (distanceRatio == "KM" && speed == "wlan" && distance == Double.parseDouble("TwoMillionAnd9")) {

			fail("Invalid data entered, Double numerical value expected for distance.");

		} else if (distanceRatio == "KM" && speed == "wlan" && distance == Double.parseDouble("9PointTwo")) {

			fail("Invalid data entered, Double numerical value expected for distance.");

		} else if (distanceRatio == "KM" && speed == "wlan" && distance == Double.parseDouble(null)) {

			fail("No data entered, Double numerical value expected for distance.");

		}

	}

	@Test
	public void testDistanceCalcNumberFormatETCF() throws NumberFormatException {

		try {

			distanceRatio = "MB";
			speed = "lan";

			@SuppressWarnings("unused")
			double distance;

			distance = Double.parseDouble("$Admin/Two289.982");

			calc.getVelocity();

		} catch (NumberFormatException NFE) {

			System.err.println(
					NFE.getMessage().toString() + ": Wrong data type entered for distance, expecting numerical value.");
		} finally {

			System.out.println(
					"Please try entering a numerical value. If this problem persists, Please send this error to the developer. ");
		}
	}

	@Test
	public void testDistanceCalcNullPointerETCF() throws NullPointerException {

		try {

			distanceRatio = "MB";
			speed = "lan";

			@SuppressWarnings("unused")
			double distance;

			calc.getVelocity();

		} catch (NumberFormatException NPE) {

			System.err.println(
					NPE.getMessage().toString() + ": No data type entered for distance, expecting numerical value.");
		} finally {

			System.out.println(
					"Please try entering a numerical value. If this problem persists, Please send this error to the developer. ");
		}
	}

	@Test
	public void testDistanceCalcNull() throws NullPointerException {

		distanceRatio = "MB";
		speed = "lan";

		@SuppressWarnings("unused")
		double distance;

		calc.getVelocity();

	}

	@Test
	public void testDistanceCalcNumberFormat() throws NumberFormatException {

		distanceRatio = "MB";
		speed = "lan";

		@SuppressWarnings("unused")
		double distance;

		distance = Double.parseDouble("5Nine");

		calc.getVelocity();

	}

	/*
	 * double bits; double statedRate; double bitRate; double insertion; double
	 * propagation; double totalDelay; double realState;
	 */

	@Test
	public void testActualState() {

		if (bits == 2 && bitRate == 1) {

			assertEquals("0.5", calc.getActualRate());

		} else if (bits == 8 && bitRate == 1) {

			assertEquals("1", calc.getActualRate());

		} else if (bits > 0 && bitRate > 0) {

			assertEquals(">=0", calc.getActualRate());

		} else if (bits == 2.9 && bitRate == 4.5) {

			assertEquals("0.6444444444444444", calc.getActualRate());

		}

	}

	public void testActualStateNumberFormatE() throws NumberFormatException {

		if (bitRate == 12 && bits == Double.parseDouble("+_")) {

			fail("Invalid data entry at file format size, double numerical values expected.");

		}

		else if (bits == Double.parseDouble("Two") && bitRate == Double.parseDouble("Two")) {

			fail("Invalid data entry, double numerical values expected.");

		}
	}
	/*
	 * @Test public void testInsertionDelay() {
	 * 
	 * if () {
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } }
	 * 
	 * @Test public void testPropagationDelay() {
	 * 
	 * if () {
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } }
	 * 
	 * @Test public void testtotalDelay() {
	 * 
	 * if () {
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } }
	 * 
	 * @Test public void testRealState() {
	 * 
	 * if () {
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } else if (){
	 * 
	 * } }
	 * 
	 */
}

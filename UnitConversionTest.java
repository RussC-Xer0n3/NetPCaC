
/**
 * @author Russell Clarke - i7694005 - Bournemouth University
 * Created 01/03/2015 - Semester 2 - Object Orientated Programming Assignment.
 * @version BaySix_0.9.4-Alpha
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitConversionTest {

	/**
	 * Test method for {@link UnitConversion#UnitConversion()}.
	 */

	String format;
	double userNum;

	UnitConversion conv = new UnitConversion();

	@Test
	public void testUnitConversion() {

		if (userNum == 1 && format == "b") {
			assertEquals("1.0", conv.getBits());

			assertEquals("0.1250", conv.getBytes());

			assertEquals("0.0001", conv.getKilobytes());

			assertEquals("0.000001", conv.getMegabytes());

			assertEquals("0.000000001", conv.getGigabytes());
		} else if (userNum == 1 && format == "GB") {
			assertEquals("8589934592.0", conv.getBits());

			assertEquals("1073741824.0", conv.getBytes());

			assertEquals("1048576.0", conv.getKilobytes());

			assertEquals("1024.0", conv.getMegabytes());

			assertEquals("1.0", conv.getGigabytes());

		}
	}

	/**
	 * Test method for {@link UnitConversion#UnitConversion(b, null)}.
	 */

	@Test
	public void testNoValue() throws NullPointerException {
		if (userNum == Double.parseDouble(null) && format == "b") {
			fail("Value is required, cannot convert using no value: NullPointerException thrown.");
		}
	}

	/**
	 * Test method for {@link UnitConversion#UnitConversion(b, "one")}.
	 */

	@Test
	public void testNumberAsString() throws NumberFormatException {
		if (userNum == Double.parseDouble("one") && format == "b") {
			fail("Value is not a double numerical value as expected: String value received.");
		}
	}

	/**
	 * Test method for {@link UnitConversion#UnitConversion(b, +)}.
	 */

	@Test
	public void testNumberAsMathOperator() throws NumberFormatException {
		if (userNum == Double.parseDouble("+") && format == "b") {
			fail("Value is not a numerical value, double value required: Math operator value received.");
		}
	}

	/**
	 * Test method for {@link UnitConversion#UnitConversion(b, null) Try Catch,
	 * Finally}.
	 */

	@Test
	public void testExceptionNullPointerTCF() {

		try {

			format = "b";
			@SuppressWarnings("unused")
			double userNum;

		} catch (NullPointerException NPE) {

			System.err.println("1.  " + NPE.getMessage() + ". No data entered, expecting numerical value.");

		} finally {

			System.out.println("1.  " + "ERROR: No Data Entered: Please enter a numerical value.");

		}
	}

	/**
	 * Test method for {@link UnitConversion#UnitConversion(B, "One") Try Catch,
	 * Finally}.
	 */

	@Test
	public void testExNumberFormatTCF() {

		try {

			format = "B";
			@SuppressWarnings("unused")
			double userNum = Double.parseDouble("One");

		} catch (NumberFormatException StringFormat) {

			System.err.println(
					"2.  " + StringFormat.getMessage() + ". Wrong data type entered, expecting numerical value.");

		} finally {

			System.out.println("2.  " + "Send this error to developer. Then try using a numerical value.");

		}

		/**
		 * Test method for {@link UnitConversion#UnitConversion(b, +) Try Catch,
		 * Finally}.
		 */
	}

	@Test
	public void testExNumberFormatMathOperatorTCF() {

		try {

			format = "b";
			@SuppressWarnings("unused")
			double userNum = Double.parseDouble("+");

		} catch (NumberFormatException MathOperation) {

			System.err.println(
					"3.  " + MathOperation.getMessage() + ". Wrong data type entered, expecting numerical value.");

		} finally {

			System.out.println("3.  " + "Send this error to developer. Then try using a numerical value.");

		}

	}

	/**
	 * Test method for {@link UnitConversion#UnitConversion(setFormat("b"),
	 * setUserNum(1))}. Tests the get and set methods.
	 */

	@Test
	public void testGetSetMethods() {

		conv.setFormat("b");
		conv.setUserNum(1);

		conv.getBits();
		conv.getBytes();
		conv.getKilobytes();
		conv.getMegabytes();
		conv.getGigabytes();

	}
}

/**
 * @title UnitConversion
 * @description This particular class is designed to take input from the user
 *              via the Graphical User Interface. Allocate the data to the
 *              correct variable in the main method of the UnitConversion Class.
 *              Pass the userData to the equivalent method using get and set
 *              methods.
 * @author Russell Clarke - i7694005 - Bournemouth University Created 01/03/2015
 *         - Semester 2 - Object Orientated Programming Assignment.
 * @version BaySix_0.9.4-Alpha
 */

// With all the output, decimal data is restricted by readable format. The
// solution to this problem is accomplished using the print format condition./

public class UnitConversion {

	/**
	 * @description The UnitConversion Class takes two variables in total:
	 * @param args
	 *            String format : Where format is either GB, MB, KB, B or b -
	 *            Equivalent to Computer file format sizes.
	 * @param args
	 *            double userNum : Where userNum is the value of the file size
	 *            in retrospect to the format.
	 * @param args
	 *            getComponent() and setComponent() methods for bits, bytes,
	 *            kilobytes, megabytes, gigabytes, format and userNum. The
	 *            rounded returned figure is accurate to 2 decimal places when
	 *            converting from GigaBytes and increases in decimal accuracy as
	 *            the format decreases to bits. Because bits are larger in
	 *            numerical value when converting from a larger file format, the
	 *            shift in decimal rounding allows for greater accuracy in
	 *            output.
	 * @author Russell Clarke - i7694005 - Bournemouth University
	 */

	private String format;
	private double userNum;

	private double bits;
	private double bytes;
	private double kilobytes;
	private double megabytes;
	private double gigabytes;

	/**
	 * @param args
	 *            useData() : String format, double userNum
	 * @return public UnitConversion()
	 * @description A constructor method which kicks off the initial conversion
	 *              process once the data is set.
	 */

	public UnitConversion() {

		useData(format, userNum);

	}

	public void convertGiga() {

		/**
		 * @description convertGiga method, This method is called and executed
		 *              when the condition meets the value String format = "GB"
		 *              Returns the calculated value in bits, Bytes, KiloBytes,
		 *              MegaBytes and GigaBytes.
		 * @param args
		 *            convertGiga(String format, double userNum);
		 * @return void
		 */

		gigabytes = userNum;
		megabytes = userNum * 1024;
		kilobytes = userNum * 1024 * 1024;
		bytes = userNum * 1024 * 1024 * 1024;
		bits = userNum * 1024 * 1024 * 1024 * 8;

	}

	public void convertMega() {

		/**
		 * @description convertMega method, This method is called and executed
		 *              when the condition meets the value String format = "MB"
		 *              Returns the calculated value in bits, Bytes, KiloBytes,
		 *              MegaBytes and GigaBytes.
		 * @param args
		 *            convertMega(String format, double userNum);
		 * @return void
		 */

		gigabytes = userNum / 1024;
		megabytes = userNum;
		kilobytes = userNum * 1024;
		bytes = userNum * 1024 * 1024;
		bits = userNum * 1024 * 1024 * 8;

	}

	public void convertKilo() {

		/**
		 * @description convertKilo method, This method is called and executed
		 *              when the condition meets the value String format = "KB"
		 *              Returns the calculated value in bits, Bytes, KiloBytes,
		 *              MegaBytes and GigaBytes.
		 * @param args
		 *            convertKilo(String format, double userNum);
		 * @return void
		 */

		gigabytes = userNum / 1024 / 1024;
		megabytes = userNum / 1024;
		kilobytes = userNum;
		bytes = userNum * 1024;
		bits = userNum * 1024 * 8;

	}

	public void convertBytes() {

		/**
		 * @description convertBytes method, This method is called and executed
		 *              when the condition meets the value String format = "B"
		 *              Returns the calculated value in bits, Bytes, KiloBytes,
		 *              MegaBytes and GigaBytes.
		 * @param args
		 *            convertBytes(String format, double userNum);
		 * @return void
		 */

		gigabytes = userNum / 1024 / 1024 / 1024;
		megabytes = userNum / 1024 / 1024;
		kilobytes = userNum / 1024;
		bytes = userNum;
		bits = userNum * 8;

	}

	public void convertBits() {

		/**
		 * @description convertBits method, This method is called and executed
		 *              when the condition meets the value String format = "b"
		 *              Returns the calculated value in bits, Bytes, KiloBytes,
		 *              MegaBytes and GigaBytes.
		 * @param args
		 *            convertBits(String format, double userNum);
		 * @return void
		 */

		gigabytes = userNum / 1024 / 1024 / 1024;
		megabytes = userNum / 1024 / 1024;
		kilobytes = userNum / 1024;
		bytes = userNum / 8;
		bits = userNum;

	}

	public void useData(String format, double userNum) {

		/**
		 * @description useData method, This method is called by the class
		 *              constructor method as a decision table for the data
		 *              which has been set and called from another class or
		 *              internally.
		 * @param args
		 *            useData(String format, double userNum)
		 * @return void
		 */

		if (format == "GB" && userNum > 0) {

			convertGiga();

			return;

		} else if (format == "MB" && userNum > 0) {

			convertMega();

			return;

		} else if (format == "KB" && userNum > 0) {

			convertKilo();

			return;

		} else if (format == "B" && userNum > 0) {

			convertBytes();

			return;

		} else if (format == "b" && userNum > 0) {

			convertBits();

			return;

		}

	}

	public void Display() {

		/**
		 * @description Display method, This method is used to format the output
		 *              of the conversion method. The formatting must occur
		 *              otherwise irregular data is output to the GUI. The
		 *              printf function is used to achieve this and the format
		 *              varies depending on the input and required output.
		 * @return void sets formated file format data to their respective
		 *         variables.
		 */

		if (format == "GB" && userNum > 0) {

			System.out.printf("%.2f", gigabytes);
			System.out.printf("%.2f", megabytes);
			System.out.printf("%.2f", kilobytes);
			System.out.printf("%.2f", bytes);
			System.out.printf("%.2f", bits);

			return;

		} else if (format == "MB" && userNum > 0) {

			System.out.printf("%.3f", gigabytes);
			System.out.printf("%.2f", megabytes);
			System.out.printf("%.2f", kilobytes);
			System.out.printf("%.2f", bytes);
			System.out.printf("%.2f", bits);

			return;

		} else if (format == "KB" && userNum > 0) {

			System.out.printf("%.6f", gigabytes);
			System.out.printf("%.4f", megabytes);
			System.out.printf("%.2f", kilobytes);
			System.out.printf("%.2f", bytes);
			System.out.printf("%.2f", bits);

			return;

		} else if (format == "B" && userNum > 0) {

			System.out.printf("%.12f", gigabytes);
			System.out.printf("%.10f", megabytes);
			System.out.printf("%.6f", kilobytes);
			System.out.printf("%.2f", bytes);
			System.out.printf("%.2f", bits);

			return;

		} else if (format == "b" && userNum > 0) {

			System.out.printf("%.14f", gigabytes);
			System.out.printf("%.12f", megabytes);
			System.out.printf("%.10f", kilobytes);
			System.out.printf("%.8f", bytes);
			System.out.printf("%.2f", bits);

			return;

		}

	}

	public static void main(String[] args) {

		/**
		 * @description UnitConversion main method uses Get and Set methods to
		 *              pass data from outside the class to the encapsulated
		 *              variables. Boolean statements ensure the correct method
		 *              is used according to the format selected by the user.
		 * @param args
		 *            UnitConversion(String format, double userNum)
		 * @return public static void main(String[] args)
		 */

	}

	// ------------------getter and setter methods start---------------------//

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

	public double getBits() {
		return bits;
	}

	public void setBits(double bits) {
		this.bits = bits;
	}

	public double getBytes() {
		return bytes;
	}

	public void setBytes(double bytes) {
		this.bytes = bytes;
	}

	public double getKilobytes() {
		return kilobytes;
	}

	public void setKilobytes(double kilobytes) {
		this.kilobytes = kilobytes;
	}

	public double getMegabytes() {
		return megabytes;
	}

	public void setMegabytes(double megabytes) {
		this.megabytes = megabytes;
	}

	public double getGigabytes() {
		return gigabytes;
	}

	public void setGigabytes(double gigabytes) {
		this.gigabytes = gigabytes;
	}

	// ------------------getter and setter methods end---------------------//

}
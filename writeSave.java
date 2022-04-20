import java.io.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class writeSave {

	Scanner scan = new Scanner(System.in);
	File temp = new File("temp.txt");

	private JFrame fileFrame;
	private JFileChooser choose;

	public writeSave() {
		fileFrame();
		collectInfo();
		writeInfo();

		fileFrame = new JFrame();
		choose = new JFileChooser();

		fileFrame.add(choose);
		fileFrame.setVisible(true);
	}

	public void fileFrame() {

		fileFrame = new JFrame();
		fileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileFrame.setPreferredSize(new Dimension(300, 400));

		choose = new JFileChooser();
		choose.setLayout(null);
		choose.setBackground(Color.darkGray);

	}

	public void collectInfo() {

	}

	public void writeInfo() {

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		new writeSave();

		@SuppressWarnings("unused")
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("temp.txt")));

	}

}

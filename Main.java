package MyPac;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		Gui g = new Gui();
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setTitle("Number Base Converter");
		g.setSize(450,300);
		g.setVisible(true);
	}
}

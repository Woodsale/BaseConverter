package MyPac;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{
	private JTextField baseFromText,baseFrom,baseToText,baseTo,
					   numberFromText,numberFrom,resultText,result;
	
	private JButton con;
	
	private JMenuBar menu;
    	private JMenu options;
    	private JMenuItem quit, help; 
	
	public Gui() {
		super("Convert Number Bases");
		setLayout(new FlowLayout());
		
		setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();
		
		/**Convert From Base Text and Number*/
		baseFromText = new JTextField("Convert from Base:",15);
		baseFromText.setFont(new Font("Serif",Font.PLAIN,14));
		baseFromText.setEditable(false);
		position.gridx = 0;
		position.gridy = 0;
		add(baseFromText,position);
		
		baseFrom = new JTextField("",15);
		baseFrom.setFont(new Font("Serif",Font.PLAIN,14));
		baseFrom.setEditable(true);
		position.gridx = 0;
		position.gridy = 1;
		position.gridwidth = 1;
		position.gridheight = 1;
		add(baseFrom,position);
		
		/**Convert Base to text and number*/
		baseToText = new JTextField("Convert To Base:",15);
		baseToText.setFont(new Font("Serif",Font.PLAIN,14));
		baseToText.setEditable(false);
		position.gridx = 2;
		position.gridy = 0;
		add(baseToText,position);
		
		baseTo = new JTextField("",15);
		baseTo.setFont(new Font("Serif",Font.PLAIN,14));
		baseTo.setEditable(true);
		position.gridx = 2;
		position.gridy = 1;
		position.gridwidth = 1;
		position.gridheight = 1;
		add(baseTo,position);
		
		/**Number from text and input*/
		numberFromText = new JTextField("Convert Number:",15);
		numberFromText.setFont(new Font("Serif",Font.PLAIN,14));
		numberFromText.setEditable(false);
		position.gridx = 0;
		position.gridy = 2;
		position.gridwidth = 1;
		position.gridheight = 1;
		add(numberFromText,position);
		
		numberFrom = new JTextField("",15);
		numberFrom.setFont(new Font("Serif",Font.PLAIN,14));
		numberFrom.setEditable(true);
		position.gridx = 0;
		position.gridy = 3;
		position.gridwidth = 1;
		position.gridheight = 1;
		add(numberFrom,position);
		
		/**Result text and Output number*/
		resultText = new JTextField("Result",15);
		resultText.setFont(new Font("Serif",Font.PLAIN,14));
		resultText.setEditable(false);
		position.gridx = 2;
		position.gridy = 2;
		add(resultText,position);
		
		result = new JTextField("Result",15);
		result.setFont(new Font("Serif",Font.PLAIN,14));
		result.setEditable(false);
		position.gridx = 2;
		position.gridy = 3;
		add(result,position);
		
		/**Convert button*/
		con = new JButton();
		con.setText("Convert");
		position.gridx = 0;
		position.gridy = 4;
		position.gridwidth = 3;
		position.gridheight = 1;
		add(con,position);
		
		setupMenus();
		
		actions a = new actions();
		con.addActionListener(a);
		quit.addActionListener(a);
        help.addActionListener(a);
	}
	private class actions implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==con) {
				String bfv = ""; //base from value
				int bfvInt;
				String btv = ""; //base to value
				int btvInt;
				String nf = ""; //number from
				String r = ""; //result
				
				bfv = baseFrom.getText();
				btv = baseTo.getText();
				nf = numberFrom.getText();
					
				bfvInt = Integer.parseInt(bfv);
				btvInt = Integer.parseInt(btv);
				
				r = NumberBase.convert(nf, bfvInt, btvInt);
				result.setText(r);
			}else if(e.getSource()==help) {
				String s = "Hello,\nThis program converts"+"\na number to"+
				"\nanother base";
				JOptionPane.showMessageDialog(help, s);
			}else if(e.getSource()==quit) {
				System.exit(0);
			}
		}
	}
	
	private void setupMenus(){
        options = new JMenu("Options");
        help = new JMenuItem("Help");
        quit = new JMenuItem("Quit");
        options.add(help);
        options.add(quit);
        menu = new JMenuBar();
        setJMenuBar(menu);
        menu.add(options);
    }
	 
	
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class LoginGUI {

	private JFrame login;
	private CardLayout c; 
	private String un = "";		
	private String pw = "";
	private HashMap <String,String> list = new HashMap<>();
	
	public  LoginGUI() {
		
		login = new JFrame();
		
		login.setSize(400,300);
		login.setTitle("Login");
		login.setLocation(200,200);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = new CardLayout();
		
		//holder of the panels
		JPanel cardhold = new JPanel(c);
		
		//create main menu
		JPanel userChoice = new JPanel();
		userChoice.setLayout(new GridBagLayout());
		GridBagConstraints edit = new GridBagConstraints();
		
		//add label
		JLabel title = new JLabel("main menu");
		edit.gridx = 0;
		edit.gridy = 0;
		edit.insets = new Insets(10,0,10,0);
		edit.anchor = GridBagConstraints.CENTER;
		userChoice.add(title,edit);
		
		//add login in button
		JButton logB = new JButton ("Login");
		edit.gridy = 1;
		edit.insets = new Insets(10,0,10,0); //add space to each side (top, left, bottom, right)
		userChoice.add(logB,edit);
		
		//add create account button
		JButton CreateB = new JButton("Create New Account");
		edit.gridy = 2;
		userChoice.add(CreateB,edit);
		
		
		//login panel
		JPanel loginpanel = new JPanel();
		loginpanel.setLayout(new GridBagLayout());
		
		JLabel userLabel = new JLabel("Username");
		edit.gridx = 0;
		edit.gridy = 0;
		edit.insets = new Insets(10,0,10,0);
		edit.anchor = GridBagConstraints.CENTER;
		loginpanel.add(userLabel,edit);
		
		JTextField username = new JTextField(15);
		edit.gridy = 1;
		loginpanel.add(username,edit);
		
		JLabel passwordlabel = new JLabel("Password (max characters is 8)");
		edit.gridy = 2;
		loginpanel.add(passwordlabel,edit);
		
		JTextField password = new JTextField(15);
		edit.gridy = 3;
		loginpanel.add(password,edit);
		
		JButton ops = new JButton("dont have one?");
		edit.gridy = 4;
		loginpanel.add(ops, edit);

		//create panel
		JPanel createpanel = new JPanel();
		createpanel.setLayout(new GridBagLayout());
				
		JLabel newlabel = new JLabel("Create New Account");
		edit.gridx = 0;
		edit.gridy = 0;
		edit.insets = new Insets(10,0,10,0);
		edit.anchor = GridBagConstraints.CENTER;
		createpanel.add(newlabel,edit);
		
		JLabel CreateU = new JLabel("Username");
		edit.gridy = 1;
		createpanel.add(CreateU,edit);
				
		JTextField Cusername = new JTextField(15);
		edit.gridy = 2;
		createpanel.add(Cusername,edit);
				
		JLabel CreatePW = new JLabel("Password (max characters is 8)");
		edit.gridy = 3;
		createpanel.add(CreatePW,edit);
				
		JTextField Cpassword = new JTextField(15);
		edit.gridy = 4;
		createpanel.add(Cpassword,edit);
		
		//add it to panel that holds all the other panels 
		cardhold.add(userChoice,"main menu");
		cardhold.add(loginpanel,"Login");
		cardhold.add(createpanel,"Create account");
		
		//add an action to the button when pressed 
		logB.addActionListener(e -> c.show(cardhold,"Login"));
		CreateB.addActionListener(e -> c.show(cardhold,"Create account"));
		ops.addActionListener(e -> c.show(cardhold, "Create account"));
		
		//function for creating password text field 
		password.addActionListener(e -> {
			un = username.getText().trim();
			pw = password.getText().trim();
			boolean isvalid = true;
			
			if(un.isEmpty()) {
				userLabel.setText("Username (Username can not be empty!)");
				username.setForeground(Color.RED);
				isvalid = false;
			}
			
			if(pw.length() > 8) {
				passwordlabel.setText("Password (max characters is 8)");
				passwordlabel.setForeground(Color.RED);
				isvalid = false;
			}
			
			if(pw.isEmpty()) {
				passwordlabel.setText("Password (Password can not be empty)");
				passwordlabel.setForeground(Color.RED);
				isvalid = false;
			}
			
			if(!list.containsKey(un) && !list.containsValue(pw)) {
				userLabel.setText("Username (the username or password is incorrect)");
				userLabel.setForeground(Color.RED);
				isvalid = false;
			}
				
			if(isvalid == true) {
				userLabel.setText("Username");
				userLabel.setForeground(Color.BLACK);
				passwordlabel.setText("Password (max characters is 8)");
				passwordlabel.setForeground(Color.BLACK);
				username.setText(null);
				password.setText(null);
				c.show(cardhold, "Successful");
				}
		
		});
				
		
		Cpassword.addActionListener(e -> { 
			un = Cusername.getText().trim();
			pw = Cpassword.getText().trim();
			boolean isvalid = true;
			
			if(un.isEmpty()) {
				Cusername.setText("Username (Username can not be empty!)");
				Cusername.setForeground(Color.RED);
				isvalid = false;
			}
			
			if(list.containsKey(un)){
				Cusername.setText("Username (Username is taken)");
				Cusername.setForeground(Color.RED);
				isvalid = false;
			}
			
			if(pw.length() > 8) {
				CreatePW.setText("Password (max characters is 8)");
				CreatePW.setForeground(Color.RED);
				isvalid = false;
			}
			
			if(pw.isEmpty()) {
				CreatePW.setText("Password (Password can not be empty)");
				CreatePW.setForeground(Color.RED);
				isvalid = false;
			}
			
			if(isvalid == true) {
			//stores the password and username
			list.put(un, pw);
			
			//resets everything to normal
			CreateU.setText("Username");
			CreateU.setForeground(Color.BLACK);
			CreatePW.setText("Password (max characters is 8)");
			CreatePW.setForeground(Color.BLACK);
			Cusername.setText(null);
			Cpassword.setText(null);
			c.show(cardhold, "Successful");
			}
		});
		
		//login successful 
		JPanel successful = new JPanel();
		successful.setLayout(new GridBagLayout());
		successful.setBackground(Color.YELLOW);
		JLabel s = new JLabel("Successful!");
		edit.gridx = 0;
		edit.gridy = 0;
		edit.insets = new Insets(10,0,10,0);
		edit.anchor = GridBagConstraints.CENTER;
		successful.add(s,edit);
		JButton back = new JButton("Go Back?");
		edit.gridy = 1;
		edit.insets = new Insets(10,0,10,0);
		edit.anchor = GridBagConstraints.CENTER;
		successful.add(back,edit);
		cardhold.add(successful,"Successful");
		
		back.addActionListener(e -> c.show(cardhold,"main menu"));
		
		login.add(cardhold);
		
		login.setVisible(true);
	}
}

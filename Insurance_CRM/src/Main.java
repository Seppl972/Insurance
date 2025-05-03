package src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {

	//SWING GUI deklarieren
	JFrame frame;
	JTextField textField;
	JButton[] buttonArray = new JButton[6];
	JButton printCustomorButton,searchCustumorButton, addCustumorButton, updateCustumorButton, deleteCustumorButton;

	JPanel panel;

	Font myFont = new Font("Ink Free", Font.BOLD,20);
	Color myBlue = new Color(30, 144, 255); // Dodger Blue

	public Main() {
		//GUI Rahmen erstellen
		frame = new JFrame("Insurance CRM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setBackground(myBlue);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLayout(null);


		//GUI Textfeld erstellen
		textField = new JTextField();
		textField.setSize(200, 200);
		textField.setBounds(50, 25, 400, 50);
		textField.setFont(myFont);
		textField.setEditable(false);
		textField.setBackground(myBlue);

		//GUI Button erstellen
		printCustomorButton = new JButton("Print all Customors in a list");
		searchCustumorButton = new JButton("Search for a Custumor");
		addCustumorButton = new JButton("Add a new Customor");
		updateCustumorButton = new JButton("Update an existing Custumor");
		deleteCustumorButton = new JButton("Delete a Customor from the system");

		//Array für Buttons
		buttonArray[0] = printCustomorButton;
		buttonArray[1] = searchCustumorButton;
		buttonArray[2] = addCustumorButton;
		buttonArray[3] = updateCustumorButton;
		buttonArray[4] = deleteCustumorButton;

		for(int i = 0; i < 5; i++) {
			buttonArray[i].addActionListener((this));
			buttonArray[i].setFont(myFont);
			buttonArray[i].setBackground(myBlue);
			buttonArray[i].setFocusable(false);
		}
		
		//GUI panel ergänzen
		panel = new JPanel();
		panel.setBounds(50, 100, 400, 300);
		panel.setLayout(new GridLayout(7, 1, 10, 10));
		panel.setBackground(myBlue);

		panel.add(buttonArray[0]);
		panel.add(buttonArray[1]);
		panel.add(buttonArray[2]);
		panel.add(buttonArray[3]);
		panel.add(buttonArray[4]);

		//GUI frame
		frame.add(panel);
		frame.add(textField);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    Main CRM = new Main();
                    CRM.setVisible(true);
                });

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Kundenliste ausgeben - wo Daten? Array mit Objekten wieder verwendbar?
		if(e.getSource() == printCustomorButton) {
			
			textField.setText("List of all Custumor");
			//Altes panel entfernen
			panel.removeAll();	
			panel.revalidate();
			panel.repaint();			

			//Enter & Back-Button
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			panel.add(enterButton);
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			panel.add(backButton);
			
			//ActionsListener
			enterButton.addActionListener(l -> {
				//textField.setText("ID: "+searchIDJTextField.getText() +" was not found");
			});
			backButton.addActionListener(l -> {
				Main restart = new Main();
			});
		}

		//Einzelnen Kunden suchen
		if(e.getSource() == searchCustumorButton) {
			textField.setText("Search Customor");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();
			panel.setLayout(new GridLayout(0, 2));
			
			//ID-Suche
			JLabel searchID = new JLabel("ID: ");
			searchID.setFont(myFont);
			panel.add(searchID);
			JTextField searchIDJTextField = new JTextField();
			searchIDJTextField.setFont(myFont);
			panel.add(searchIDJTextField);

			//Name-Suche
			JLabel searchName = new JLabel("Name: ");
			searchName.setFont(myFont);
			panel.add(searchName);
			JTextField searchName2JTextField = new JTextField();
			searchName2JTextField.setFont(myFont);
			panel.add(searchName2JTextField);
			
			//Enter & Back-Button
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			panel.add(backButton);
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			panel.add(enterButton);
			
			//ActionsListener
			enterButton.addActionListener(l -> {
				textField.setText("ID: "+searchIDJTextField.getText() +" was not found");
			});
			backButton.addActionListener(l -> {
				Main restart = new Main();
			});

		}

		//Neuen Benutzer hinzufügen - gerade dabei
		if(e.getSource() == addCustumorButton) {
			JLabel answerLabel;
			
			//textField.setText("Creating new Customor");

			//Alte GUI-panel entfernen			
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			//Gleiches Fenster, desshalb kein "JFrame frame = new JFrame();""
			textField.setText("Create new Customor");
			
			//Buttons, JLabels, JTextFields
			JLabel enterName = new JLabel("Enter name:");
			enterName.setFont(myFont);
			JLabel enterAge = new JLabel("Enter age:");
			enterAge.setFont(myFont);
			JLabel enterPlace = new JLabel("Enter place");
			enterPlace.setFont(myFont);

			JTextField name = new JTextField();
        	name.setFont(myFont);
        	JTextField Age = new JTextField();
        	Age.setFont(myFont);
			JTextField Place = new JTextField();
			Place.setFont(myFont);

			//Enter & Back
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			panel.add(backButton);

			enterButton.addActionListener(l -> {
				int cusCounter = 0;
				cusCounter++;
				textField.setText(name.getText() +" was created succesfully");
			});
			backButton.addActionListener(l -> {
				Main restart = new Main();
			});

			//Gleiches GUI-panel wie bei der Startmaske, deshalb kein "panel = new JPanel();""
			panel.setLayout(new GridLayout(0, 1));
			panel.add(enterName);
			panel.add(name);
			panel.add(enterAge);
			panel.add(Age);
			panel.add(enterPlace);
			panel.add(Place);
			answerLabel = new JLabel("			");
			panel.add(answerLabel);
			panel.add(enterButton);
			panel.add(backButton);
		}

		//Benutzer updaten - leer
		if(e.getSource() == updateCustumorButton) {
			textField.setText("Update an existing Customor");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();

			//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.setLayout((new GridLayout(0, 1)));
			JLabel enterID = new JLabel("Choose ID:");
			enterID.setFont(myFont);
			panel.add(enterID);
			JSpinner ID = new JSpinner(new SpinnerNumberModel(10, 0, 10, 1));
			ID.setFont(myFont);
			panel.add(ID);
			JLabel enterName = new JLabel("Update name:");
			enterName.setFont(myFont);
			JLabel enterAge = new JLabel("Update age:");
			enterAge.setFont(myFont);
			JLabel enterPlace = new JLabel("Update place");
			enterPlace.setFont(myFont);

			JTextField name = new JTextField();
        	name.setFont(myFont);
        	JTextField Age = new JTextField();
        	Age.setFont(myFont);
			JTextField Place = new JTextField();
			Place.setFont(myFont);

			//Enter & Back
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			panel.add(backButton);

			enterButton.addActionListener(l -> {
				int cusCounter = 0;
				cusCounter++;
				textField.setText(name.getText() +" was created succesfully");
			});
			backButton.addActionListener(l -> {
				Main restart = new Main();
			});

			panel.add(enterName);
			panel.add(name);
			panel.add(enterAge);
			panel.add(Age);
			panel.add(enterPlace);
			panel.add(Place);
			JLabel Space = new JLabel("			");
			panel.add(Space);
			panel.add(enterButton);
			panel.add(backButton);

			enterButton.addActionListener(l -> {
				textField.setText(name.getText() +" was updated succesfully");
			});

		}

		//Benutzer löschen - leer
		if(e.getSource() == deleteCustumorButton) {
			textField.setText("Please verify to delete Data!");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();
			panel.setLayout((new GridLayout(0, 2)));

			//Login-Name
			JLabel askUsername = new JLabel("Username: ");
			askUsername.setFont(myFont);
			panel.add(askUsername);
			JTextField getUsername = new JTextField();
			getUsername.setFont(myFont);
			panel.add(getUsername);

			//Login-PW
			JLabel password = new JLabel("Password: ");
			password.setFont(myFont);
			panel.add(password);
			JPasswordField pw = new JPasswordField();
			pw.setFont(myFont);
			panel.add(pw);

			//Enter & Back
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			panel.add(backButton);
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			panel.add(enterButton);
			
			//Actionslistener
			enterButton.addActionListener(l -> {
				
			});
			backButton.addActionListener(l -> {
				Main restart = new Main();
			});

		}

		/*ArrayWert des Buttons ausgeben - wird nicht benötigt aktell
		for(int i=0;i<1;i++) {
			if(e.getSource()==functionButtons[i]) {
				if(e.getSource() == buttonArray[i]) 
					textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}*/

	}

	/*Terminalcode verwendbar für GUI-Anwendung? (=Backend-code?)
	//Startmethode der Terminal-Anwendung
	public static void programmStart() {
				
		//Variablen deklarieren
		boolean software = true;
		int answer;
		//int counter; eventuell einbauen zum zählen (Inkrementieren)
		
		//Eröffnungstext des Startmenüs (wird nach jeder Methode wieder neu angezeigt)
		while (software == true) {
		System.out.println("\nHello Sebastian, I hope you're doing fine. \nHow can I help you?\n");
		System.out.println("1. Print all existing custumor");
		System.out.println("2. Search for an existing custumor");
		System.out.println("3. Add a new custumor");
		System.out.println("4. Update an existing custumor");
		System.out.println("5. Delete an existing custumor");
		System.out.println("6. Delete a custumor field\n");

		//Benutzereingabe über Scanner		
		Scanner scan1 = new Scanner(System.in);
		answer = scan1.nextInt();
		
		//Auswahlmöglichkeiten Kundenprofil
		manageCustumorProfiles(answer);
		}
		
	}
	
	//Auswahlmöglichkeiten der Kundenprofil-Methoden
	public static int manageCustumorProfiles (int answer) {	

		//CustumorService-Methoden werden per switch als Zahl aufgerufen
		switch (answer) {
		case 1: 
			CustomorService.printCustumors();
		case 2: 
			CustomorService.searchCustumor();
			break;
		case 3: 
			CustomorService.addCustumor();	
			break;
		case 4:
			CustomorService.updateCustumor();
			break;
		case 5: 
			CustomorService.deleteCustumor();
			break;
		case 6: 
			CustomorService.resetCustumorField();
			break;
		default: 
			System.out.println("The Exception-method doesnt exist yet!");
			System.out.println("Please type in the right number!");
		}
		return answer;
		
	}*/

}

		
/* todo's'

## 🛠️ Features

- Manage customer profiles (add, update, delete)
	> done, also added the printCustumor(), searchCustumor() and deleteCustumorField() methods
- Basic console-based interface
	> in progress
- Create and manage insurance policies
- Simulate the filing and processing of claims

*/
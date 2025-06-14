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
	JFrame startFrame, dataFrame;
	JPanel startPanel, dataPanel;
	JTextField textField;
	JButton[] buttonArray = new JButton[10];
	JButton printCustomorButton,searchCustumorButton, addCustumorButton, updateCustumorButton;
	JButton deleteCustumorButton, JTableButton, SQLButton;
	Font myFont = new Font("Ink Free", Font.BOLD,20);
	Color myBlue = new Color(30, 144, 255); // Dodger Blue

	public Main() {
		//GUI Rahmen erstellen - 1920x1080
		startFrame = new JFrame("Insurance CRM");
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setSize(1920, 1080);
		startFrame.setBackground(myBlue);
		startFrame.getContentPane().setBackground(Color.BLUE);
		startFrame.setLocationRelativeTo(null);
		startFrame.setResizable(true);
		startFrame.setVisible(true);
		startFrame.setLayout(null);

		//GUI Textfeld erstellen
		textField = new JTextField();
		textField.setSize(200, 200);
		textField.setBounds(750, 225, 400, 50);		//Neu positioniert
		textField.setFont(myFont);
		textField.setEditable(false);
		textField.setBackground(myBlue);

		//GUI Button erstellen
		printCustomorButton = new JButton("Print all Customors in a list");
		searchCustumorButton = new JButton("Search for a Customor");
		addCustumorButton = new JButton("Add a new Customor");
		updateCustumorButton = new JButton("Update an existing Customor");
		deleteCustumorButton = new JButton("Delete a Customor");
		JTableButton = new JButton("Teste JTable");
		SQLButton = new JButton("1.Versuch mit SQL");

		//GUI Buttons in Array speichern
		buttonArray[0] = printCustomorButton;
		buttonArray[1] = searchCustumorButton;
		buttonArray[2] = addCustumorButton;
		buttonArray[3] = updateCustumorButton;
		buttonArray[4] = deleteCustumorButton;
		buttonArray[5] = JTableButton;
		buttonArray[6] = SQLButton;

		//GUI panel erstellen
		startPanel = new JPanel();
		startPanel.setBounds(750, 300, 400, 300);	//Neu positioniert
		startPanel.setLayout(new GridLayout(7, 1, 10, 10));
		startPanel.setBackground(myBlue);

		//Buttons mit Grundfunktionen ausstatten
		for(int i = 0; i < 7; i++) {
			buttonArray[i].addActionListener((this));
			buttonArray[i].setFont(myFont);
			buttonArray[i].setBackground(myBlue);
			buttonArray[i].setFocusable(false);
			//Buttons dem panel hinzufügen
			startPanel.add(buttonArray[i]);
		}

		//GUI frame anzeigen (immer zum Schluss?)
		startFrame.add(startPanel);
		startFrame.add(textField);
		startFrame.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    Main CRM = new Main();
                    CRM.setVisible(true);
                });

	}

	public void showStartGUI() {
		
		//startPanel = new JPanel();
		startPanel.removeAll();	
		startPanel.revalidate();
		startPanel.repaint();
		textField.setText("What do you want to do?");

		for(int i = 0; i < 50; i++) {
			buttonArray[i].addActionListener((this));
			buttonArray[i].setFont(myFont);
			buttonArray[i].setBackground(myBlue);
			buttonArray[i].setFocusable(false);
			//Buttons dem panel hinzufügen
			startPanel.add(buttonArray[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Kundenliste ausgeben - wo Daten? Array mit Objekten wieder verwendbar?
		//Jtable ausgeben - Komplettansicht Datenbank (Soll scrollen durch Benutzerdaten ermöglichen)
		//Mit SQL-Datenbank verbinden (per JDBC)
		if(e.getSource() == printCustomorButton) {
			
			textField.setText("List of all Custumor");
			//Altes panel entfernen
			startPanel.removeAll();	
			startPanel.revalidate();
			startPanel.repaint();		
			
			JTable Data = new JTable();
			Data.setFont(myFont);
			startPanel.add(Data);

			//Enter & Back-Button
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			startPanel.add(enterButton);
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			startPanel.add(backButton);
			
			//ActionsListener
			enterButton.addActionListener(l -> {
				//textField.setText("ID: "+searchIDJTextField.getText() +" was not found");
			});
			backButton.addActionListener(l -> {
				showStartGUI();
			});
		}

		//Einzelnen Kunden suchen
		//Soll durch Eingabe der UserID nur die UserDaten auspucken
		if(e.getSource() == searchCustumorButton) {
			textField.setText("Search Customor");

			startPanel.removeAll();	
			startPanel.revalidate();
			startPanel.repaint();
			startPanel.setLayout(new GridLayout(0, 1));
			
			//ID-Suche
			JLabel searchID = new JLabel("Please type in the Aktenzeichen: ");
			searchID.setFont(myFont);
			startPanel.add(searchID);
			JTextField searchIDJTextField = new JTextField();
			searchIDJTextField.setFont(myFont);
			startPanel.add(searchIDJTextField);
			
			//Enter & Back-Button
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			startPanel.add(enterButton);
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			startPanel.add(backButton);
			
			//ActionsListener
			enterButton.addActionListener(l -> {
				textField.setText("ID: "+searchIDJTextField.getText() +" was not found");
			});
			backButton.addActionListener(l -> {
				showStartGUI();
			});

		}

		//Neuen Benutzer hinzufügen - gerade dabei (mit JTextField)
		//Erstellte User sollen in JTable gespeichert werden nach dem Erstellen
		//Später JTableTabelle mit SQL verbinden
		if(e.getSource() == addCustumorButton) {
			JLabel answerLabel;
			
			//textField.setText("Creating new Customor");

			//Alte GUI-panel entfernen			
			startPanel.removeAll();
			startPanel.revalidate();
			startPanel.repaint();
			
			//Gleiches Fenster, desshalb kein "JFrame frame = new JFrame();""
			textField.setText("Create new Customor");
			
			//Buttons, JLabels, JTextFields
			JLabel enterName = new JLabel("Enter full name:");
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
			startPanel.add(backButton);

			enterButton.addActionListener(l -> {
				int cusCounter = 0;
				cusCounter++;
				textField.setText(name.getText() +" was created succesfully");
			});
			backButton.addActionListener(l -> {
				showStartGUI();
			});

			//Gleiches GUI-panel wie bei der Startmaske, deshalb kein "panel = new JPanel();""
			startPanel.setLayout(new GridLayout(0, 1));
			startPanel.add(enterName);
			startPanel.add(name);
			startPanel.add(enterAge);
			startPanel.add(Age);
			startPanel.add(enterPlace);
			startPanel.add(Place);
			answerLabel = new JLabel("			");
			startPanel.add(answerLabel);
			startPanel.add(enterButton);
			startPanel.add(backButton);
		}

		//Benutzer updaten - leer
		if(e.getSource() == updateCustumorButton) {
			textField.setText("Update an existing Customor");

			startPanel.removeAll();	
			startPanel.revalidate();
			startPanel.repaint();

			//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			startPanel.setLayout((new GridLayout(0, 1)));
			JLabel enterID = new JLabel("Choose ID:");
			enterID.setFont(myFont);
			JSpinner ID = new JSpinner(new SpinnerNumberModel(10, 0, 10, 1));
			ID.setFont(myFont);
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
			startPanel.add(backButton);

			enterButton.addActionListener(l -> {
				int cusCounter = 0;
				cusCounter++;
				textField.setText(name.getText() +" was updated succesfully");
			});
			backButton.addActionListener(l -> {
				showStartGUI();
			});

			startPanel.add(enterID);
			startPanel.add(ID);
			startPanel.add(enterName);
			startPanel.add(name);
			startPanel.add(enterAge);
			startPanel.add(Age);
			startPanel.add(enterPlace);
			startPanel.add(Place);
			JLabel Space = new JLabel("			");
			startPanel.add(Space);
			startPanel.add(enterButton);
			startPanel.add(backButton);

			enterButton.addActionListener(l -> {
				textField.setText(name.getText() +" was updated succesfully");
			});

		}

		//Benutzer löschen - (Zuerst eine Anmeldemaske)
		//User aus JTable-Tabelle entfernen
		if(e.getSource() == deleteCustumorButton) {
			textField.setText("Please verify to delete Data!");

			startPanel.removeAll();	
			startPanel.revalidate();
			startPanel.repaint();

			//Login-Name
			JLabel askUsername = new JLabel("Username: ");
			askUsername.setFont(myFont);
			startPanel.add(askUsername);
			JTextField getUsername = new JTextField();
			getUsername.setFont(myFont);
			startPanel.add(getUsername);

			//Login-PW
			JLabel password = new JLabel("Password: ");
			password.setFont(myFont);
			startPanel.add(password);
			JPasswordField pw = new JPasswordField();
			pw.setFont(myFont);
			startPanel.add(pw);

			//Enter & Back
			JButton enterButton = new JButton("enter");
			enterButton.setFont(myFont);
			startPanel.add(enterButton);
			JButton backButton = new JButton("back");
			backButton.setFont(myFont);
			startPanel.add(backButton);
			
			//Actionslistener
			enterButton.addActionListener(l -> {
				
			});
			backButton.addActionListener(l -> {
				showStartGUI();
			});

		}

		//Erster JTable-Versuch - 2d Array
		if(e.getSource() == JTableButton) {

				
			// Spaltentitel
			String[] title = new String[]{
				"First Name", "Last Name", "Age", "Place"
			};
		
			// Die Daten für das Table
			String[][] data = new String[][]{
				{"Sebastian", "Lindner", "23", "Java"},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				
			};

			// Das JTable initialisieren
			JTable table = new JTable( data, title );
		
			JFrame dataFrame = new JFrame( "Customor data" );
			dataFrame.getContentPane().add( new JScrollPane( table ) );

			dataFrame.pack();
			dataFrame.setSize(800, 200);
			dataFrame.setLocationRelativeTo(null);
			dataFrame.setVisible( true );
	}
				
		
		/*ArrayWert des Buttons ausgeben - wird nicht benötigt aktell
		for(int i=0;i<1;i++) {
			if(e.getSource()==functionButtons[i]) {
				if(e.getSource() == buttonArray[i]) 
					textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}*/

	}

	

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
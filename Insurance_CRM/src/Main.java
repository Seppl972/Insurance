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
	JButton[] functionButtons = new JButton[1];
	JButton printCustomorButton,searchCustumorButton, addCustumorButton, updateCustumorButton, deleteCustumorButton, resetCustumorFieldButton;
	JButton delButton;

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
		resetCustumorFieldButton = new JButton("Reset a field vom a customor");
		delButton = new JButton("delete");

		buttonArray[0] = printCustomorButton;
		buttonArray[1] = searchCustumorButton;
		buttonArray[2] = addCustumorButton;
		buttonArray[3] = updateCustumorButton;
		buttonArray[4] = deleteCustumorButton;
		buttonArray[5] = resetCustumorFieldButton;

		functionButtons[0] = delButton;
	
		for(int i = 0; i < 1; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setBackground(myBlue);
			functionButtons[i].setFocusable(false);
		}

		for(int i = 0; i < 6; i++) {
			buttonArray[i].addActionListener((this));
			buttonArray[i].setFont(myFont);
			buttonArray[i].setBackground(myBlue);
			buttonArray[i].setFocusable(false);
		}

		//delButton.setBounds(250, 430, 100, 50);
		
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
		panel.add(buttonArray[5]);

		panel.add(functionButtons[0]);

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

		//Kundenliste ausgeben
		if(e.getSource() == printCustomorButton) {
			textField.setText("List of all Custumor");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();
		}

		//Einzelnen Kunden suchen
		if(e.getSource() == searchCustumorButton) {
			textField.setText("Which Customor u want to print?");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();

		}

		//Neuen Benutzer hinzufügen - gerade dabei
		if(e.getSource() == addCustumorButton) {
			JLabel answerLabel;
			
			textField.setText("Creating new Customor");

			//Alte GUI-panel entfernen			
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			//Gleiches Fenster, desshalb kein "JFrame frame = new JFrame();""
			
			//Buttons, JLabels, JTextFields
			JButton button = new JButton("enter");
			button.addActionListener(this);

			JLabel label = new JLabel("How to create a new Customor:");
			label.setFont(myFont);

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

			//Gleiches GUI-panel wie bei der Startmaske, deshalb kein "panel = new JPanel();""
			panel.setLayout(new GridLayout(0, 1));
			panel.add(label);
			panel.add(enterName);
			panel.add(name);
			panel.add(enterAge);
			panel.add(Age);
			panel.add(enterPlace);
			panel.add(Place);
			answerLabel = new JLabel("			");
			panel.add(answerLabel);
			panel.add(button);

			frame.add(panel);
			frame.setSize(450, 450);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Titel des Frames");
			frame.setVisible(true);
			frame.setResizable(false);


		}

		//Benutzer updaten - leer
		if(e.getSource() == updateCustumorButton) {
			textField.setText("Update an existing Customor");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();

		}

		//Benutzer löschen - leer
		if(e.getSource() == deleteCustumorButton) {
			textField.setText("Delete an existing Customor");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();

		}

		//Benutzerfeld zurücksetzen - leer
		if(e.getSource() == resetCustumorFieldButton) {
			textField.setText("Reset a Customor field");

			panel.removeAll();	
			panel.revalidate();
			panel.repaint();

		}

		//Eingabefeld zurücksetzen - funktioniert nicht mehr
		if(e.getSource()==delButton) {
			textField.setText("");
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
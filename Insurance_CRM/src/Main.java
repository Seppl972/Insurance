import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame.*;
import javax.swing.*;

//GUI bauen, schwieriger als gedacht
 
public class Main extends JFrame {

	public Main() {
		setTitle("Unsere GUI");
		setSize(1920, 1080);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Container
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Main m = new Main();
				m.setVisible(true);
				//programmStart();
			}
		});
	}

	//Startmaske der Anwendung
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
		
	}

    private static void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
		
/* todo's'

## 🛠️ Features

- Manage customer profiles (add, update, delete)
	> done, also added the printCustumor(), searchCustumor() and deleteCustumorField() methods
- Create and manage insurance policies
- Simulate the filing and processing of claims
- Basic console-based interface

*/
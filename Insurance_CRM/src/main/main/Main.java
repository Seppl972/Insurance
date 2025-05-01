package main;

import java.util.Scanner;
import services.CustomorService;
 
public class Main {

	public static void main(String[] args) {

			programmStart();
				
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

}
		
/* todo's'

## 🛠️ Features

- Manage customer profiles (add, update, delete)
	> done, also added the printCustumor(), searchCustumor() and deleteCustumorField() methods
- Create and manage insurance policies
- Simulate the filing and processing of claims
- Basic console-based interface

*/
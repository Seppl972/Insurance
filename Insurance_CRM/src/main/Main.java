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
		System.out.println("0. Search for an existing custumor");
		System.out.println("1. Add a new custumor");
		System.out.println("2. Update an existing custumor");
		System.out.println("3. Delete an existing custumor\n");

		//Benutzereingabe über Scanner		
		Scanner scan1 = new Scanner(System.in);
		answer = scan1.nextInt();

		//Auswahlmöglichkeiten Kundenprofil
		manageCustumorProfiles(answer);
		}
		
	}
		
	//Auswahlmöglichkeiten der Kundenprofil-Methoden
	public static void manageCustumorProfiles (int answer) {	

		//CustumorService-Methoden werden per switch als Zahl aufgerufen
		switch (answer) {
		case 0: 
			CustomorService.searchCustumor();
			break;
		case 1: 
			CustomorService.addCustumor();	
			break;
		case 2:
			CustomorService.updateCustumor();
			break;
		case 3: 
			CustomorService.deleteCustumor();
			break;
		default: 
			System.out.println("The Exception-method doesnt exist yet!");
			System.out.println("Please type in the right number!");
		}
		
	}

}
		
/* todo's'

## 🛠️ Features

- Manage customer profiles (add, update, delete)
- Create and manage insurance policies
- Simulate the filing and processing of claims
- Basic console-based interface

*/
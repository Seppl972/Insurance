package main;

import java.util.Scanner;
import services.CustomorService;
 
public class Main {

	public static void main(String[] args) {

			programmStart();
				
	}

	//Startmaske
	public static void programmStart() {
		
		//Variablen deklarieren
		boolean software = true;
		int answer;
		//int counter; eventuell einbauen zum zählen (Inkrementieren)
		
		while (software == true) {
		//Eröffnungstext
		System.out.println("\nHello Sebastian, I hope you're doing fine. \nHow can I help you?\n");
		System.out.println("0. Search for an existing customor");
		System.out.println("1. Add a new customor");
		System.out.println("2. Update an existing custumor");
		System.out.println("3. Delete an existing customor\n");

		//Benutzereingabe über Scanner		
		Scanner scan1 = new Scanner(System.in);
		answer = scan1.nextInt();

		//Auswahlmöglichkeiten Kundenprofil
		manageCustumorProfiles(answer);
		}
		
	}
		
	//Auswahlmöglichkeiten Kundenprofil
	public static void manageCustumorProfiles (int answer) {	

		//Switch einbauen? 
		if (answer == 0) {
			CustomorService.searchCustumor();
		}
		else if (answer == 1) {
			CustomorService.addCustumor();
		}
		/*else if (answer == 2) {
			updateCustumor();
		}*/
		else if (answer == 3) {
			CustomorService.deleteCustumor();
		}
		else {
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
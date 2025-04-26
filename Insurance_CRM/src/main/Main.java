package main;

import java.util.Scanner;
import models.Custumor;
 

public class Main extends Custumor {

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
		System.out.println("\nHello Sebastian, i hope you're doing fine today. \nWhat do you want to do?\n");
		System.out.println("0. Search for an customor \n1. Add a new customor \n2. Update a custumor \n3. Delete a customor");

		//Benutzereingabe über Scanner		
		Scanner scan1 = new Scanner(System.in);
		answer = scan1.nextInt();

		//Auswahlmöglichkeiten
		optionchose(answer);
		}
		
	}
		
	//Auswahlmöglichkeiten
	public static void optionchose(int answer) {	
		if (answer == 0) {
			searchCustumor();
		}
		else if (answer == 1) {
			addCustumor();
		}
		else if (answer == 2) {
			updateCustumor();
		}
		else if (answer == 3) {
			deleteCustumor();
		}
		else if (answer == 4) {
			System.out.println("Not ready yet!");
		}
		else if (answer == 5) {
			System.out.println("Not ready yet!");
		}
		else {
			System.out.println(" This method doesnt exist!\n");
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
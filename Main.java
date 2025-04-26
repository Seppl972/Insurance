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
		String name;
	
		while (software == true) {
		//Eröffnungstext
		System.out.println("Hello Sebastian, what do you want to do?");
		System.out.println("1. Add a new customor \n2. Update a custumor \n3. Delete a customor");

		//Benutzereingabe über Scanner		
		Scanner scan1 = new Scanner(System.in);
		answer = scan1.nextInt();
		
		//Auswahlmöglichkeiten
		optionchose(answer);	
		}
		
	}
		
		//Auswahlmöglichkeiten
	public static void optionchose(int answer) {	
		if (answer == 1) {
			addCustumor();
		}
		else if (answer == 2) {
			updateCustumor();
		}
		else if (answer == 3) {
			deleteCustumor();
		}
		
		/*Ausnahmen
		else {
			System.out.println("Choose the right option again!");
			System.out.println("Sers");
		optionchose();
		}*/
	} 
	
}
		
/* todo's'

## 🛠️ Features

- Manage customer profiles (add, update, delete)
- Create and manage insurance policies
- Simulate the filing and processing of claims
- Basic console-based interface

*/
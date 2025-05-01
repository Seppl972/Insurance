package src.services;

import java.util.Scanner;

import src.Main.*;
import src.models.Customor;

//Klasse CustumorService ist aktuell auf Terminal-Anwendung spezialisiert
//Mal schauen inwiefern sich die Methoden migrieren lassen in die neue GUI-Anwendung
public class CustomorService extends Customor{

	public static int inputId;
	static int arraycounter = 0;
	
	//Arrays in progress
	public static Customor[] users = new Customor[9];

	//Methode zum Array-Stelle-x ausgeben
	public static void arrayAusgeben(int arrayStelle) {
		System.out.println("ID: "+users[arrayStelle].id);
		System.out.println("Name: "+users[arrayStelle].name);
		System.out.println("Age: "+users[arrayStelle].age);
		System.out.println("Place: "+users[arrayStelle].place);
	}

	//Methode - print All Custumors
	public static void printCustumors() {

		System.out.println("The following Users are registered in the system:");
		
		if (arraycounter == 0) {
			System.out.println("There are no Custumors in the database.");
		}
		for (int i = 0; i < arraycounter; i++) {
			System.out.println("UserID: " + users[i].id + " - " + users[i].name);
		} 
		Main.programmStart();

	}
	
	//Methode greift nicht auf die geupdateten Wert zu
	//Methode zum suchen einer ID im Objekt-Array (mithilfe des inkrementierten arrayounters)
	public static void searchCustumor() {

		//Nachfrage nach bestehender Id
		System.out.println("\nPlease give me a CustumorID:\n");
		//Speicherung der Eingabe Id mithilfe eines Scanners (Optional BufferedReader einbauen)
		Scanner oldid = new Scanner(System.in);
		inputId = oldid.nextInt();
		//Ausgabe der arrayStelle anhand der ID (mithilfe des arrayounters)
		if (inputId <= arraycounter) {
			System.out.println("The following user was found!");	
			arrayAusgeben(inputId-1);
		} else {
			System.out.println("UserID wasn't found in the array!");	
		} 

	}
	
	//Methode zum hinzufügen eines neuen Kunden - zurüücks einfügen
	public static void addCustumor() {
	
		//Userbestand anzeigen (mithilfe des arrayounters)
		System.out.println("\nThe following ID's are already used in the system!");
		if (arraycounter == 0) {
			System.out.println("There are no users in the system yet!");
		} else {
			for (int i = 0; i < arraycounter; i++) {
				System.out.print(users[i].id + ", ");
			}
		}

		//addID
		int newid = arraycounter + 1;
		System.out.println("\n" + newid + " is the next free ID!");
		System.out.println(newid + " will be used for the newCustumorId.");

		//addName
		System.out.println("\nWhat is his name?");
		Scanner newname = new Scanner(System.in);
		String inputName = newname.nextLine();

		//addAge
		System.out.println("\nWhat is his age?");
		Scanner newage = new Scanner(System.in);
		int inputAge = newage.nextInt();

		//addPlace
		System.out.println("\nWhat is his place?");
		Scanner newplace = new Scanner(System.in);
		String inputPlace = newplace.nextLine();
		System.out.println();

		//neues Objekt Custumor erzeugen (neues Objekt wird i.V.m. Konstruktor autom. ausgegeben)
		Customor newCustumor = new Customor(newid, inputName, inputAge, inputPlace);

		//neues Objekt im Array speichern, fängt bei Stelle 0 (inkrementiert mithilfe des arrayounters)
		users[arraycounter] = newCustumor;
		arraycounter++;		
		System.out.println("User " + arraycounter + " has been created succesfully!");
		
	}

	//Methode zur Benutzeraktualisierung einzelner Datenfelder/Array>Objekten>Variablen)
	public static void updateCustumor() {
		System.out.println("\nWhich Custumor do you want to update?");

		//Speicherung der Eingabe Id
		Scanner consistingId = new Scanner(System.in);
		int inputId = consistingId.nextInt();

		//Änderungsmöglichkeiten
		if (inputId <= arraycounter) {
			System.out.println("\nUser "+inputId+" was found in the System!");	
			arrayAusgeben(inputId-1);
			System.out.println("\nWhat do you want to change? \nPlease press one of the following keys!");
			System.out.println("1. ID");
			System.out.println("2. Name");
			System.out.println("3. Age");
			System.out.println("4. Place");
			System.out.println("5. Back");

		} else {
			System.out.println("The UsedID doesn't exist!");	
		} 

		Scanner updateCustumorScanner = new Scanner(System.in);
		int updateCustumorField = updateCustumorScanner.nextInt();

		switch(updateCustumorField) {
			case 1: //UserId updaten
				//Funktioniert nicht richtig wegen arrayAusgeben-Methode
				System.out.println("\nWhat should be the new ID?");
				Scanner updateUserId = new Scanner(System.in);
				int updateUserFieldId = updateUserId.nextInt();
				System.out.println("\nOldID: "+inputId);
				users[inputId-1].id = updateUserFieldId;
				System.out.println("NewID: "+updateUserFieldId);
				System.out.println("UserID was changed succesfully!");
				break;
			case 2: //Name updaten
				//Ändert den Namen im Dialog und im Datenbestand?
				System.out.println("\nWhat should be the new name?");
				Scanner updateUserName = new Scanner(System.in);
				String updateUserFieldName = updateUserName.nextLine();
				System.out.println("\nOldName: "+users[inputId-1].name);
				users[inputId-1].name = updateUserFieldName;
				System.out.println("NewName: "+updateUserFieldName);
				System.out.println("Name was changed succesfully!");
				break;
			case 3: //Age updaten
				//Ändert Alter im Dialog und im Datenbestand
				System.out.println("\nWhat should be the new age?");
				Scanner updateUserAge = new Scanner(System.in);
				int updateUserFieldAge = updateUserAge.nextInt();
				System.out.println("\nOldAge: "+users[inputId-1].age);
				users[inputId-1].age = updateUserFieldAge;
				System.out.println("NewAge: "+updateUserFieldAge);
				System.out.println("Age was changed succesfully!");
				break;
			case 4: //Place updaten
				System.out.println("\nWhat should be the new place?");
				Scanner updateUserPlace = new Scanner(System.in);
				String updateUserFieldPlace = updateUserPlace.nextLine();
				System.out.println("\nOldPlace: "+users[inputId-1].place);
				users[inputId-1].place = updateUserFieldPlace;
				System.out.println("NewAge: "+updateUserFieldPlace);
				System.out.println("Place was changed succesfully!");
				break;
			case 5: //Zurück zum Startmenü
				Main.programmStart();
		}

	}
	
	//Methode zur Benutzerlöschung - Objekt aus array entfernen?
	public static void deleteCustumor() {
		System.out.println("\nWhich Customor do you want to delete?");
		
		//Benutzereingabe
		Scanner deleteUser = new Scanner(System.in);
		int deletedUserArray = deleteUser.nextInt();
			
		//Verweis auf array basteln
		users[deletedUserArray-1].id = 0;
		users[deletedUserArray-1].name = " ";
		users[deletedUserArray-1].age = 0;
		users[deletedUserArray-1].place = " ";
		System.out.println("\nUser: "+deletedUserArray + " has been deleted from the system succesfully!");
		Main.programmStart();
	}

	//Methode zum zurücksetzen einzelner Kundenfelder
	public static void resetCustumorField() { 
		
		//Kundensuche
		System.out.println("From which customor u want to delete a field?");
		Scanner searchCustumorScanner = new Scanner(System.in);
		int searchCustumorField = searchCustumorScanner.nextInt();
		arrayAusgeben(searchCustumorField-1);

		if (searchCustumorField == 0) {
			System.out.println("UserID wasn't found in the array!");	
		} else {
					
			System.out.println("\nCustumor: "+searchCustumorField+" was found!");	
			System.out.println("Which field do u wanted to reset?");	
			System.out.println("1. ID");
			System.out.println("2. Name");
			System.out.println("3. Age");
			System.out.println("4. Place");
			System.out.println("5. Back\n");
		}

			//Speicherung der Eingabe
			Scanner resetCustumorScanner = new Scanner(System.in);
			int resetCustumorField = resetCustumorScanner.nextInt();

			switch(resetCustumorField) {
				case 1: //UserId zurücksetzen
					System.out.println("\nOldID: "+users[searchCustumorField-1].id);
					users[searchCustumorField-1].id = 0;
					System.out.println("UserID was reseted succesfully!");
				break;
				case 2: //Name zurücksetzen
					System.out.println("\nOldName: "+users[searchCustumorField-1].name);
					users[searchCustumorField-1].name = " ";
					System.out.println("Name was reseted succesfully!");
				break;
				case 3: //Age zurücksetzen
					//Ändert Alter im Dialog und im Datenbestand
					System.out.println("\nOldAge: "+users[searchCustumorField-1].age);
					users[searchCustumorField-1].age = 0;
					System.out.println("Age was reseted succesfully!");
				break;
				case 4: //Place zurücksetzen 
					System.out.println("\nOldPlace: "+users[searchCustumorField-1].place);
					users[searchCustumorField-1].place = "  ";
					System.out.println("Place was reseted succesfully!");
				break;
				case 5: //Zurück zum Startmenü
					Main.programmStart();
			}
		} 

	}
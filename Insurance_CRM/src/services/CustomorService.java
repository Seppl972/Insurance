package services;

import java.util.Scanner;
import main.Main; //import static main.Main.programmStart;
import models.Customor;

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
	
	//Methode zum hinzufügen eines neuen Kunden - fertig
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
			System.out.println("0. ID");
			System.out.println("1. Name");
			System.out.println("2. Age");
			System.out.println("3. Place");
			System.out.println("4. Back");

		} else {
			System.out.println("The UsedID doesn't exist!");	
		} 

		Scanner updateUser = new Scanner(System.in);
		int updateUserField = updateUser.nextInt();

		switch(updateUserField) {
			case 0: //UserId updaten
				//Funktioniert nicht richtig wegen arrayAusgeben-Methode
				System.out.println("\nWhat should be the new ID?");
				Scanner updateUserId = new Scanner(System.in);
				int updateUserFieldId = updateUserId.nextInt();
				System.out.println("\nOldID: "+inputId);
				users[inputId-1].id = updateUserFieldId;
				System.out.println("NewID: "+updateUserFieldId);
				System.out.println("UserID was changed succesfully!");
				break;
			case 1: //Name updaten
				//Ändert den Namen im Dialog und im Datenbestand?
				System.out.println("\nWhat should be the new name?");
				Scanner updateUserName = new Scanner(System.in);
				String updateUserFieldName = updateUserName.nextLine();
				System.out.println("\nOldName: "+users[inputId-1].name);
				users[inputId-1].name = updateUserFieldName;
				System.out.println("NewName: "+updateUserFieldName);
				System.out.println("Name was changed succesfully!");
				break;
			case 2: //Age updaten
				//Ändert Alter im Dialog und im Datenbestand
				System.out.println("\nWhat should be the new age?");
				Scanner updateUserAge = new Scanner(System.in);
				int updateUserFieldAge = updateUserAge.nextInt();
				System.out.println("\nOldAge: "+users[inputId-1].age);
				users[inputId-1].age = updateUserFieldAge;
				System.out.println("NewAge: "+updateUserFieldAge);
				System.out.println("Age was changed succesfully!");
				break;
			case 3: //Place updaten
				System.out.println("\nWhat should be the new place?");
				Scanner updateUserPlace = new Scanner(System.in);
				String updateUserFieldPlace = updateUserPlace.nextLine();
				System.out.println("\nOldPlace: "+users[inputId-1].place);
				users[inputId-1].place = updateUserFieldPlace;
				System.out.println("NewAge: "+updateUserFieldPlace);
				System.out.println("Place was changed succesfully!");
				break;
			case 4: //Zurück
				Main.programmStart();

		}

	}
	
	//Methode zur Benutzerlöschung - Objekt aus array entfernen?
	public static void deleteCustumor() {
		System.out.println("\nWhich Custumor do you want to delete?");
			
		Scanner deleteId = new Scanner(System.in);
		int deletedId = deleteId.nextInt();
			
		//Verweis auf array basteln
		System.out.println(deletedId + " has been succesfully deleted from the system!\n");
	}

}
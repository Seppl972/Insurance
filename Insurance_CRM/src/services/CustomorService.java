package services;

import java.util.Scanner;
import models.Customor;

public class CustomorService {

	public static String name;
	static int arraycounter = 0;
	
	//Arrays in progress
	public static int [] arrayCustumorId = {};
	public static Customor[] users = new Customor[9];

	//Methode zum suchen einer ID in einfachen int Strings {1, 2, 3,..}
	public static void searchCustumor() {
	
		//Variablen deklarieren
		int inputId;
		//Nachfrage nach bestehender Id
		System.out.println("\nPlease give me the CustumorID:\n");
		//Speicherung der Eingabe Id
		Scanner oldid = new Scanner(System.in);
		inputId = oldid.nextInt();
		
		//In basic_array nachsehen mit for-Schleife
		boolean cusExist = false;
		for (int id : arrayCustumorId) {
			if (inputId == id) {
				cusExist = true;
				break; //Sobald die Zahl gefunden ist Schleife beenden
			}
		}
		//Textausgabe User, wenn ID gefunden
		if (cusExist) {
			System.out.println(inputId + " was found in the array!");
			System.out.println("ID: "+users[0].id);
			System.out.println("Name: "+users[0].name);
			System.out.println("Age: "+users[0].age);
			System.out.println("Place: "+users[0].place);

		} else {
			System.out.println(inputId + " is no valid CustumorID!");
		}
	}

	//Methode zum Array-Stelle-x ausgeben
	public static void arrayAusgeben(int arrayStelle) {
		System.out.println("ID: "+users[arrayStelle].id);
		System.out.println("Name: "+users[arrayStelle].name);
		System.out.println("Age: "+users[arrayStelle].age);
		System.out.println("Place: "+users[arrayStelle].place);
	}

	//Methode zum hinzufügen eines Kunden - funktioniert mit neuem Konstruktor!!
	public static void addCustumor() {
	
		//addID
		System.out.println("\nThe following ID's are already used in the system!");
		for (int i = 0; i < arrayCustumorId.length; i++) {
		System.out.print(arrayCustumorId[i] + ", ");
		}
		int newid = arrayCustumorId.length + 1;
		System.out.println("\n\n" + newid + " is the next free ID!");
		System.out.println(newid + " will be used for the newCustumorId.");

		//addName
		System.out.println("\nWhat is his name?\n");
		Scanner newname = new Scanner(System.in);
		String inputName = newname.nextLine();

		//addAge
		System.out.println("\nWhat is his age?\n");
		Scanner newage = new Scanner(System.in);
		int inputAge = newage.nextInt();

		//addPlace
		System.out.println("\nWhat is his place?\n");
		Scanner newplace = new Scanner(System.in);
		String inputPlace = newplace.nextLine();
		System.out.println();

		//Objekt Custumor erzeugen (wird ausgegeben)
		Customor newCustumor = new Customor(newid, inputName, inputAge, inputPlace);

		//Objekt im Array speichern, fängt bei Stelle 0 an
		//for (int i = 0; i < users.length; i++) {
		users[arraycounter] = newCustumor;
		arrayAusgeben(arraycounter); //zum Testen doppelt ausgeben
		
		System.out.println("User has been created succesfully!");
		
	}

	//Methode zur Benutzeraktualisierung - nicht fertig - (Umfangreich, ggfs. nur einzelne Sachen updaten?)
	/*public static void updateCustumor() {
	int update;
	String updatedname;
	int updatedage;
	String updatedplace;
	String deletedname;
			
	//String updatedaccident;
	//Double updatedpension;
	
	//Nachfrage zum aktualisieren (Erstmal ohne Speicherung den eigenen Daten in z.B. Arrays
	//Später Speicherung in JDBC vorstellbar
	System.out.println("\nWhat do you want to update?");
	System.out.println("Please choose between:");
	System.out.println("0. id");
	System.out.println("1. name");
	System.out.println("2. age");
	System.out.println("3. place");
	System.out.println("4. accident");
	System.out.println("5. pension\n");
	Scanner newupdate = new Scanner(System.in);
	update = newupdate.nextInt();
	
	if (update == 0) {
		updateId();
	}
	else if (update == 1) {
		updateName();
	}
	else if (update == 2){
		updateAge();
	}
	else if (update == 3) {
		updatePlace();
	}
	//4. boolean accident
	//5. double pension
	}	
	
		public static void updateId() {
			System.out.println("Methode noch nicht fertig");
		}

		public static void updateName() {
			Custumor One = new Custumor();
			System.out.println("\nPlease type in the new name!");
	
			Scanner newupdate = new Scanner(System.in);
			name = newupdate.nextLine();
	
			System.out.println(name + " is now the new Name!\n");
		}		
	
		public static void updateAge() {
			Custumor One = new Custumor();
			System.out.println("Please type in the new age!");
	
			Scanner updatedage = new Scanner(System.in);
			One.age = updatedage.nextInt();
	
			System.out.println(One.age + " is now the new age!\n");
		}
	
		public static void updatePlace() {
			Custumor One = new Custumor();
			System.out.println("Please type in the new place!");
	
		Scanner updatedplace= new Scanner(System.in);
		One.place = updatedplace.nextLine();
	
		System.out.println(One.place + " is now the new place!\n");
		}
		//Update 4. accident ergänzen
		//Update 5. pension ergänzen
		*/
	
	//Methode zur Benutzerlöschung - Verweis auf arrayCustumorId fehlt
	public static void deleteCustumor() {
		System.out.println("\nWhich Custumor do you want to delete?");
			
		Scanner deleteId = new Scanner(System.in);
		int deletedId = deleteId.nextInt();
			
		//Verweis auf array basteln
		System.out.println(deletedId + " has been succesfully deleted from the system!\n");
	}

}
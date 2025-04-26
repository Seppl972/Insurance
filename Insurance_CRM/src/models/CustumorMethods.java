package models;

import java.util.Scanner;

public class CustumorMethods {

	public static String name;
	
	//Methoden zum hinzufügen
	public static void addCustumor() {
		Custumor One = new Custumor();
	
		//Nachfrage Name
		System.out.println("Okay, so you want to add a new cusumor. \nWhat is his name?");
	
		//Speicherung des Namen
		Scanner newname = new Scanner(System.in);
		name = newname.nextLine();
		One.setName();
		One.getName();
		System.out.println(name + " has been added to the register!\n");
	}
	
	//Methoden zur Benutzeraktualisierung
	public static void updateCustumor() {
		int update;
		String updatedname;
		int updatedage;
		String updatedplace;
		String deletedname;
				
		//String updatedaccident;
		//Double updatedpension;
		
		//Nachfrage zum aktualisieren (Erstmal ohne Speicherung den eigenen Daten in z.B. Arrays
		//Später Speicherung in JDBC vorstellbar
		System.out.println("What do you want to update?");
		System.out.println("Please choose between:");
		System.out.println("1. name");
		System.out.println("2. age");
		System.out.println("3. place");
		System.out.println("4. accident");
		System.out.println("5. pension\n");

		Scanner newupdate = new Scanner(System.in);
		update = newupdate.nextInt();
		
		if (update == 1) {
			updateName();
		}
		else if (update == 2){
			updateAge();
		}
		else if (update == 3) {
			updatePlace();
		}
	}	
		
	public static void updateName() {
		Custumor One = new Custumor();
		System.out.println("Please type in the new name!");
		
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
	//Update accident ergänzen
	//Update pension ergänzen
		
	public static void deleteCustumor() {
		System.out.println("Which Custumor do you want to delete?");
		
		Scanner deletedname = new Scanner(System.in);
		name = deletedname.nextLine();
		
		System.out.println(name + " has been deleted from the system!\n");
	}
	
}
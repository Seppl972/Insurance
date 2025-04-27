package models;


// versuchen die Klassen übersichtlich zu halten!
public class Customor {

	// Variablen deklarieren //static entfernt
	public int id;
	public String name;
	public int age;
	public String place;
	//private boolean accident;
	//private Double pension;
	
	//Konstruktoren
	public Customor () {
		System.out.println("Leerer Konstruktor");
	}
	public Customor (int id, String name, int age, String place) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.place = place;
		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Place: "+place);
	}

	// Getter & Setter
	// id
	public int getId() {
		return id;
	}
	public int setId() {
		this.id = id;
		return id;
	}

	// name
	public String getName() {
		return name;
	}
	public String setName() {
		this.name = name;
		return name;
	}
	
	// age
	public int getAge() {
		return age;
	}
	public int setAge() {
		this.age =  age;
		return age;	
	}
	
	// place
	public String getPlace() {
		return place;
	}
	public String setPlace() {
		this.place = place;
		return place;
	}
	
	/*accident
	Boolean getAccident() {
		return accident;
	}
	Boolean setAccident() {
		this.accident = accident;
		return accident;
	}*/
	
	/*pension
	Double getPension() {
		return pension;
	}
	Double setPension() {
		this.pension = pension;
		return pension;
	}*/

}
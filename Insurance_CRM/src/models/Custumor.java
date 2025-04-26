package models;

public class Custumor extends CustumorMethods {

	//Variablen deklarieren
	int [] arrayCustumors;
	public int id;
	public static String name;
	public int age;
	public String place;
	Boolean accident;
	Double pension;
	
	//id
	public int getId() {
	return id;
	}
	public int setId() {
	this.id = id;
	return id;
	}

	//name
	public String getName() {
		return name;
	}
	public String setName() {
		this.name = name;
		return name;
	}
	
	//age
	int getAge() {
		return age;
	}
	int setAge() {
		this.age =  age;
		return age;	
	}
	
	//place
	String getPlace() {
		return place;
	}
	String setPlace() {
		this.place = place;
		return place;
	}
	
	//accident
	Boolean getAccident() {
		return accident;
	}
	Boolean setAccident() {
		this.accident = accident;
		return accident;
	}
	
	//pension
	Double getPension() {
		return pension;
	}
	Double setPension() {
		this.pension = pension;
		return pension;
	}
	
}
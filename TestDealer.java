package Package1;

class Car {

	public String model;
	public int year;
	public int price;

	public Car(String m, int y, int p) {
		model = m;
		year = y;
		price = p;
	}

	public String toString() {
		return model + " " + " " + year + " " + price;
	}

	public String printThis(int i) {

		return "";
	}

	public int getPrice() {
		return price;
	}

}

class NewCar extends Car {

	private String color;

	public NewCar(String m, int y, int p, String c) {
		super(m, y, p);
		color = c;
	}

	public String toString() {
		return super.toString() + " " + color + "\n";
	}

	public String printThis(int i) {
		String s = "";
		s += "Car " + i + ": New car" + "\n";
		s += "Model: " + model + "\n";
		s += "Year Made: " + year + "\n";
		s += "Price: " + price + "\n";
		s += "Color: " + color + "\n";
		s += "Selling Price: " + price + "\n";
		return s;
	}

}

class UsedCar extends Car {

	private boolean rusty = false;

	public UsedCar(String m, int y, int p, boolean r) {
		super(m, y, p);
		rusty = r;
	}

	public String toString() {
		return super.toString() + " " + rusty + "\n";

	}

	public String printThis(int i) {
		String s = "";
		s += "Car " + i + ": Used car" + "\n";
		s += "Model: " + model + "\n";
		s += "Year Made: " + year + "\n";
		s += "Price: " + price + "\n";
		if (rusty) {
			s += "Body Condition: " + "rusty" + "\n";

			s += "Selling Price: " + (price - 500) + "\n";
		} else {
			s += "Body Condition: " + "good" + "\n";

			s += "Selling Price: " + price + "\n";
		}
		return s;
	}

}

class CarDealerShip {
	final int MAX_NUMBER = 80;
	int CAR_COUNTER = 0;// TRACKING, WHAT YOU ARE STORING AT
	Car[] cars = new Car[MAX_NUMBER];

	public void addNewCar(String m, int y, int p, String c) {
		Car new1 = new NewCar(m, y, p, c);
		cars[CAR_COUNTER] = new1;
		CAR_COUNTER = CAR_COUNTER + 1;
	}

	public void addUsedCar(String m, int y, int p, boolean r) {
		Car used1 = new UsedCar(m, y, p, r);
		cars[CAR_COUNTER] = used1;
		CAR_COUNTER = CAR_COUNTER + 1;
	}

	public String printReport() {
		String s = "";
		for (int i = 0; i < CAR_COUNTER; i++) {
			// s += cars[i].toString();
			s += cars[i].printThis(i) + "\n";
		}
		return s;
	}

	public String printAllCarsWithSellingPriceBelow(int p) {
		String s = "";
		for (int i = 0; i < CAR_COUNTER; i++) {
			// s += cars[i].toString();
			if (cars[i].getPrice() < p) {
				int h = cars[i].getPrice();
				s += cars[h].printThis(h) + "\n";
			}
		}
		return s;

	}

	/*
	 * public String printAllCarsOfColor(String c){
	 * 
	 * return ""; }
	 */

}

public class TestDealer {
	public static void main(String[] args) {

		CarDealerShip dealer = new CarDealerShip();// CAR COUNTER
		dealer.addNewCar("GM Buick Century", 2004, 20000, "Silver");
		dealer.addUsedCar("Toyota Corolla", 1999, 9000, true);
		dealer.addNewCar("Honda Civic", 2004, 15000, "Green");
		dealer.addNewCar("BMW 320i", 2004, 35000, "Black");
		dealer.addUsedCar("Toyota Sienna", 2000, 11000, false);

		System.out.println(dealer.printReport());

		System.out.println("****************************************");

		System.out.println(dealer.printAllCarsWithSellingPriceBelow(10000));

		System.out.println("****************************************");

		// System.out.println(dealer.printAllCarsOfColor("Green"));

	}
}

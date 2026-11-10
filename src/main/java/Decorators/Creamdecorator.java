package Decorators;

public class Creamdecorator extends Coffeedecorator{

	public Creamdecorator(Coffee coffee) {
		super(coffee);
		// TODO Auto-generated constructor stub
	}
	public int getCost() {
		return coffee.getCost()+5;
	}
	public String getDescription() {
		return coffee.getDescription()+" added cream together";
	}

}

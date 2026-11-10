package Decorators;

public class Milkdecorator extends Coffeedecorator{
	
	public Milkdecorator(Coffee coffee) {
		super(coffee);
	}
	public int getCost() {
		return coffee.getCost()+2;
	}
	public String getDescription() {
		return coffee.getDescription()+" added milk together";
	}
}

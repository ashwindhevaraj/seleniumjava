package Decorators;

public class Coffeedecorator implements Coffee{
	protected Coffee coffee;
	public Coffeedecorator(Coffee coffee) {
		this.coffee=coffee;
	}

	@Override
	public int getCost() {
		return coffee.getCost();
	}

	@Override
	public String getDescription() {
		return coffee.getDescription();
	}

}

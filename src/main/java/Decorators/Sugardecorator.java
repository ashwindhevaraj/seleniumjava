package Decorators;

public class Sugardecorator extends Coffeedecorator{
	public Sugardecorator(Coffee coffee){
		super(coffee);
		}
		public int getCost() {
			return coffee.getCost()+1;
		}
		public String getDescription() {
			return coffee.getDescription()+" added sugar together";
		}
	}

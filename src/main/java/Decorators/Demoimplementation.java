package Decorators;

public class Demoimplementation {
	public static void main(String args[]) {
		// normal coffee
		Coffee coffee=new Normalcoffee();
		System.out.println(coffee.getCost());                 //5
		System.out.println(coffee.getDescription());          //normal coffee
		
		// adding milk
		coffee=new Milkdecorator(coffee);
		System.out.println(coffee.getCost());                 //7
		System.out.println(coffee.getDescription());          //normal coffee added milk together
		
		// adding sugar
		coffee=new Sugardecorator(coffee);
		System.out.println(coffee.getCost());                 //8
		System.out.println(coffee.getDescription());          //normal coffee added milk together added sugar together
		
		// adding cream
		coffee=new Creamdecorator(coffee);
		System.out.println(coffee.getCost());                 //13
		System.out.println(coffee.getDescription());          //normal coffee added milk together added sugar together added cream together
	}
}

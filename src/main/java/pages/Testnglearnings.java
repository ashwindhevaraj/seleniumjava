package pages;

public class Testnglearnings {
private String message;
public Testnglearnings(String k){
	this.message=k;
}
public String message() {
	return message;
}
public void checkException() {
	System.out.println("this method will throw exception");
	int c=1/0;
}
public void dependsoncheck() {
	System.out.println("just a depends on methods check");
	}
}

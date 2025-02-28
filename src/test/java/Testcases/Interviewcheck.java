package Testcases;

public class Interviewcheck {

	public static void main(String args[]) {
		Interviewcheck first=new Interviewcheck();
		first.encodecheck("aaabbcdd");	
}
	public void encodecheck(String input) {
		StringBuilder encode=new StringBuilder();
		int count=1;
		char k;
		for(int i=0;i<input.length()-1;i++) {
			k=input.charAt(i);
			if(k==input.charAt(i+1))
			count++;
			else {
				encode.append(input.charAt(i));
				encode.append(count);
				count=1;
			}
		}
		System.out.println(encode);
	}
	public void largest(String input) {
		
	}
}

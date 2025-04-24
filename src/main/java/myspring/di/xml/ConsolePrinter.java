package myspring.di.xml;

public class ConsolePrinter implements Printer {
	
	public ConsolePrinter() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}
	
	public void print(String message) {
		System.out.println(message);
	}
}

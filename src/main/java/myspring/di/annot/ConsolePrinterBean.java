package myspring.di.annot;

public class ConsolePrinterBean implements PrinterBean {
	
	public ConsolePrinterBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}
	
	public void print(String message) {
		System.out.println(message);
	}
}

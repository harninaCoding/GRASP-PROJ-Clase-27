package ejercicio02;

public class Bussines {
	private PrinterPool printerPool=new PrinterPool();
	private SesssionPool sesssionPool=new SesssionPool();
	private SGBD sgbd=new SGBD();
	
	public boolean startSystem() {
		return printerPool.begin()&&sesssionPool.init()&&sgbd.start();
	}
}

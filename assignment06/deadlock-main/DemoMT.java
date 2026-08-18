package deadLock;


class Hello implements Runnable{
	@Override 
	public void run() {
		for(int i=1;i<6;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + " "+ Thread.currentThread().getName());
		}
	}
}
public class DemoMT {

	public static void main(String[] args) {
		Hello hh = new Hello();
		Hello h1 = new Hello();
		Thread tt = new Thread(hh);
		Thread t1 = new Thread(h1);
		tt.start();
		t1.start();

	}

}

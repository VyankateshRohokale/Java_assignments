package deadLock;


class Pen{
	public synchronized void writeWithPenAndPaper(Paper paper) {
		System.out.println(Thread.currentThread().getName() + " is using pen locked PEN and is trying to lock PAPER");
		paper.finishWriting();
	}

	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " finished using pen ");
	}
}

class Paper{
	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " finished using pen ");
	}

	public synchronized void writeWithPaperAndPen(Pen pen) {
		System.out.println(Thread.currentThread().getName() + " is using paper locked PAPER and is trying to lock PEN");
		pen.finishWriting();

	}

}

class Task1 implements Runnable{
	private Pen pen;
	private Paper paper;

	public Task1(Pen pen, Paper paper) {
		this.pen = pen;
		this.paper = paper;
	}
	@Override
	public void run() {
		pen.writeWithPenAndPaper(paper); // thread locks pen and tries to lock paper

	}
}

class Task2 implements Runnable{
	private Pen pen;
	private Paper paper;

	public Task2(Pen pen, Paper paper) {
		this.pen = pen;
		this.paper = paper;
	}
	@Override
	public void run() {
		//pen.writeWithPenAndPaper(paper); 
		synchronized(pen) {
			paper.writeWithPaperAndPen(pen); // thread2 locks paper and tries to lock pen		
		}
	}
}
public class DeadLockDemo {


	public static void main(String[] args) {
		Pen pen = new Pen();
		Paper paper = new Paper();

		Thread t1 = new Thread(new Task1(pen,paper), "Thread-1");
		Thread t2 = new Thread(new Task2(pen,paper), "Thread-2");
		t1.start();
		t2.start();

	}

}

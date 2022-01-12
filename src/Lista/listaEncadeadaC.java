package Lista;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class listaEncadeadaC {

	public class ThreadB extends Thread {

		private int position;
		private int value;
		
		public ThreadB(int position) {
			this.position = position;
		}
		
		@Override
		public void run() {
			value = list.get(position);		
		}

		public int getValue() {
	        return value;
	    }
	}
	
	public class ThreadI extends Thread {

		private int value;
		
		public ThreadI(int value) {
			this.value = value;
		}
		
		@Override
		public void run() {
			list.add(value);
			
		}

	}
	
	public class ThreadR extends Thread {

		private int position;
		
		public ThreadR(int position) {
			this.position = position;
		}
		
		@Override
		public void run() {
			list.remove(position);
			
		}

	}

	
	private volatile LinkedList<Integer> list;
	private Semaphore semaphore_I;
	private Semaphore semaphore_R;

	public listaEncadeadaC() {
		list = new LinkedList<Integer>();
		semaphore_I = new Semaphore(1);
		semaphore_R = new Semaphore(1);
	}
	
	public int get(int position) {
		ThreadB thread = new ThreadB(position);
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return thread.getValue();
	}
	
	public void insert(int value) {
		ThreadI thread = new ThreadI(value);
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(int position) {
		ThreadR thread = new ThreadR(position);
		thread.start();
		thread.setPriority(thread.MAX_PRIORITY);
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
}

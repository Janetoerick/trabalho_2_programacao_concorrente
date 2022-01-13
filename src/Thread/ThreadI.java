package Thread;

import Lista.ListaEncadeadaC;

public class ThreadI extends Thread {

	private int value;
	private ListaEncadeadaC list;
	
	public ThreadI(int value, ListaEncadeadaC list) {
		this.value = value;
		this.list = list;
	}
	
	@Override
	public void run() {
		int count = 0;
		list.add(value);
		while(list.avaliablePermits() == 0) {
			try {
				if(getPriority() < 10) {
					setPriority(getPriority()+1);
					Thread.sleep(5);
				} else {
					count++;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count == 3)
				break;
		}
		System.out.println("I" + value + ": Adicionando " + value);
	}

}

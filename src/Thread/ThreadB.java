package Thread;

import Lista.ListaEncadeadaC;

public class ThreadB extends Thread {

	private int position;
	private ListaEncadeadaC list;
	
	public ThreadB(int position, ListaEncadeadaC list) {
		this.position = position;
		this.list = list;
	}
	
	@Override
	public void run() {
		int count = 0;
		if(position < list.size()) {
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
			int value = list.get(position);
			System.out.println("B"+ position +": Buscando... | Achou valor "
								+ value + " na posicao " + position);
		}
		
	}
}
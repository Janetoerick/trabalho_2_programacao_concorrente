package Thread;

import Lista.ListaEncadeadaC;

public class ThreadR extends Thread {

	private int position;
	private ListaEncadeadaC list;
	
	public ThreadR(int position, ListaEncadeadaC list) {
		this.position = position;
		this.list = list;
	}
	
	@Override
	public void run() {
		int p = 10;
		if(position < list.size()) {
			list.acquireSemaphore();
			while(Thread.activeCount() != 2) {
				System.out.println("================================== " + Thread.activeCount()
									+ "================================== ");
				try {
					if(getPriority() < 10) {
						setPriority(getPriority()+1);
						Thread.sleep(5);
					} else {
						p++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(p == 30) {
					System.out.println("***********************************************************************************");
					break;
				}
			}
			list.remove(position);
			list.releaseSemaphore();
			System.out.println("NUMERO DE THREADS EM EXECUCAO:" + Thread.activeCount());
			System.out.println("R" + position + ": Removeu valor da posicao " + position);
		}
	}

}
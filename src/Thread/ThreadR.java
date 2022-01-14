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
		list.addThreadR(getId());
		while (list.firstThreadR() != getId()) {
			if(!list.ContainsThreadR(getId())) {
				System.out.println("****************************************************************************************************");
				list.addThreadR(getId());
			}
			try {
				if (getPriority() < 10) { // aumenta o valor da prioridade
					setPriority(getPriority() + 1); // quanto mais a thread espera
													// garantindo que nao ocorra starvation
				}
				Thread.sleep(5);
				//System.out.println(getId() + " | " + list.firstThread() + " -- " + list.sizeThread());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.acquireSemaphore(); // dizendo que uma threadR vai comecar a executar e deve parar as demais
		System.out.println("ESSA THREAD PASSOU " + getId());

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}

		if (position < list.size()) { // caso exista a posicao na lista
			/*
			 * Verifica se apenas 2 threads estao em execucao no sistema, caso haja mais
			 * entao existe alguma thread do tipo B,I ou R, em execucao - OBS: sao duas
			 * threads, pois conta 1 com a main que chamou essa e mais 1 com essa propria
			 */
//			while (Thread.activeCount() - list.sizeThread() != 1) {
//				System.out.println("================================== " + Thread.activeCount()
//						+ "================================== ");
//				try {
//					if (getPriority() < 10) { // aumenta o valor da prioridade
//						setPriority(getPriority() + 1); // quanto mais a thread espera
//						Thread.sleep(1000); // garantindo que nao ocorra starvation
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				if (list.avaliablePermits() == 1)
//					list.acquireSemaphore();
//			}
			list.remove(position);
			System.out.println("R" + getId() + ": Removeu valor da posicao " + position);
		}
		list.releaseSemaphore(); // libera o semaforo para as outras threads poderem executar
		if(list.firstThreadR() > 0)
			list.removeThreadR();
		System.out.println("--> " + list.firstThreadR());
	}

}
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
		list.addThreadR(getId());		// adiciona essa thread na lista de espera
		while (list.firstThreadR() != getId()) { // faz a verificacao se eh sua vez
			
			try {
				if (getPriority() < 10) { 			// aumenta o valor da prioridade
					setPriority(getPriority() + 1); // quanto mais a thread espera
													// garantindo que nao ocorra starvation
				}
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.acquireSemaphore(); // dizendo que uma threadR vai comecar a executar e deve parar as demais

		// espera um curto tempo para que as threads que ja estavam em execucao terminem
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}
		
		if (position < list.size()) { // caso exista a posicao na lista
			list.remove(position); // remove o elemento
			System.out.println("R" + getId() + ": Removeu valor da posicao " + position);
		}
		list.releaseSemaphore(); // libera o semaforo para as outras threads poderem executar
		if (list.firstThreadR() > 0) // caso ainda haja thread para retirar da fila
			list.removeThreadR();

	}

}
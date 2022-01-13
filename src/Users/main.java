package Users;

import java.util.Iterator;

import Lista.ListaEncadeadaC;
import Thread.ThreadB;
import Thread.ThreadI;
import Thread.ThreadR;

public class main {

	public static void main(String[] args) {
		ListaEncadeadaC list = new ListaEncadeadaC();
		
		for (int i = 0; i < 100; i++) {
			Thread threadI = new ThreadI(i, list);
			threadI.start();
			
		}
		
		for (int i = 0; i < 100; i++) {
			Thread threadB = new ThreadB(i, list);
			Thread threadR = new ThreadR(i, list);
			threadB.start();
			threadR.start();
			System.out.println("NUMERO DE THREADS EM EXECUCAO:" + Thread.activeCount());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.listar();

	}

}

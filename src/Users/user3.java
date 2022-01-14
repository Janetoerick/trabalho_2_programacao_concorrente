package Users;

import Lista.ListaEncadeadaC;
import Thread.ThreadB;
import Thread.ThreadI;
import Thread.ThreadR;

public class user3 {

	public static void main(String[] args) {
		ListaEncadeadaC list = new ListaEncadeadaC();

		for (int i = 0; i < 200; i++) {
			Thread threadI = new ThreadI(i, list);
			threadI.start();
			
			if(i%2 == 0) {
				Thread threadB = new ThreadB(i, list);
				threadB.start();
			}
			
			if(i%3 == 0) {
				Thread threadR = new ThreadR(i, list);
				threadR.start();
			}

		}


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.listar();

	}

}

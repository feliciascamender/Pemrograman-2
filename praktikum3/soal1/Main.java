package praktikum3.soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        int jumlahDadu = input.nextInt();
	        LinkedList<Dadu> daftarDadu = new LinkedList<>();

	        for (int i = 0; i < jumlahDadu; i++) {
	            Dadu d = new Dadu();
	            daftarDadu.add(d);
	        }
	      int total = 0;
	        for (int i = 0; i < daftarDadu.size(); i++) {
	            int nilai = daftarDadu.get(i).getNilai();
	            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilai);
	            total += nilai;
	        }

	        System.out.println("Total nilai dadu keseluruhan " + total);

	        input.close();
	    }

}

package Modul_1;

import java.util.Scanner;

public class PRAK104_2410817320005_NADIAFELICIASR {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] abu = new String[3];
		String[] bagas = new String[3];
		
		System.out.println("Tangan Abu:");
		for (int i = 0; i < 3; i++) {
			abu[i] = input.next();
		}
		System.out.println("Tangan Bagas:");
		for (int i = 0; i < 3; i++) {
            bagas[i] = input.next();
		}
		int poinAbu = 0, poinBagas = 0;

        for (int i = 0; i < 3; i++) {
            if (abu[i].equals(bagas[i])) {
                continue; 
            } else if ((abu[i].equals("B") && bagas[i].equals("G")) ||
                       (abu[i].equals("G") && bagas[i].equals("K")) ||
                       (abu[i].equals("K") && bagas[i].equals("B"))) {
                poinAbu++;
            } else {
                poinBagas++;
            }
        }

        if (poinAbu > poinBagas) {
            System.out.println("Abu");
        } else if (poinBagas > poinAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

        input.close();
	}
}


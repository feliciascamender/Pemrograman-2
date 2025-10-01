package Modul_1;

import java.util.Scanner;

public class PRAK103_2410817320005_NADIAFELICIASR {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int batas = input.nextInt();
		int angka = input.nextInt();
		
		int count = 0;
		do {
			if(angka % 2 != 0) {
				if(count == batas - 1) {
					System.out.print(angka);
					} else {
					System.out.print(angka + ", ");
				}
				count++;
			}
			angka++;
		} while(count < batas);
		
		input.close();

	}

}

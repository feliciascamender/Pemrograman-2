package Modul_1;

import java.util.Scanner;

public class PRAK102_2410817320005_NADIAFELICIASR {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int masukan = input.nextInt();
		int count = 0;
		
		while(count <= 10) {
			int hasil = 0;
			 hasil = masukan % 5 == 0 ? masukan / 5 - 1 : masukan;
			 
			 if(count == 10) System.out.print(hasil); else System.out.print(hasil + ",");
			 count++;
			 masukan++; 
			 }
		input.close();
		}
		

	}

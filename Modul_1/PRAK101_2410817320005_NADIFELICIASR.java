package Modul_1;
import java.util.Scanner; 

public class PRAK101_2410817320005_NADIFELICIASR {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Masukkan Nama Lengkap: ");
		String nama = input.nextLine();
		System.out.print("Masukkan Tempat Lahir: ");
		String tempatLahir = input.nextLine();
		System.out.print("Masukkan Tanggal Lahir: ");
		int tanggalLahir = input.nextInt();
		System.out.print("Masukkan Bulan Lahir: ");
		int bulanLahir = input.nextInt();
		System.out.print("Masukkan Tahun Lahir: ");
		int tahunLahir = input.nextInt();
		System.out.print("Masukkan Tinggi Badan: ");
		int tinggiBadan = input.nextInt();
		System.out.print("Masukkan Berat Badan: ");
		double beratBadan = input.nextDouble();
		
		String bulan[] = {
				"", "Januari", "Februari", "Maret", "April", "May", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" };
		
		System.out.println("Nama Lengkap " + nama + ", Lahir di " + tempatLahir + " pada Tanggal " + tanggalLahir + " " + bulan[bulanLahir] + " " + tahunLahir + "Tinggi Badan" + tinggiBadan + "cm dan Berat Badan " + beratBadan + " Kilogaram" );
		
		input.close();
		}
		
}

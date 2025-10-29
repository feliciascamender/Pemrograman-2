package soal2;

import java.util.Scanner;

public class MainPet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan : ");
        System.out.println("1 = Kucing ");
        System.out.println("2 = Anjing ");
        System.out.print("Masukkan pilihan : ");
        int choose = input.nextInt();

        if (choose == 1) {
            input.nextLine();
            System.out.print("Nama hewan peliharaan : ");
            String catName = input.nextLine();

            System.out.print("Ras : ");
            String catSpecies = input.nextLine();

            System.out.print("Warna Bulu : ");
            String catColor = input.nextLine();

            Cat cat = new Cat(catName, catSpecies, catColor);
            cat.display();
        } else if (choose == 2) {
            input.nextLine();
            System.out.print("Nama hewan peliharaan : ");
            String dogName = input.nextLine();

            System.out.print("Ras : ");
            String dogSpecies = input.nextLine();

            System.out.print("Warna Bulu : ");
            String dogColor = input.nextLine();

            System.out.print("Kemampuan : ");
            String dogAbility = input.nextLine();
            String[] ability = dogAbility.split(",");

            Dog dog = new Dog(dogName, dogSpecies, dogColor, ability);
            dog.display();
        } else {
            System.out.println("Pilihan tidak valid ");
        }

        input.close();
    }
}

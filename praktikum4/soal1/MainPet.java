package soal1;

import java.util.Scanner;

public class MainPet {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        Pet.input1();
        String name = print.nextLine();

        Pet.input2();
        String species = print.nextLine();

        Pet pet = new Pet(name, species);
        pet.display();
    }
}

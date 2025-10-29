package soal1;

public class Pet {
    private String name;
    private String species;

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public static void input1() {
        System.out.print("Nama Hewan Peliharaan : ");
    }

    public static void input2() {
        System.out.print("Ras : ");
    }

    public void display() {
        System.out.println(" ");
        System.out.println("Detail Hewan Peliharaan : ");
        System.out.println("Name: " + getName());
        System.out.println("Species: " + getSpecies());
    }

}

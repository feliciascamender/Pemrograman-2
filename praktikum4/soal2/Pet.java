package soal2;

public class Pet {
    private String name;
    private String species;

    public Pet(String n, String r) {
        this.name = n;
        this.species = r;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void display() {
        System.out.println(" ");
        System.out.println("Detail Hewan Peliharaan : ");
        System.out.println("Nama hewan peliharaanku adalah : " + getName());
        System.out.println("Dengan ras : " + getSpecies());
    }

}

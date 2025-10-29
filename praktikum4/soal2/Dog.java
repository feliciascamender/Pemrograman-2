package soal2;

public class Dog extends Pet{
    private String featherColor;
    private String[] ability;

    public Dog(String n, String r, String w, String[] k) {
        super(n, r);
        this.featherColor = w;
        this.ability = k;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Memiliki warna bulu : " + featherColor);
        System.out.print("Memiliki kemampuan : ");
        for (String k : ability) {
            System.out.print(" " + k);
        }
    }
}

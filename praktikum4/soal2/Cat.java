package soal2;

public class Cat extends Pet {
    private String featherColor;

    public Cat(String r, String n, String w) {
        super(n, r);
        this.featherColor = w;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Memiliki warna bulu : " + featherColor);
    }
}

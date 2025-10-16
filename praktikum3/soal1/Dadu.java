package praktikum3.soal1;

class Dadu {
	private int nilai;
    private final int min = 1;
    private final int max = 6;

    Dadu() {
        acakNilai();
    }

    private void acakNilai() {
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        this.nilai = random_int;
    }

    public int getNilai() {
        return this.nilai;
    }

}

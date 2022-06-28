public class Magicial extends BaseHero {
    private int mana;
    private int maxMana;

    public Magicial() {
        super(String.format("Hero_Magician #%d", ++Magicial.number),
                Magicial.r.nextInt(100, 150));
        this.maxMana = Magicial.r.nextInt(50, 150);
        this.mana = maxMana;
    }
    public String getInfo() {
        return String.format("%s  Mana: %d", super.getInfo(), this.mana);
    }
}

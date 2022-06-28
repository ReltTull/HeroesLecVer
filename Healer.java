public class Healer extends BaseHero {
    private int mana;
    private int maxMana;

    public Healer() {
        super(String.format("Hero_Healer #%d", ++Magicial.number),
                Magicial.r.nextInt(75, 130));
        this.maxMana = Magicial.r.nextInt(100, 150);
        this.mana = maxMana;
    }
    public String getInfo() {
        return String.format("%s  Energy: %d", super.getInfo(), this.mana);
    }
}

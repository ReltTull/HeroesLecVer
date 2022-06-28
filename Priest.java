public class Priest extends BaseHero {

    private int elixir;
    private int maxElixir;

    public Priest() {
        super(String.format("Hero_Priest #%d", ++Magicial.number),
                Magicial.r.nextInt(100, 200));
        this.maxElixir = Magicial.r.nextInt(50, 100);
        this.elixir = maxElixir;
    }
    public String getInfo() {
        return String.format("%s  Elixir: %d", super.getInfo(), this.elixir);
    }
}

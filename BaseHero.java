import java.util.Random;

public class BaseHero {
    protected static int number;
    protected static Random r;

    protected String name;
    protected int hp;
    protected int maxHp;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public BaseHero() {
        this(String.format("Hero_Priest #%d", ++BaseHero.number),
                BaseHero.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("Name: %s  Hp: %d  Type: %s",
                this.name, this.hp, this.getClass().getSimpleName());
    }

    public void healed(int Hp) {

        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    public void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }

    public void Attack(BaseHero user, BaseHero target) {
        int damage = BaseHero.r.nextInt(10, 20);
        target.GetDamage(damage);
        System.out.println(target.name + " get damage by " + user.name);
    }

    /**
     * метод лечения. Кроме самого лечения я хочу здесь уменьшать запас маны хиллера
     * @param user сюда предполагал вложить хиллера, чтобы через user.mana уменьшать запас маны. Но класс BaseHero не
     *             знает про ману. Как вариант - переместить параметр мана из потомственных классов в BaseHero.
     * @param target
     */
    public void Healing(BaseHero user, BaseHero target) {
        int heal = BaseHero.r.nextInt(5, 12);
        target.healed(heal);
        System.out.println(target.name + " get heal by " + user.name);
    }

}

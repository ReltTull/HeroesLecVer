import java.util.Random;

public class BaseHero {
    protected static int number;
    protected static Random r;

    protected String name;
    protected int hp;
    protected int maxHp;

    //    проверить, что будет при ещё одном использовании field
    private int field;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public void spendMana(int spendValue) {
        this.field -= spendValue;
    }

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


    public void healed(int Hp) {
        if (field < 5) {
            System.out.println("Not enough mana");
        } else {
            this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
            spendMana(5);
        }
    }

    public void Healing(BaseHero user, BaseHero target) {
        int heal = BaseHero.r.nextInt(5, 7);
        target.healed(heal);
        System.out.println(target.name + " get heal by " + user.name);
    }

}

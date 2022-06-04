package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    protected final int health;
    private int currentHealth;
    private int damage;
    private int defense;
    private boolean isAlive;

    public Barbarian(String name, int maxHP, int damage, int defense) {
        this.name = name;
        this.health = maxHP;
        this.damage = damage;
        this.defense = defense;
        this.isAlive = true;
        this.currentHealth = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.currentHealth;
    }

    public int getMaxHp() {
        return this.health;
    }

    public void setHp(int hp) {
        if (hp <= 0) {
            this.isAlive = false;
        }
        this.currentHealth = hp;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDefense() {
        return this.defense;
    }

    public void attack(Barbarian target) {
        // 피해치 = (공격자의 공격력 - 방어자의 방어력) / 2
        // 계산을 할 때는 double 자료형을 사용하고 계산 뒤에는 소수점 이하는 버리세요. (아래 예 참조)

        // 예>
        // 피해치 = (121 - 100) / 2 = 10.5
        // 피해치 = 10
        // 다른 야만용사에게 공격을 받은 야만용사의 최소 피해치는 1입니다.
        if (isAlive && (target != this)) {
            double totalDamage = ((double) this.damage - (double) target.defense) / 2.0;
            int total = 0;

            if (totalDamage < 1) {
                total = 1;
            } else if (totalDamage >= target.getHp()) {
                total = target.getHp();
            } else {
                total = (int) totalDamage;
            }
    
            target.currentHealth -= total;
            if (target.currentHealth <= 0) {
                target.isAlive = false;
            }
        }
    }

    public boolean isAlive() {
        if (this.currentHealth <= 0) {
            this.isAlive = false;
            return this.isAlive;
        } else {
            this.isAlive = true;
            return this.isAlive;
        }
    }
}

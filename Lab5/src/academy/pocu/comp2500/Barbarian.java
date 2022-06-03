package academy.pocu.comp2500;

public class Barbarian {
    private String name;
    protected int HP;
    private int damage;
    private int defense;

    public Barbarian(String name, int maxHP, int damage, int defense) {
        this.name = name;
        this.HP = maxHP;
        this.damage = damage;
        this.defense = defense;
    }

    public int getHp() {
        return this.HP;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDefense() {
        return this.defense;
    }

    public void attack(Barbarian target) {
//         피해치 = (공격자의 공격력 - 방어자의 방어력) / 2
//         계산을 할 때는 double 자료형을 사용하고 계산 뒤에는 소수점 이하는 버리세요. (아래 예 참조)

// 예>
// 피해치 = (121 - 100) / 2 = 10.5
// 피해치 = 10
// 다른 야만용사에게 공격을 받은 야만용사의 최소 피해치는 1입니다.
        double totalDamage = (double)(this.damage - target.defense) / 2.0;
        int total = (int)totalDamage;

        target.HP -= total;
    }

    public boolean isAlive() {
        if (this.HP < 0) {
            return false;
        } else {
            return true;
        }
    }


}

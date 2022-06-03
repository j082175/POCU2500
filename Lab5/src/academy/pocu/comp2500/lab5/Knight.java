package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int maxHP, int damage, int defense) {
        super(name, maxHP, damage, defense);
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void attackTogether(Gladiator target) {
        if (pet != null) {
            // 피해치 = (공격자의 공격력 + 펫의 공격력 - 방어자의 방어력) / 2
            // 계산을 할 때는 double 자료형을 사용하고 계산 뒤에는 소수점 이하는 버리세요.

            // 공격에 성공하면 최소 1의 피해를 입힙니다.
            double damage = (this.getDamage() + this.pet.getDamage() - target.getDefense()) / 2;
            int total = (int) damage;

            target.setHp(target.getHp() - total);
        }
    }
}

package academy.pocu.comp2500.lab5;

public class Move {
    private String nameOfAttackSkill;
    private int damageOfAttackSkill;
    private int maxCountToUsingSkill;

    public Move(String nameOfAttackSkill, int damageOfAttackSkill, int maxCountToUsingSkill) {
        this.nameOfAttackSkill = nameOfAttackSkill;
        this.damageOfAttackSkill = damageOfAttackSkill;
        this.maxCountToUsingSkill = maxCountToUsingSkill;
    }

    public String getNameOfAttackSkill() {
        return this.nameOfAttackSkill;
    }

    public int getDamageOfAttackSkill() {
        return this.damageOfAttackSkill;
    }

    public int getMaxCountToUsingSkill() {
        return this.maxCountToUsingSkill;
    }

    public void increaseMaxCountToUsingSkill() {
        this.maxCountToUsingSkill++;
    }

    public void decreaseMaxCountToUsingSkill() {
        this.maxCountToUsingSkill--;
    }
}

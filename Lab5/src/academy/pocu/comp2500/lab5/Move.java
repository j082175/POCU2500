package academy.pocu.comp2500.lab5;

public class Move {
    private String nameOfAttackSkill;
    private int damageOfAttackSkill;
    private final int maxCountToUsingSkill;
    private int currentMaxCountToUsingSkill;

    public Move(String nameOfAttackSkill, int damageOfAttackSkill, int maxCountToUsingSkill) {
        this.nameOfAttackSkill = nameOfAttackSkill;
        this.damageOfAttackSkill = damageOfAttackSkill;
        this.maxCountToUsingSkill = maxCountToUsingSkill;
        this.currentMaxCountToUsingSkill = this.maxCountToUsingSkill;
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

    public int getCurrentMaxCountToUsingSkill() {
        return this.currentMaxCountToUsingSkill;
    }

    public void increaseMaxCountToUsingSkill() {
        this.currentMaxCountToUsingSkill++;
    }

    public void decreaseMaxCountToUsingSkill() {
        this.currentMaxCountToUsingSkill--;
    }

}

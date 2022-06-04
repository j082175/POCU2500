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

    protected String getNameOfAttackSkill() {
        return this.nameOfAttackSkill;
    }

    protected int getDamageOfAttackSkill() {
        return this.damageOfAttackSkill;
    }

    protected int getMaxCountToUsingSkill() {
        return this.maxCountToUsingSkill;
    }

    protected int getCurrentMaxCountToUsingSkill() {
        return this.currentMaxCountToUsingSkill;
    }

    protected void increaseMaxCountToUsingSkill() {
        this.currentMaxCountToUsingSkill++;
    }

    protected void decreaseMaxCountToUsingSkill() {
        this.currentMaxCountToUsingSkill--;
    }

}

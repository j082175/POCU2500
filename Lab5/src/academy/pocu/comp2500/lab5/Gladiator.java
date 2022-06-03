package academy.pocu.comp2500.lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gladiator extends Barbarian {
    private Map<String, Move> moves;
    private ArrayList<String> movesManager;
    private int maxSkillCount;

    public Gladiator(String name, int maxHP, int damage, int defense) {
        super(name, maxHP, damage, defense);
        this.moves = new HashMap<>();
        this.movesManager = new ArrayList<>();
        this.maxSkillCount = 0;
    }

    public boolean addMove(Move move) {
        if (moves.containsKey(move.getNameOfAttackSkill()) || this.maxSkillCount >= 4) {
            return false;
        } else {
            moves.put(move.getNameOfAttackSkill(), move);
            movesManager.add(move.getNameOfAttackSkill());
            this.maxSkillCount++;
            return true;
        }
    }

    public boolean removeMove(String nameOfSkill) {
        if (moves.containsKey(nameOfSkill)) {
            moves.remove(nameOfSkill);
            movesManager.remove(nameOfSkill);
            return true;
        } else {
            return false;
        }
    }

    public void attack(String nameOfSkill, Barbarian target) {
        if (moves.containsKey(nameOfSkill) && this.isAlive() && target != this) {
            if (moves.get(nameOfSkill).getCurrentMaxCountToUsingSkill() > 0) {
                // 피해치 = (공격자의 공격력 / 방어자의 방어력 * 스킬의 파워) / 2
                // 계산을 할 때는 double 자료형을 사용하고 계산 뒤에는 소수점 이하는 버리세요.
                moves.get(nameOfSkill).decreaseMaxCountToUsingSkill();
                // 공격에 성공하면 최소 1의 피해를 입힙니다.
                double damage = (((double) this.getDamage() / (double) target.getDefense())
                        * (double) moves.get(nameOfSkill).getDamageOfAttackSkill()) / 2.0;
                int total = 0;


                if (damage < 1) {
                    total = 1;
                } else if (damage >= target.getHp()) {
                    total = target.getHp();
                } else {
                    total = (int) damage;
                }

                int health = target.getHp() - total;
                target.setHp(health);
                
            }
        }
    }

    public void rest() {
        if ((this.getHp() + 10) <= this.getMaxHp()) {
            this.setHp(this.getHp() + 10);
            this.setting();
        } else {
            this.setHp(this.getMaxHp());
            this.setting();
        }
    }

    private void setting() {
        for (int i = 0; i < moves.size(); i++) {
            if (moves.containsKey(movesManager.get(i))) {
                if (moves.get(movesManager.get(i)).getCurrentMaxCountToUsingSkill() < moves.get(movesManager.get(i))
                        .getMaxCountToUsingSkill()) {
                    moves.get(movesManager.get(i)).increaseMaxCountToUsingSkill();
                }
            }
        }
    }
}

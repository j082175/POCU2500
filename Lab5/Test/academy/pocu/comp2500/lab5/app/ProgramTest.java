package academy.pocu.comp2500.lab5.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import academy.pocu.comp2500.lab5.Barbarian;
import academy.pocu.comp2500.lab5.Gladiator;
import academy.pocu.comp2500.lab5.Knight;
import academy.pocu.comp2500.lab5.Move;
import academy.pocu.comp2500.lab5.Pet;
class ProgramTest {
    void test1() {
        Barbarian barbarian0 = new Barbarian("Dragonborn Whiterun", 250, 210, 60);
        Barbarian barbarian1 = new Barbarian("Ulfric Stormcloak", 200, 70, 10);

        barbarian0.attack(barbarian1);

        assert barbarian1.getHp() == 100;
        assert barbarian1.isAlive();

        barbarian0.attack(barbarian1);

        assert barbarian1.getHp() == 0;
        assert !barbarian1.isAlive();

        Gladiator gladiator0 = new Gladiator("Parthunax", 250, 210, 10);
        Gladiator gladiator1 = new Gladiator("Zoro", 100, 150, 65);
        Move move0 = new Move("Gomu Gomu no pistol", 50, 10);
        Move move1 = new Move("Thunderbolt", 90, 15);
        Move move2 = new Move("Ice Beam", 90, 10);
        Move move3 = new Move("Surf", 90, 15);

        assert gladiator0.addMove(move0);
        assert gladiator0.addMove(move1);
        assert gladiator0.addMove(move2);
        assert gladiator0.addMove(move3);

        assert gladiator0.removeMove("Surf");

        gladiator0.attack("Gomu Gomu no pistol", barbarian0);

        assert barbarian0.getHp() == 163;
        assert barbarian0.isAlive();

        gladiator0.attack("Gomu Gomu no pistol", gladiator1);

        assert gladiator1.getHp() == 20;

        gladiator1.rest();

        assert gladiator1.getHp() == 30;

        Knight knight0 = new Knight("Naruto", 252, 310, 99);
        Knight knight1 = new Knight("Sasuke", 250, 290, 111);
        Pet pet0 = new Pet("Giant Toad", 180);

        knight0.setPet(pet0);

        knight0.attackTogether(gladiator0);

        assert gladiator0.getHp() == 10;

        knight0.attackTogether(knight1);

        assert knight1.getHp() == 61;
    }
    @Test
    void main() {
        Gladiator g1 = new Gladiator("one",100,10,5);
        Gladiator g2 = new Gladiator("two",200,20,10);
        Move m1 = new Move("PowerAttack",1000,1);
        g1.addMove(m1);
        g1.attack("PowerAttack",g2);
        int a = g2.getHp();
        g2.rest();
        int b = g2.getHp();
        g1.rest();
        Barbarian b1 = new Barbarian("fe",1,1,1);

    }
}
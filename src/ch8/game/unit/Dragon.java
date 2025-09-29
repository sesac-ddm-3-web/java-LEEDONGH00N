package ch8.game.unit;

import ch8.game.attack.Attackable;
import ch8.game.attack.MagicAttackable;
import ch8.game.move.Flyable;
import ch8.game.move.Movable;

public class Dragon implements Flyable, MagicAttackable {
    @Override
    public void magicAttack() {
        System.out.println("드래곤이 마법 공격을 합니다!");
    }

    @Override
    public void attack() {
        System.out.println("드래곤이 물리 공격을 합니다.");
    }

    @Override
    public void fly() {
        System.out.println("드래곤이 하늘을 날아갑니다.");
    }

    @Override
    public void move() {
        System.out.println("드래곤이 이동합니다.");
    }
}

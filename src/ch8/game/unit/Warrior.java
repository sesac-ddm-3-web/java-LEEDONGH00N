package ch8.game.unit;

import ch8.game.attack.Attackable;
import ch8.game.move.Movable;

public class Warrior implements Movable, Attackable {
    @Override
    public void attack() {
        System.out.println("전사가 물리 공격을 합니다.");
    }

    @Override
    public void move() {
        System.out.println("전사가 이동합니다.");
    }
}

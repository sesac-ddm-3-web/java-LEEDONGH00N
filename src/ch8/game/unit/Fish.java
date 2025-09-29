package ch8.game.unit;

import ch8.game.move.Movable;
import ch8.game.move.Swimable;

public class Fish implements Swimable {
    @Override
    public void swim() {
        System.out.println("물고기가 수영합니다.");
    }

    @Override
    public void move() {
        System.out.println("물고기가 이동합니다.");
    }
}

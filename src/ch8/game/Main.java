package ch8.game;

import ch8.game.unit.*;

public class Main {
    public static void main(String[] args) {
        // 각 캐릭터 객체 생성
        Dragon dragon = new Dragon();
        Fish fish = new Fish();
        Warrior warrior = new Warrior();

        // 드래곤의 모든 기능 실행
        dragon.move();
        dragon.fly();
        dragon.attack();
        dragon.magicAttack();
        System.out.println(); // 줄 바꿈

        // 물고기의 모든 기능 실행
        fish.move();
        fish.swim();
        System.out.println(); // 줄 바꿈

        // 전사의 모든 기능 실행
        warrior.move();
        warrior.attack();
    }
}

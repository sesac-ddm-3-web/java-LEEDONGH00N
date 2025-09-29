package sec6.game;

public class GameMain {
    public static void main(String[] args) {
        // 1. '전사' 캐릭터 생성
        System.out.println("새로운 캐릭터 '전사'를 생성합니다.");
        GameCharacter warrior = new GameCharacter("전사");
        warrior.getCharacterInfo();
        System.out.println();

        // 2. 몬스터에게 30의 피해를 입음
        System.out.println("## 전투 시작 ##");
        warrior.takeDamage(30);
        System.out.println();

        // 3. 체력 물약 사용 (50 회복)
        System.out.println("체력 물약을 사용합니다.");
        warrior.recoverHp(50);
        warrior.getCharacterInfo();
        System.out.println();

        // 4. 다시 몬스터에게 100의 피해를 입음
        System.out.println("강력한 공격을 받았습니다!");
        warrior.takeDamage(100);
        warrior.getCharacterInfo();
        System.out.println();

        // 5. 레벨 업!
        System.out.println("몬스터를 처치하여 레벨이 올랐습니다.");
        warrior.levelUp();
        warrior.getCharacterInfo();

    }
}

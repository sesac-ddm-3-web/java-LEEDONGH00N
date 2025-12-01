package ch6.game;

public class GameCharacter {

    private int level;
    private int hp;
    private int maxHp;
    private String name;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.hp = 100;
        this.maxHp = 100;
    }

    public void takeDamage(int damage) {
        calculateHpByDamage(damage);
        System.out.printf("%s이(가) %d의 피해를 입었습니다.\n", this.name, damage);
    }

    public void recoverHp(int amount){
        calculateHpByRecover(amount);
        System.out.printf("%s이(가) HP를 %d만큼 회복했습니다.\n", this.name, amount);
    }

    public void levelUp(){
        this.level++;
        updateHp();
        System.out.printf("레벨 업! %s의 레벨이 %d이 되었습니다. (최대 HP: %d)\n", this.name, this.level, this.maxHp);
    }

    public void getCharacterInfo(){
        System.out.printf("이름: %s, 레벨: %d, HP: %d/%d\n", this.name, this.level, this.hp, this.maxHp);
    }

    private void calculateHpByDamage(int damage){
        this.hp = this.hp - damage;
        if(this.hp <= 0) {
            this.hp = 0;
        }
    }

    private void calculateHpByRecover(int amount) {
        this.hp = this.hp + amount;
        if(this.hp >= this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    private void updateHp() {
        this.maxHp = this.maxHp + 20;
        this.hp = this.maxHp;
    }
}

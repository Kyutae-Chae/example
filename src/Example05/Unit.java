package Example05;

public class Unit {
    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void beAttacked(Unit a) { //공격받을때 healthPoint와 상대 공격력을 고려하여 차감한다.
        int attack = a.getAttackPower() - this.defencePower; //내 방어력만큼 공격력을 차감한다.
        if (this.healthPoint < attack) this.healthPoint = 0;
        else this.healthPoint = this.healthPoint - attack;
    }

    String name;    //유닛이름
    int attackPower;    //공격력
    int defencePower;   //방어력
    int healthPoint;    //체력

    Unit(String name, int attackPower, int defencePower, int healthPoint) {
        //유닛 생성시에는 이름, 공격력, 방어력, 체력 입력을 필요로 한다.
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.healthPoint = healthPoint;

        //유닛 객체의 정보를 생성시 출력해준다.
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.printf("[안내] %s 유닛이 게임에 참여하였습니다.\n", this.name);
        System.out.println("[공격력] : " + this.attackPower);
        System.out.println("[방어력] : " + this.defencePower);
        System.out.println("[체력] : " + this.healthPoint);
    }

    public void attack(Unit enemy) {    //내 공격력으로 상대의 체력을 깍아버린다.
        System.out.println("----------------------------------------");
        System.out.printf("[안내] [%s]유닛이 [공격] 하였습니다.\n", this.name);
        enemy.beAttacked(this); //enemy가 나(this)의 공격을 받는다.
        System.out.printf("[안내] 상대 유닛의 남은 [체력]은 %d 입니다.\n", enemy.getHealthPoint());
        System.out.println("----------------------------------------");

        //체력이 0인경우 유닛이 제거된다.
        if (enemy.getHealthPoint() == 0) {
            System.out.println("[안내] 더 이상 공격할 수 없습니다.\n" +
                    "\n" +
                    "[안내] 상대 유닛이 제거되었습니다.");
        }
    }
}

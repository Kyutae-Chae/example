package Example05;

public class Unit {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    String name;    //유닛이름
    int attackPower;    //공격력
    int defencePower;   //방어력
    int healthPoint;    //체력

    Unit(String name, int attackPower, int defencePower, int healthPoint) {
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.healthPoint = healthPoint;

        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.printf("[안내] %s 유닛이 게임에 참여하였습니다.\n", this.name);
        System.out.println("[공격력] : " + this.attackPower);
        System.out.println("[방어력] : " + this.defencePower);
        System.out.println("[체력] : " + this.healthPoint);
    }

    public void attack(Unit enemy) {
        System.out.println("----------------------------------------");
        System.out.printf("[안내] [%s]유닛이 [공격] 하였습니다.\n", this.name);
        enemy.setHealthPoint(enemy.getHealthPoint() < this.attackPower ? 0 : enemy.getHealthPoint() - this.attackPower);
        System.out.printf("[안내] 상대 유닛의 남은 [체력]은 %d 입니다.\n", enemy.getHealthPoint());
        System.out.println("----------------------------------------");

        if (enemy.getHealthPoint() == 0) {
            System.out.println("[안내] 더 이상 공격할 수 없습니다.\n" +
                    "\n" +
                    "[안내] 상대 유닛이 제거되었습니다.");
        }
    }
}

public abstract class Character implements Fighter {
    String name;
    int health, power, skill, experience, gold;


    public Character(String name, int health, int power, int skill, int experience, int gold) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.skill = skill;
        this.experience = experience;
        this.gold = gold;
    }

    @Override
    public int attack() {
        if (skill > Random100()) {
            return power * 2;
        } else if (skill * 3 > Random100()) {
            return power;
        } else return 0;
    }
    private int Random100() {
        return (int) (Math.random() * 100);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getSkill() {
        return skill;
    }
    public void setSkill(int skill) {
        this.skill = skill;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
}

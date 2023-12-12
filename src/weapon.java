public interface weapon {
    public String getName();
    public int getLevel();
    public int getSkill();
    public int getDamage();
    public void upgrade(Human h);
}
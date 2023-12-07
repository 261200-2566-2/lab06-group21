public class Sword implements weapon {
    private int level = 1;
    private int damage = 10;
    public int skill = 15;

    /** Instantiate Sword class
     * effects: คำนวณค่า attack ของ object Human ที่รับเข้ามา โดยบวกค่า damage เพิ่มเข้าไป
     * @param h object type Human ที่ใช้เพื่อเข้าถึงค่า attack
     */
    Sword(Human h){
        h.attack += damage;
    }

    /** ส่งค่าชื่อของ weapon
     * @return ชื่อของ weapon
     */
    public String getName(){
        return Sword.class.getName();
    }
    /** ส่งค่า level ของ weapon
     * @return level ของ weapon
     */
    public int getLevel(){
        return level;
    }
    /** ส่งค่า skill ของ weapon
     * @return skill ของ weapon
     */
    public int getSkill(){
        return skill;
    }

    /** ส่งค่า damage ของ weapon
     * @return damage ของ weapon
     */
    public int getDamage(){
        return damage;
    }

    /** เปลี่ยนแปลง field ของ Sword
     * effects: เปลี่ยนแปลงค่าของ level, damage and attack
     * @param h object type Human ที่ใช้เพื่อเข้าถึงค่า attack
     */
    public void upgrade(Human h){
        level += 1;
        damage += 2;
        h.attack += 2;
    }
}
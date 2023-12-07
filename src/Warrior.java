public class  Warrior extends Human{
    /** Instantiate Warrior class
     * effects: เรียกใช้ constructor ของ class Human
     * @param name type String เพื่อเป็น input ของ constructor ที่เรียกใช้
     */
    Warrior(String name){
        super(name,150,50,7);
    }

    /** ส่งค่าชื่ออาชีพของ character
     * @return ชื่ออาชีพของ character
     */
    @Override
    public String getJob(){ return Warrior.class.getName(); }

    /** คำนวณค่า HP ของคู่ต่อสู้ใหม่เมื่อตัวละครที่เรียก method นี้ กำลังถือ weapon อยู่
     * effects: แก้ไขค่า mana
     * @param h object type Human ที่ใช้เพื่อเข้าถึงค่า HP ของตัวละครที่เรียก method นี้
     */
    @Override
    public void useSkill(Human h){
        if(haveWeapon) {
            h.HP -= attack + weapon.getSkill();
            mana -= 10;
        }
    }

    /** เพิ่ม Level, HP, mana และ attack ของ character
     * effects: เพิ่ม Level, HP, mana และ attack ของ character
     */
    public void levelUp(){
        level += 1;
        HP += 10;
        mana += 5;
        attack += 2;
    }
}

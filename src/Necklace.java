public class Necklace implements accessories{
    private int level = 1;
    private int ability = 5;
    private int HP = 20;

    /** Instantiate object ของ class Necklace
     * effects: เปลี่ยนแปลงค่า mana ของ object class Human โดยเพิ่มจากค่า abililty ของ Necklace
     * effects: เปลี่ยนแปลงค่า HP ของ object class Human โดยเพิ่มจากค่า HP ของ Necklace
     * @param h object class Human ที่ใช้เพื่อเข้าถึง method และ field ใน class Human
     */
    Necklace(Human h){
        h.mana += ability;
        h.HP += HP;
    }
    /** ส่งค่า name ของ Necklace
     * @return ชื่อของ class
     */
    public String getName(){
        return Necklace.class.getName();
    }
    /** ส่งค่า level ของ Necklace
     * @return level ของ Necklace
     */
    public int getLevel(){
        return level;
    }
    /** ส่งค่า ability ของ Necklace
     * @return ability ของ Necklace
     */
    public int getAbility(){
        return ability;
    }

    /** ส่งค่า HP ของ Necklace
     * @return HP ของ Necklace
     */
    public int getHP(){
        return HP;
    }
    /** เปลี่ยนแปลง field ของ Necklace
     *  effects: เปลี่ยนแปลงค่าของ level
     *  effects: เปลี่ยนแปลงค่าของ ability
     *  effectS: เปลี่ยนแปลงค่าของ HP
     */
    public void upgrade(){
        level += 1;
        ability += 10;
        HP += 10;
    }

}
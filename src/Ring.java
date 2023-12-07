public class Ring implements accessories{
    private int level = 1;
    private int ability = 5;
    private int HP = 20;

    /** Instantiate object ของ class Ring
     * effects: เปลี่ยนแปลงค่า attack ของ object class Human โดยเพิ่มจากค่า abililty ของ Necklace
     * effects: เปลี่ยนแปลงค่า HP ของ object class Human โดยเพิ่มจากค่า HP ของ Necklace
      * @param h object class Human ที่ใช้เพื่อเข้าถึง method และ field ใน class Human
     */
    Ring(Human h){
        h.attack += ability;
        h.HP += HP;
    }
    /** ส่งค่า name ของ Ring
     * @return ชื่อของ class
     */
    public String getName(){
        return Ring.class.getName();
    }
    /** ส่งค่า level ของ Ring
     * @return level ของ Ring
     */
    public int getLevel(){
        return level;
    }
    /** ส่งค่า ability ของ Ring
     * @return ability ของ Ring
     */
    public int getAbility(){
        return ability;
    }

    /** ส่งค่า HP ของ Ring
     * @return HP ของ Ring
     */
    public int getHP(){
        return HP;
    }
    /** เปลี่ยนแปลง field ของ Ring
     *  effects: เปลี่ยนแปลงค่าของ level
     *  effects: เปลี่ยนแปลงค่าของ ability
     *  effectS: เปลี่ยนแปลงค่าของ HP
     */
    public void upgrade(){
        level += 1;
        ability += 5;
        HP += 10;
    }

}
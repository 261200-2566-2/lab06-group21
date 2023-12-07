public class Human implements humanInterface{
    protected String name;
    protected int HP;
    protected int mana;
    protected int attack;
    protected int level;
    protected boolean haveAccessories;
    protected boolean haveWeapon;
    protected accessories accessories;
    protected weapon weapon;

    /** Instantiate Human class
     * effects: กำหนดค่าให้ตัวแปร name, HP, mana and attack
     */
    Human(String name, int HP, int mana, int attack){
        this.name = name;
        this.HP = HP;
        this.mana = mana;
        level = 1;
        this.attack = attack;
    }

    /** ส่งค่าอาชีพของ character
     * @return null
     */
    public String getJob(){
        return null;
    }

    /** เพิ่ม Level ของ character
     * effects: เพิ่ม Level ของ character
     */
    public void levelUp(){
        level += 1;
    }

    /** ลดค่า HP ของคู่ต่อสู้
     * effects: ลดค่า HP ของคู่ต่อสู้โดยลบ HP ของคู่ต่อสู้ด้วยค่า attack ของตัวละครที่เรียก method นี้
     * @param h object type Human ที่ใช้เพื่อเข้าถึงค่า HP ของตัวละครที่เรียก method นี้
     */
    public void attack(Human h){
        h.HP -= this.attack;
    }

    /** คำนวณค่า HP ของคู่ต่อสู้ใหม่เมื่อตัวละครที่เรียก method นี้ กำลังถือ weapon อยู่
     * @param h object type Human ที่ใช้เพื่อเข้าถึงทุก method และ field ใน class Human
     */
    public void useSkill(Human h){
    }

    /** เช็คว่าตัวละครที่เรียกใช้ method นี้ ถือ accessories อยู่หรือไม่
     * @return หากตัวละครที่เรียกใช้ method นี้ ถือ accessories อยู่จะส่งชื่อของ accessories ที่ถืออยู่ออกไป
     * แต่ถ้าหากไม่ได้ถือ accessories อยู่จะส่งคำว่า none ออกไป
     */
    public String isHaveAccessories(){
        if(haveAccessories) return accessories.getName();
        else return "none";
    }

    /** เช็คว่าตัวละครที่เรียกใช้ method นี้ ถือ weapon อยู่หรือไม่
     * @return หากตัวละครที่เรียกใช้ method นี้ ถือ weapon อยู่จะส่งชื่อของ weapon ที่ถืออยู่ออกไป
     * แต่ถ้าหากไม่ได้ถือ weapon อยู่จะส่งคำว่า none ออกไป
     */
    public String isHaveWeapon(){
        if(haveWeapon) return weapon.getName();
        else return "none";
    }

    /** สร้าง object ของ class ตามชื่อที่ส่งเข้าไปใน method นี้
     * effects: สร้าง object ที่ชื่อตรงกับ String ที่ส่งเข้ามา และ กำหนดค่า true ให้กับตัวแปร haveAccessories
     * @param acs type String รับเข้ามาเพื่อนำไปเช็คว่าตรงกับชื่อ class หรือไม่
     */
    public void equipAccessories(String acs) {
        if (!haveAccessories) {
            if (acs.equalsIgnoreCase("Ring")) {
                accessories = new Ring(this);
                haveAccessories = true;
            } else if (acs.equalsIgnoreCase("Necklace")) {
                accessories = new Necklace(this);
                haveAccessories = true;
            }
        }
    }

    /** สร้าง object ของ class ตามชื่อที่ส่งเข้าไปใน method นี้
     * effects: สร้าง object ที่ชื่อตรงกับ String ที่ส่งเข้ามา และ กำหนดค่า true ให้กับตัวแปร haveWeapon
     * @param wep type String รับเข้ามาเพื่อนำไปเช็คว่าตรงกับชื่อ class หรือไม่
     */
    public void equipWeapon(String wep){
        if(wep.equalsIgnoreCase("Sword")){
            weapon = new Sword(this);
            haveWeapon = true;
        }else if(wep.equalsIgnoreCase("Wand")){
            weapon = new Wand(this);
            haveWeapon = true;
        }

    }

    /** เรียก method upgrade ใน class weapon
     * effects: เรียก method upgrade ใน class weapon
     */
    public void upgradeWeapon() {
        if (haveWeapon){
            weapon.upgrade(this);
        }
    }
}
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        String welcomeMessage =
                "+---------------------------------+\n" +
                        "|                                 |\n" +
                        "|             WELCOME             |\n" +
                        "|                                 |\n" +
                        "+---------------------------------+";

        System.out.println(welcomeMessage);

        Scanner s = new Scanner(System.in);
        System.out.print("Enter player 1 name : ");
        String name1 = s.nextLine();
        String cls1;
        Human p1 = null;
        Human p2 = null;
        do {
            System.out.println("Choose your class : Warrior / Wizard");
            cls1 = s.nextLine();
            if (cls1.equalsIgnoreCase("Warrior")) {
                p1 = new Warrior(name1);
            } else if (cls1.equalsIgnoreCase("Wizard")) {
                p1 = new Wizard(name1);
            } else {
                System.out.println("Nahh bro");
            }
        } while (p1 == null);

        System.out.print("Enter player 2 name : ");
        String name2 = s.nextLine();
        String cls2;
        do {
            System.out.println("Choose your class : Warrior / Wizard");
            cls2 = s.nextLine();
            if (cls2.equalsIgnoreCase("Warrior")) {
                p2 = new Warrior(name2);
            } else if (cls2.equalsIgnoreCase("Wizard")) {
                p2 = new Wizard(name2);
            } else {
                System.out.println("Nahh bro");
            }
        } while (p2 == null);

//        Warrior p1 = new Warrior("poon");
//        Wizard p2 = new Wizard("mew");
        System.out.printf("------------------------------------------------------%n");
        System.out.printf("                    BATTLE START                      %n");
        do {
            stat(p1, p2);
            timeToUpgrade(p1);
            stat(p1,p2);
            timeToAttack(p1,p2);
            if(p1.HP <= 0 || p2.HP <= 0) break;

            stat(p1,p2);
            timeToUpgrade(p2);
            stat(p1,p2);
            timeToAttack(p2,p1);
        }while (p1.HP >= 0 && p2.HP >= 0);

        if(p1.HP <= 0) System.out.println(p2.name + " WIN !");
        else System.out.println(p1.name + " WIN !");
    }
    /** แสดง stat ของ object class Human
     * effects: แสดงตาราง stat ของ object class Human ทั้งสอง ใน terminal
     * @param p1 object class Human ที่ใช้เพื่อเข้าถึง method และ field ใน class Human คนแรก
     * @param p2 object class Human ที่ใช้เพื่อเข้าถึง method และ field ใน class Human คนที่สอง
     */
    public static void stat(Human p1,Human p2){
        int accLevel1;
        int accHP1;
        int accAb1;
        int wepLevel1;
        int wepSk1;
        int accLevel2;
        int accHP2;
        int accAb2;
        int wepLevel2;
        int wepSk2;
        int wepDe1;
        int wepDe2;

        if(!p1.haveAccessories) accLevel1 = 0;
        else accLevel1 = p1.accessories.getLevel();
        if(!p2.haveAccessories) accLevel2 = 0;
        else accLevel2 = p2.accessories.getLevel();
        if(!p1.haveAccessories) accHP1 = 0;
        else accHP1 = p1.accessories.getHP();
        if(!p2.haveAccessories) accHP2 = 0;
        else accHP2= p2.accessories.getHP();
        if(!p1.haveAccessories) accAb1 = 0;
        else accAb1 = p1.accessories.getAbility();
        if(!p2.haveAccessories) accAb2 = 0;
        else accAb2= p2.accessories.getAbility();

        if(!p1.haveWeapon) wepLevel1 = 0;
        else wepLevel1 = p1.weapon.getLevel();
        if(!p2.haveWeapon) wepLevel2 = 0;
        else wepLevel2 = p2.weapon.getLevel();
        if(!p1.haveWeapon) wepSk1 = 0;
        else wepSk1 = p1.weapon.getSkill();
        if(!p2.haveWeapon) wepSk2 = 0;
        else wepSk2 = p2.weapon.getSkill();
        if(!p1.haveWeapon) wepDe1 = 0;
        else wepDe1 = p1.weapon.getDamage();
        if(!p2.haveWeapon) wepDe2 = 0;
        else wepDe2 = p2.weapon.getDamage();

        System.out.printf("------------------------------------------------------%n");
        System.out.printf("| %-30s  %-22s  %n", "Player 1", "Player 2");
        System.out.printf("| %-30s  %-22s  %n", p1.name, p2.name);
        System.out.printf("------------------------------------------------------%n");

        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "level", p1.level,"level",  p2.level);
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "HP", p1.HP,"HP",  p2.HP);
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "mana", p1.mana,"mana",  p2.mana);
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "attack", p1.attack,"attack",  p2.attack);
        System.out.printf("| %-19s  %-3s | %-20s  %-3s  %n", "accessories",p1.isHaveAccessories() ,"accessories",  p2.isHaveAccessories());
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "acc level", accLevel1,"acc level", accLevel2);
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "acc HP", accHP1,"acc HP", accHP2);
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "acc ability boost", accAb1,"acc ability boost", accAb2);
        System.out.printf("| %-19s  %-3s | %-20s  %-3s  %n", "weapon",p1.isHaveWeapon() ,"weapon",  p2.isHaveWeapon());
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "weapon level", wepLevel1,"weapon level", wepLevel2);
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "weapon skill damage", wepSk1,"weapon skill damage", wepSk2);
        System.out.printf("| %-20s  %03d | %-20s  %03d  %n", "weapon damage", wepDe1,"weapon damage", wepDe2);

        System.out.printf("------------------------------------------------------%n");


    }
    /** แสดง text ui ,ตอบโต้กับ client และ update ค่าต่างๆของ character ในเฟสการ upgrade
     * effects: scanner รับค่าที่ user ส่งเข้ามาดป็นตัวเลข 1-5 ถ้าใส่นอกเหนือจากนี้จะแสดง "Nahh"
     * effects: เมื่อเลือก 1 จะเป็นการเปลี่ยนค่าของ level
     * effects: เมื่อเลือก 2 จะแสดง "Choose your accessories : Ring / Necklace" และเป็นการใส่ assensorise ให้กับ character ตาม job ของ character
     *          ถ้าใส่ไว้แล้วแล้วจะส่ง "You already have accessories" แต่ถ้าป้อนค่าผิดจะแสดง "Nahh"
     * effects: เมื่อเลือก 3 จะแสดง เป็นการใส่ weapon  ให้ character ถ้าใส่อาวุธอยู่แล้วจะแสดง "You already have weapon"
     * effects: เมื่อเลือก 4 จะเปลี่ยนแปลงค่า level ของ weapon ถ้าไม่มี weapon จะแแสดง "You need to equip weapon first"
     * effects: เมื่อเลือก 5 จะเปลี่ยนแปลงค่า level ของ accessories ถ้าไม่มี accessories จะแสดง "You need to equip accessories first"
     * @param p object ของ class Human ที่ใช้เพื่อเข้าถึง method และ field ใน class Human
     */
    public static void timeToUpgrade(Human p){
        System.out.printf("                    TIME TO UPGRADE                   %n");
        System.out.printf("------------------------------------------------------%n");
        System.out.println(
                "   Player "+ p.name +" time to upgrade\n" +
                        "1.level up\n" + "2.equip accessories\n" + "3.equip weapon\n" + "4.upgrade weapon\n" + "5.upgrade accessorise\n"+ "Enter number : "
        );
        Scanner s = new Scanner(System.in);
        boolean pass = true;
        do {
            int up = s.nextInt();
            pass = true;
            if (up == 1) {
                p.levelUp();
                System.out.println(p.name + " level up to level " + p.level +" !");
            } else if (up == 2) {
                if(!p.haveAccessories) {
                    System.out.println("Choose your accessories : Ring / Necklace");
                    String acs = s.nextLine();
                    do {
                        acs = s.nextLine();
                        if(!acs.equalsIgnoreCase("Ring") && !acs.equalsIgnoreCase("Necklace")){
                            System.out.println("Nahh");
                        }else{
                            p.equipAccessories(acs);
                        }
                    } while (!acs.equalsIgnoreCase("Ring") && !acs.equalsIgnoreCase("Necklace"));
                    System.out.println(p.name + " equip " + p.accessories.getName() + " !");
                }else{
                    System.out.println("You already have accessories");
                    pass = false;
                }
            } else if (up == 3) {
                if(!p.haveWeapon) {
                    if (p.getJob().equals("Warrior")) {
                        p.equipWeapon("Sword");
                        System.out.println(p.name + " equip " + p.weapon.getName() + " !");
                    } else if(p.getJob().equals("Wizard")) {
                        p.equipWeapon("Wand");
                        System.out.println(p.name + " equip " + p.weapon.getName() + " !");
                    }
                }else{
                    System.out.println("You already have weapon");
                    pass = false;
                }
            } else if (up == 4) {
                if (p.haveWeapon) {
                    p.upgradeWeapon();
                    System.out.println("Your weapon level up to level "+ p.weapon.getLevel() +" !");
                } else {
                    System.out.println("You need to equip weapon first");
                    pass = false;
                }
            }else if (up == 5) {
                if (p.haveAccessories) {
                    p.accessories.upgrade();
                    System.out.println("Your accessories level up to level " + p.accessories.getLevel() + " !");
                } else {
                    System.out.println("You need to equip accessories first");
                    pass = false;
                }
            }else{
                System.out.println("Nahh");
                pass = false;
            }
        }while (!pass);

    }

    /** แสดง text ui ,ตอบโต้กับ client และ update ค่าต่าง ๆ ของ character ในเฟสการ attack
     * effects: scanner รับค่าที่ user ส่งเข้ามาดป็นตัวเลข 1-5 ถ้าใส่นอกเหนือจากนี้จะแสดง "Nahh"
     *          แต่ถ้าไม่มี weapon จะแสดง "You need to equip weapon first"
     * effects: เมื่อเลือก 1 จะลดค่าของ HP ของ Human คนที่สองด้วย attack ของคนแรก
     * effects: เมื่อเลือก 2 จะลดค่าของ HP ของ Human คนที่สองด้วย attack + skill ของคนแรก
     * @param p1 object ของ class Human ที่ใช้เพื่อเข้าถึง method และ field ใน class Human คนแรก
     * @param p2 object ของ class Human ที่ใช้เพื่อเข้าถึง method และ field ใน class Human คนที่สอง
     */
    public static void timeToAttack(Human p1,Human p2){
        System.out.printf("                    TIME TO ATTACK                    %n");
        System.out.printf("------------------------------------------------------%n");
        System.out.println(
                "   Player "+ p1.name +" time to attack\n" +
                        "1.attack\n" + "2.skill\n" + "Enter number : "
        );
        Scanner s = new Scanner(System.in);
        boolean pass = true;
        do{
            int up = s.nextInt();
            pass = true;
            if(up == 1){
                p1.attack(p2);
                System.out.println(p2.name +" was attack by asshole " + p1.name + "  -" + p1.attack);
                System.out.println(p2.name + " has " + p2.HP +" HP !");
            }else if(up == 2) {
                if (p1.haveWeapon) {
                    if (p1.getJob().equalsIgnoreCase("Warrior")) {
                        p1.useSkill(p2);
                        System.out.println(p1.name + " used slash !" + "  -" + (p1.attack + p1.weapon.getSkill()));
                        System.out.println(p2.name + " has " + p2.HP + " HP !");
                    } else if (p1.getJob().equalsIgnoreCase("Wizard")) {
                        p1.useSkill(p2);
                        System.out.println(p1.name + " used fire ball !" + "  -" + (p1.attack + p1.weapon.getSkill()));
                        System.out.println(p2.name + " has " + p2.HP + " HP !");
                    }
                }else {
                    System.out.println("You need to equip weapon first");
                    pass = false;
                }
            }else {
                System.out.println("Nahh");
                pass = false;
            }
        }while (!pass);
    }
}
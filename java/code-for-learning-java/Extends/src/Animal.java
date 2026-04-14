public class Animal {
    public String name;
    public String color;
    public int age;
    public String sex;
    public void eat(){
        System.out.println("宠物猪正在吃猪食");
       /* System.out.println("小狗正在吃狗粮");*/
    }
    public void run(){
        System.out.println("宠物猪正在跑步");
       /* System.out.println("小狗正在跑步");*/
    }
    public static void Aniaml(Animal animal){
        animal.run();
    }
}

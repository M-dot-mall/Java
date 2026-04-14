
public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.color = "黑色";
        Animal animal2 = new PigPet();
        System.out.println(animal.color);
        animal.run();
        animal2.run();
    }
    public static void main2(String[] args) {
 /*       B b=new B();*/
        Engine engine=new Engine("V6",300);
        Car car=new Car("奔驰",engine);
        car.startEngine();
    }
    public static void main1(String[] args) {
      /*  Dog dog = new Dog();
        dog.color="黑色";
        dog.age=1;
        dog.name="大黄";
        dog.sex="female";*/
        PigPet pigPet = new PigPet();
        pigPet.name="佩奇";
        pigPet.age=12;
        pigPet.color="粉色";
        pigPet.sex="male";
/*        System.out.println("小狗叫"+dog.name+"颜色是"+dog.color+"年龄是"+dog.age);
        System.out.println("宠物猪叫"+pigPet.name+"颜色是"+pigPet.color+"年龄是"+pigPet.age);*/
     /*   dog.eat();
        dog.run();*/
        pigPet.eat();
        pigPet.run();
    }
}
class Engine{
    private String type;
    private int power;
    public Engine(String type,int power){
        this.type=type;
        this.power=power;
    }
    public void start(){
        System.out.println("发动机启动，类型："+type+"功率："+power);
    }
}
class Car{
    private String name;
    private Engine engine;
    public Car(String name,Engine engine){
        this.name=name;
        this.engine=engine;
    }
    public void startEngine(){
        System.out.println(name+"汽车启动");
        engine.start();
    }
}
/*
class A{
    static {
        System.out.println("代码1,静态代码块");
    }
    {
        System.out.println("代码2,实例化代码块");
    }
    public A(){
        System.out.println("代码3,构造代码块");
    }
}
class B extends A{
    static {
        System.out.println("代码4,子类静态代码块");
    }
    {
        System.out.println("代码5,子类实例化代码块");
    }
    public B(){

        System.out.println("代码6,子类构造代码块");
    }
}
*/


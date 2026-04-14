class Animal{
    public void Animal(){
        System.out.println("父类构造方法");
    }
}
class Dog extends Animal{
    public void Dog(){
        System.out.println("狗类构造方法");
    }
}
class HDog extends Dog{
    public void HDog(){
        System.out.println("哈士奇类构造方法");
    }
}
class Base{
    Base(string s){
        System.out.print("B");
    }
}
public class extend extends Base{
    public extend(string s){
        super(s);
        System.out.println("D");
    }
    public static void main(String[] args) {
       Animal animal=new Dog();
        Dog dog2=new HDog();
        Animal dog3=new HDog();
       new extend(D);

    }
}
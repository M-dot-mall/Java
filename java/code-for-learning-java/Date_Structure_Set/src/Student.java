public class Student {
    public int age;
    public String name;
    public int ID;
    public String sex;
    //重写toString方法
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", ID=" + ID +
                '}';
    }
}

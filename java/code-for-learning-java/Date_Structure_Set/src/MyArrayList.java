import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Objects;

public class MyArrayList {

    private static final int MAXSIZE = 10;
    private Student []elem;
    Student data = new Student();
    private int usedsized = 0;
    //初始化顺序表
    public void initList(){
        this.usedsized=0;
        elem = new Student[MAXSIZE];
    }
    //判断顺序表是否已满
    public boolean ifFull(){
        if(usedsized==MAXSIZE){
            return true;
        }
        return false;
    }
    //在末尾添加元素
    public void add(){
        if(!ifFull()){
            System.out.println("请输入姓名：");
            Scanner scanner = new Scanner(System.in);
            elem[this.usedsized] = new Student();
            data.name =scanner.nextLine();
            elem[this.usedsized].name = data.name;
            System.out.println("请输入年龄：");
            data.age=scanner.nextInt();
            elem[this.usedsized].age=data.age;
            scanner.nextLine();
            System.out.println("请输入性别：");
            data.sex=scanner.nextLine();
            elem[this.usedsized].sex=data.sex;
            System.out.println("请输入学号：");
            data.ID=scanner.nextInt();
            elem[this.usedsized].ID=data.ID;
            usedsized++;
        }
        else{
            elem = Arrays.copyOf(elem,2*elem.length);
            System.out.println("扩容成功");
        }
    }
    //展示顺序表
    public void displayList() {
        for (int i = 0; i < usedsized; i++) {
            Student student = elem[i];
            if (student != null) { // 确保元素非空
                System.out.println("姓名：" + student.name +
                        ", 年龄：" + student.age +
                        ", 性别：" + student.sex +
                        ", 学号：" + student.ID);
            }
        }
    }
    //判断顺序表是否为空
    public boolean isEmpty(){
        if(this.usedsized == 0){
            return true;
        }
        return false;
    }
    //删除顺序表末尾元素
    public void deleteList(){
        if(isEmpty()){
            System.out.println("顺序表是空表,不能删除");
            return;
        }
        usedsized--;
    }
    //在指定位置插入元素
    public void add(int pos){
        if(!ifFull()){
            for (int i = usedsized-1; i >= pos; i--) {
                elem[i+1] = elem[i];
            }
            //在pos位置加上元素
            Scanner scanner = new Scanner(System.in);
            elem[pos] = new Student();
            System.out.println("请输入姓名：");
            data.name =scanner.nextLine();
            elem[pos].name = data.name;
            System.out.println("请输入年龄：");
            data.age=scanner.nextInt();
            elem[pos].age=data.age;
            scanner.nextLine();
            System.out.println("请输入性别：");
            data.sex=scanner.nextLine();
            elem[pos].sex=data.sex;
            System.out.println("请输入学号：");
            data.ID=scanner.nextInt();
            elem[pos].ID=data.ID;
            usedsized++;
        }
        else{
            elem = Arrays.copyOf(elem,2*elem.length);
            System.out.println("扩容成功");
        }
    }
    //在指定位置删除元素
    public void deleteList(int pos){
        if(isEmpty()){
            System.out.println("顺序表是空，不能删除元素");
        }
        else {
            for (int i = pos; i < usedsized - 1; i++) {
                elem[i] = elem[i + 1];
            }
            usedsized--;
        }
    }

    //在顺序表中查找元素
    public String reaserchList(String name){
        if(Objects.equals(name,"")){
            System.out.println("输入错误！");
            return null;
        }
        name = name.trim();
        for (int i = 0; i < usedsized; i++) {
            if(Objects.equals(this.elem[i].name,name)){
                return elem[i].toString();
            }
        }
        System.out.println("无要查找的元素！");
        return null;
    }

}


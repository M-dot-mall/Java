/*class Alg<T extends Comparable<T>>{

    public T max(T []array){
        T max=array[0];
        for(int i=0;i<array.length;i++){

            if(max.compareTo(array[i])<0){
                max=array[i];
            }
        }
        return max;
    }
}*/

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.initList();
        myArrayList.add();
        myArrayList.add();
        /*myArrayList.add(1);*/
        /*myArrayList.deleteList(0);*/
        /*myArrayList.displayList();*/
        String student = myArrayList.reaserchList("1");
        System.out.println(student);
    }
}
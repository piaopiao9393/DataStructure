package array;

public class Main {
    public static void main(String[] args){
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("lsg", 26));
        studentArray.addLast(new Student("wn", 25));
        studentArray.addLast(new Student("hjl", 24));
        System.out.println(studentArray);
    }
}

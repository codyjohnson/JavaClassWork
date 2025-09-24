package Sep_23_2025;

public class Main {

    public static void main(String[] args) {

    Parent grandChild = new GrandChild();
    grandChild.func1();
    grandChild.func2();
    grandChild.func3();


    }


}

abstract class Parent {

    abstract void func1();
    abstract void func2();
    abstract void func3();
}

abstract  class Child extends Parent {

    void func1() {
        System.out.println("func1");
    }
    abstract void func2();
    abstract void func3();
}

class GrandChild extends Child {

    void func2() {
        System.out.println("func2");
    }
    void func3() {
        System.out.println("func3");
    }
}

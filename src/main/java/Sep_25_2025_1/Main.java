package Sep_25_2025_1;

public class Main {

    public static void main(String[] args) {

        A<Object> a0 = new A<Object>("Test");
        System.out.println(a0.getA());

        A<Object> a1 = new A<Object>(20);
        System.out.println(a1.getA());

        A<Object> a2 = new A<Object>(20.5646);
        System.out.println(a2.getA());


    }
}

class A<T> {

    private T a;

    public A(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }
    public void setA(T a) {
        this.a = a;
    }
}

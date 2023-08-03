class Calculator{
    void multiply(int a, int b) {
        System.out.println("결과는 : " + (a * b) + "입니다.");
    }
        void multiply(int a, int b, int c) {
        System.out.println("결과는 : " + (a * b * c) + "입니다.");
    }
        void multiply(double a, double b) {
        System.out.println("결과는 : " + (a * b) + "입니다.");
    }
}

public class MyClass {
    public static void main(Sring args[]) {
        int a = 1;
        int b = 2;
        int d = 3;

        Calculator c = new Calculator();
        c.multiply(a, b);
        c.multiply(a, b, d);

        double aa = 1.2;
        double bb = 1.4;

        c.multiply(aa, bb);
    }
}


// overriding-1
class Animal{
    void eat() {
        System.out.println("먹습니다.");
    }
}
class Person extends Animal{
    @Override
    void eat(){
        System.out.println("사람처럼 먹습니다.");
    }
}


// overriding-2
interface Animal{
    public void eat();
}
class Person implements Animal{
    @Override
    public void eat(){
        System.out.println("사람처럼 먹습니다.")
    }
}



// 추상화
abstract class Animal {
    public abstract void animalSound();
    public void sleep() {
        System.out.println("zzz");
    }
}

class Pig extends Animal {
    public void animalSound() {
        System.out.println('꿀꿀꿀~');
    }
}
class Dog extends Animal {
    public void animalSound() {
        System.out.println("왈왈~");
    }
}

public class Main {
    public static void main(String[] args) {
        Pig a = new Pig();
        a.animalSound();
        a.sleep();
        Dog b = new Dog();
        b.animalSound();
        b.sleep();
    }
}

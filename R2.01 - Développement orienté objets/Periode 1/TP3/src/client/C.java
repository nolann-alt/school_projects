package client;
import jeux.B;
public class C extends B{
    private int c1;
    public C(){
        super(-10);
        System.out.println("Constructeur de C");
    }
    public void m1(){
        System.out.println("m1 de C");
    }
    public void m5() {
        // this.a1=2;
        // this.a2=3;
        this.a3=4;
        this.a4=5;

        System.out.println(this.getA1());
        this.m2();
    }

    protected void m7() {
        System.out.println("M7");
    }

    void m8() {
        System.out.println("M8");
    }
}


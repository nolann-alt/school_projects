package jeux;
public class A {
    private int a1;
    int a2;
    protected int a3;
    public int a4;
    public A(){
        System.out.println("Constructeur de A");
        this.a1=1;
        this.a2=2;
        this.a3=3;
        this.a4=4;
    }
    public int getA1(){
        System.out.println("getA1 de A");
        return this.a1;
    }
    protected void m2(){
        System.out.println("m2 de A");
    }
    void m3(){
        System.out.println("m3 de A");
    }
    private void m4(){
        System.out.println("m4 de A");
    }
}
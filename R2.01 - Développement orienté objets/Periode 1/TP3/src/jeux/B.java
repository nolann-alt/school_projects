package jeux;
public class B extends A{
    private int b1;
    public B(int i){
        System.out.println("Constructeur de B");
        this.b1=i;
    }
    protected void m2(){
        System.out.println("m2 de B");
        super.m2();
    }

    public void m6() {
        //this.a1=2;
        this.a2=3;
        this.a3=4;
        this.a4=5;
    }
}

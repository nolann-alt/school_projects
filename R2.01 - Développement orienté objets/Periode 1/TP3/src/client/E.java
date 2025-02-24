package client;
import jeux.*;
public class E{
    public static void main(String args[]){
        A unA=new A();
        B unB=new B(3);
        C unC =new C();
        D unD =new D();
        E unE=new E();

        unC.m5();

        // Accès inter-objets direct
        // unC.a1 = 3;
        unC.m7();
        unC.m8();
        unC.m1();

        // Accès inter-objets indirect
       //  unC.a1 = 3;
        // unC.a2 = 4;
        // unC.a3 = 5;
        unC.a4 = 6;


        // Accès inter-objets entre 2 classes de package différents
        // unA.a1 = 3;
        // unA.a2 = 4;
        // unA.a3 = 5;
        unA.a4 = 6;

        // Question 5
        // unA.m2();
        // unB.m2();
        // unC.m2();
        unD.m2();

        System.out.println("----------------------------------------------------------------------");

        unA = unC;
        unC = (C) unA;
        unC.m5();
        unA = unD;
        unC = (C) unA;


    }
}

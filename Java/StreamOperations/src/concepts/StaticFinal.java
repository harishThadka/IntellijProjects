package concepts;

public class StaticFinal {

    public static void main(String[] args) {

        B b = new B();
        b.show();
        b.show(5,7);

    }


}


class A{
    
    public void show(){
        System.out.println("In A show");
    }
}

class B extends  A{

    @Override
    public final void show(){
        System.out.println("In B show");
    }

    public final void show(int a, int b){
        System.out.println("In final b show");
    }
}

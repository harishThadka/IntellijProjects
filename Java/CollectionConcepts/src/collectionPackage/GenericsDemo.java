package collectionPackage;

import java.util.HashMap;

public class GenericsDemo {

    public static void main(String[] args) {

        Container container = new Container<>();
        container.value = (Number)1;
        container.show();


    }
}

class Container<T>{

    T value;

    public void show(){
        System.out.println(value.getClass());
    }
}

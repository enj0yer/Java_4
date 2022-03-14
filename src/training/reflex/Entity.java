package training.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Entity {

    @Override
    public String toString() {
        String output = "" + this.getClass().getName() + " ==> ";

        Field[] fields = this.getClass().getDeclaredFields();

        for (var el : fields){
            output += el.getName() + " = ";
            try {
                output += el.get(this).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            output += ",";
        }

//        if (this.getClass().getSuperclass() != null){
//            try {
//                output += this.getClass().newInstance().toString();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }


        return output;
    }
}

class A extends Entity{
    String a = "sohfisguofi";
    int num = 2849;
}

class B extends A{
    Object obj = new Object();
}

import java.util.ArrayList;
import java.util.Collections;

class PrintFirstChar implements Runnable{

    Fruits fruits;

    public PrintFirstChar(Fruits fruits) {
        this.fruits = fruits;
    }

    @Override
    public void run() {
      String str1 = fruits.name;
      System.out.println("The first character of "+str1+" Fruit: "+str1.charAt(0));
      
       System.out.println(" by " + Thread.currentThread().getName());
    }
    
}

public class Fruits{
    String name;
    String color;
    

    public Fruits(String name, String color) {
        this.name = name;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Fruits [name=" + name + ", color=" + color + "]";
    }
    public static void main(String[] args) {
        Fruits f1=new Fruits("Mango", "Yellow");
        Fruits f2=new Fruits("Banana", "Yellow");
        Fruits f3=new Fruits("Apple", "Red");
        ArrayList<Fruits> fruits=new ArrayList<>();
        fruits.add(f1);
        fruits.add(f2);
        fruits.add(f3);
        for(Fruits f:fruits)
        {
            System.out.println(f);
        }
         for(Fruits f:fruits)
        {
            Thread t=new Thread(new PrintFirstChar(f));
            t.start();
        }

    }
    
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class Branch {
    String location;
    int id;
    public Branch(String location, int id) {
        this.location = location;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Branch [location=" + location + ", id=" + id + "]";
    }
    // public static void main(String[] args) {
    //     Branch b1=new Branch("Hyderabad", 232);
    //     Branch b2=new Branch("Siddipet", 272);
    //     Branch b3=new Branch("Karimnagar", 242);
    //     Branch b4=new Branch("Coimbatore", 252);
    //     Branch b5=new Branch("Chennai", 262);


    //     List<Branch> braches=new LinkedList<>();
    //     braches.add(b1);
    //     braches.add(b2);
    //     braches.add(b3);
    //     braches.add(b4);
    //     braches.add(b5);


        // Map<String,Branch> banks=new HashMap<>();
        // banks.put("HDFC", b1);
        // banks.put("ICICI", b2);
        // banks.put("SBI", b3);
        // banks.put("DBS", b4);
        // banks.put("BOB", b5);

        // System.out.println(banks);
        // Set<String> keys=banks.keySet();
        // System.out.println(banks);

        // for(String i: keys){
        //     System.out.println(banks.get(i));
        // }
        


    // }
}


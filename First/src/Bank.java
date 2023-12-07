import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class Bank {
    String name;
    int id;
    List<Branch> branches;

    
    
    public List<Branch> getBranches() {
        return branches;
    }
    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
    public Bank(String name, int id, List<Branch> branches) {
        this.name = name;
        this.id = id;
        this.branches = branches;
    }
    public Bank(String name, int id) {
        this.name = name;
        this.id = id;
    }
 
    @Override
    public String toString() {
        return "Bank [name=" + name + ", id=" + id + ", branches=" + branches + "]";
    }
    public static void printBankDetails( Map<String,Bank> banks, String bankName){
        System.out.println(banks.get(bankName));
    }

    public static void addBranchToBank( Map<String,Bank> banks, String bankName, Branch branch){
        // System.out.println(banks.get(bankName));

        Bank bank = banks.get(bankName);
        bank.branches.add(branch);

        System.out.println(bank);
    }
    public static boolean findBankBranch(Map<String,Bank> banks,String bankName,String branchName){
        Bank bank =  banks.get(bankName);
        if(bank!=null){
            for(Branch b :  bank.branches){
                if(b.location.equals(branchName)){
                    return true;
                }
            }
        }
        return false;
    }

    

    public static void main(String[] args) {
        Bank b1=new Bank("HDFC", 232);
        Bank b2=new Bank("ICICI", 272);
        Bank b3=new Bank("SBI", 242);
        Bank b4=new Bank("DBS", 252);
       

        Map<String,Bank> banks=new HashMap<>();
        banks.put("HDFC", b1);
        banks.put("ICICI", b2);
        banks.put("SBI", b3);
        banks.put("DBS", b4);
        // banks.put("BOB", b5);

        Branch c1=new Branch("Hyderabad", 232);
        Branch c2=new Branch("Siddipet", 272);
        Branch c3=new Branch("Karimnagar", 242);
        Branch c4=new Branch("Coimbatore", 252);
        Branch c5=new Branch("Chennai", 262);

       


        List<Branch> braches=new LinkedList<>();
        braches.add(c1);
        braches.add(c2);
        braches.add(c3);
        braches.add(c4);
        braches.add(c5);

        //setters
         b1.setBranches(braches);

         //constructor
          Bank b5=new Bank("BOB", 262, braches);

    

        // System.out.println(banks);
        Set<String> keys=banks.keySet();
        // System.out.println(banks);

        for(String i: keys){
            // System.out.println(banks.get(i));
        }
        
    // System.out.println(braches);

    printBankDetails(banks, "HDFC");

    addBranchToBank(banks, "HDFC", new Branch("South Ex", 3));
        System.out.println(findBankBranch(banks,"HDFC", "South Ex"));
    }
}

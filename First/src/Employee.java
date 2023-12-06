public class Employee extends Object{
    int id;
    String name;
    double salary;
    // has-a 
    Address address;

    public Employee(int id, String name, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public double incrementSalary(double incrementAmount){
        this.salary += incrementAmount;
        return this.salary;
    }

    // constructor for initializing mandatory fields
    public Employee(){

    }
    public Employee(int id, String name, double s,String c){
        this.id = id;
        this.name = name;
        salary = s;
        
    }

    // public String toString(){
    //     return this.id + ": "  + this.name;
    // }
        // public String changeCity(String city)
        // {
        //     this.city=city;
        //     return "New City : "+this.city;
        // }
    
    public static void main(String[] args) {
        // create object of employee
        Address address = new Address(23, "Jangpura", "Delhi");
        Employee e = new Employee(12, "Priya", 34343.34, address);
        // e.name = "Amit";
        System.out.println(e.toString());
        System.out.println(e.incrementSalary(5000));
        // System.out.println(e.changeCity("Coimbatore"));
        System.out.println(e);
    }
    // @Override
    // public String toString() {
    //     return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ",City="+ city+ "]";
    // }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address="
                + address + "]";
    }

    
}

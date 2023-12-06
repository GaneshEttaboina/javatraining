public class Address {
    int houseNumber;
    String locality;
    String city;
    public Address(){
        
    }

    // public void setCity(String city) {
    //     this.city = city;
    // }

    public Address(int houseNumber, String locality, String city) {
        this.houseNumber = houseNumber;
        this.locality = locality;
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address [houseNumber=" + houseNumber + ", locality=" + locality + ", city=" + city + "]";
    }

    
}

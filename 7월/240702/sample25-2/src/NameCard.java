public class NameCard {
    String name;
    String phone;
    String email;

    PrintNameCard printNameCard; // interface

    public NameCard(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

   public void setPrintNameCard(PrintNameCard p) {
        this.printNameCard = p;
   }

   public void print() {
       this.printNameCard.print(this);
   }
}

public class Restaurant {
    private int availableTables;

    public Restaurant(int availableTables) {
        this.availableTables = availableTables;
    }

    public boolean reserveTable() {
        if(availableTables> 0) {
            availableTables--;
            return true;
        }else{
            return false;
        }
    }

    public boolean cancelReservation() {
        availableTables++;
        return true;
    }

    public int getAvailableTables() {
        return availableTables;
    }
}

public class One {
    private int number;

    public One(int number) {
        this.number = number;
    }

    public void oneMethod(){
        SingletonClass sc = SingletonClass.getInstance();
        sc.number = this.number;

    }

    public void oneFunc(){
        SingletonClass sc = SingletonClass.getInstance();
        String name = sc.name;
        System.out.println("name = " + name);
    }

    /*public int getNumber() {
        return number;
    }

    public void setName(String name){
        System.out.println("Twoclass name = " + name);
    }*/
}

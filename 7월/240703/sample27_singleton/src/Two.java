public class Two {
    private String name;

    public Two(String name) {
        this.name = name;
    }

    public void twoMethod(){
        SingletonClass sc = SingletonClass.getInstance();
        int number = sc.number;
        System.out.println(number);

        sc.name = this.name;
    }


    /*public void setNumber(int number){
        System.out.println( "Oneclass number = " +number);
    }

    public String getName() {
        return name;
    }*/
}

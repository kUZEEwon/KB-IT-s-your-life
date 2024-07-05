import java.util.Observable;

public class Member extends Observable {

    private String id;
    private String password;

    private String preArg = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void notifyObservers(Object arg) {
        String str = (String) arg;

        // 변화가 없음 -> 알려주지 않는다.
        if(str.equals(preArg)){
            return;
        }

        // 변화가 있음 -> 알려줌
        preArg = str;
        setChanged(); // reset


        super.notifyObservers(arg);

        clearChanged();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

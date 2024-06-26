package cls;

public class ParentClass {

    int parent_x;
    String parent_name;

    private int private_number; // 자식에게 물려주기 no(접근하려면 setter, getter), 현재 영역을 제외한 모든 곳에서 접근 불허
    public int public_number; // 모든 영역에서 접근이 가능하다
    protected int protected_number; // 현재 영역(같은 패키지)과 자식클래스(상속 받은 패키지)에서만 접근을 허용


    public void ParentMethod(){
        System.out.println(parent_x+"\tParentMethod");
    }
}

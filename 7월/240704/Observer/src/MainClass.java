public class MainClass {

    public static void main(String[] args) {
        /*
        * Observer : 정찰용 유닛
        *           감시자 패턴
        * */

        Member member = new Member();

        // 감시자를 추가
        member.addObserver(new ObserverA());
        System.out.println(member.toString());

        member.setId("abc");
        member.setPassword("pwpwpwpw213");
        member.notifyObservers(member.getPassword());

    }
}

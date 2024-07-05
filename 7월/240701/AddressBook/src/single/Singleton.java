package single;

import dto.HumanDto;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton sc = null;

    public List<HumanDto> list = null;

    private Singleton(){
        list = new ArrayList<HumanDto>();
        /*list.add(new HumanDto("홍길동", 24, "123", "강릉시", "친구"));
        list.add(new HumanDto("성춘향", 16, "234", "남원시", "여사친"));
        list.add(new HumanDto("일지매", 22, "345", "대구시", "후배"));*/
    }

     public static Singleton getInstance(){
        if(sc == null){
            sc = new Singleton();
        }
        return sc;
     }
}

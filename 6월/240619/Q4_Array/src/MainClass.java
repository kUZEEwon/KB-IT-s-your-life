import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        String subject[] = {"국어", "영어","수학","컴퓨터","화학"};
        int semester1[]={44, 66, 22, 99, 100};
        int semester2[]= new int[semester1.length];
        System.arraycopy(semester1, 0, semester2, 0, semester1.length);
        semester2[0]=22;
        semester2[2] = 88;


        System.out.println("1학기 성적: "+ Arrays.toString(semester1));
        System.out.println("2학기 성적: "+ Arrays.toString(semester2));

        int same=0;

        String [] BestSubjectIndex = new String[semester1.length];
        String [] temp = new String[semester1.length];
        for(int i=0;i<semester1.length;i++){
            if(semester1[i]==semester2[i]){
                same++;
            }
            if(semester1[i] < semester2[i]){
                BestSubjectIndex[i] = subject[i];
            }
        }


        // BestSubjectIndex 배열에서 null이 아닌 요소만 수집
        ArrayList<String> improvedSubjects = new ArrayList<>();
        for (String subjectName : BestSubjectIndex) {
            if (subjectName != null) {
                improvedSubjects.add(subjectName);
            }
        }


        System.out.println("1학기와 2학기 성적이 동일한 과목 수: "+same);
        System.out.println("1학기보다 성적이 오른 과목 수: "+improvedSubjects.size());
        System.out.println("성적이 오른 과목명: "+ String.join(", ", improvedSubjects));



    }
}

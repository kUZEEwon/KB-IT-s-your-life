import java.util.Random;

public class MainClass {
    public static void main(String[] args) {

        // Index    CorrectAnswer   My Answer
        //0         2               3
        Random rand = new Random();
        int solution[] = new int[1000];
        int my_solution[] = new int[1000];
        int score = 0;

        for (int i = 0; i < solution.length; i++) {
            solution[i] = rand.nextInt(4)+1;
        }

        for (int i = 0; i < my_solution.length; i++) {
            my_solution[i] = rand.nextInt(4)+1;
        }
        System.out.println("Index       CorrectAnswer        My Answer");
        for (int i = 0; i < solution.length; i++) {
            System.out.println(i + "\t\t\t" + solution[i] + "\t\t\t\t\t\t" + my_solution[i]);
        }



        for (int i = 0; i < solution.length; i++) {
            if(solution[i] == my_solution[i]) {
                score++;
            }
        }

        System.out.println("맞은 점수: "+score);
    }
}

package week1;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] sequence = {1, 4, 2, 3, 5};
        int k = 5;
        int minLengthSubarray = sol.minLengthSubarray(sequence, k);
        System.out.println("Minimum length of subarray with sum >= k: " + minLengthSubarray);
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,1000000};
        int total = 0;
        int start = 0;
        for(int end=0; end < sequence.length; end++) {
            total += sequence[end];
            while(total > k){
                total -= sequence[start];
                start++;
            }
            if(total == k){
                if((end - start)< (answer[1] - answer[0])){
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        return answer;

    }
}



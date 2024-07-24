// Khant Nyi Thu
// 6632108
// 541

package Week06;

import java.util.*;

public class VoteCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of candidates (1 ≤ n ≤ 100):");
        int n = scanner.nextInt();
        
        System.out.println("Enter the number of voters (1 ≤ m ≤ 1,000,000):");
        int m = scanner.nextInt();
        
        int[] votes = new int[n + 1];
        
        System.out.println("Enter the sequence of votes (each vote is a candidate number):");
        for (int i = 0; i < m; i++) {
            int candidateNumber = scanner.nextInt();
            votes[candidateNumber]++;
        }
        
        int maxVotes = 0;
        for (int i = 1; i <= n; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
            }
        }
        
        List<Integer> winners = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (votes[i] == maxVotes) {
                winners.add(i);
            }
        }
        
        Collections.sort(winners);
        System.out.println("The candidate(s) with the maximum number of votes:");
        for (int winner : winners) {
            System.out.println(winner);
        }
        
        scanner.close();
    }
}
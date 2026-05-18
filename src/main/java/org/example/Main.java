package org.example;

import org.example.array.A001EratosthenesSieve;
import org.example.array.A002Ranking;
import org.example.array.A003GridMaxSum;
import org.example.array.A004TemporaryClassPresident;
import org.example.array.A005Mentoring;
import org.example.dfsbfs.D001RecursiveCallStack;
import org.example.dfsbfs.D002BinaryPrintRecursive;
import org.example.dfsbfs.D003Factorial;
import org.example.dfsbfs.D004FibonacciMemo;
import org.example.dfsbfs.D005SubsetDfs;
import org.example.dfsbfs.D006TreeBfs;
import org.example.dfsbfs.D007CalfBfs;
import org.example.dfsbfs.D008TargetNumberDfs;
import org.example.dfsbfs.D009PathSearchDfs;
import org.example.dfsbfs.D010GraphShortestBfs;
import org.example.dfsbfs.D011EqualSubsetSum;
import org.example.dfsbfs.D012MaxScore;
import org.example.dfsbfs.D013CoinChangeDfs;
import org.example.stackqueue.*;
import org.example.hash.H001ClassPresident;
import org.example.hash.H002Anagram;
import org.example.hash.H003SalesKind;
import org.example.twopointers.T001MergeByTwoPointers;
import org.example.twopointers.T002CommonElements;
import org.example.twopointers.T003MaxWindowSum;
import org.example.twopointers.T004CountSubsequenceSum;
import org.example.twopointers.T005MaxConsecutiveOnesWithFlips;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Problem> PROBLEMS = new LinkedHashMap<>();

    static {
        PROBLEMS.put("p001", new P001ValidParentheses());
        PROBLEMS.put("p002", new P002CraneDollPicker());
        PROBLEMS.put("p003", new P003PostfixEvaluation());
        PROBLEMS.put("p004", new P004IronRod());
        PROBLEMS.put("p46", new P46());
        PROBLEMS.put("p005", new P005RescuePrincess());
        PROBLEMS.put("a001", new A001EratosthenesSieve());
        PROBLEMS.put("a002", new A002Ranking());
        PROBLEMS.put("a003", new A003GridMaxSum());
        PROBLEMS.put("a004", new A004TemporaryClassPresident());
        PROBLEMS.put("a005", new A005Mentoring());
        PROBLEMS.put("d001", new D001RecursiveCallStack());
        PROBLEMS.put("d002", new D002BinaryPrintRecursive());
        PROBLEMS.put("d003", new D003Factorial());
        PROBLEMS.put("d004", new D004FibonacciMemo());
        PROBLEMS.put("d005", new D005SubsetDfs());
        PROBLEMS.put("d006", new D006TreeBfs());
        PROBLEMS.put("d007", new D007CalfBfs());
        PROBLEMS.put("d008", new D008TargetNumberDfs());
        PROBLEMS.put("d009", new D009PathSearchDfs());
        PROBLEMS.put("d010", new D010GraphShortestBfs());
        PROBLEMS.put("d011", new D011EqualSubsetSum());
        PROBLEMS.put("d012", new D012MaxScore());
        PROBLEMS.put("d013", new D013CoinChangeDfs());
        PROBLEMS.put("t001", new T001MergeByTwoPointers());
        PROBLEMS.put("t002", new T002CommonElements());
        PROBLEMS.put("t003", new T003MaxWindowSum());
        PROBLEMS.put("t004", new T004CountSubsequenceSum());
        PROBLEMS.put("t005", new T005MaxConsecutiveOnesWithFlips());
        PROBLEMS.put("h001", new H001ClassPresident());
        PROBLEMS.put("h002", new H002Anagram());
        PROBLEMS.put("h003", new H003SalesKind());
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        String key = args[0].toLowerCase();
        Problem problem = PROBLEMS.get(key);

        if (problem == null) {
            System.out.println("Unknown problem key: " + key);
            printUsage();
            return;
        }

        problem.run();
    }

    private static void printUsage() {
        System.out.println("Usage: java -cp target/classes org.example.Main <problem-key>");
        System.out.println("Available problem keys:");
        for (String key : PROBLEMS.keySet()) {
            System.out.println(" - " + key);
        }
    }
}

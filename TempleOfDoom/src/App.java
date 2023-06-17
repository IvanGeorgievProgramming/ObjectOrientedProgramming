import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tools = readSequence(scanner.nextLine());
        List<Integer> substances = readSequence(scanner.nextLine());
        List<Integer> challenges = readSequence(scanner.nextLine());

        while (!challenges.isEmpty() && !tools.isEmpty() && !substances.isEmpty()) {
            int currentTool = tools.get(0);
            int currentSubstance = substances.get(substances.size() - 1);
            int result = currentTool * currentSubstance;

            if (challenges.contains(result)) {
                challenges.remove(Integer.valueOf(result));
                tools.remove(0);
                substances.remove(substances.size() - 1);
            } else {
                currentTool++;
                currentSubstance--;
                if (currentSubstance == 0) {
                    substances.remove(substances.size() - 1);
                } else {
                    substances.set(substances.size() - 1, currentSubstance);
                }
                tools.remove(0);
                tools.add(currentTool);
            }
        }

        if (substances.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        printSequence("Tools", tools);
        printSequence("Substances", substances);
        printSequence("Challenges", challenges);
    }

    private static List<Integer> readSequence(String input) {
        String[] tokens = input.split(" ");
        List<Integer> sequence = new ArrayList<>();

        for (String token : tokens) {
            sequence.add(Integer.parseInt(token));
        }

        return sequence;
    }

    private static void printSequence(String label, List<Integer> sequence) {
        if (sequence.isEmpty()) {
            return;
        } else {
            System.out.print(label + ": ");
            for (int i = 0; i < sequence.size() - 1; i++) {
                System.out.print(sequence.get(i) + ", ");
            }
            System.out.println(sequence.get(sequence.size() - 1));
        }
    }
}
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        char[][] cupboard = new char[rows][columns];
        int mouseRow = -1;
        int mouseCol = -1;
        int cheeseCount = 0;

        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < columns; j++) {
                cupboard[i][j] = row.charAt(j);
                if (cupboard[i][j] == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                } else if (cupboard[i][j] == 'C') {
                    cheeseCount++;
                }
            }
        }

        boolean trapped = false;
        boolean eatenAllCheese = false;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("danger")) {
                if (!trapped && !eatenAllCheese) {
                    System.out.println("Mouse will come back later!");
                }
                break;
            }

            int newMouseRow = mouseRow;
            int newMouseCol = mouseCol;

            switch (command) {
                case "up":
                    newMouseRow--;
                    break;
                case "down":
                    newMouseRow++;
                    break;
                case "left":
                    newMouseCol--;
                    break;
                case "right":
                    newMouseCol++;
                    break;
            }

            if (newMouseRow < 0 || newMouseRow >= rows || newMouseCol < 0 || newMouseCol >= columns) {
                System.out.println("No more cheese for tonight!");
                break;
            }

            char newPosition = cupboard[newMouseRow][newMouseCol];

            if (newPosition == '@') {
                continue; // Skip the command, as it is a wall
            } else if (newPosition == 'T') {
                trapped = true;
                cupboard[mouseRow][mouseCol] = '*';
                cupboard[newMouseRow][newMouseCol] = 'M';
                break;
            } else if (newPosition == 'C') {
                cupboard[mouseRow][mouseCol] = '*';
                cupboard[newMouseRow][newMouseCol] = 'M';
                mouseRow = newMouseRow;
                mouseCol = newMouseCol;
                cheeseCount--;

                if (cheeseCount == 0) {
                    eatenAllCheese = true;
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }
            } else if (newPosition == '*') {
                cupboard[mouseRow][mouseCol] = '*';
                cupboard[newMouseRow][newMouseCol] = 'M';
                mouseRow = newMouseRow;
                mouseCol = newMouseCol;
            }
        }

        if (!trapped && !eatenAllCheese) {
            cupboard[mouseRow][mouseCol] = 'M';
        }

        if (trapped) {
            System.out.println("Mouse is trapped!");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cupboard[i][j]);
            }
            System.out.println();
        }
    }
}

// Tic Tac Toe written completely in Java

import java.util.Scanner;

public class Main {

    static String welcomeString = "=".repeat(50) + '\n' + "Welcome to TicTacToe in Java!" + '\n' + "=".repeat(50);
    // 0 is blank, X is player1 or user, O is player2 or computer
    static char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    static boolean player1 = true;

    public static void resetBoard() {
        char counter = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = counter++;
            }
        }
    }

    public static boolean checkGame() {
        return (board[0][0] == board[0][1] && board[0][1] == board[0][2])
                || (board[1][0] == board[1][1] && board[1][1] == board[1][2])
                || (board[2][0] == board[2][1] && board[2][1] == board[2][2])
                || (board[0][0] == board[1][0] && board[1][0] == board[2][0])
                || (board[0][1] == board[1][1] && board[1][1] == board[2][1])
                || (board[0][2] == board[1][2] && board[1][2] == board[2][2])
                || (board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print("|" + cell + "|");
            }
            System.out.println("\n");
        }
    }

    public static boolean replace(char target, char newValue) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == target && target != 'X' && target != 'O') {
                    board[i][j] = newValue;
                    return true;
                }
            }
        }
        return false;
    }

    public static void selfGame() {
        Scanner sc = new Scanner(System.in);
        resetBoard();
        player1 = true;
        int moves = 0;

        while (true) {
            char playerChar = player1 ? 'X' : 'O';
            System.out.println("\nTurn of: " + playerChar);
            printBoard();
            System.out.print("You place it at: ");
            
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;
            
            char choice = input.charAt(0);

            if (replace(choice, playerChar)) {
                moves++;
                if (checkGame()) {
                    printBoard();
                    System.out.println("=".repeat(50) + '\n' + playerChar + " WINS!!" + '\n' + "=".repeat(50));
                    break;
                }
                if (moves == 9) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                player1 = !player1;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    public static void computerGame() {
        System.out.println("Still under construction!!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println(welcomeString);
            System.out.print("Press 0 to play with yourself, 1 to play with Computer and other to quit: ");
            String userInput = sc.nextLine().trim();

            switch (userInput) {
                case "0":
                    selfGame();
                    break;
                case "1":
                    computerGame();
                    break;
                default:
                    System.out.println("Thank you for playing the game!");
                    break OUTER;
            }
        }
    }
}
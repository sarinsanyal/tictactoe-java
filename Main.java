// Tic Tac Toe written completely in Java

import java.util.Scanner;

public class Main {

    static String welcomeString = "=".repeat(50) + '\n' + "Welcome to TicTacToe in Java!" + '\n' + "=".repeat(50);
    static char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}}; // 0 is blank, X is player1 or user, O is player2 or computer
    static Boolean player1 = true;

    public static Boolean checkGame(char[][] args) {
        return (board[0][0] == board[0][1] && board[0][1] == board[0][2])
                || (board[1][0] == board[1][1] && board[1][1] == board[1][2])
                || (board[2][0] == board[2][1] && board[2][1] == board[2][2])
                || (board[0][0] == board[1][0] && board[1][0] == board[2][0])
                || (board[0][1] == board[1][1] && board[1][1] == board[2][1])
                || (board[0][2] == board[1][2] && board[1][2] == board[2][2])
                || (board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    public static void printBoard(char[][] args) {
        for (char[] boardRow : board) {
            for (int j = 0; j < boardRow.length; j++) {
                System.out.print("|" + boardRow[j] + "|");
            }
            System.out.println("\n");
        }
    }

    public static void replace(char[][] board, char target, char newValue) {
        for (char[] boardRow : board) {
            for (int j = 0; j < boardRow.length; j++) {
                if (boardRow[j] == target) {
                    boardRow[j] = newValue;
                }
            }
        }
    }

    public static void selfGame() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            char playerBoardCharacter = player1 ? 'X' : 'O';
            System.out.println("\nTurn of: " + playerBoardCharacter);
            printBoard(board);
            System.out.print("You place it at: ");
            char newPositionInput = sc.nextLine().trim().charAt(0);
            if (newPositionInput != 'X' && newPositionInput != 'O') {
                replace(board, newPositionInput, playerBoardCharacter);
            }
            if (checkGame(board)) {
                printBoard(board);
                System.out.println("=".repeat(50) + '\n' + playerBoardCharacter + " "+ "WINS!!" + '\n' + "=".repeat(50) + '\n');
                break;
            }
            player1 = !player1;
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
            String UserInput = sc.nextLine().trim();
            switch (UserInput) {
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

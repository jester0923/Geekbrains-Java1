/*
 * Java Level 1. HomeWork3. Created by Dmitriy Kirpichnikov 13.10.2016
 */
import java.util.*;

class TicTacToeUltimate {

    final char PLAYER_DOT = 'X';
    final char AI_DOT = 'O';
    final char EMPTY_DOT = '.';
    final int FIELD_SIZE = 5;
    char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new TicTacToeUltimate().go();
    }

    void go() {
        initField();
        printField();
        while (true) {
            turnPlayer();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("Congratulations! You won!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry, draw...");
                break;
            }
            turnAI();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("AI won!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry draw...");
                break;
            }
        }
    }

    void turnPlayer() {
        int x, y;
        do {
            System.out.println("Enter coordinates X Y (1-"+FIELD_SIZE+"):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        field[x][y] = PLAYER_DOT;
    }

    void turnAI() {
        int x, y;
        do {
            x = rand.nextInt(FIELD_SIZE);
            y = rand.nextInt(FIELD_SIZE);
        } while (!isCellEmpty(x, y));
        field[x][y] = AI_DOT;
    }

    boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) {
            System.out.println("Coordinates invalid! Retry enter coordinates!!! X Y (1-"+FIELD_SIZE+"):");
            return false;
        }
        if (field[x][y] == EMPTY_DOT) return true;
        return false;
    }

    boolean isFieldFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (field[i][j] == EMPTY_DOT) return false;
        return true;
    }

    boolean checkWin(char ch) {
        // check horizontals, vertikals
        for (int i = 0, countHoriz = 0, countVertik = 0; i < FIELD_SIZE; i++, countHoriz = 0, countVertik = 0) 
            for (int j = 0; j < FIELD_SIZE; j++) {
                countHoriz = field[i][j] == ch ? countHoriz + 1 : countHoriz - 1;
                countVertik = field[j][i] == ch ? countVertik + 1 : countVertik - 1;     
                if (countHoriz == 4 || countVertik == 4) return true;
            }
                
        //check главную diag
        for (int i = 0, countDiag = 0; i < FIELD_SIZE; i++) { 
                countDiag = field[i][i] == ch ? countDiag + 1 : countDiag - 1;  
                if (countDiag == 4 ) return true;
            }
               
        // check побочную diag
        for (int i = 4, j = 0, countDiag2 = 0; j < FIELD_SIZE; i--, j++) {
                countDiag2 = field[i][j] == ch ? countDiag2 + 1 : countDiag2 - 1;  
                if (countDiag2 == 4 ) return true;
        }
 
        // check зеркальные от главной diag
        for (int i = 1, j = 0, countDiag3 = 0; i < FIELD_SIZE; i++, j++) {
                countDiag3 = field[i][j] == ch ? countDiag3 + 1 : countDiag3 - 1; 
                if (countDiag3 == 4) return true;
        }
        
        // check зеркальные от главной diag
        for (int i = 0, j = 1, countDiag4 = 0; j < FIELD_SIZE; i++, j++) {
                countDiag4 = field[i][j] == ch ? countDiag4 + 1 : countDiag4 - 1; 
                if (countDiag4 == 4) return true;  
        }    
        
        // check зеркальные от побочной diag
        for (int i = 3, j = 0, countDiag5 = 0; j < FIELD_SIZE - 1; i--, j++) {
                countDiag5 = field[i][j] == ch ? countDiag5 + 1 : countDiag5 - 1; 
                if (countDiag5 == 4) return true;
        }
        
        // check зеркальные от побочной diag
        for (int i = 4, j = 1, countDiag6 = 0; j < FIELD_SIZE; i--, j++) {
                countDiag6 = field[i][j] == ch ? countDiag6 + 1 : countDiag6 - 1; 
                if (countDiag6 == 4) return true;  
        }

    return false;
    }

    void initField() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                field[i][j] = EMPTY_DOT;
    }
    
    void printField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.println("-----------");
            System.out.print("|");
            for (int j = 0; j < FIELD_SIZE; j++) 
                System.out.print(field[i][j] + "|");
            System.out.println();
            }
        System.out.println("-----------");
    }
    
}

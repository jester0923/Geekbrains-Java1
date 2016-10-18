/*
 * Java Level 1. HomeWork4. Created by Dmitriy Kirpichnikov 17.10.2016               //��������-������ � ��� ����� (���� 5*5)
 */

import java.util.*;

class TTToeObjectsFinal {
    
    Field field = new Field();     //�������� ������� field �� ��������� ������ Field
    Human human = new Human();     //�������� ������� human �� ��������� ������ Human
    AI ai = new AI();              //�������� ������� ai �� ��������� ������ AI
    
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        
        //�������� ������� � ����������� �� ������ ������ Person
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Dmitriy", "Direktor", "jester0@gmail.com", "+79220000000", 50000, 30);
        persArray[1] = new Person("Vasiliy", "Zam", "jester1@gmail.com", "+79220000001", 45000, 25);
        persArray[2] = new Person("Nikolay", "Coder", "jester2@gmail.com", "+79220000002", 35000, 27);
        persArray[3] = new Person("Sergey", "HR", "jester3@gmail.com", "+79220000003", 30000, 42);
        persArray[4] = new Person("Egor", "Special", "jester4@gmail.com", "+79220000004", 30000, 47);
        
        System.out.println("Personal: ");     //����� ���� � �����������
        System.out.println();
            for (int i = 0; i < persArray.length; i++) { 
                persArray[i].hum();
            }
            
        //���������� ����� getAge ��� ��������� �������� � ����� hum ��� ������ ���� �� �����
        System.out.println("Human > 40 age: ");
            for (int i = 0; i < persArray.length; i++) {
                if (persArray[i].getAge() > 40) persArray[i].hum();
            }
        
        System.out.println();
        System.out.println("Let`s PLAY");
        new TTToeObjectsFinal().play();                //� ������ ��������) �� ������� ����!
        
    }

    void play() {        //����� �������� ��������
        field.view();    //������� ���� � �������
        while (true) {
            human.turn();    //����� - ��� ������
            field.view();    //������� ���� � ������� ����� ���� ������
            if (field.isWin(human.getDot())) {                    //����� ������ �������� �������� ������
                System.out.println("Congratulations! You WON!");
                break;
            }
            if (field.Full()) {
                System.out.println("Sorry draw...");  //�����
                break;
            }
            ai.turn();       //����� - ��� ������
            field.view();    //������� ���� � ������� ����� ���� ��
            
            if (field.isWin(ai.getDot())) {            //����� ������ �������� �������� ��
                System.out.println("AI won!");
                break;
            }
            if (field.Full()) {                         //����� ������ �������� ������������� ����
                System.out.println("Sorry draw...");
                break;
            }
        }
    }

    class Field {     //����� ����
        
        final int FIELD_SIZE = 5;
        final char EMPTY_DOT = '.';
        final char DOT_AI = 'O';
        
        char[][] field = new char[FIELD_SIZE][FIELD_SIZE];  //�������� ������� �� ����� (����)

        Field() {                                        //������������� ����
            for (int i = 0; i < FIELD_SIZE; i++)
                for (int j = 0; j < FIELD_SIZE; j++)     //���������� ���� ������ �������
                    field[i][j] = EMPTY_DOT;
        }

        int getSize() {           //������ ������� ����
            return FIELD_SIZE; 
            }   

        void setDot(int x, int y, char ch) {      //����� ��������� ������ ������ (. � �)
            field[x][y] = ch; 
        }   

        boolean isCellEmpty(int x, int y) {              //�������� �� ������������ �����...� ����� �� ������?
            
            if (field[x][y] == DOT_AI) {
                System.out.println("The cell is occupied!"); 
                return false;
            }
                
            if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) return false;
            if (field[x][y] == EMPTY_DOT) return true;
        return false;
        }

        boolean Full() {                              // ����� �������� ������������� ����
            for (int i = 0; i < FIELD_SIZE; i++)
                for (int j = 0; j < FIELD_SIZE; j++)
                    if (field[i][j] == EMPTY_DOT) return false;
            return true;
        }

        boolean isWin(char ch) {                      // ����� �������� ������ ������
            // check horizontals, vertikals
        for (int i = 0, countHoriz = 0, countVertik = 0; i < FIELD_SIZE; i++, countHoriz = 0, countVertik = 0) 
            for (int j = 0; j < FIELD_SIZE; j++) {
                countHoriz = field[i][j] == ch ? countHoriz + 1 : countHoriz - 1;
                countVertik = field[j][i] == ch ? countVertik + 1 : countVertik - 1;     
                if (countHoriz == 4 || countVertik == 4) return true;
            }
                
        //check ������� diag
        for (int i = 0, countDiag = 0; i < FIELD_SIZE; i++) { 
                countDiag = field[i][i] == ch ? countDiag + 1 : countDiag - 1;  
                if (countDiag == 4 ) return true;
            }
               
        // check �������� diag
        for (int i = 4, j = 0, countDiag2 = 0; j < FIELD_SIZE; i--, j++) {
                countDiag2 = field[i][j] == ch ? countDiag2 + 1 : countDiag2 - 1;  
                if (countDiag2 == 4 ) return true;
        }
 
        // check ���������� �� ������� diag
        for (int i = 1, j = 0, countDiag3 = 0; i < FIELD_SIZE; i++, j++) {
                countDiag3 = field[i][j] == ch ? countDiag3 + 1 : countDiag3 - 1; 
                if (countDiag3 == 4) return true;
        }
        
        // check ���������� �� ������� diag
        for (int i = 0, j = 1, countDiag4 = 0; j < FIELD_SIZE; i++, j++) {
                countDiag4 = field[i][j] == ch ? countDiag4 + 1 : countDiag4 - 1; 
                if (countDiag4 == 4) return true;  
        }    
        
        // check ���������� �� �������� diag
        for (int i = 3, j = 0, countDiag5 = 0; j < FIELD_SIZE - 1; i--, j++) {
                countDiag5 = field[i][j] == ch ? countDiag5 + 1 : countDiag5 - 1; 
                if (countDiag5 == 4) return true;
        }
        
        // check ���������� �� �������� diag
        for (int i = 4, j = 1, countDiag6 = 0; j < FIELD_SIZE; i--, j++) {
                countDiag6 = field[i][j] == ch ? countDiag6 + 1 : countDiag6 - 1; 
                if (countDiag6 == 4) return true;  
        }

        return false;
        }

        void view() {                                  //����� ������ ���� � �������
            for (int x = 0; x < FIELD_SIZE; x++) {
                System.out.println("-----------");
                System.out.print("|");
                for (int y = 0; y < FIELD_SIZE; y++) 
                    System.out.print(field[x][y] + "|");
                System.out.println();
            }
        }
    }

    class AI {                                //����� ��
        final char DOT = 'O';

        char getDot() { 
            return DOT; 
        }

        void turn() {
            System.out.println("AI turn");
            int x, y;
            do {
                x = rand.nextInt(field.getSize());
                y = rand.nextInt(field.getSize());
            } while (!field.isCellEmpty(x, y));
            field.setDot(x, y, DOT);
        }
    }
    
    class Human {                             //����� �����
        final char DOT = 'X';

        char getDot() { 
            return DOT; 
        }

        void turn() {
            int x, y;
            do {
                System.out.println("You turn! Enter coordinates X Y (1-"+field.getSize()+"):");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!field.isCellEmpty(x, y));
            field.setDot(x, y, DOT);
        }
    }  
}

//  ������� � 1.

class Person {          //����� ��������� *������� � 1
    String name;
    String position;
    String email;
    String phone;
    int money;
    private int age;

    Person (String name, String position, String email, String phone, int money, int age) {      //����������� ������
    this.name = name;
    this.position = position;
    this.email = email;
    this.phone = phone;
    this.money = money;
    this.age = age;
    }  
    
    int getAge() { //getter
        return age;
    }
    
    void hum() {   //����� ��� ������ ���� �� ������� � �������
         System.out.println("Personal " + name + ": " + position + " | " + email + " | " + phone + " | " + money + " | " + age);
    }  
}
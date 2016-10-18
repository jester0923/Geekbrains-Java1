/*
 * Java Level 1. HomeWork4. Created by Dmitriy Kirpichnikov 17.10.2016
 */

class Personal {

    public static void main(String[] args) {
        
        //создание записей о сотрдуниках на основе класса Person
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Dmitriy", "Direktor", "jester0@gmail.com", "+79220000000", 50000, 30);
        persArray[1] =  new Person("Vasiliy", "Zam", "jester1@gmail.com", "+79220000001", 45000, 25);
        persArray[2] =  new Person("Nikolay", "Coder", "jester2@gmail.com", "+79220000002", 35000, 27);
        persArray[3] =  new Person("Sergey", "HR", "jester3@gmail.com", "+79220000003", 30000, 42);
        persArray[4] = new Person("Egor", "Special", "jester4@gmail.com", "+79220000004", 30000, 47);
        
        System.out.println("Personal: ");     //вывод инфы о сотрудниках
            for (int i = 0; i < persArray.length; i++) { 
                persArray[i].hum();
            }
            
        //используем метод getAge для получения возраста и метод hum для вывода инфы на экран
        System.out.println("Human > 40 age: ");
            for (int i = 0; i < persArray.length; i++) {
                if (persArray[i].getAge() > 40) persArray[i].hum();
            }
    }
}
    
class Person {
    String name;
    String position;
    String email;
    String phone;
    int money;
    private int age;

Person (String name, String position, String email, String phone, int money, int age) { 
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
    
    void hum() {   //метод для вывода инфы об объекте в консоль
         System.out.println("Personal " + name + ": " + position + " | " + email + " | " + phone + " | " + money + " | " + age);
    }  
}
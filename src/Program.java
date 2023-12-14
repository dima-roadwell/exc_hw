package src;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception{
        boolean isValidString = false;

        while(!isValidString) {
            try {
                System.out.print("Введите свои данные: ");
                DataHandler dh = new DataHandler(new Scanner(System.in).nextLine());
                
                isValidString = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

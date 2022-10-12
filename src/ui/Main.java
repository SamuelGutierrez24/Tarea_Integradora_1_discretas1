package ui;

import java.util.Scanner;

import model.Control;

public class Main {
    
    public static Scanner sc;
    private Control control;

    public Main(){
        this.control = new Control();
        sc = new Scanner(System.in);
    }

        public static void main(String [] args){
            
            Main ppal = new Main();
            int option;
            do{
                System.out.println("ingrese la opcion del problema que quiera probar:\n\n" +
                "(1) Invertir un String\n" +
                "(2) Invertir una Pila\n" +
                "(3) Invertir una Cola\n" +
                "(4) Verificar si los parentesis estan balanceados\n");
                option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    default :
                    System.out.println("Digita un valor correcto.");
                    break;
                    case 0:
                    System.out.println("En la buena");
                    break;
                    case 1:
                        ppal.primero();
                    break;
                }
                

            }while(option != 0);

           
        }

        

      
}

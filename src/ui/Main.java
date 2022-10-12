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
               option = ppal.showMenu();
                ppal.selecOption(option);
            }while(option != 0);

           
        }

       public int showMenu(){
        int option = 0;
        System.out.println("ingrese la opcion del problema que quiera probar:\n\n" +
        "(1) Search client\n" );
        option = sc.nextInt();
        sc.nextLine();
        return option;
       } 

       public void selecOption(int option){
        switch(option){
            default :
            System.out.println("Digita un valor correcto.");
            break;
            case 0:
            System.out.println("En la buena");
            break;
            case 1:
                searchClient();
            break;
        }
       }

       public void searchClient(){

         System.out.println("Please give the client id: ");
         String id = sc.nextLine();
         control.searchClient(id);
       }

      
}

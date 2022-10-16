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
            ppal.showMenu();
        
           
        }

       public void showMenu() {
    	   
    	   System.out.println("Welcome!\n" );
    	   
    	   boolean stopFlag = false;

           while (!stopFlag) {
        	   
        	   System.out.println("Select what do you want to do:\n\n" + "(1) Enter to a lab\n" + "(2) Search client\n" + "(0) Exit" );

               int mainOption = sc.nextInt();

               switch (mainOption) {
                   case 1: 
				   System.out.println("Select wich lab you want to go:\n\n" + "(1) Hematology\n" + "(2) General purpose\n" + "(0) Back");
				   int lab = sc.nextInt(); 
					searchClient(lab);

                	   //boolean stopFlag2 = false;
                	   
                	   /*while (!stopFlag2) {
                	   
                		   switch(lab) {
                	   
                		   case 1:
                		   
                			   break;
                		   case 2:
                		   
                			   break;
                		   default:
                		            		   
                			   break;
                		   case 0:
                			   
                			   stopFlag2 = true;
                			   break;		   
                		   }
                		   
                	   }*/
                	   
                   
                       break;
                   case 2:
                   	
                       
                       
                       break;
                   case 0:
                   	
                       System.out.println("Bye.");
                       
                       stopFlag = true;
                       break;
               }
           }
    	   
  
        
       } 

     
       public void searchClient(int lab){

         System.out.println("Please give the client id: ");
         String id = sc.nextLine();
        boolean answer = control.searchClientBool(id);
		if(answer == true){
			control.putInPriorityQ(lab, id);
		}else{
			registerClient();
		}
		

       }

	
	   
      
}

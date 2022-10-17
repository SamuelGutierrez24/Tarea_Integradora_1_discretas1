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

        public static void main(String [] args) throws Exception{
            
            Main ppal = new Main();
            
            int option;
            ppal.showMenu();
        
           
        }

       public void showMenu() throws Exception {
    	   
    	   System.out.println("Welcome!\n" );
    	   
    	   boolean stopFlag = false;

           while (!stopFlag) {
        	   
        	   System.out.println("Select what do you want to do:\n\n" + "(1) Enter to a lab\n" + "(2) Search client\n" + "(3) pull out of queue" + "(0) Exit" );

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
				   
				   registerClient();
				   
                       break;
                   case 0:
                   	
                       System.out.println("Bye.");
                       
                       stopFlag = true;
                       break;
               }
           }
    	   
  
        
       }
	   
	   private void registerClient() {
		boolean pregnant = false;
		boolean illness = false;
		int key = 0;
		System.out.println("To register a client complete the following information");
		System.out.println("Type the name of the client");
		String name = sc.nextLine();
		System.out.println("Type the age of the client");
		int age = sc.nextInt();
		System.out.println("Type the id of the client");
		String id = sc.nextLine();
		System.out.println("Type the gender of the client. Type (1) if is Male or type (2) if is Female");
		int gender = sc.nextInt();
		if (gender == 1) {

			System.out.println("Type (1) if the client is pregnant if not type (2)");
			int pregnancy = sc.nextInt();
			switch (pregnancy) {
				case 1: pregnant=true;
				break;
				case 2: pregnant = false;
			}

		}else{
			System.out.println("The client can't be pregnant because is male");

		}
		System.out.println("Type (1) if the client has any important illness if not type (2)");
		int ill = sc.nextInt();
		if (ill == 1){
			illness = true;
		}else{
			illness = false;
		}
			control.registerClient(name, age, id, gender, pregnant, illness, key);

	}

     
       public void searchClient(int lab) throws Exception{

         System.out.println("Please give the client id: ");
         String id = sc.nextLine();
        boolean answer = control.searchClientBool(id);
		if(answer == true){
			control.putInPriorityQ(lab, id);
		}else{
			registerClient();
		}
		

       }

	  /*  public void outOfQ(int lab){

		try{
			control.outOfTheQueue(lab);
		}catch{

		}
	   }*/

	
	   
      
}

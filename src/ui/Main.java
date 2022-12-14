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
    	   
    	
    	   control.loadTxt();

    
    	   System.out.println("Welcome!\n" );
    	   
    	   boolean stopFlag = false;

           while (!stopFlag) {
        	   
        	   System.out.println("Select what do you want to do:\n\n" + "(1) Enter to a lab.\n" + "(2) Search client.\n" + "(3) Pull out of queue.\n" + "(4) Undo.\n" + "(5) Show a lab order.\n" + "(6) Register a client.\n" + "(0) Exit." );

               int mainOption = Integer.parseInt(sc.nextLine());
			   

               switch (mainOption) {
               
                   case 1: 
                	   
                	   System.out.println("Select which lab you want to go:\n\n" + "(1) Hematology\n" + "(2) General purpose\n" + "(0) Back");
                	   int lab = Integer.parseInt(sc.nextLine()); 
                	   boolean stopFlag2 = false;
                	   
                	   switch(lab) {
                	   
                	   		case 1: 
                	   			
                	   			searchClient(lab);
                	   			
                	   			break;
                	   		case 2:
                	   			
                	   			searchClient(lab);
                	   			
                	   			break;
                	   		case 0:
                	   			
                	   			break;
                	   		default:
                	   			
                	   			System.out.println("Type one of the options, returning to main menu.\n");
                	   			
                	   			break;
                	   }
                	  
                	   break;				
                   case 2:
				   
                	   searchClient();
				   
                	   break;
					case 3:
					
						outOfQ();   

						break;
					case 4 :
						
						undo();
						
						break;
					case 5:
						
						showOrder();
					
						break;
					case 6:
						
						registerClient();
						
						break;
					case 0:
                   	
                	   control.hashMapToTxt();
                	    
                       System.out.println("Bye.");
                       
                       stopFlag = true;
                       
                       break;
					default:
                	   
                	   System.out.println("Type one of the options.\n");
                	   
                	   break;
               }
           }
    	}
	   
	   private void registerClientNotFound(String id) {
		   
		   boolean pregnant = false;
		   boolean illness = false;
		   int key = 0;
		   
		   System.out.println("The client was not found in the data base.\n");
		   System.out.println("To register a client complete the following information: \n");
		   System.out.println("Type the name of the client");
		   String name = sc.nextLine();
		   System.out.println("Type the age of the client");
		   int age = sc.nextInt();
		   sc.nextLine();
		
		   if(id.equalsIgnoreCase("")) {
			   System.out.println("Type the id of the client");
			   id = sc.nextLine();
		   }
		
		   System.out.println("Type the gender of the client. Type (1) if is Female or type (2) if is Male");
		   int gender = sc.nextInt();
		
		   if (gender == 1) {

			   System.out.println("Type (1) if the client is pregnant if not type (2)");
			   int pregnancy = sc.nextInt();

			   switch (pregnancy) {
			   		
					case 1: 
						
						pregnant=true;
						
						break;	
			   }

		   } else{
			
			   System.out.println("The client can't be pregnant because is male");

		   }
		   
		   
		   System.out.println("Type (1) if the client has any important illness if not type (2)");
		   int ill = sc.nextInt();
		   sc.nextLine();
		
		   if (ill == 1){
			   illness = true;
		   }else{
			   illness = false;
		   }
		   
		control.registerClient(name, age, id, gender, pregnant, illness, key);

	   }

	   private void registerClient() {
		   
		   boolean pregnant = false;
		   boolean illness = false;
		   int key = 0;
		  
		   System.out.println("To register a client complete the following information: \n");
		   System.out.println("Type the name of the client");
		   String name = sc.nextLine();
		   System.out.println("Type the age of the client");
		   int age = sc.nextInt();
		   sc.nextLine();
		   
		   System.out.println("Type the id of the client");
		   String id = sc.nextLine();
		
		   System.out.println("Type the gender of the client. Type (1) if is Female or type (2) if is Male");
		   int gender = sc.nextInt();
		
		   if (gender == 1) {

			   System.out.println("Type (1) if the client is pregnant if not type (2)");
			   int pregnancy = sc.nextInt();

			   switch (pregnancy) {
			   		
					case 1: 
						
						pregnant=true;
						
						break;	
			   }

		   } else{
			
			   System.out.println("The client can't be pregnant because is male");

		   }
		   
		   
		   System.out.println("Type (1) if the client has any important illness if not type (2)");
		   int ill = sc.nextInt();
		   sc.nextLine();
		
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
				registerClientNotFound(id);
			}
       }

	   public void outOfQ() throws Exception{

		System.out.println("Insert the number of lab queue (1) Hematology (2) General propuose: ");
		int lab = sc.nextInt();
		sc.nextLine();
		System.out.println(control.outOfTheQueue(lab));
		

	   }

	   public void searchClient(){

		System.out.println("Please enter the client id:");
		String id = sc.nextLine();
		System.out.println(control.searchClient(id));
	   }

	   public void undo()throws Exception{
		System.out.println("??In wich lab you whant to undo? (1) Hematology (2) General propouse");
		int lab = sc.nextInt();
		sc.nextLine();
		System.out.println(control.undo(lab));
	   }

	   public void showOrder() throws Exception{
		System.out.println("Please enter the lab which you want to see the order (1) Hematology (2) General propouse : ");
		int lab = sc.nextInt();
		sc.nextLine();
		System.out.println(control.showPriorityQ(lab));
	   }

	
	   
      
}

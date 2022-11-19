import java.util.Scanner;
public class Home {
    public static double budget;
    public static double monthlyBudget;
    public static float expense;
    public static float close;
    public static String item;
    public static String list[]=new String[1000];
    public static double price[]=new double[1000];
    public static int top=-1;
    public static float daily;
    public static String cat[]=new String[]{"Food","General","Medicines","Gifts","Shopping","travel","General","Holidays","Entertainment"};
    public static String catchoice[]=new String[1000];
    public static int choicecat;
    static Scanner sc= new Scanner(System.in);
    static Scanner st= new Scanner(System.in);
    public static double total=0;
    
    static void setBudget(){
        System.out.print("Enter your monthly budget: ");
        monthlyBudget=sc.nextDouble();
        budget=monthlyBudget;
        daily=(float) (monthlyBudget/30);
     }
    static void addExpense(){
        
        System.out.print("Enter the item: ");
        item=st.nextLine();
        System.out.print("\n");
        
        System.out.print("Enter the amount you have spent: ");
        expense=sc.nextFloat();
        System.out.println("Enter what type of expense: ");
        for(int i=0;i<9;i++){
            System.out.println((i+1)+" "+cat[i]);
        }

        System.out.print("PRESS TO CHOOSE: ");
        choicecat=sc.nextInt();
        top++;
        list[top]=item;
        price[top]=expense;
        catchoice[top]=cat[choicecat-1];

        budget=budget-expense;
        total=total+expense;
        System.out.println("\n");
        System.out.println("You have "+budget+" left for the month");
    }
    static void displayBudget(){
        System.out.println("You have "+budget+" left for the month");
    }
    static void warning(){
        close=(float) ((monthlyBudget*10)/100);
        if (budget<=close){
            System.out.println("You have less than 10% of budget left for the month that is "+budget);
        }
    }
    static void expenseSheet(){
        
        int i=0;
        System.out.println("EXPENSE SHEET");
        while(i<=top){
            System.out.println("Item: "+list[i]+" price: "+price[i]+" Catageory: "+catchoice[i]);
            i++;

        }
        totalExpenditure();
    }
    static void dailyLeft(){
        
        System.out.println("Your daily expenditure should be "+daily);
        float dailyLeft=daily-expense;
        System.out.println("Money left: "+dailyLeft);
        
    }
    static void saving(){

    }
    static void monthlyAvg(){

    }
    static void yearlyExpense(){

    }
    static void totalExpenditure(){
        
        System.out.print("Enter your expenditure for this month is: "+total);
        
    }








    public static void main(String[] args) {
        int choice,choice2;
        Scanner in= new Scanner(System.in);
        System.out.println("WELCOME TO THE EXPENSE TRACKER");
        System.out.println("Please set your monthly budget first");
        setBudget();
        
        do{
            System.out.println("\nPRESS\n1->TO ADD EXPENSE\n2->TO SEE THE REMAINING BUDGET\n3->TO SEE THE EXPENSE SHEET\n4->FOR MORE INFO\n5->TO EXIT");
            choice=in.nextInt();
            warning();
            switch(choice)
               {
                
            
                case 1:
                addExpense();
                
                break;

                case 2:
                displayBudget();
                
                break;


                case 3:
                expenseSheet();
                
                break;

                case 4:
                do{
                System.out.println("PRESS \n1->FOR DAILY EXPENSE LEFT\n2->SAVINGS TILL NOW\n3->MONTHLY AVG EXPENDITURE\n4->YEARLY REPORT\n5->BACK TO MAIN MENU");
                choice2=in.nextInt();
                switch(choice2){
                    case 1:
                        dailyLeft();
                
                        break;

                    case 2:
                        saving();

                        break;


                    case 3:
                        monthlyAvg();
                
                        break;
                    case 4:
                        yearlyExpense();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Enter a valid option");
                        break;
                    
                }
                }
                while(choice2!=5);
                    break;
                
                case 5:
                    break;    

                default:
                    System.out.println("Enter a valid option");
                    break;

            }


        } 
        while((choice!=5));
    }

        
}
    

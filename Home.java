//<-----TITLE----->
//<-----Spending Tracker----->

import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

class Exo{
    public String date;
    public Date thisDate=new Date();
    static SimpleDateFormat dateForm=new SimpleDateFormat("dd/M/Y");
    //dateForm.format(thisDate));
    public String month;
    public Date thisMonth=new Date();
    static SimpleDateFormat dateForm2=new SimpleDateFormat("M");
    public String getDate(){
            
            date=dateForm.format(thisDate);
            return date;
        
    }
    public String getMonth(){
        month=dateForm2.format(thisMonth);
        return month;


    }
    


}


class Home extends Exo{
    public static double budget;
    public static double monthlyBudget;
    public static float expense;
    public static float close;
    public static String item;
    public static String list[]=new String[1000];
    public static double price[]=new double[1000];
    public static int top=-1;
    public static float daily;
    public static String cat[]=new String[]{"Food","General","Medicines","Gifts","Shopping","travel","Holidays","Entertainment"};
    public static String catchoice[]=new String[1000];
    public static String datelist[]=new String[1000];
    public static String monthlist[]=new String[1000];
    public static int choicecat;
    static Scanner sc= new Scanner(System.in);
    static Scanner st= new Scanner(System.in);
    public static double total=0;
    

    public static void setBudget(){
        System.out.print("Enter your monthly budget: ");
        monthlyBudget=sc.nextDouble();
        
        budget=monthlyBudget;
        daily=(float) (monthlyBudget/30);
        
     }
    void addExpense(){
        
        System.out.print("Enter the item: ");
        item=st.nextLine();
        System.out.print("\n");
        
        System.out.print("Enter the amount you have spent: ");
        expense=sc.nextFloat();
        System.out.println("Enter what type of expense: ");
        for(int i=0;i<8;i++){
            System.out.println((i+1)+" "+cat[i]);
        }

        System.out.print("PRESS TO CHOOSE: ");
        choicecat=sc.nextInt();
        top++;
        list[top]=item;
        price[top]=expense;
        
        datelist[top]=super.getDate();
        monthlist[top]=super.getMonth();
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

    static void tableSheet(){
        int i=0;
        JFrame frame = new JFrame();
 
      String[] columnNames = {"Name", "Price", "Category","Date"};
      
 
      Object[][] data =new Object[1000][4];
      for(i=0;i<(top+1);i++){
        data[i][0]=list[i];
        data[i][1]=price[i];
        data[i][2]=catchoice[i];
        data[i][3]=datelist[i];

      }
      
    JTable table = new JTable(data, columnNames);
 
   frame.add(table);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(400,400);
   frame.setLocationRelativeTo(null);  
   frame.setVisible(true);
   }
   

    
    static void expenseSheet(){
        //exception-handling
        try{
        int i=0;
        System.out.println("EXPENSE SHEET");
        while(i<=top){
            System.out.println("\tItem: "+list[i]+"\tprice: "+price[i]+"\tCatageory: "+catchoice[i]+"        \tDate: "+datelist[i]);
            i++;
        

        }
    }
    catch(ArrayIndexOutOfBoundsException  e)
    {
        System.out.println(e);
        System.out.println("Unexpected array out of bound error found");


    }
    //<------END------->//
        totalExpenditure();
        System.out.println(" ");
        percentage();

    }
    

    static void percentage(){
        int Food=0,General=0,Medicines=0,Gifts=0,Shopping=0,travel=0,Holidays=0,Entertainment=0;

        System.out.println("Your Expenditure categories % ->");
        for(int i=0;i<(top+1);i++){
            if(catchoice[i]=="Food"){
                Food=(int) (Food+price[i]);
            }
            if(catchoice[i]=="General"){
                General=(int) (General+price[i]);
            }
            if(catchoice[i]=="Medicines"){
                Medicines= (int) (Medicines+price[i]);
            }
            if(catchoice[i]=="Gifts"){
                Gifts= (int) (Gifts+price[i]);
            }
            if(catchoice[i]=="Shopping"){
                Shopping= (int) (Shopping+price[i]);
            }
            if(catchoice[i]=="travel"){
                travel= (int) (travel+price[i]);
            }
            if(catchoice[i]=="Holidays"){
                Holidays= (int) (Holidays+price[i]);
            }
            if(catchoice[i]=="Entertainment"){
                Entertainment=(int) (Entertainment+price[i]);
            }
        }
        System.out.println("Food:"+(int)((Food/total)*100)+"\tGeneral:"+(int) ((General/total)*100)+"\tMedicines:"+(int) ((Medicines/total)*100)+"\tGifts:"+(int) ((Gifts/total)*100)+"\tShopping:"+(int) ((Shopping/total)*100)+"\ttravel:"+(int) ((travel/total)*100)+"\tHolidays:"+(int) ((Holidays/total)*100)+"\tEntertainment:"+(int) ((Entertainment/total)*100));

    }



    static void dailyLeft(){
        
        System.out.println("Your daily expenditure should be "+daily);
        float dailyLeft=daily-expense;
        System.out.println("Money left: "+dailyLeft);
        
    }


    static void saving(){
        double jan=0,feb=0,mar=0,apr=0,may=0,jun=0,jul=0,aug=0,sept=0,oct=0,nov=0,dec=0;
        
        String str;
        

        
        System.out.println("Your monthly savings are:");
        for(int i=0;i<(top+1);i++){
            str=monthlist[i];
            if(Integer.valueOf(str).equals(Integer.valueOf("1"))){
                jan=(jan+price[i]);
            }
            if(Integer.valueOf(str).equals(Integer.valueOf("2"))){
                feb=(feb+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("3"))){
                mar=(mar+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("4"))){
                apr=(apr+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("5"))){
                may= (may+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("6"))){
                jun= (jun+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("7"))){
                jul=(jul+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("8"))){
                aug= (aug+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("9"))){
                sept= (sept+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("10"))){
                oct=(oct+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("11"))){
                nov= (nov+price[i]);
            }

            if(Integer.valueOf(str).equals(Integer.valueOf("12"))){
                dec=(dec+price[i]);
            }



        }
        
        System.out.println("Jan:"+(monthlyBudget-jan)+"\tFeb:"+(monthlyBudget-feb)+"\tMar:"+(monthlyBudget-mar)+"\tApril:"+(monthlyBudget-apr)+"\tMay:"+(monthlyBudget-may)+"\tJune:"+(monthlyBudget-jun)+"\nJuly:"+(monthlyBudget-jul)+"\tAugust:"+(monthlyBudget-aug)+"\tSeptember:"+(monthlyBudget-sept)+"\tOct:"+(monthlyBudget-oct)+"\tNov:"+(monthlyBudget-nov)+"\tDec:"+(monthlyBudget-dec));



    }

    
    static void monthlyAvg(){
        try{
        int avg=(int) (total/12);
            
            
        
        System.out.println("Your monthly Avg are:"+avg);
        }
        catch(ArithmeticException e){
            {System.out.println(e);}  
     
   System.out.println("Division by 0 error");  
        }

    }


    static void totalExpenditure(){
        
        System.out.print("Enter your expenditure for this Month is: "+total);
        
    }


    public static void main(String[] args) {
        int choice,choice2;
        Scanner in= new Scanner(System.in);
        System.out.println("WELCOME TO THE EXPENSE TRACKER");
        System.out.println("Please set your monthly budget first");
        setBudget();
        Home obj=new Home();
        try{
        
        do{
            System.out.println("\nPRESS\n1->TO ADD EXPENSE\n2->TO SEE THE REMAINING BUDGET\n3->TO SEE THE EXPENSE SHEET\n4->For Percentage distribution of spending\n5->FOR MORE INFO\n6->TO EXIT");
            choice=in.nextInt();
            warning();
            switch(choice)
               {
                
            
                case 1:
                obj.addExpense();
                
                break;

                case 2:
                displayBudget();
                
                break;


                case 3:
                expenseSheet();
                tableSheet();

                
                break;

                case 4:
                    percentage();
                    break; 

                case 5:
                do{
                System.out.println("PRESS \n1->FOR DAILY EXPENSE LEFT\n2->SAVINGS TILL NOW\n3->MONTHLY AVG EXPENDITURE\n4->BACK TO MAIN MENU");
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
                        break;
                    default:
                        System.out.println("Enter a valid option");
                        break;
                    
                }
                }
                while(choice2!=4);
                    break;
                
                
                 
                case 6:
                    break;      

                default:
                    System.out.println("Enter a valid option");
                    break;

            }


        } 
        while((choice!=6));
    }

    catch(ArrayIndexOutOfBoundsException  e)
    {
        System.out.println(e);
        System.out.println("Unexpected array out of bound error found");


    }
    catch(ArithmeticException e)
    {
        System.out.println(e);
        System.out.println("Unexpected Arithemetic error found");


    }
    catch(NullPointerException e)
    {
        System.out.println(e);
        System.out.println("Unexpected Null pointer error found");


    }
    catch(NumberFormatException e)
    {
        System.out.println(e);
        System.out.println("Unexpected Number format error found");


    }

catch (Exception e) {
    // Throwing an exception
    System.out.println("Exception is caught");

}
in.close();
}
}
    

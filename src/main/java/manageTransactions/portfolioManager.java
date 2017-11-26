package manageTransactions;

import Utilities.queryHandler;
import Utilities.scannerInputs;
import Utilities.transactionBridge;

public class portfolioManager extends transactionBridge {

    public static void portfolioManagerMenu(){
        int input = 0;
        String title = "\n\n\n\t\t========================\n" +
                "\t        Manage Portfolio        \n" +
                "\t\t========================\n\n";
        String question = "1.) See investment breakdown"
                + "\n2.) Predicted investment trajectory"
                + "\n3.) Change Aggression"
                + "\n4.) Go back to Main Menu"
                + "\nEnter Choice: ";
        while (input != 4) {
            input = queryHandler.optionsQuery(title + question, 4);
            switch(input){
                case 1:
                case 2:
                case 3:
            }
        }
    }

    public static Portfolio createPortfolio(Portfolio portObj, Bank bankObj){
        System.out.println("\n\n\n\t\t========================\n" +
                "\t       Create a Portfolio!        \n" +
                "\t\t========================");

        changeAggression(portObj);
        addFunds(portObj,bankObj);

        return portObj;
    }

    public static void changeAggression(Portfolio portObj){
        String question = "Select investing aggression: \n\n1.) Conservative \n2.) Moderate \n3.) Aggressive \n4.) Cancel \n\nEnter Choice:";
        int input = queryHandler.optionsQuery(question,4);
        portObj.aggression = input != 4 ? input : portObj.aggression;
    }

    public static void addFunds(Portfolio portObj, Bank bankObj){
        System.out.print("\nAdd money to Investment Funds\n\nEnter amount to add from bank:");
        double amount = scannerInputs.scanDouble();
        transactionBridge.bankToPortfolio(bankObj,portObj,amount);
    }

}
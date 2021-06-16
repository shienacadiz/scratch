package klarna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transactions {
    public static int AMOUNT_INDEX = 3;
    public static int TRANSACTION_ID_INDEX = 4;
    public static String TRANSACTION_DELIMITER = ",";

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        List<String> rejectedTransactions = new ArrayList<>();
        int availableCreditLimit = creditLimit;

        for(String transaction : transactions) {
            List<String> transactionDetails = Arrays.asList(transaction.split(TRANSACTION_DELIMITER));
            if(availableCreditLimit - Integer.parseInt(transactionDetails.get(AMOUNT_INDEX)) < 0){
                rejectedTransactions.add(transactionDetails.get(TRANSACTION_ID_INDEX));
            } else {
                availableCreditLimit -= Integer.parseInt(transactionDetails.get(AMOUNT_INDEX));
            }
        }

        return rejectedTransactions;
    }
}

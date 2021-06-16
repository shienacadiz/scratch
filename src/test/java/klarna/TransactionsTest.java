package klarna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    @Test
    public void shouldReturnEmptyListIfThereIsNoTransactions() {
        assertThat(Transactions.findRejectedTransactions(new ArrayList<>(), 0).size(), is(0));
    }

    @Test
    public void shouldReturnEmptyListIfThereIsATransactionWithinCreditLimit() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,200,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions.size(), is(0));
    }

    @Test
    public void shouldReturnTransactionThatIsOverCreditLimit() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,201,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(Arrays.asList("TR0001")));
    }

    @Test
    public void shouldReturnEmptyListWhenAmountIsExact() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,100,TR0001",
            "John,Doe,john@doe.com,100,TR0002",
            "John,Doe,john@doe.com,100,TR0003");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 300);

        assertThat(rejectedTransactions.size(), is(0));
    }

    @Test
    public void shouldReturnAllTransactionWhenAmountIsZero() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,100,TR0001",
            "John,Doe,john@doe.com,100,TR0002",
            "John,Doe,john@doe.com,100,TR0003");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 0);

        assertThat(rejectedTransactions, is(Arrays.asList("TR0001", "TR0002", "TR0003")));
    }

    @Test
    public void shouldReturnSucceedingTransactionsWhenCreditLimitExceededExactly() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,130,TR0001",
            "John,Doe,john@doe.com,120,TR0002",
            "John,Doe,john@doe.com,100,TR0004",
            "John,Doe,john@doe.com,100,TR0005",
            "John,Doe,john@doe.com,100,TR0006");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 300);

        assertThat(rejectedTransactions, is(Arrays.asList("TR0004", "TR0005", "TR0006")));
    }

    @Test
    public void shouldReturnSucceedingTransactionsWhenTransactionIsGreaterThanRemainingCreditLimit() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,50,TR0001",
            "John,Doe,john@doe.com,20,TR0002",
            "John,Doe,john@doe.com,50,TR0004",
            "John,Doe,john@doe.com,900,TR0005",
            "John,Doe,john@doe.com,100,TR0006");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 100);

        assertThat(rejectedTransactions, is(Arrays.asList("TR0004", "TR0005", "TR0006")));
    }

    @Test
    public void shouldReturnCodesWhenSomeTransactionsCanStillFitTheLimit() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,50,TR0001",
            "John,Doe,john@doe.com,20,TR0002",
            "John,Doe,john@doe.com,50,TR0004",
            "John,Doe,john@doe.com,200,TR0005",
            "John,Doe,john@doe.com,10,TR0006",
            "John,Doe,john@doe.com,5,TR0007",
            "John,Doe,john@doe.com,50,TR0008");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 100);

        assertThat(rejectedTransactions, is(Arrays.asList("TR0004", "TR0005", "TR0008")));
    }
}
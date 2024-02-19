package bankProject.bankProject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest{
	 
	
	public Bank bank;

    @BeforeMethod
    public void setUp() {
        bank = new Bank(1000); // Initial balance for testing
    }

    @Test
    public void testGetBalance() {
        Assert.assertEquals(bank.getBalance(), 1000.0);
    }

    @Test
    public void testDeposit() {
        bank.deposit(500);
        Assert.assertEquals(bank.getBalance(), 1500.0);
    }

    @Test
    public void testWithdrawSufficientFunds() {
        boolean result = bank.withdraw(300);
        Assert.assertTrue(result);
        Assert.assertEquals(bank.getBalance(), 700.0);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        boolean result = bank.withdraw(1200);
        Assert.assertFalse(result);
        Assert.assertEquals(bank.getBalance(), 1000.0);
    }
	
}

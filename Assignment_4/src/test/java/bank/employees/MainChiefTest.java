package bank.employees;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class MainChiefTest consists of tests checking all functionalities
 * a Main Chief has
 */
class MainChiefTest {
    MainChief MainChief;
    Customer regularCustomer;
    Customer platinumCustomer;
    Customer goldenCustomer;

    /**
     * This method is used for initialization purposes before each test.
     */
    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1234);
        regularCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        goldenCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        platinumCustomer = getCustomerHelper(Level.PLATINUM, creditCard);
        MainChief = new MainChief("name", "surname");
        MainChief.addCustomer(regularCustomer);
        MainChief.addCustomer(goldenCustomer);
        MainChief.addCustomer(platinumCustomer);
    }

    /**
     * This test checks whether the level upgrade (done by a Main Chief)
     * from a regular to a golden customer works correctly
     */
    @Test
    public void testUpgradeToGOLDEN(){
        MainChief.upgradeCustomer(regularCustomer.getId());
        assertEquals(Level.GOLDEN, regularCustomer.getLevel());
    }

    /**
     * This test checks whether the level upgrade (done by a Main Chief)
     * from a golden to a platinum customer works correctly
     */
    @Test
    public void testUpgradeToPLATINUM(){
        MainChief.upgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.PLATINUM, goldenCustomer.getLevel());
    }

    /**
     * This test checks whether the level downgrade (done by a Main Chief)
     * from a golden to a regular customer works correctly
     */
    @Test
    public void testDowngradeToREGULAR(){
        MainChief.downgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.REGULAR, goldenCustomer.getLevel());
    }

    /**
     * This test checks whether the level downgrade (done by a Main Chief)
     * from a platinum to a golden customer works correctly
     */
    @Test
    public void testDowngradeToGOLDEN(){
        MainChief.downgradeCustomer(platinumCustomer.getId());
        assertEquals(Level.GOLDEN, platinumCustomer.getLevel());
    }

    /**
     * This test checks whether the levels of the Main Chief's customers change
     * if a random other customer upgrades its level
     */
    @Test
    public void testUpgradeNonexistentCustomer(){
        MainChief.upgradeCustomer(UUID.randomUUID());
        assertEquals(Level.REGULAR, regularCustomer.getLevel());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
    }

    /**
     * This test checks whether the levels of the Main Chief's customers change
     * if a random other customer downgrades its level
     */
    @Test
    public void testDowngradeNonexistentCustomer(){
        MainChief.downgradeCustomer(UUID.randomUUID());
        assertEquals(Level.REGULAR, regularCustomer.getLevel());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
    }

    /**
     * This method is used as a helper to simplify the customer generation
     * @param level REGULAR, GOLDEN or PLATINUM
     * @param creditCard a default credit card is used as dummy, since for these tests
     *                   it's not important
     * @return Customer to help testing
     */
    public Customer getCustomerHelper(Level level, CreditCard creditCard){
        return new Customer(
                "name",
                "surname",
                1,
                level,
                creditCard
        );
    }
}
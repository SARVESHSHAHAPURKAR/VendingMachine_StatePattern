package VendingState;

import org.example.Coin;
import org.example.Item;
import org.example.VendingMachine;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState(){
        System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Invalid operation at this stage");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Invalid operation at this stage");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Invalid operation at this stage");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Invalid operation at this stage");
    }
}

package BigShop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shop implements PayCheck{

    private BigDecimal balance;
    private BigDecimal balanceAccount;
    private Map < String, ArrayList> mapping = new HashMap(); // ALMACENA Y UBICA A CLIENTES U ITEMS PARA VERIFICAR, SETTEAR BALANCE

    public Shop() {
    }

    public Shop(BigDecimal balance) {
        setBalance(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Map<String, ArrayList> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, ArrayList> mapping) {
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "balance=" + balance +
                ", mapping=" + mapping +
                '}';
    }

    public BigDecimal checkItemPrice(String item) {
        BigDecimal itemPrice = new BigDecimal("0.00");
        for (int i = 0; i < mapping.get("item").size(); i++) {
            if (((Item) mapping.get("item").get(i)).getName().equals(item)) {
                System.out.println("Precio del Item :" + ((Item) mapping.get("item").get(i)).getPrice());
                itemPrice = ((Item) mapping.get("item").get(i)).getPrice();
            }
        }
        return itemPrice;
    }

    public void checkBalance(String name) {
        for (int j = 0; j < mapping.get("user").size(); j++) {
            //System.out.println(((User) mapping.get("user").get(j)).getName().equals(name)); ---  RETORNA FALSE Y ES LA MISMA CONSDICIÓN, PORQUÉ??
            if (((User) mapping.get("user").get(j)).getName().equals(name)) {
                System.out.println("El balance de tu cuenta es : " + ((User) mapping.get("user").get(j)).getBalance());
                balanceAccount =  ((User) mapping.get("user").get(j)).getBalance();
            }
        }
    }

    @Override
    public void receivePayment(BigDecimal amount) {
        if(amount.compareTo(balanceAccount) > 0) {
            System.out.println("Lo siento, el item excede su balance");
        } else {
            setBalance(balance.add(amount));
            System.out.println("Compra realizada exitosamente");
            System.out.println("El balance actual en tienda es " + this.balance);
        }
    }


}

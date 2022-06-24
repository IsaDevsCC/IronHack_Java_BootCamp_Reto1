package BigShop;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


public class MainApp {
    private static final Scanner ASK = new Scanner(System.in);
    private static ArrayList < User > users = new ArrayList < User >();
    private static ArrayList < Item > items = new ArrayList < Item> ();
    private static Map < String, ArrayList> map = new HashMap();
    private static Shop shop = null;
    public static void main(String x []) throws IOException {
        usersArrays();
        //listOfItems();
        System.out.println("Hello, give me your name in the list of users, please?");
        String name = ASK.next();

        if(userVerified(name)) {
            listOfItems();
            createShop();
            System.out.println("Please choice a item of the list");
            String item = ASK.next();
            shop.checkItemPrice(item);
            shop.checkBalance(name);
            System.out.println("Desea realizar la compra?");
            String respuesta = ASK.next();
            switch (respuesta) {
                case "si" -> shop.receivePayment(shop.checkItemPrice(item));
                case "no" -> {
                }
            }
            System.out.println("Presione 1 para almacenar el registo o 2 para Salir");
            int save = ASK.nextInt();
            switch (save) {
                case 1 -> saveRegister();
                case 2 -> {
                }
            }

        } else {
            System.out.println("Do you like adding like User, press (1) for 'YES' or (0) for 'NO");
            int response = ASK.nextInt();
            switch (response) {
                case 1 :
                    addNewUser();
                    break;
                case 0 :
                    System.out.println("Adeu ...");
                    break;
            }
        }
    }

    public  static void usersArrays() {
        String name [] = {"Arthur", "Peter", "Lewis"};    //48564
        BigDecimal [] balances = {new BigDecimal("850546.545"),new BigDecimal("7.256"), new BigDecimal("1237844.589")};

        for(int i = 0; i < name.length; i++){
            users.add(new User(name[i], balances[i]));
        }
        printUsers(users);
    }

    public static void printUsers(ArrayList < User > users) {
        System.out.println("Listado de Usuarios registrados");
        for (User i : users) {
            System.out.println("Usuario = " + i.getName() + " Balance = " + i.getBalance());
        }
    }

    public static boolean userVerified(String name) {
        boolean resp = false;
        for(var i : users) {
            if(i.getName().equals(name)){
                resp = true;
            }
        }
        return resp;
    }

    public static void addNewUser(){
        System.out.println("Tell me your name?");
        String name = ASK.next();
        System.out.println("Tell me your balance?");
        BigDecimal balance = new BigDecimal(ASK.next());

        users.add(new User(name, balance));
        System.out.println("User correctly add");

        for(var i : users) {
            System.out.println(i.toString());
        }
    }

    public static void listOfItems() {
        String [] itemsPhysicsNames = {"Book", "Laptop", "CompactDisk", "Telescope", "Lp's"};
        String [] itemsDigitalNames = {"eBook", "Cloud", "MP4", "GPS", "Sanity"};
        BigDecimal [] itemsAll = {new BigDecimal("785.56"), new BigDecimal("7845.9645"), new BigDecimal("235.5633"), new BigDecimal("784.965525"), new BigDecimal("785.56")};

        for(int i = 0; i < itemsPhysicsNames.length; i++) {
            items.add(new Physic(itemsPhysicsNames[i], itemsAll[i]));
            items.add(new Digital(itemsDigitalNames[i], itemsAll[i]));
        }

        printListItem(items);
    }

    public static void printListItem(ArrayList <Item> items)  {
        System.out.println("El listado de Items disponibles y su costo es :");
        for(var i : items) {
            System.out.println(i.toString());
        }
    }

    public static boolean checkingItem(String item) {
        boolean response = false;
        for(var i : items) {
            if(i.getName().equals(item)) {
                response = true;
            }
        }
        return response;
    }

    public static void createShop() {
        shop = new Shop(new BigDecimal("0.0000"));
        map.put("item", items);
        map.put("user", users);
        shop.setMapping(map);

        System.out.println(shop.toString());
    }

    public static void saveRegister() throws IOException {
        FileWriter escribe = new FileWriter("Shop.txt");
        for(int i = 0; i < 1; i++) {
            escribe.write(shop.toString() + "\n");
        }
        escribe.close();
    }

}

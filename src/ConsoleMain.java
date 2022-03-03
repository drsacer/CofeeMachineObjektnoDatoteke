import java.io.*;
import java.util.Scanner;

public class ConsoleMain {

    static Scanner s = new Scanner(System.in);
    static String configFileName = "coffee_machine_status.txt";

    public static void main(String[] args) {

        Machine machine = new Machine(550, 400, 540, 120, 9);
        loadCoffeeMachineStatusFromFile (machine, configFileName);

        String odabir = "";
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            odabir = s.nextLine();

            switch (odabir) {
                case "buy":
                    buy(machine);
                    break;
                case "fill":
                    fill(machine);
                    break;
                case "remaining":
                    remaining(machine);
                    break;
                case "take":
                    take(machine);
                    break;
                case "exit":
                    saveCoffeeMachineStatusToFile (machine, configFileName);
                    break;
                default:
                    System.out.println("Krivi odabir!");
            }

        } while (!odabir.equals("exit"));
    }

    private static void buy(Machine machine) {
        CoffeeCup c;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:  ");
        String odabir = s.nextLine();

        switch (odabir) {
            case "1":
                c = new CoffeeCup("Espresso", 250, 0, 16, 4);
                break;
            case "2":
                c = new CoffeeCup("Latte", 350, 75, 20, 7);
                break;
            case "3":
                c = new CoffeeCup("Capuccino", 200, 100, 12, 6);
                break;
            case "exit":
                return;
            default:
                System.out.println("Krivi unos");
                return;
        }

        if (!machine.imaLiDovoljnoResursi(c)) {
            System.out.println("Sorry, not enough " + machine.provjeriKojiResursFali(c) + "!"); // Napisati koji resurs fali
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            machine.napraviKavu(c);
        }
    }

    public static void remaining(Machine machine) {
        System.out.println("The coffee machine has:\n" +
                machine.getTrenutnoStanjeVode() + " ml of water\n" +
                machine.getTrenutnoStanjeMlijeka() + " ml of milk\n" +
                machine.getTrenutnoStanjeKave() + " g of coffee beans\n" +
                machine.getTrenutnoStanjeSalica() + " disposable cups\n" +
                "$" + machine.trenutnoStanjeNovca + " of money\n");
    }

    public static void fill(Machine machine) {
        System.out.println("Write how many ml of water you want to add:");
        machine.setTrenutnoStanjeVode(machine.getTrenutnoStanjeVode() + s.nextInt());
        System.out.println("Write how many ml of milk you want to add: ");
        machine.setTrenutnoStanjeMlijeka(machine.getTrenutnoStanjeMlijeka() + s.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        machine.setTrenutnoStanjeKave(machine.getTrenutnoStanjeKave() + s.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        machine.setTrenutnoStanjeSalica(machine.getTrenutnoStanjeSalica() + s.nextInt());
        s.nextLine();

    }

    public static void take(Machine machine) {
        System.out.println("I gave you $" + machine.getTrenutnoStanjeNovca() + " of money");
        machine.setTrenutnoStanjeNovca(0);
    }

    // ČITANJE STATUSA MAŠINE IZ DATOTEKE

    private static void loadCoffeeMachineStatusFromFile(Machine machine, String fileName) {

        try {
            FileReader reader = new FileReader(fileName);
            Scanner fileScanner = new Scanner(reader);  // Objasniti

           // Scanner fileScanner = new Scanner(new FileReader(fileName));
            fileScanner.nextLine();
            fileScanner.useDelimiter(",");

            machine.setTrenutnoStanjeNovca(fileScanner.nextInt());
            machine.setTrenutnoStanjeVode(fileScanner.nextInt());
            machine.setTrenutnoStanjeMlijeka(fileScanner.nextInt());
            machine.setTrenutnoStanjeKave(fileScanner.nextInt());
            machine.setTrenutnoStanjeSalica(fileScanner.nextInt());


        }catch (FileNotFoundException e) {
            System.out.println("Coffee Machine Not Found");
        } catch (Exception e){
            System.out.println("Input file is not in right format!");
        }
        System.out.println(machine);
    }

    private static void saveCoffeeMachineStatusToFile (Machine machine, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Novac,Voda,Mlijeko,Kava,Šalice\n");
            writer.write(machine.getTrenutnoStanjeNovca() + "," +machine.getTrenutnoStanjeVode()+ "," + machine.getTrenutnoStanjeMlijeka() + "," +
                    machine.getTrenutnoStanjeKave() + "," + machine.getTrenutnoStanjeSalica());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



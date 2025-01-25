package backEnd;
import java.io.Serializable;
import java.sql.PseudoColumnUsage;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class AppManager implements Serializable {
    private static Scanner scanner = new Scanner(System.in);
    private static final long serialVersionUID = 1L;
    private static FileWriter bugWriter, userDataWriter;
    private Map<Login, Password> userData = new HashMap<Login, Password>();
    private int x = 10;

    public void listUsers() {
        for (Login key: userData.keySet()) {
            Password value = userData.get(key);
            System.out.println(key.listData() + " " + value.listData());
        }
    }


    public void runSimulation() throws IOException{
        System.out.println("Do you want to delete all existing passwords y/n?");
        String wiper = scanner.nextLine();
        try {
            if(wiper.equals("n")) {
                userDataWriter = new FileWriter("loginPasswords.txt",true);
            } else {
                userDataWriter = new FileWriter("loginPasswords.txt");
                userData.clear();
            }
            bugWriter = new FileWriter("bugLogger.txt");
            String enteredLine = "";
            while (true) {
                enteredLine = scanner.nextLine();
                if (enteredLine.equals("end")) {
                    break;
                }
                String cleanLine = enteredLine.trim().replaceAll(" +", " ").strip();
                String[] data = cleanLine.split(" ");
                try {
                    if (data.length != 2) {
                        throw new InvalidAmoutOfInputsException();
                    }
                    Password enteredPass = new Password(data[1]);
                    Login enteredLogin = new Login(data[0]);
                    userData.put(enteredLogin, enteredPass);
                    userDataWriter.write(enteredLogin.getLogin() + " " + enteredPass.getEncryptedPassword() + "\n");
                } catch (InvalidAmoutOfInputsException e) {
                    bugWriter.write(e.getMessage());
                }
            }
        } catch (IOException e) {
            bugWriter.write("File is not found!");
            System.exit(-1);
        } finally {
            bugWriter.close();
            userDataWriter.close();
        }
    }

}

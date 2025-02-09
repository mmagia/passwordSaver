import backEnd.AppManager;

import java.io.*;

public class Main implements Serializable {
    private static final String PATH = "appState.ser";
    private static AppManager manager = null;

    public static void main(String[] args) {
        try {
            manager = deserializeState();
        } catch (Exception e) {
            manager = new AppManager();
        } finally {
            try {
                manager.runSimulation();
            } catch (IOException e) {
            }
            manager.listUsers();
            serializeState(manager);
        }
    }

    public static void serializeState(AppManager manager) {
        try (FileOutputStream fileOut = new FileOutputStream(PATH);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(manager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppManager deserializeState() {
        try (FileInputStream fileIn = new FileInputStream(PATH);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (AppManager) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
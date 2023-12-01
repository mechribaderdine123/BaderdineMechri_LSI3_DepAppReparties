package rmiServer;

import rmiService.ConversionImpl;
import rmiService.IConversion;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionServer {

    public static void main(String[] args) {
        try {
            // Création d'une instance de l'implémentation de l'interface
            IConversion conversionService = new ConversionImpl();

            // Création du registre RMI sur le port spécifié (1099 dans cet exemple)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Liaison du service au registre RMI avec un nom associé
            registry.rebind("ConversionService", conversionService);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

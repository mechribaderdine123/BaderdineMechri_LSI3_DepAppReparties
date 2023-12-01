package rmiClient;

import rmiService.IConversion;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionClient {

    public static void main(String[] args) {
        try {
            // Accès au registre RMI sur le port spécifié (1099 dans cet exemple)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Recherche du service par son nom associé
            IConversion conversionService = (IConversion) registry.lookup("ConversionService");

            // Exemple d'utilisation du service
            double montant = 100.0;
            double montantConverti = conversionService.convertirMontant(montant);

            System.out.println("Montant initial : " + montant);
            System.out.println("Montant converti : " + montantConverti);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}


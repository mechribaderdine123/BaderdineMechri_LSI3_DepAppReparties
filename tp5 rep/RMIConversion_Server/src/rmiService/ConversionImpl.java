package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversionImpl extends UnicastRemoteObject implements IConversion {
    double tauxDeConversion;
    public ConversionImpl() throws RemoteException {
        super();
    }
    @Override
    public double convertirMontant(double mt) throws RemoteException {
        return mt * tauxDeConversion;
    }
}

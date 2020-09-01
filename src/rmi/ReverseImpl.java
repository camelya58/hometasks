package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Class ReverseImpl represents the realization of Reverse interface.
 *
 * @author Kamila Meshcheryakova
 * created by 01.09.2020
 */
public class ReverseImpl implements Reverse {
    @Override
    public String reverse(String str) throws RemoteException {
        return new StringBuilder(str).reverse().toString();
    }

    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception {
        //create an object for remote invocation
        final ReverseImpl service = new ReverseImpl();

        //create shared object registry
        final Registry registry = LocateRegistry.createRegistry(2099);

        //create "stub" - remote call receiver
        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        //registering a stub in the registry
        registry.bind(UNIC_BINDING_NAME, stub);

        //put the main thread to sleep, otherwise the program is closed
        Thread.sleep(Integer.MAX_VALUE);
    }
}

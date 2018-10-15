import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Livros extends Remote {
	
	public boolean incluir (Livro l) throws RemoteException;
	
	public boolean excluir (int isbn) throws RemoteException; 
	
	public Livro buscar (int isbn) throws RemoteException;
	
	public ArrayList<Livro> getTodos () throws RemoteException;
	
}

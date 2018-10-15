import java.util.ArrayList;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Livros {

    public Server() {}
	ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public boolean incluir (Livro l){
		return livros.add(l);
	}
	
	public boolean excluir (int isbn){
		int posicao = 0;
		for (int i = 0; i < livros.size(); i++)
		{
			if(livros.get(i).getIsbn()==isbn){
				posicao = i;
				i = livros.size();
			}
		}
		if(livros.remove(posicao).getClass().toString() == "Livro"){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Livro buscar (int isbn){
		for (int i = 0; i < livros.size(); i++)
		{
			if(livros.get(i).getIsbn()==isbn){
				return livros.get(i);
			}
		}
		return new Livro(9999999,"não existe livro nesta posição",0000);
	}
	
	public ArrayList<Livro> getTodos (){
		return livros;
	}
	
	public static void main (String args[]) {
		
		try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
			
			//Create and export a remote object
			Server obj = new Server();
			Livros stub = (Livros) UnicastRemoteObject.exportObject(obj,0);
			
			//Register the remote object with a Java RMI registry
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("Livros", stub);
			
			System.out.println("Server Ready");
		}
			catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}


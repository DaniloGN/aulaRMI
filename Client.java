
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client {

  private Client() {}
	
	public static void main (String args[]) {
		
		String host = (args.length < 1) ? null : args[0];
		
		try {
						
			Registry registry = LocateRegistry.getRegistry(host);
			Livros stub = (Livros) registry.lookup("Livros");
			String teste = "inicio";
			Scanner sc = new Scanner(System.in);
				while(!teste.equals("exit")){
					System.out.println("incluir/excluir/buscar/todos");
					teste = sc.next();
					Scanner sc2 = new Scanner(System.in);
					if(teste.equals("incluir")){
						int isbn = sc2.nextInt();
						String titulo = sc2.next();
						int ano = sc2.nextInt();
						boolean response = stub.incluir(new Livro(isbn,titulo,ano));
						System.out.println("response: " + response);
					}
					if(teste.equals("buscar")){
						int busca = sc2.nextInt();
						Livro response = stub.buscar(busca);
						System.out.println("response: " + response.getTitulo());
					}
				}
		}
		catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}


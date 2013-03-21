package jogo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import jogo.Tela;

public class RagBomberServer extends UnicastRemoteObject implements IFRagBomberServer, IFClienteRmi {
	
	//private Destrutiveis =  new ArrayList<BlocoDestrutivel>();
	
	private String mensagem;
	private String envio;

	public RagBomberServer() throws RemoteException {
		
		try { 
            LocateRegistry.createRegistry(1234); 
            IFRagBomberServer servidor = new ImplementacaoServidor(); 
            Naming.rebind("rmi://localhost:1234/servidor",servidor); 
              
            // trecho de cуdigo que deixa a thread corrente  
            // esperando atй que outra thread notifique (utilizaзгo de monitores). 
            synchronized (servidor) 
            { 
                try 
                { 
                    servidor.wait(); 
                }  
                catch (InterruptedException e1)  
                { 
                } 
            } 
            String nome = JOptionPane.showInputDialog("Digite o seu Nick(Servidor):"); 
            IFClienteRmi cliente = servidor.getClienteRmi(); 
            cliente.conectar(); 
           
              
  
            do { 
                mensagem = JOptionPane.showInputDialog("Digite a mensagem(Servidor):"); 
                cliente.ipCliente(nome + " disse: " +mensagem); 
                System.out.println("Vocк disse: "+mensagem); 
                  
            } while (!mensagem.equals("sair")); 
  
            cliente.mensagemClienteRmi(nome + " saiu da conversa!"); 
  
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
  
        
	@Override
	public void colocarBomba(int x, int y) {
		
		
		
	}



	@Override
	public void mexerY() {
		
		
	}



	@Override
	public void mexerX() {
		
		this.mexerX();
		
	}


	@Override
	public void gerarBlocosDestrutiveis() {
		this.gerarBlocosDestrutiveis();
		
	}

	@Override
	public void gerarUpgrade() {
		this.gerarUpgrade();
		
	}

	@Override
	public void conectar() throws RemoteException {
		this.conectar();
		
	}

	@Override
	public void desconectar() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acharServidor(ClienteRmi stub) {
		
        } 
    

	@Override
	public void mensagemCliente(String mensagem) throws RemoteException {
		
		
	}

	@Override
	public void ipCliente(String localhost) {
		
		
	}

	@Override
	public  void mensagemServidor(String mensagem) throws RemoteException {
		
		
	}

	@Override
	public void mensagemClienteRmi(String mensagem) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IFClienteRmi getClienteRmi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ClienteRmi() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) throws RemoteException { 
		new RagBomberServer(); 
	} 
	
}



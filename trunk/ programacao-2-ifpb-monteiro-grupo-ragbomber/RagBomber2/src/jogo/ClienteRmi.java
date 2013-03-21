package jogo;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

public class ClienteRmi  {

	private String mensagem;
//	
//	 protected ClienteRmi() throws RemoteException {
//		
//		
//	}

	public  ClienteRmi () { 
		 try { 
		               
		             localhost(); 
		             String nome = JOptionPane.showInputDialog("Digite o seu Nick:"); 
		             String ip = JOptionPane.showInputDialog("Digite o IP do servidor:"); 
		   
		             IFRagBomberServer objCalculoRemoto = (IFRagBomberServer) Naming 
		                     .lookup("rmi://" + ip + ":1234/servidor"); 
		               
		             LocateRegistry.createRegistry(1235); 
		             ImplementacaoCliente cliente = new ImplementacaoCliente(); 
		             Naming.rebind("rmi://localhost:1235/cliente", cliente); 
		             objCalculoRemoto.ipCliente(localhost()); 
		               
		             // trecho de cуdigo que deixa a thread corrente  
		             // esperando atй que outra thread notifique (utilizaзгo de monitores). 
		             synchronized (cliente) { 
		                 try { 
		                     cliente.wait(); 
		                 } catch (InterruptedException e) { 
		                 } 
		             } 
		   
		             do { 
		                 mensagem = JOptionPane.showInputDialog("Digite a mensagem:"); 
		                 System.out.println("Vocк disse:" + mensagem); 
		                 objCalculoRemoto.mensagemServidor(nome + " disse: " + mensagem); 
		             } while (!mensagem.equals("sair")); 
		   
		             objCalculoRemoto.mensagemServidor(nome + " saiu da conversa!"); 
		   
		         } catch (RemoteException e) { 
		             e.printStackTrace(); 
		             System.out.println("Erro:" + e.toString()); 
		         } catch (Exception e) { 
		             JOptionPane.showMessageDialog(null, "Entrada invalida", 
		                     e.getMessage(), JOptionPane.ERROR_MESSAGE); 
		             e.printStackTrace(); 
		             System.exit(-1); 
		         } 
		     } 
		       
		     /** 
		      * Mйtodo que retorna o endereзo local da maquina. 
		      * @return O endereзo da mбquina local. 
		      */
		     private static String localhost() { 
		         try { 
		             return InetAddress.getLocalHost().getHostAddress(); 
		         } catch (UnknownHostException e) { 
		             return new String("127.0.0.1"); 
		         } 
		     } 
		       
		       
		     public static void main(String[] args) throws RemoteException { 
		         new ClienteRmi(); 
		     } 
		   
		       
		 
	

	public void conectar() throws RemoteException {
		System.out.println(" Começar jogo ");
		
		
	}

	
	public void desconectar() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void mensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void acharServidor(ClienteRmi stub) {
		// TODO Auto-generated method stub
		
	}

	
	public void acharServidor() {
		// TODO Auto-generated method stub
		
	}

	
	public void mensagemClienteRmi(String mensagem) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void ipCliente(String ip) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void ClienteRmi() {
		// TODO Auto-generated method stub
		
	}

}

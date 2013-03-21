//package jogo;
//
//import java.rmi.Naming;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//import jogo.Bomba;
//import java.net.SocketPermission;
//
//public class ServidorRmi  implements IFServidorRmi, {
//	
//	private Personagem personagem;
//	private Bomba bomba;
//	private Upgrade upgrade;
//	private BlocoDestrutivel bloco;
//	
//	public void setPersonagem(Personagem personagem) {
//		this.personagem = personagem;
//	}
//
//	public void setBomba(Bomba bomba) {
//		this.bomba = bomba;
//	}
//
//	public void setUpgrade(Upgrade upgrade) {
//		this.upgrade = upgrade;
//	}
//
//	public void setBloco(BlocoDestrutivel bloco) {
//		this.bloco = bloco;
//	}
//	
//	public static void main(String[] args) {
//		if (System.getSecurityManager() == null) { 
//            System.setSecurityManager(new SecurityManager()); 
//        }
//		try {
//		ServidorRmi obj = new ServidorRmi();
//		Naming.rebind("rmi://localhost:1099/ServidorRmi", obj);
//	}
//	catch (Exception e){
//		System.out.println(" Erro " + e);
//	}
//	}
//	
//	public static void acharServidor(ClienteRmi stub) { 
//       String nome = "Compute"; 
//        try { 
//            System.out.print("..."); 
//            Registry registry = LocateRegistry.createRegistry(1099); 
//            registry.rebind(nome, stub); 
//            System.out.println("ComputeEngine bound"); 
//        } catch (Exception e) { 
//            try { 
//               Thread.sleep(1000); 
//            } catch (InterruptedException e1) { 
//            } 
//            e.printStackTrace(); 
//           acharServidor(stub); 
//        } 
//    } 
//  
//	
//////	@Override
//////	public void conectar() throws RemoteException {
//////		throw new UnsupportedOperationException();
//////		
//////		
//////	}
//////
//////	@Override
//////	public void desconectar() throws RemoteException {
//////		throw new UnsupportedOperationException("Nao suporta ainda");		
//////	}
//////
//////	@Override
//////	public void mensagem(String msg) throws RemoteException {
//////		throw new UnsupportedOperationException("Nao suporta ainda");		
//////	}
//////
//////	@Override
//////	public void criarJogo() throws RemoteException {
//////		// TODO Auto-generated method stub
//////		
//////	}
//////
//////	@Override
//////	public void mexer() throws RemoteException {
//////		// TODO Auto-generated method stub
//////		
//////	}
//////
//////	@Override
//////	public void colocarBomba() throws RemoteException {
//////		// TODO Auto-generated method stub
//////		
//////	}
//////
//////	@Override
//////	public void upgrade() throws RemoteException {
//////		// TODO Auto-generated method stub
//////		
//////	}
//////	
//////
//////}

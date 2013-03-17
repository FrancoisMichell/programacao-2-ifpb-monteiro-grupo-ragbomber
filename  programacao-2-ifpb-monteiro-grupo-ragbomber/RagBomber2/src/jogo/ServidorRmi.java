package jogo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import jogo.Bomba;


public class ServidorRmi  implements IFServidorRmi{
	
	private Personagem personagem;
	private Bomba bomba;
	private Upgrade upgrade;
	private BlocoDestrutivel bloco;
	

	
	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}

	public void setUpgrade(Upgrade upgrade) {
		this.upgrade = upgrade;
	}

	public void setBloco(BlocoDestrutivel bloco) {
		this.bloco = bloco;
	}

	public ServidorRmi() {
		try {
			ServidorRmi obj = new ServidorRmi();
			Naming.rebind("rmi://localhost:1099/ServidorRmi", obj);
		}
		catch (Exception e){
			System.out.println(" Erro " + e);
		}
	}

	@Override
	public void conectar() throws RemoteException {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void desconectar() throws RemoteException {
		throw new UnsupportedOperationException("Nao suporta ainda");		
	}

	@Override
	public void mensagem(String msg) throws RemoteException {
		throw new UnsupportedOperationException("Nao suporta ainda");		
	}

	@Override
	public void criarJogo() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mexer() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colocarBomba() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upgrade() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

}

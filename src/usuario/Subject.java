package usuario;

public interface Subject {
	public void registraObservador(Observer o);
	public void removerObservador(Observer o);
	public void notificarObservadores();
}

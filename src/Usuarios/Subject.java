package Usuarios;

public interface Subject {
	public void addObservador(Observer o);

	public void removerObservador(Observer o);

	public void notificarObservadores();
}

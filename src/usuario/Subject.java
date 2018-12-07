package usuario;

public interface Subject {
	public void addObserver(Observer o);

	public void removerObserver(Observer o);

	public void notificarObservers();
}

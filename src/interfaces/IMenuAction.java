package interfaces;

public interface IMenuAction<T> {

    abstract void printHeader(String menuName);

    abstract void printBody(T value);
}

package exeption;

public class ToDoListNotFoundExeption extends RuntimeException{
    public ToDoListNotFoundExeption(String message){
        super(message);
    }
}

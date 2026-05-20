package Exception;

public class LexicalException extends Exception
{
    public LexicalException(String mensage)
    {
        super("El token '" + mensage + "' es inválido");
    }
}

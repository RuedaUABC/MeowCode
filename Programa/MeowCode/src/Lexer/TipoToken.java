package Lexer;

public class TipoToken 
{
    private String nombre;
    private String patron;

    public TipoToken(String nombre, String patron)
    {
        this.nombre = nombre;
        this.patron = patron;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getPatron()
    {
        return patron;
    }

    /* --- Tipos de token de MeowCode --- */
    public static String MAIN = "MAIN";
    // Delimitadores
    public static String LLAVEIZQ = "LLAVEIZQ";
    public static String LLAVEDER = "LLAVEDER";
    public static String PARENTESISIZQ = "PARENTESISIZQ";
    public static String PARENTESISDER = "PARENTESISDER";
    public static String CORCHETEIZQ = "CORCHETEIZQ";
    public static String CORCHETEDER = "CORCHETEDER";
    // Tipos de datos
    public static String TIPODATO = "TIPODATO";
    // Operadores aritméticos
    public static String OPARITMETICO = "OPARITMETICO";
    // Operadores aritméticos compuestos
    public static String OPARITMETICOCOMP = "OPARITMETICOCOMP";
    // Incremento y decremento
    public static String INCREMENTO = "INCREMENTO";
    public static String DECREMENTO = "DECREMENTO";
    // Separadores
    public static String PUNTOYCOMA = "PUNTOYCOMA";
    public static String DOSPUNTOS = "DOSPUNTOS";
    public static String COMA = "COMA";
    public static String COMILLA = "COMILLA";
    public static String DOBLECOMILLA = "DOBLECOMILLA";
    public static String ESPACIO = "ESPACIO";
    // Estructuras de control de programa
    public static String FOR = "FOR";
    public static String WHILE = "WHILE";
    public static String IF = "IF";
    public static String ELSE = "ELSE";
    public static String ELSEIF = "ELSEIF";
    public static String RETURN = "RETURN";
    public static String BREAK = "BREAK";
    public static String CONTINUE = "CONTINUE";
    // Entrada y salida
    public static String INPUT = "INPUT";
    public static String PRINT = "PRINT";
    // Operadores lógicos
    public static String AND = "AND";
    public static String OR = "OR";
    // Operadores relacionales
    public static String IGUAL = "meew";
    public static String OPRELACIONAL = "OPRELACIONAL";
    // Comentarios
    public static String COMENTARIO = "COMENTARIO";
    // Hola mundo!
    public static String HOLAMUNDO = "HOLAMUNDO";
    // Variables
    public static String VARIABLE = "VARIABLE";
    public static String FLOTANTE = "FLOTANTE";
    public static String ENTERO = "ENTERO";
    public static String CARACTER = "CARACTER";
    public static String CADENA = "CADENA";
    // Error
    public static String ERROR = "ERROR";

}

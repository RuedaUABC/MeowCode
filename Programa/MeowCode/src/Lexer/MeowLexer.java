package Lexer;

import Exception.LexicalException;
import java.util.ArrayList;
import java.util.regex.*;

public class MeowLexer
{
    private ArrayList<TipoToken> tipos = new ArrayList<>();
    private ArrayList<Token> tokens = new ArrayList<>();
    
    public MeowLexer()
    {
        // Espacios en blanco
        tipos.add(new TipoToken(TipoToken.ESPACIO, "[ \\t\\f\\r\\n]+"));

        // Hola mundo!
        tipos.add(new TipoToken(TipoToken.HOLAMUNDO, "HelloWorld\\!\\(\\\"print\\\"\\);"));

        // Estructuras de control de programa
        tipos.add(new TipoToken(TipoToken.ELSEIF, "mmeowwmewmew"));
        tipos.add(new TipoToken(TipoToken.RETURN, "mmeeooww"));
        tipos.add(new TipoToken(TipoToken.FOR, "meowmeow"));
        tipos.add(new TipoToken(TipoToken.WHILE, "meowwoem"));
        tipos.add(new TipoToken(TipoToken.ELSE, "mmeoww"));
        tipos.add(new TipoToken(TipoToken.IF, "mewmew"));
        tipos.add(new TipoToken(TipoToken.BREAK, "mww"));
        tipos.add(new TipoToken(TipoToken.CONTINUE, "mmw"));
        
        // Entrada y salida
        tipos.add(new TipoToken(TipoToken.INPUT, "meeeoow"));
        tipos.add(new TipoToken(TipoToken.PRINT, "meeeow"));
        
        // Tipos de datos
        tipos.add(new TipoToken(TipoToken.TIPODATO, "meooooow|meoooow|meooow|mew"));
        
        // Delimitadores
        tipos.add(new TipoToken(TipoToken.CORCHETEDER, "meowww"));
        tipos.add(new TipoToken(TipoToken.CORCHETEIZQ, "mmmeow"));
        tipos.add(new TipoToken(TipoToken.LLAVEDER, "meoww"));
        tipos.add(new TipoToken(TipoToken.LLAVEIZQ, "mmeow"));
        tipos.add(new TipoToken(TipoToken.PARENTESISDER, "meoow"));
        tipos.add(new TipoToken(TipoToken.PARENTESISIZQ, "meeow"));
        
        // Operadores relacionales
        tipos.add(new TipoToken(TipoToken.OPRELACIONAL, "mmmmeowmeew|meowwwwmeew|meewmeew|meemeew|mmmmeow|meowwww"));
        tipos.add(new TipoToken(TipoToken.IGUAL, "meew"));
        
        // Operadores lógicos
        tipos.add(new TipoToken(TipoToken.AND, "meooww"));
        tipos.add(new TipoToken(TipoToken.OR, "mmeeow"));
        
        // Main
        tipos.add(new TipoToken(TipoToken.MAIN, "meow"));
        
        // Operadores aritméticos compuestos
        tipos.add(new TipoToken(TipoToken.OPARITMETICOCOMP, "mooooooowmeew|moooooowmeew|mooooowmeew|moooowmeew|mooowmeew|moowmeew"));
        
        // Incrementos y decrementos
        tipos.add(new TipoToken(TipoToken.DECREMENTO, "mooowmooow"));
        tipos.add(new TipoToken(TipoToken.INCREMENTO, "moowmoow"));
        
        // Operadotes aritméticos
        tipos.add(new TipoToken(TipoToken.OPARITMETICO, "mooooooow|moooooow|mooooow|moooow|mooow|moow"));
        
        // Cadenas
        tipos.add(new TipoToken(TipoToken.CADENA, "meomeo.*?meomeo"));
        
        // Cualquier carácter individual
        tipos.add(new TipoToken(TipoToken.CARACTER, "meo.*?meo"));

        // Separadores
        tipos.add(new TipoToken(TipoToken.DOBLECOMILLA, "meomeo"));
        tipos.add(new TipoToken(TipoToken.COMILLA, "meo"));
        tipos.add(new TipoToken(TipoToken.DOSPUNTOS, "mow"));
        tipos.add(new TipoToken(TipoToken.PUNTOYCOMA, "mw"));
        tipos.add(new TipoToken(TipoToken.COMA, "m"));
        
        // Numeros enteros y flotantes
        tipos.add(new TipoToken(TipoToken.FLOTANTE, "[+-]?[0-9]+\\.[0-9]+"));
        tipos.add(new TipoToken(TipoToken.ENTERO, "[+-]?[0-9]+"));
        
        // Variable
        tipos.add(new TipoToken(TipoToken.VARIABLE, "[a-zA-Z][a-zA-Z0-9_]*"));

        // Error
        tipos.add(new TipoToken(TipoToken.ERROR, "[^ \\t\\f\\n]"));
    }

    public ArrayList<Token> getTokens()
    {
        return tokens;
    }

    public void analizar(String entrada) throws LexicalException
    {
        StringBuffer er = new StringBuffer();

        for(TipoToken tt : tipos)
        {
            er.append(String.format("|(?<%s>%s)", tt.getNombre(), tt.getPatron()));
        }

        Pattern p = Pattern.compile(new String(er.substring(1)), Pattern.DOTALL);
        Matcher m = p.matcher(entrada);

        while(m.find())
        {
            if(m.group(TipoToken.ESPACIO) != null)
            {
                continue;
            }

            for(TipoToken tt: tipos)
            {
                if(m.group(tt.getNombre()) != null)
                {
                    if(tt.getNombre().equals(TipoToken.ERROR))
                    {
                        LexicalException ex = new LexicalException(m.group(tt.getNombre()));
                        throw ex;
                    }

                    String nombre = m.group(tt.getNombre());

                    if(tt.getNombre().equals(TipoToken.CADENA))
                    {
                        nombre = nombre.substring(1, nombre.length()-1);
                    }
                    tokens.add(new Token(tt, nombre));
                    break;
                }
            }
        }
    }
}
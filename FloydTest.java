import org.junit.Assert;

import static org.junit.Assert.assertEquals;

import java.util.Formattable;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Scanner;
import java.util.regex.MatchResult;


public class FloydTest {
    Reader read = new Reader();
    Floyd F= new Floyd();
    
    @org.junit.Test  
    public void cambio() {
        String [][] Matriz = read.Reader("guategrafo.txt");
        Matriz=F.cambio(Matriz,1,4,"2");
        assertEquals("2",Matriz[2][4]);
    }

    @org.junit.Test
    public void PruebaFloyd() {
        String [][] Matriz = read.Reader("guategrafo.txt");
        System.out.println("");
        Matriz=F.recarcular(Matriz);
        assertEquals("30",Matriz[1][2]);
    }
}
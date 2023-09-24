package spielfeldTest;

import spielfeld.Spielfeld;
import validieren.Validiere;
import org.junit.Assert;
import org.junit.Test;

public class SpielfeldTest {

    @Test
    public void testGetBoard(){
        System.out.println("TEST testGetBoard");
        char[][] board = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
        Spielfeld spielfeld = new Spielfeld();
        Assert.assertNotNull(spielfeld.getBoard());
        Assert.assertArrayEquals(spielfeld.getBoard(), board);
    }

    @Test
    public void testSetBoard(){
        System.out.println("TEST setBoard");
        char[][] board = {
                {'X', '2', '3'},
                {'4', 'O', '6'},
                {'7', '8', '9'}
        };
        Spielfeld spielfeld = new Spielfeld();
        spielfeld.setBoard(1, 'X');
        spielfeld.setBoard(5, 'O');
        Assert.assertArrayEquals(spielfeld.getBoard(), board);
    }

    @Test
    public void testIstUnentschieden(){
        System.out.println("TEST istUnentschieden");
        Spielfeld spielfeld = new Spielfeld();
        Assert.assertFalse(spielfeld.istUnentschieden());
        spielfeld.setBoard(5, 'X');
        spielfeld.setBoard(1, 'O');
        spielfeld.setBoard(3, 'X');
        spielfeld.setBoard(8, 'O');
        spielfeld.setBoard(2, 'X');
        spielfeld.setBoard(7, 'O');
        spielfeld.setBoard(4, 'X');
        spielfeld.setBoard(6, 'O');
        spielfeld.setBoard(9, 'X');
        spielfeld.setAnzahlZuege(9);
        System.out.println(spielfeld);
        Assert.assertTrue(spielfeld.istUnentschieden());
    }

    @Test
    public void testIstGewonnenX(){
        System.out.println("TEST istGewonnen X");
        Spielfeld spielfeld = new Spielfeld();
        Assert.assertFalse(spielfeld.istGewonnen());
        spielfeld.setBoard(1, 'X');
        spielfeld.setBoard(2, 'X');
        spielfeld.setBoard(3, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(4, 'X');
        spielfeld.setBoard(5, 'X');
        spielfeld.setBoard(6, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(7, 'X');
        spielfeld.setBoard(8, 'X');
        spielfeld.setBoard(9, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(1, 'X');
        spielfeld.setBoard(4, 'X');
        spielfeld.setBoard(7, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(2, 'X');
        spielfeld.setBoard(5, 'X');
        spielfeld.setBoard(8, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(3, 'X');
        spielfeld.setBoard(6, 'X');
        spielfeld.setBoard(9, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(1, 'X');
        spielfeld.setBoard(5, 'X');
        spielfeld.setBoard(9, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(3, 'X');
        spielfeld.setBoard(5, 'X');
        spielfeld.setBoard(7, 'X');
        Assert.assertTrue(spielfeld.istGewonnen());
    }

    @Test
    public void testIstGewonnenO(){
        System.out.println("TEST istGewonnen O");
        Spielfeld spielfeld = new Spielfeld();
        Assert.assertFalse(spielfeld.istGewonnen());
        spielfeld.setBoard(1, 'O');
        spielfeld.setBoard(2, 'O');
        spielfeld.setBoard(3, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(4, 'O');
        spielfeld.setBoard(5, 'O');
        spielfeld.setBoard(6, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(7, 'O');
        spielfeld.setBoard(8, 'O');
        spielfeld.setBoard(9, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(1, 'O');
        spielfeld.setBoard(4, 'O');
        spielfeld.setBoard(7, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(2, 'O');
        spielfeld.setBoard(5, 'O');
        spielfeld.setBoard(8, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(3, 'O');
        spielfeld.setBoard(6, 'O');
        spielfeld.setBoard(9, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(1, 'O');
        spielfeld.setBoard(5, 'O');
        spielfeld.setBoard(9, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
        spielfeld = new Spielfeld();
        spielfeld.setBoard(3, 'O');
        spielfeld.setBoard(5, 'O');
        spielfeld.setBoard(7, 'O');
        Assert.assertTrue(spielfeld.istGewonnen());
    }
}

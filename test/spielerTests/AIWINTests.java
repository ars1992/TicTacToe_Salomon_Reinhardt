package spielerTests;
import spielfeld.Spielfeld;
import spieler.AIWin;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AIWINTests {

    //Erkenntniss: Testmethoden für die Spieler sind in diesem Fall, in keinem Fall möglich.

    @Test
    public void testMacheZug(){
        System.out.println("Testversuch des Menschspielers,der einen Zug zu machen will:");
        AIWin kalkulator = new AIWin("Yury", 'X');

        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int zug = kalkulator.zugMachen();

        assertEquals(10, zug);

        String consoleOutput = outputStream.toString().trim();
        assertFalse(consoleOutput.contains("Ungültige eingabe!"));

    }
}

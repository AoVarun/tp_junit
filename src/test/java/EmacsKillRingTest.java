import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmacsKillRingTest {
    private TextBuffer textBuffer;

    @Test
    public void EmacsKillRingTesttoString() throws EmacsKillRingOverflowException{
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        emacsKillRing.add("Test_ok1");
        emacsKillRing.add("Test_ok2");

        // Assert
        Assertions.assertEquals("[Test_ok2, Test_ok1]",emacsKillRing.toString());
    }

    @Test
    public void EmacsKillRingTestRotate() throws EmacsKillRingOverflowException{
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        emacsKillRing.add("Test_ok1");
        emacsKillRing.add("Test_ok2");

        // Assert

        Assertions.assertEquals("Test_ok2",emacsKillRing.currentElt());
        emacsKillRing.rotateFwd();
        Assertions.assertEquals("Test_ok1",emacsKillRing.currentElt());


    }

    // Exemple test prof
    @Test
    public void should_throw_emackskillringoverflowexception_when_buffer_full() {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();

        // Act
        try {
            for (int i = 0; i < emacsKillRing.MAX; i++) {
                emacsKillRing.add("test");
            }
        } catch (EmacsKillRingOverflowException e) {
            Assertions.fail();
        }

        // Assert
        Assertions.assertThrows(EmacsKillRingOverflowException.class, () -> {
            emacsKillRing.add("test");
        });
    }


}

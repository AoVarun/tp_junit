import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TextEditorTest {

    @Mock
    public TextBuffer textBuffer;
    @Mock
    public EmacsKillRing emacsKillRing;

    @Test
    public void testYankPop() throws IllegalAccessException, EmacsKillRingOverflowException {
            TextEditor text = new TextEditor("test");
            text.setMark(0);
            text.setCursor(0);
            text.yank();
            Mockito.when(emacsKillRing.currentElt()).thenReturn("test");

    }

    @Test
    public void testYank() throws IllegalAccessException, EmacsKillRingOverflowException{
        TextEditor textEditor = new TextEditor("Test");


    }



}

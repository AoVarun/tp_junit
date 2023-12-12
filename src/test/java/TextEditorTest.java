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
        Mockito.when(emacsKillRing.currentElt()).thenReturn("Le test");
        Mockito.when(textBuffer.maxP()).thenReturn(100);

        textEditor.yank();
        Mockito.verify(emacsKillRing, Mockito.times(1)).currentElt();
    }

    @Test
    public void testYankPopAfter() throws IllegalAccessException, EmacsKillRingOverflowException{
        TextEditor textEditor = new TextEditor("test");
        textEditor.setMark(0);
        textEditor.setCursor(5);
        Mockito.when(emacsKillRing.currentElt()).thenReturn("test");

        textEditor.yank();
        textEditor.yankPop();

        Mockito.verify(emacsKillRing,Mockito.times(1)).rotateFwd();
    }



}

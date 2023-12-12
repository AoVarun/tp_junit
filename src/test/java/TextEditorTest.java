import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import static org.mockito.Mockito.*;

public class TextEditorTest {

    @Test
    public void testYankPop() throws IllegalAccessException, EmacsKillRingOverflowException {
            EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);

            TextEditor text = new TextEditor("test");
            text.setMark(0);
            text.setCursor(5);
            text.emacsKillRing = mockEmacsKillRing;

            text.yank();
            when(mockEmacsKillRing.currentElt()).thenReturn("test");

            text.emacsKillRing = mockEmacsKillRing;

            text.yankPop();

            verify(mockEmacsKillRing,times(1)).rotateFwd();

    }

    @Test
    public void testYank() throws IllegalAccessException, EmacsKillRingOverflowException{
        EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);
        TextBuffer mockTextBuffer = mock(TextBuffer.class);


        TextEditor textEditor = new TextEditor("Test");
        when(mockEmacsKillRing.currentElt()).thenReturn("Le test");
        when(mockTextBuffer.maxP()).thenReturn(100);

        textEditor.yank();
        verify(mockEmacsKillRing, times(1)).currentElt();
    }

    @Test
    public void testYankPopAfter() throws IllegalAccessException, EmacsKillRingOverflowException{
        TextEditor textEditor = new TextEditor("test");
        textEditor.setMark(0);
        textEditor.setCursor(5);
        when(emacsKillRing.currentElt()).thenReturn("test");

        textEditor.yank();
        textEditor.yankPop();

        verify(emacsKillRing, times(1)).rotateFwd();
    }



}

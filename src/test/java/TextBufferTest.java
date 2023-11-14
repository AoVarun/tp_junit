import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class TextBufferTest {
    @Test
    public void TextBufferTestToString(){
        TextBuffer bu = new TextBuffer("test_ok");
        String bu_string = bu.toString();

        String expectedText = "test_ok";

        Assertions.assertEquals(expectedText,bu_string);
    }

    @Test
    public void TextBufferTestMaxP(){
        TextBuffer bu = new TextBuffer("jem'appellehenryjevoudraisbienreussirmavie");
        int bu_maxP = bu.maxP();

        int expectInt = bu.toString().length();

        Assertions.assertEquals(expectInt,bu_maxP);

    }

}

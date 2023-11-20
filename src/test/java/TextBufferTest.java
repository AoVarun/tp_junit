import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TextBufferTest {

    /**
     * 
     */
    @Test
    public void TextBufferTestIns(){
        TextBuffer textBuffer = new TextBuffer("Test");
        
        // Valide 
        textBuffer.ins("_ok",4);
        assertThat(textBuffer.toString(),is("Test_ok"));

        // Invalide 
        textBuffer.ins("bonjour",16);
        assertThat(textBuffer.toString(),is("Test_ok"));
        

    }

    @Test
    public void TextBufferTestDel(){
        TextBuffer textBuffer = new TextBuffer("Test_ok");
        
        // Valide 
        assertThat(textBuffer.toString(),is("Test"));

        // Invalide 
        textBuffer.del(-18,16);
        assertThat(textBuffer.toString(),is("Test_ok"));
        

    }

    @Test
    public void TextBufferTestSubstr(){
        TextBuffer textBuffer = new TextBuffer("Test_ok");
        
        // Valide 
        assertThat(textBuffer.substr(0,4),is("Test"));

        // Invalide 
        assertThat(textBuffer.substr(-2,15),is("Test_ok"));
        
    }

    @Test
    public void TextBufferTestMaxP(){
        TextBuffer textBuffer = new TextBuffer("Test_ok");
        
        // Valide 
        assertThat(textBuffer.maxP(),is(7));

    }

    @Test
    public void TextBufferTestToString(){
        TextBuffer bu = new TextBuffer("test_ok");
        String bu_string = bu.toString();

        String expectedText = "test_ok";

        Assertions.assertEquals(expectedText,bu_string);
    }

    

}

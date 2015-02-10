package lang.tests;

/**
 * Created by Nik on 10-2-15.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class LexerTest {
    @Test
    public void testTokens() {
        String str= "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
}

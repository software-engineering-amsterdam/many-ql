package nl.uva.softwcons.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void testUnquoteWithUnquotedString() {
        String notQuoted = "South Park";
        assertThat(Utils.unquote(notQuoted)).isEqualTo(notQuoted);
    }

    @Test
    public void testUnquoteWithPartiallyDoubleQuotedString() {
        String partiallyQuoted = "South Park\"";
        String partiallyQuoted2 = "\"Family Guy";
        assertThat(Utils.unquote(partiallyQuoted)).isEqualTo(partiallyQuoted);
        assertThat(Utils.unquote(partiallyQuoted2)).isEqualTo(partiallyQuoted2);
    }

    @Test
    public void testUnquoteWithPartiallySingleQuotedString() {
        String partiallyQuoted = "Star Wars'";
        String partiallyQuoted2 = "'Star Trek";
        assertThat(Utils.unquote(partiallyQuoted)).isEqualTo(partiallyQuoted);
        assertThat(Utils.unquote(partiallyQuoted2)).isEqualTo(partiallyQuoted2);
    }

    @Test
    public void testUnquoteWithSingleQuotedString() {
        String quoted = "'Star Wars'";
        assertThat(Utils.unquote(quoted)).isEqualTo("Star Wars");
    }

    @Test
    public void testUnquoteWithDoubleQuotedString() {
        String quoted = "\"Star Wars\"";
        assertThat(Utils.unquote(quoted)).isEqualTo("Star Wars");
    }

    @Test
    public void remotesOnlyFirstPairOfQuotes() {
        String tooQuoted = "\"\"Star Wars\"\"";
        String tooQuoted2 = "''Star Wars''";
        assertThat(Utils.unquote(tooQuoted)).isEqualTo("\"Star Wars\"");
        assertThat(Utils.unquote(tooQuoted2)).isEqualTo("'Star Wars'");
    }

}

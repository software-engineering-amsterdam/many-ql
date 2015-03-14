package test.kls.logic;

import com.kls.logic.properties.FontColor;
import com.kls.logic.properties.FontSize;
import com.kls.logic.style.AStyle;
import com.kls.logic.properties.AProperty;
import com.kls.logic.properties.FontFamily;
import com.kls.logic.style.PageStyle;
import com.kls.logic.style.QuestionStyle;
import com.kls.logic.style.SectionStyle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Juriaan on 14-3-2015.
 */
public class AStyleTest {
    private QuestionStyle qStyle;
    private SectionStyle sStyle;
    private PageStyle pStyle;


    @Before
    public void setUp() throws Exception {
        qStyle = new QuestionStyle();
        sStyle = new SectionStyle();
        pStyle = new PageStyle();
    }

    @Test
    public void testToCSS() throws Exception {
        AProperty prop = new FontFamily("Arial");
        AStyle style = new QuestionStyle();
        style.addProperty(prop);

        assertEquals("font-family: Arial;", style.toCSS());
    }

    @Test
    public void testMerge1() throws Exception {
        AProperty font = new FontFamily("Arial");
        AProperty size = new FontSize(12);

        qStyle.addProperty(size);
        sStyle.addProperty(font);

        qStyle.merge(sStyle);
        assertEquals("font-size: 12;font-family: Arial;", qStyle.toCSS());
    }

    @Test
    public void testMerge2() throws Exception {
        AProperty font1 = new FontFamily("Arial");
        AProperty font2 = new FontFamily("Helvetica");

        qStyle.addProperty(font1);
        sStyle.addProperty(font2);

        qStyle.merge(sStyle);
        assertEquals("font-family: Arial;", qStyle.toCSS());
    }

    @Test
    public void testMerge3() throws Exception {
        AProperty font1 = new FontFamily("Arial");
        AProperty font2 = new FontFamily("Helvetica");

        sStyle.addProperty(font1);
        pStyle.addProperty(font2);

        pStyle.merge(sStyle);
        assertEquals("font-family: Arial;", sStyle.toCSS());
    }

    @Test
    public void testMerge4() throws Exception {
        AProperty font1 = new FontFamily("Arial");
        AProperty font2 = new FontFamily("Helvetica");
        AProperty font3 = new FontFamily("Comic Sans");
        AProperty size = new FontSize(12);
        AProperty color = new FontColor("#000000");

        qStyle.addProperty(font1);
        sStyle.addProperty(font2);
        sStyle.addProperty(color);
        pStyle.addProperty(font3);
        pStyle.addProperty(size);

        qStyle.merge(sStyle);
        qStyle.merge(pStyle);

        assertEquals("font-family: Arial;", qStyle.getProperties().get("font-family").toCSS());
        assertEquals("font-size: 12;", qStyle.getProperties().get("font-size").toCSS());
        assertEquals("color: #000000;", qStyle.getProperties().get("color").toCSS());

    }
}

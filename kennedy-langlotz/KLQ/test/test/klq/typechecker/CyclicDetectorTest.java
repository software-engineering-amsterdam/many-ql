package test.klq.typechecker;

import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.typechecker.CyclicDetector;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by juriaan on 9-3-15.
 */
public class CyclicDetectorTest {
    private CyclicDetector detector;

    @Before
    public void setUp() throws Exception {
        detector = new CyclicDetector();
    }
    @Test
    public void testCycleDetection() throws Exception {
        detector.addKey(new IdentifierNode("1"));
        detector.addKey(new IdentifierNode("2"));
        detector.addKey(new IdentifierNode("3"));

        detector.addDependency(new IdentifierNode("1"), new IdentifierNode("2"));
        detector.addDependency(new IdentifierNode("2"), new IdentifierNode("3"));

        detector.calculateFullDependencies();
        assertEquals(false, detector.hasCycles());

        detector.addDependency(new IdentifierNode("3"), new IdentifierNode("1"));
        detector.calculateFullDependencies();
        assertEquals(true, detector.hasCycles());
    }

    @Test
    public void testSelfReference() throws Exception {
        detector.addKey(new IdentifierNode("1"));
        detector.addDependency(new IdentifierNode("1"), new IdentifierNode("1"));
        detector.calculateFullDependencies();

        assertEquals(true, detector.hasCycles());
    }
}

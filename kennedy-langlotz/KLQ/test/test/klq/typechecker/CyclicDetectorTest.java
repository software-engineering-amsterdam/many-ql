package test.klq.typechecker;

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
        detector.addKey("1");
        detector.addKey("2");
        detector.addKey("3");

        detector.addDependency("1", "2");
        detector.addDependency("2", "3");

        detector.calculateFullDependencies();
        assertEquals(false, detector.hasCycles());

        detector.addDependency("3", "1");
        detector.calculateFullDependencies();
        assertEquals(true, detector.hasCycles());
    }

    @Test
    public void testSelfReference() throws Exception {
        detector.addKey("1");
        detector.addDependency("1", "1");
        detector.calculateFullDependencies();

        assertEquals(true, detector.hasCycles());
    }
}

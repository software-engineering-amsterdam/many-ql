package test.klq.typechecker;

import com.klq.typecheker.CyclicDetector;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by juriaan on 9-3-15.
 */
public class CyclicDetectorTest {
    @Test
    public void testCycleDetection() throws Exception {
        CyclicDetector detector = new CyclicDetector();
        detector.addKey("1");
        detector.addKey("2");
        detector.addKey("3");

        detector.addDependency("1", "2");
        detector.addDependency("2", "3");

        assertEquals(false, detector.hasCycles());

        detector.addDependency("3", "1");
        assertEquals(true, detector.hasCycles());
    }
}

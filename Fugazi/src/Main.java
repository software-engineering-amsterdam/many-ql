import org.fugazi.ql.QLApplication;
import org.fugazi.qls.QLSApplication;

public class Main {
    
    public static void main(String[] args) throws Exception {

        if (args.length == 1) {
            QLApplication.run(args[0]);
        } else if (args.length > 1) {
            QLSApplication.run(args[0], args[1]);
        } else {
            System.out.println("Usage: java -jar Fugazi.jar qlfilename.ql [qlsfilename.qls]");
            System.exit(-1);
        }
    }
}
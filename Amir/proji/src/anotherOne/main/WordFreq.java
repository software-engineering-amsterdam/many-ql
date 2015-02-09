package anotherOne.main;
import java.io.FileInputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFreq {

    public static void main(String args[]) throws Exception {

  String filePath = "E:/tstst.txt";


  // Map File from filename to byte buffer

  FileInputStream in = new FileInputStream(filePath);

  FileChannel filech = in.getChannel();

  int fileLen = (int) filech.size();

  MappedByteBuffer buf = filech.map(FileChannel.MapMode.READ_ONLY, 0,


    fileLen);


  // Convert to character buffer

  Charset chars = Charset.forName("ISO-8859-1");

  CharsetDecoder dec = chars.newDecoder();

  CharBuffer charBuf = dec.decode(buf);


  // Create line pattern

  Pattern linePatt = Pattern.compile(".*$", Pattern.MULTILINE);


  // Create word pattern

  Pattern wordBrkPatt = Pattern.compile("[p{Punct}s}]");


  // Match line pattern to buffer

  Matcher lineM = linePatt.matcher(charBuf);


  Map m = new TreeMap();

  Integer one = new Integer(1);


  // For each line

  while (lineM.find()) {


// Get line


CharSequence lineSeq = lineM.group();



// Get array of words on line


String words[] = wordBrkPatt.split(lineSeq);



// For each word


for (int i = 0, n = words.length; i < n; i++) {


    if (words[i].length() > 0) {



  Integer frequency = (Integer) m.get(words[i]);



  if (frequency == null) {




frequency = one;



  } else {




int value = frequency.intValue();




frequency = new Integer(value + 1);



  }



  m.put(words[i], frequency);


    }


}

  }

  System.out.println(m);
    }
}

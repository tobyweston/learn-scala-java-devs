
package s4j.java.chapter12;

import java.io.File;
import java.io.IOException;
import java.lang.Readable;
import java.nio.CharBuffer;

public class FileReader implements Readable, AutoCloseable {

    private final File file;

    public FileReader(File file) {
        this.file = file;
    }

    @Override
    public int read(CharBuffer buffer) {
        int read = 0;
        // ...
        return read;
    }

    @Override
    public void close() {
        // close
    }

    public static void main(String... args) throws IOException {
        try (FileReader reader = new FileReader(new File("autoexec.bat"))) {
            System.out.println(reader.read(CharBuffer.allocate(100)));
        }
     }

}


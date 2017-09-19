
/*
 * Copyright (c) 2015-2017 Toby Weston
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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


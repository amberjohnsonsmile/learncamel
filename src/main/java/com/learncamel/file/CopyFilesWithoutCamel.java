package com.learncamel.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CopyFilesWithoutCamel {

    public static void main(String[] args) throws IOException {

        // Create an object to read the directories
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        // Read the files from the directory
        File[] files = inputDirectory.listFiles();

        // Create the output directory and write the files
        for (File source : files) {
            if (source.isFile()) {
                File dest = new File(outputDirectory.getPath() + File.separator + source.getName());

                OutputStream oStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) source.length()];
                FileInputStream iStream = new FileInputStream(source);
                iStream.read(buffer);

                try {
                    oStream.write(buffer);
                } finally {
                    // Close the streams
                    oStream.close();
                    iStream.close();
                }
            }
        }
    }
}

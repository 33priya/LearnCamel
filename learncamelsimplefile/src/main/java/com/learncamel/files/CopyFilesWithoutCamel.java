package com.learncamel.files;

import java.io.*;

public class CopyFilesWithoutCamel {

    public static void main(String[] args) throws IOException {
        File inputFileDir = new File("data/input");
        File outputFileDir = new File("data/output");

        File[] files = inputFileDir.listFiles();
        for (File source : files) {
            if (source.isFile()) {
                File dest = new File(
                        outputFileDir.getPath()
                                + File.separator
                                + source.getName());

                OutputStream outputStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) source.length()];
                InputStream inputStream = new FileInputStream(source);
                inputStream.read(buffer);
                try {
                    outputStream.write(buffer);
                } finally {
                    outputStream.close();
                    inputStream.close();
                }
            }
        }
    }
}

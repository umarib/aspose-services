package com.aspose.ws;

import java.net.URI;

import com.aspose.words.Document;

public class Program {

	public static void main(String[] args) throws Exception
    {
        // Sample infrastructure.
        URI exeDir = Program.class.getResource("").toURI();
        String dataDir = "E:/AsposeTest/";

        // The encoding of the text file is automatically detected.
        Document doc = new Document(dataDir+"LoadTxt.txt");

        // Save as any Aspose.Words supported format, such as DOCX.
        doc.save(dataDir + "LoadTxt-Out.docx");
    }
	
	
}

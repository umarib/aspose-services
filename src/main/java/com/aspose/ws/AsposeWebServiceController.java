package com.aspose.ws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import com.aspose.words.Document;
import com.aspose.words.ProtectionType;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/")
public class AsposeWebServiceController {

	String dataDir = "E:/AsposeTest/";
	String inputfileName = "input-file.txt";
	String outputfileName = "output-file.docx";

	String result = "";

	@POST
	@Path("/words/{protection_name}/protection")
	@Produces(MediaType.TEXT_PLAIN)
	public Response postProtectionService(
			@PathParam("protection_name") int protectionType) {
		System.out.println(protectionType);
		System.out.println(DataStore.convertedFile);
		System.out.println(DataStore.protectedFile);
		String returnFileName = "";
		try {
			if(DataStore.protectedFile!=null){
				returnFileName = addProtection(protectionType,DataStore.protectedFile);
			}else{
				returnFileName = addProtection(protectionType,DataStore.convertedFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(result + returnFileName).build();
	}

	@GET
	@Path("/words/{protection_name}/protection")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getProtectionService(
			@PathParam("protection_name") int protectionType) {
		System.out.println(protectionType);
		System.out.println(DataStore.convertedFile);
		String returnFileName = "";
		try {
			returnFileName = addProtection(protectionType,DataStore.convertedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(result + returnFileName).build();
	}

	@POST
	@Path("/words/convert")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
	public Response postConvertService(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String convertedFile = convertFileRequest(uploadedInputStream,
				fileDetail);
		ResponseBuilder response = Response.ok((Object) new File(dataDir
				+ convertedFile));
		response.header("Content-Disposition", "attachment; filename=\""
				+ convertedFile + " \"");
		return response.build();

	}

	private String convertFileRequest(InputStream uploadedInputStream,
			FormDataContentDisposition fileDetail) {
		String uploadedFileLocation = System.currentTimeMillis() + "-"
				+ fileDetail.getFileName();
		String convertedFile = "convertedFile-" + System.currentTimeMillis()
				+ ".docx";
		// save it
		writeToFile(uploadedInputStream, dataDir + uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation;
		try {
			this.convertTxtFileToDocument(dataDir + uploadedFileLocation,
					dataDir + convertedFile);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		DataStore.convertedFile = dataDir + convertedFile;
		return convertedFile;
	}
	
	@PUT
	@Path("/words/convert")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
	public Response putConvertService(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String convertedFile = convertFileRequest(uploadedInputStream,
				fileDetail);
		ResponseBuilder response = Response.ok((Object) new File(dataDir
				+ convertedFile));
		response.header("Content-Disposition", "attachment; filename=\""
				+ convertedFile + " \"");
		return response.build();

	}

	@GET
	@Path("/getfile/{fileName}")
	@Produces("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
	public Response getFile(@PathParam("fileName") String fileName){
		ResponseBuilder response = Response.ok((Object) new File(dataDir
				+ fileName));
		response.header("Content-Disposition", "attachment; filename=\""
				+ fileName + " \"");
		return response.build();
	}
	
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {
		try {
			FileUtils.copyToFile(uploadedInputStream, new File(
					uploadedFileLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void saveStringContentToFile(String content, File file)
			throws IOException {
		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.close();
	}

	private void convertTxtFileToDocument(String inPutFileName,
			String outPutFileName) throws Exception {
		Document doc = new Document(inPutFileName);
		// Save as any Aspose.Words supported format, such as DOCX.
		doc.save(outPutFileName);
	}
	
	private String addProtection(int protectionType,String inPutFileName) throws Exception {
		Document doc = new Document(inPutFileName);
		doc.protect(protectionType, DataStore.filePassword);
		String convertedFileNameWithoutExt = FilenameUtils.getBaseName(inPutFileName);
		String fullConvertedFile = dataDir+convertedFileNameWithoutExt+"-protected.docx";
		doc.save(fullConvertedFile);
		DataStore.protectedFile = fullConvertedFile;
		return convertedFileNameWithoutExt+"-protected.docx";
	}
}

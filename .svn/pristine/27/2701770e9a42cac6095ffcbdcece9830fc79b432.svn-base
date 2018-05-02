package us.tx.state.tea.seleniumfw.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtils {
	 public static PDDocument loadDoc(String filename) throws IOException{
	        File file = new File(filename);
	        PDDocument doc = PDDocument.load(file);
	        return doc;
	    }
	 
	    public static PDPage getPage(PDDocument pdDoc, int pgIndex) throws Exception {
	        PDPageTree pdPT = pdDoc.getPages();
	        return pdPT.get(pgIndex);
	    }
	    
	    public static String getText(PDDocument pdDoc) throws IOException {
	    	PDFTextStripper pdfStripper = new PDFTextStripper();        
	        String txtDoc = pdfStripper.getText(pdDoc);
	        return txtDoc;
	    }
	    
/*	    public void verifyPDFDownloaded(String filepath) throws Exception {
	    	ExecutorService executor = Executors.newSingleThreadExecutor();
	        Future<String> future = (Future<String>) executor.submit(new pdfTask());
	        try {
	            System.out.println("Started..");
	            System.out.println(future.get(60, TimeUnit.SECONDS));
	            System.out.println("Finished!");
	        } catch (TimeoutException e) {
	            future.cancel(true);
	            System.out.println("Terminated!");
	        }
	    }
	    
	    class pdfTask implements Callable<String> {
	    	@Override
		    public String call() throws Exception {
		    	File f2 = new File();
		        File[] pdflist = f2.listFiles(pdfFilter);
		        while (pdflist.length == 0){
		            pdflist = f2.listFiles(pdfFilter);
		        }
				return "Ready!";
		    }
		}
	    
	    FilenameFilter pdfFilter = new FilenameFilter() {
	        @Override
	        public boolean accept(File dir, String name) {
	        	String lowercaseName = name.toLowerCase();
	        	if (lowercaseName.endsWith(".pdf")) {
	        		return true;
	        	} else {
	        		return false;
	        	}
	        }
	    }; */
}

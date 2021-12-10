package com.iocl.dhruva2api.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class StringToByteUtility {

	public static byte[] convert(String htmlContent) throws DocumentException, IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] bytes = null;
		ITextRenderer renderer = new ITextRenderer();
		SharedContext sharedContext = renderer.getSharedContext();
		sharedContext.setPrint(true);

		sharedContext.setInteractive(false);
		sharedContext.setReplacedElementFactory(new B64ImgReplacedElementFactory());
		sharedContext.getTextRenderer().setSmoothingThreshold(0);
		try {
			renderer.setDocumentFromString(htmlContent.replace("&", "and"));
			renderer.layout();
			renderer.createPDF(byteArrayOutputStream);
			bytes = byteArrayOutputStream.toByteArray();
		} catch (Throwable e) {
			System.out.println("Error while generating pdf ${" + e.getMessage() + "}");
		}
		return bytes;
	}

}

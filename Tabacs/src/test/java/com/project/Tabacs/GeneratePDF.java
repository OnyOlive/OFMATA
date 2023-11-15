import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class GeneratePDF {

    public void generateInvoicePDF(String invoiceContent, String outputPath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();
            document.add(new Paragraph("Facture"));
            document.add(new Paragraph(invoiceContent));
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}

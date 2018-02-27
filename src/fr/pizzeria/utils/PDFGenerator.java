/**
 * 
 */
package fr.pizzeria.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fr.pizzeria.model.Pizza;

/**Classe permettant de créer un pdf
 * @author Alexis Darcy
 *
 */
public class PDFGenerator {

    /**Créer un pdf de la liste des pizzas
     * @param lesPizzas : List<Pizza>
     */
    public static void PDFCreator(List<Pizza> lesPizzas) {

        Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream(new File("..\\pizzeria\\pdf\\Menu.pdf")));

            document.open();
            for(Pizza p : lesPizzas){
            	document.add(new Paragraph(p.toString()));
            }
            document.close(); // no need to close PDFwriter?

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.itextpoc;
import com.mycompany.itextpoc.Estilos.Textos.pValor;
import com.mycompany.itextpoc.Estilos.Textos.pEtiqueta;
import com.itextpdf.layout.element.Image;
import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.forms.*;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;
import oracle.jrockit.jfr.parser.ChunkParser;

/**
 *
 * @author Dunjo
 */
public class OrdenesADistancia {

    //Ruta
    public static final String DEST = "C:\\iTextPOC\\";
    //Colores
    public static final com.itextpdf.kernel.colors.Color negro = new DeviceRgb(0, 0, 0);
    public static final com.itextpdf.kernel.colors.Color blanco = new DeviceRgb(255, 255, 255);
    public static final com.itextpdf.kernel.colors.Color verdeBM = new DeviceRgb(0, 119, 101);
    public static final com.itextpdf.kernel.colors.Color grisBM = new DeviceRgb(230, 230, 230);
    public static final com.itextpdf.kernel.colors.Color grisOscuroBM = new DeviceRgb(80, 80, 80);
 
    public static void main(String[] args) throws IOException {
        
        //Nombre fichero
        String nombreFichero = "Ordenes - " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()) + ".pdf";
        String ruta = DEST + nombreFichero;
        //Crear PDF
        long inicio = System.currentTimeMillis();
        File file = new File(ruta);
        file.getParentFile().mkdirs();
        new OrdenesADistancia().createPdf(ruta);
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println("Tiempo de ejecución:" + tiempo + " segundos");
        //Abrir PDF
        try{ Desktop.getDesktop().open(new File(DEST + nombreFichero));
        }catch (Exception e) { System.out.println(e); } 
    }
    
    public void createPdf(String dest) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        try (Document document = new Document(pdf)) {
            //Fuentes
            PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            
            //TITULO SUPERIOR
            Paragraph titulo = new Paragraph("INFORMACIÓN IMPORTANTE").setFontColor(verdeBM).setFontSize(20);
            Paragraph subtitulo = new Paragraph("A VALORAR ANTES DE CONTRATAR EL/LOS\n" + "SIGUIENTE/S INSTRUMENTO/S FINANCIERO/S").setFontColor(verdeBM).setFontSize(14);;
            Table tablaTitulo = new Table(2);
            tablaTitulo.addCell(new Cell(1,1).setHeight(30).setBorder(Border.NO_BORDER));
            tablaTitulo.addCell(new Cell(2,1).add(titulo).add(subtitulo).setBorder(Border.NO_BORDER));
            tablaTitulo.addCell(new Cell(1,1).add(new Image(ImageDataFactory.create("./src/Logo.JPG")).scaleToFit(175, 450)).setWidth(200).setBorder(Border.NO_BORDER));

            //DATOS ORDEN
            Paragraph cabeceraDatosOrden = new Paragraph("DATOS ORDEN").setFontColor(verdeBM).setFontSize(16);
            Table tablaDatosOrden = new Table(5, true);
            tablaDatosOrden.addCell(new Cell(1,5).add(cabeceraDatosOrden).setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(verdeBM, 1)));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pEtiqueta("Fecha de entrega")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pEtiqueta("Fecha límite aceptación")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pEtiqueta("Tipo de orden")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pEtiqueta("Canal de firma")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pEtiqueta("Nº Referencia")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pValor("15/01/2018 12:11")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pValor("22/01/2018 12:11")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pValor("ORDENES DE ESPAÑA")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pValor("PRESENCIAL")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pValor("01265427")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,2).add(new pEtiqueta("Titular")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pEtiqueta("Documento")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,2).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,2).add(new pValor("Juan Dunjó Arribas")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,1).add(new pValor("43208648C")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,2).setBorder(Border.NO_BORDER));
            
            tablaDatosOrden.addCell(new Cell(1,5).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,5).add(new pEtiqueta("Ordenantes").setFontSize(8).setFont(bold)).setBorder(Border.NO_BORDER).setBorderBottom(new SolidBorder(1)));
            Table tablaOrdenantes = new Table(5, true);
            tablaOrdenantes.addCell(new Cell(1,2).add(new pEtiqueta("Apellidos")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pEtiqueta("Nombre")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pEtiqueta("SIP")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pEtiqueta("Documento")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,2).add(new pValor("Massot Cristino")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("Ignacio")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("123456789")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("12345678C")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,2).add(new pValor("Dunjó Arribas")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("Juan")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("123456789")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("12345678C")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,2).add(new pValor("Casas Robichou")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("Javier")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("123456789")).setBorder(Border.NO_BORDER));
            tablaOrdenantes.addCell(new Cell(1,1).add(new pValor("12345678C")).setBorder(Border.NO_BORDER));
            tablaDatosOrden.addCell(new Cell(1,5).add(tablaOrdenantes).setBorder(Border.NO_BORDER));
            
            //ORDENES
            Table tablaOrdenes = new Table(5, true);
            tablaOrdenes.addCell(new Cell(1,5).add(new Paragraph("ÓRDENES").setFontColor(verdeBM).setFontSize(16)).setBorder(Border.NO_BORDER));
            /*for(int i = new Random().nextInt(50)+1; i>1; i--){
                tablaOrdenes.addCell(new Cell(1,5).add(new SuscripcionFondo().GeneraOrden()).setBorder(Border.NO_BORDER));
            }*/
            for(int i = 100; i>1; i--){
                tablaOrdenes.addCell(new Cell(1,5).add(new SuscripcionFondo().GeneraOrden()).setBorder(Border.NO_BORDER));
            }
            document.add(tablaTitulo);
            document.add(new Paragraph("\n"));
            document.add(tablaDatosOrden);
            document.add(new Paragraph("\n"));
            document.add(tablaOrdenes);           
        }
    }
        
        
        
    
    
}

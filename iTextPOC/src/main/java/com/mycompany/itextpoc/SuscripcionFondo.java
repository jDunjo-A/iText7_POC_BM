/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.itextpoc;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.mycompany.itextpoc.Estilos.Textos.pEtiqueta;
import com.mycompany.itextpoc.Estilos.Textos.pValor;
import java.io.IOException;

/**
 *
 * @author Dunjo
 */
public class SuscripcionFondo {

    com.itextpdf.kernel.colors.Color negro = new DeviceRgb(0, 0, 0);
    com.itextpdf.kernel.colors.Color blanco = new DeviceRgb(255, 255, 255);
    com.itextpdf.kernel.colors.Color verdeBM = new DeviceRgb(0, 119, 101);
    com.itextpdf.kernel.colors.Color grisBM = new DeviceRgb(230, 230, 230);
    com.itextpdf.kernel.colors.Color grisOscuroBM = new DeviceRgb(80, 80, 80);
    
    
    public SuscripcionFondo() {

    }
    
    public Table GeneraOrden() throws IOException{
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            
            //Suscripción fondo
            Table tablaSuscripcion = new Table(3, true).setBackgroundColor(grisBM);
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("001 - SUSCRIPCION FONDOS DE INVERSION").setFontSize(10)).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("I. Identificación del Instrumento Financiero").setFontSize(10).setFontColor(blanco)).setBackgroundColor(verdeBM).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Activo")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Gestora")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Tipo de producto")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("ES0110194000 – RENTA 4 ARGOS CAPITAL - ESPAÑOL INVESTMENT FI EUR")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("RENTA 4 GESTORA, S.G.I.I.C.S.")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("FONDO DE INVERSIÓN")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));

            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("II. Riesgos").setFontSize(10).setFontColor(blanco)).setBackgroundColor(verdeBM).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).add(new pEtiqueta("Información sobre el Riesgo del Producto")).setBorder(Border.NO_BORDER));
                Table tablaRiesgo = new Table(2);
                Text riesgoProducto = new Text("1").setFontSize(21).setFontColor(grisOscuroBM);
                Text totalRiesgoProducto = new Text("/6").setFontSize(21).setFont(bold);
                tablaRiesgo.addCell(new Cell(1,1).setWidth(40).setBorder(Border.NO_BORDER).add(new Paragraph().add(riesgoProducto).add(totalRiesgoProducto)));
                tablaRiesgo.addCell(new Cell(1,1).setBorder(Border.NO_BORDER).add(new pValor("Este número es indicativo del riesgo del producto, siendo 1/6 indicativo de menor riesgo y 6/6 de mayor riesgo.")));
            tablaSuscripcion.addCell(new Cell(1,2).add(tablaRiesgo).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).add(new pEtiqueta("Alerta Sobre Liquidez")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).add(new pValor("El reembolso, rescate o la devolución anticipada de una parte o de todo el principal invertido están sujetos a comisiones o penalizaciones")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).add(new pEtiqueta("Alerta sobre Complejidad")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).add(new pValor("Producto financiero no complejo")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("III. Datos esenciales de la Orden").setFontSize(10).setFontColor(blanco)).setBackgroundColor(verdeBM).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Contrato")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Servicio de Inversión")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Recomendación Inversión")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0061 – 0015 – 11 - 9114805800")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("ASESORAMIENTO")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0123456789")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("ISIN")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Denominación")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Gestora")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("ES0110194000")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("RENTA 4 ARGOS CAPITAL ESPAÑOL INVESTMENT FI EUR")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("RENTA 4 GESTORA, S.G.I.I.C,S")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Mercado")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Tipo Orden")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Tipo Restricción")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("FES")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("LIMITADA")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("SIN RESTRICCIONES")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Títulos")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Precio")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Importe Neto Estimado")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("1.000")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("63,75")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("650.000,00 USD")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("Incentivos").setFontSize(10)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Imp. Incentivo Institución Estimado")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Devolución Incentivo")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("108,23 USD")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("SÍ")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            
            tablaSuscripcion.addCell(new Cell(1,3).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("Comisiones y Gastos").setFontSize(10)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Concepto")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("%")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Importe")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Gestión")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0.25")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("3.750,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Distribución / Mto.")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0.00")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Depósito")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0.00")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Gest. por Resultados")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0.10")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("1.500,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Custodia")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0.00")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Suscripción Gestora")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("1.50")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("22.500,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Suscripción Distribuidor")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0.00")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("0,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            
            tablaSuscripcion.addCell(new Cell(1,3).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("Lista Incumplimientos Mercado Objetivos").setFontSize(10)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Categoría / Valor Distribuidor")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Valor cliente")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Mercado Pos/Neg")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Estrategia de Distribución / RTO de un minorista")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("Comercialización - MINORISTA")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("POSITIVO")).setBorder(Border.NO_BORDER));
            
            tablaSuscripcion.addCell(new Cell(1,3).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("Órdenes concatenadas").setFontSize(10)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Órden")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Activo")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Importe utilizado")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("001- REEMBOLSO FONDOS DE INVERSIÓN")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("ES011019400 - RENTA 4 GESTORA, S.G.I.I.C.S.")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("500.000,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("002- REEMBOLSO FONDOS DE INVERSIÓN")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("ES011019400 - RENTA 4 GESTORA, S.G.I.I.C.S.")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("500.000,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pEtiqueta("Total utilizado")).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,1).add(new pValor("1.000.000,00 USD").setTextAlignment(TextAlignment.RIGHT).setMarginRight(75)).setBorder(Border.NO_BORDER));     
            
            Table tablaDocPrecontractual = new Table(4, true);
            tablaDocPrecontractual.addCell(new Cell(1,4).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaDocPrecontractual.addCell(new Cell(1,4).add(new Paragraph("IV. Documentación Precontractual Adjunta a la Orden").setFontSize(10).setFontColor(blanco)).setBackgroundColor(verdeBM).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(new pEtiqueta("Tipo de Documento")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(new pEtiqueta("Fecha de Emisión")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,2).add(new pEtiqueta("Enlaces")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(new pValor("INF. INVERSOR")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(new pValor("01/10/2017")).setBorder(Border.NO_BORDER).setWidth(80));  
            tablaDocPrecontractual.addCell(new Cell(1,2).add(new pValor("https://www.meloinvento.com/DFI/ES0165445554")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(new pValor("INFORME SEMESTRAL")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(new pValor("01/10/2017")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,2).add(new pValor("https://www.meloinvento.com/DFI/ES0165445554")).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,4).setBorder(Border.NO_BORDER));
            BarcodeQRCode barcodeQRCode = new BarcodeQRCode("https://www.meloinvento.com/DFI/ES0165445554");
            Image imageQR = new Image(ImageDataFactory.create(barcodeQRCode.createAwtImage(java.awt.Color.BLACK, java.awt.Color.WHITE), java.awt.Color.yellow));
            tablaDocPrecontractual.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(imageQR.scaleAbsolute(75, 75)).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).add(imageQR.scaleAbsolute(75, 75)).setBorder(Border.NO_BORDER));
            tablaDocPrecontractual.addCell(new Cell(1,1).setBorder(Border.NO_BORDER));       
            tablaSuscripcion.addCell(new Cell(1,3).add(tablaDocPrecontractual).setBorder(Border.NO_BORDER));
            tablaSuscripcion.addCell(new Cell(1,3).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("Se estima que, del importe procedente de las operaciones arriba relacionadas, 1.000.000,00 USD podrán destinarse a la ejecución de esta orden, por lo que en el momento de su ejecución el cliente deberá disponer de un importe adicional aproximado a 670.000 USD en la cuenta de liquidación.").setFontSize(8)).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("Esta contratación proviene de una recomendación idónea de inversión. La idoneidad de la recomendación supone la ejecución total de la misma. La ejecución parcial de la recomendación podría implicar que la cartera resultante no se ajustara al perfil (si existe recomendación).").setFontSize(8)).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            tablaSuscripcion.addCell(new Cell(1,3).add(new Paragraph("Estimación de comisiones calculada sobre la hipótesis de que se permanezca en el fondo un año. El importe del incentivo estimado se ha calculado sobre una base trimestral.Los importes consignados como Importe Neto Aproximado, Comisiones y Gastos son una estimación. Dichos importes podrán diferir en función de las condiciones de ejecución de la presente orden.").setFontSize(8)).setBorder(Border.NO_BORDER).setBackgroundColor(blanco));
            return tablaSuscripcion;
    }
    
}

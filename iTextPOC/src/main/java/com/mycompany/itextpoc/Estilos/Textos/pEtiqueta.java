/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.itextpoc.Estilos.Textos;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;
import static com.mycompany.itextpoc.OrdenesADistancia.grisOscuroBM;
import java.io.IOException;

/**
 *
 * @author Dunjo
 */
public class pEtiqueta extends Paragraph {
        public pEtiqueta(String text) throws IOException {
            super(text);
            super.setFontSize(8);
            super.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
            super.setFontColor(grisOscuroBM);
        }   
    }

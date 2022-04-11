package com.curso.springboot.app.view.pdf;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ColorUIResource;

import com.curso.springboot.app.models.entity.Factura;
import com.curso.springboot.app.models.entity.FacturaDetalle;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;

@Component("/factura/ver")
public class FacturaPdfView extends AbstractPdfView {

  @Autowired
  private MessageSource messageSource;

  @Autowired
  private LocaleResolver localeResolver;

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    Locale locale = localeResolver.resolveLocale(request);

    MessageSourceAccessor mensajes = getMessageSourceAccessor();

    Factura factura = (Factura) model.get("factura");

    PdfPTable table = new PdfPTable(1);
    table.setSpacingAfter(20);

    PdfPCell cell = null;
    cell = new PdfPCell(new Phrase(messageSource.getMessage("text.factura.ver.datos.cliente", null, locale)));
    cell.setBackgroundColor(new ColorUIResource(184, 218, 255));
    cell.setPadding(8);
    table.addCell(cell);

    table.addCell(factura.getCliente().toString());
    table.addCell(factura.getCliente().getEmail());

    PdfPTable table2 = new PdfPTable(1);
    table2.setSpacingAfter(20);

    cell = new PdfPCell(new Phrase(messageSource.getMessage("text.factura.ver.titulo", null, locale)));
    cell.setBackgroundColor(new ColorUIResource(195, 230, 203));
    cell.setPadding(8);

    table2.addCell(cell);
    table2.addCell(mensajes.getMessage("text.cliente.factura.folio") + ": " + factura.getId());
    table2
        .addCell(mensajes.getMessage("text.cliente.factura.descripcion") + ": " + factura.getDescripcion());
    table2.addCell(mensajes.getMessage("text.cliente.factura.fecha") + ": " + factura.getCreatedAt());

    PdfPTable table3 = new PdfPTable(4);
    table3.setWidths(new float[] { 3.5f, 1, 1, 1 });
    table3.addCell(mensajes.getMessage("text.factura.form.buscar"));
    table3.addCell(mensajes.getMessage("text.factura.form.item.precio"));

    cell = new PdfPCell(new Phrase(mensajes.getMessage("text.factura.form.item.cantidad")));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

    table3.addCell(cell);
    table3.addCell("Total");

    for (FacturaDetalle un_detalle : factura.getDetalles()) {

      table3.addCell(un_detalle.getProducto().getNombre());
      table3.addCell(un_detalle.getProducto().getPrecio().toString());

      cell = new PdfPCell(new Phrase(un_detalle.getCantidad().toString()));
      cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

      table3.addCell(cell);
      table3.addCell(un_detalle.calcularImporte().toString());
    }

    cell = new PdfPCell(new Phrase(mensajes.getMessage("text.factura.form.item.total") + ": "));
    cell.setColspan(3);
    cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
    table3.addCell(cell);
    table3.addCell(factura.getTotal().toString());

    document.add(table);
    document.add(table2);
    document.add(table3);

  }

}

package com.curso.springboot.app.view.xlsx;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.springboot.app.models.entity.Factura;
import com.curso.springboot.app.models.entity.FacturaDetalle;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

@Component("/factura/ver.xlsx")
public class FacturaXlsxView extends AbstractXlsxView {

  @Override
  protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    response.setHeader("Content-Disposition", "attachment; filename=\"factura_view.xlsx\"");

    Factura factura = (Factura) model.get("factura");

    Sheet sheet = workbook.createSheet("Factura " + factura.getId());
    MessageSourceAccessor mensajes = getMessageSourceAccessor();

    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);
    cell.setCellValue(mensajes.getMessage("text.factura.ver.datos.cliente"));

    row = sheet.createRow(1);
    cell = row.createCell(0);
    cell.setCellValue(factura.getCliente().toString());

    row = sheet.createRow(2);
    cell = row.createCell(0);
    cell.setCellValue(factura.getCliente().getEmail());

    sheet.createRow(4).createCell(0).setCellValue(mensajes.getMessage("text.factura.ver.titulo"));
    sheet.createRow(5).createCell(0)
        .setCellValue(mensajes.getMessage("text.cliente.factura.folio") + ": " + factura.getId());
    sheet.createRow(6).createCell(0).setCellValue(
        mensajes.getMessage("text.cliente.factura.descripcion") + ": " + factura.getDescripcion());
    sheet.createRow(7).createCell(0)
        .setCellValue(mensajes.getMessage("text.cliente.factura.fecha") + ": " + factura.getCreatedAt());

    CellStyle theaderStyle = workbook.createCellStyle();
    theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
    theaderStyle.setBorderTop(BorderStyle.MEDIUM);
    theaderStyle.setBorderRight(BorderStyle.MEDIUM);
    theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
    theaderStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
    theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    CellStyle tbodyStyle = workbook.createCellStyle();
    tbodyStyle.setBorderBottom(BorderStyle.THIN);
    tbodyStyle.setBorderTop(BorderStyle.THIN);
    tbodyStyle.setBorderRight(BorderStyle.THIN);
    tbodyStyle.setBorderLeft(BorderStyle.THIN);

    Row header = sheet.createRow(9);
    header.createCell(0).setCellValue(mensajes.getMessage("text.factura.form.buscar"));
    header.createCell(1).setCellValue(mensajes.getMessage("text.factura.form.item.precio"));
    header.createCell(2).setCellValue(mensajes.getMessage("text.factura.form.item.cantidad"));
    header.createCell(3).setCellValue(mensajes.getMessage("text.factura.form.item.total"));

    header.getCell(0).setCellStyle(theaderStyle);
    header.getCell(1).setCellStyle(theaderStyle);
    header.getCell(2).setCellStyle(theaderStyle);
    header.getCell(3).setCellStyle(theaderStyle);

    int rownum = 10;
    for (FacturaDetalle un_detalle : factura.getDetalles()) {
      Row fila = sheet.createRow(rownum++);

      cell = fila.createCell(0);
      cell.setCellValue(un_detalle.getProducto().getNombre());
      cell.setCellStyle(tbodyStyle);

      cell = fila.createCell(1);
      cell.setCellValue(un_detalle.getProducto().getPrecio());
      cell.setCellStyle(tbodyStyle);

      cell = fila.createCell(2);
      cell.setCellValue(un_detalle.getCantidad());
      cell.setCellStyle(tbodyStyle);

      cell = fila.createCell(3);
      cell.setCellValue(un_detalle.calcularImporte());
      cell.setCellStyle(tbodyStyle);
    }

    Row filaTotal = sheet.createRow(rownum);
    cell = filaTotal.createCell(2);
    cell.setCellValue(mensajes.getMessage("text.factura.form.item.total") + ": ");
    cell.setCellStyle(tbodyStyle);

    cell = filaTotal.createCell(3);
    cell.setCellValue(factura.getTotal());
    cell.setCellStyle(tbodyStyle);

  }

}

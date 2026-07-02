/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiocaso1;

/**
 *
 * @author Laboratorio
 */
public class EstudioCaso1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    String nombreAgente = JOptionPane.showInputDialog("Ingrese el nombre del agente de ventas:");
    String cedulaAgente = JOptionPane.showInputDialog("Ingrese la cédula del agente:");
    String codigoAgente = JOptionPane.showInputDialog("Ingrese el código del agente:");
    String sucursal = JOptionPane.showInputDialog("Ingrese la sucursal a la que pertenece:");

    int opcionVehiculo = JOptionPane.showConfirmDialog(null, "¿Tiene vehículo propio?", "Vehículo", JOptionPane.YES_NO_OPTION);
    String tieneVehiculo = (opcionVehiculo == JOptionPane.YES_OPTION) ? "Sí cuenta con vehículo propio" : "No cuenta con vehículo propio";

    double totalVendidoMes = 0;
    double totalComisiones = 0;
    int totalPuntos = 0;
    int contadorFacturas = 0;
    String nombreMes = "";
    boolean mesAsignado = false;

    boolean continuar = true;

    while(continuar){
            contadorFacturas++;
            
            JOptionPane.showMessageDialog(null, "--- Registro de la Factura #" + contadorFacturas + " ---");
            String cliente = JOptionPane.showInputDialog("Nombre del cliente:");
            String cedulaCliente = JOptionPane.showInputDialog("Cédula del cliente:");
            String codigoFactura = JOptionPane.showInputDialog("Código de la factura:");
            
            double montoFactura = Double.parseDouble(JOptionPane.showInputDialog("Monto de la factura:"));

            int numMes = 0;
            while (numMes < 1 || numMes > 12) {
                numMes = Integer.parseInt(JOptionPane.showInputDialog("Número de mes (1 al 12):"));
                if (numMes < 1 || numMes > 12) {
                    JOptionPane.showMessageDialog(null, "Mes inválido. Intente de nuevo.");
                }
            }

            if (!mesAsignado) {
                String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", 
                                  "julio", "agosto", "setiembre", "octubre", "noviembre", "diciembre"};
                nombreMes = meses[numMes - 1];
                mesAsignado = true;
            }

            int cantElectricos = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos ELÉCTRICOS:"));
            int cantAutomotrices = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos AUTOMOTRICES:"));
            int cantConstruccion = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos de CONSTRUCCIÓN:"));

            double bonoFactura = 0;
            int puntosFactura = 0;

            

            if (cantElectricos > 0 && cantAutomotrices > 0 && cantConstruccion > 0) {
                bonoFactura += montoFactura * 0.10;
                puntosFactura += 3;
                
                if (montoFactura > 50000) {
                    bonoFactura += montoFactura * 0.05;
                    puntosFactura += 1;
                }
            } else {

                
                if (cantElectricos >= 3) {
                    bonoFactura += montoFactura * 0.04;
                } else if (cantElectricos > 0) {
                    bonoFactura += montoFactura * 0.02;
                }
                if (cantElectricos > 0) puntosFactura += 1;

                if (cantAutomotrices > 4) {
                    bonoFactura += montoFactura * 0.04;
                } else if (cantAutomotrices > 0) {
                    bonoFactura += montoFactura * 0.02;
                }
                if (cantAutomotrices > 0) puntosFactura += 1;

                if (cantConstruccion > 0) {
                    bonoFactura += montoFactura * 0.08;
                    puntosFactura += 2;
                }

                if (montoFactura > 50000) {
                    bonoFactura += montoFactura * 0.05;
                    puntosFactura += 1;
                }
            }

            totalVendidoMes += montoFactura;
            totalComisiones += bonoFactura;
            totalPuntos += puntosFactura;

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea registrar otra factura?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                continuar = false;
            }
        }

        String estadoBonoExtra = "El agente vendedor no logró el objetivo de llegar al BONO EXTRA.";
    if (contadorFacturas > 3 || totalVendidoMes > 300000) {
            totalComisiones += 20000;
            estadoBonoExtra = "¡El agente vendedor logró el objetivo de llegar al BONO EXTRA! (+20,000)";
        }

        String reporteFinal = "El Agente Vendedor \"" + nombreAgente + "\" código: " + codigoAgente + " en el mes de " + nombreMes + ".\n"
            + "• Vendió un total de " + totalVendidoMes + " en facturas\n"
            + "• Obtuvo un total en comisiones de " + totalComisiones + "\n"
            + "• " + estadoBonoExtra + "\n"
            + "• Puntos obtenidos por el vendedor: " + totalPuntos + "\n"
            + "• " + tieneVehiculo + "\n"
            + "• Sucursal: " + sucursal;

    JOptionPane.showMessageDialog (
            

null, reporteFinal, "Reporte Mensual de Ventas", JOptionPane.INFORMATION_MESSAGE);
    }

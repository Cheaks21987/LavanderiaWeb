package pe.edu.universidad.entidades.jdbc;

import javax.swing.WindowConstants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class reporte {

	public reporte() {

		try {

			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/reporte.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, PaisesDataSource.getDataSource());

			JasperViewer view = new JasperViewer(jprint, false);
			view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			view.setVisible(true);

		} catch (JRException ex) {
			ex.getMessage();
		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		reporte jasper = new reporte();

	}

	public void reporte2() {
		
		try {

			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/reporte.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, PaisesDataSource.getDataSource());

			JasperViewer view = new JasperViewer(jprint, false);
			view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			view.setVisible(true);

		} catch (JRException ex) {
			ex.getMessage();
		}
		// TODO Auto-generated method stub
		
	}

}

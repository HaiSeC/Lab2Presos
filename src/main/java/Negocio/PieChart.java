/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Cris
 */
public class PieChart {
    
    private static ArrayList<String> arrl = new ArrayList<String>();
    
    public PieChart(String appTitle, String chartTitle, JFrame frame) throws FileNotFoundException{
        Delitos dls = new Delitos();
        arrl = dls.cargarCantidadDelitos();
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(frame.getSize());
        frame.setContentPane(chartPanel);            
    }


    
    private PieDataset createDataset() throws FileNotFoundException{

        int tam = arrl.size();        
        int EF = Collections.frequency(arrl, "Estafador");
        int CT = Collections.frequency(arrl, "Carterista");
        int AS = Collections.frequency(arrl, "Asesino");
        int V = Collections.frequency(arrl, "Violador");
        int LC = Collections.frequency(arrl, "Lider Criminal");
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Estafadores",EF);
        result.setValue("Carteristas",CT);
        result.setValue("Asesinos",AS);
        result.setValue("Violadores",V);
        result.setValue("Lideres Criminales",LC);
        return result;
    }
            
    private JFreeChart createChart (PieDataset dataset, String title){
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
    
}

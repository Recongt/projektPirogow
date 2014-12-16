package HospitalApplication.layout;

import HospitalApplication.database.model.Dawca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DawcyOkienko extends JFrame{


    public DawcyOkienko(final List<Dawca> dawcy){
        /**********************************************************************/
        /*ROZMIAR OKNA*/
        int windowWidth = 800;
        int windowHeight = 600;
        /**********************************************************************/
        /*ROZMIARY TABELKI*/
        final String[] columnNames = {"PESEL", 
                                "WIEK", 
                                "PŁEĆ",
                                "DATA PRZYJECIA NA OIOM",
                                "ROZPOZNANIE ICD10",
                                "ROZPOZNANIE ICD10",
                                "ROZPOZNANIE ICD10",
                                "ROZPOZNANIE ICD10",
                                "SKALA GSC",
                                "KATEGORIA PACJENTA",
                                "UWAGI"};
        final int columns = columnNames.length;
        final int rows = dawcy.size();
        final Object[][] rowData = new String[rows][columns];
        /**********************************************************************/
        /*MODEL TABELKI*/
        TableModel dataModel = new AbstractTableModel(){
            @Override
            public int getRowCount() {
                return rows;
            }
            @Override
            public int getColumnCount() {
                return columns;
            }
            @Override //ustawia zawartosc tablicy
            public Object getValueAt(int rowIndex, int columnIndex) {
                Dawca dawca = dawcy.get(rowIndex);
                switch(columnIndex){
                    case 0: return dawca.getPesel();
                    case 1: return dawca.getAge();
                    case 2: return dawca.getSex();
                    case 3: return dawca.getDate().toString();
                    default: return null;
                }
            }
            @Override
            public String getColumnName(int index) {
                return columnNames[index];
            }
        };

        //DefaultTableModel dataModel = new DefaultTableModel(columnNames,0);

        /**********************************************************************/
        /*INICJALIZACJA TABELKI*/
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);
        /**********************************************************************/
        /*MENUBAR*/
        JMenuBar menuBar = new JMenuBar();
        JMenu menuMenu = new JMenu("Menu");
        JMenu menuUstawienia = new JMenu("Ustawienia");
        menuBar.add(menuMenu);
        menuBar.add(menuUstawienia);
        this.setJMenuBar(menuBar);
        /**********************************************************************/
        /*TOOLBAR + BUTTONY*/
        //ramka na buttony
        Border buttonBorder = new LineBorder(Color.GRAY, 1);
        //toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        JButton testBtn1 = new JButton();
        //try {
            //Image img = ImageIO.read(getClass().getResource("HospitalApplication/layout/settings_icon.png"));
            //testBtn1.setIcon(new ImageIcon(img));
            testBtn1.setBorder(buttonBorder);
        //} catch (IOException ex) {
        //    System.out.println(ex);
        //}
        
        JLabel szukajkaLabel = new JLabel("ICD10: ");
        JTextField szukajka = new JTextField();
        szukajka.setPreferredSize(new Dimension(120, 20));
        szukajka.setMaximumSize(szukajka.getPreferredSize());
        
        toolBar.add(testBtn1);
        toolBar.add(Box.createHorizontalGlue());
        toolBar.add(szukajkaLabel);
        toolBar.add(szukajka);
        
        /**********************************************************************/ 
        this.add(toolBar, BorderLayout.NORTH);
        this.add(scrollpane);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
	this.setVisible(true);
    }
}

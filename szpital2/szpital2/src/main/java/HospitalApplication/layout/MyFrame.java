package HospitalApplication.layout;
  
  import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.EventQueue;  
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  

import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import net.miginfocom.swing.MigLayout;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Button;
import java.awt.Choice;

import javax.swing.JComboBox;

import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;  
import javax.swing.UIManager;

  public class MyFrame extends JFrame {  
       private JPanel contentPane;  
       private JTable Dane_pacjenta;
       /**  
        * Launch the application.  
        */  
       public static void main(final String[] args) {  
            EventQueue.invokeLater(new Runnable() {  
                 public void run() {  
                      try {  
                           MyFrame frame = new MyFrame(args[0]);  
                           frame.setVisible(true);  
                      } catch (Exception e) {  
                           e.printStackTrace();  
                      }  
                 }  
            });  
       }  
       /**  
        * Create the frame.  
        */  
       public MyFrame(String args) {
       	setTitle("Pacjent: "+args+" informacje szczegolowe");
   		
    	   /*try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Windows Vista".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {*/
		    // Ustawienie Look and feel  
    	   
       	//setIconImage(Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/Projekt/okienko/icon175x175.png")));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            setBounds(100, 100, 1070, 656);  
            contentPane = new JPanel() {  
                 public void paintComponent(Graphics g) {  
                      //Image img = Toolkit.getDefaultToolkit().getImage(
                      //          MyFrame.class.getResource("background.jpg"));
                      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                 }  
            };  
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            String a = args;
            GridBagLayout gbl_contentPane = new GridBagLayout();
            gbl_contentPane.columnWidths = new int[]{1051, 0};
            gbl_contentPane.rowHeights = new int[]{77, 67, 439, 0};
            gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
            contentPane.setLayout(gbl_contentPane);
            
            JPanel panel_tytulowy = new JPanel();
            panel_tytulowy.setBackground(new Color(0,0,0,20));
            GridBagConstraints gbc_panel_tytulowy = new GridBagConstraints();
            gbc_panel_tytulowy.fill = GridBagConstraints.BOTH;
            gbc_panel_tytulowy.insets = new Insets(0, 0, 5, 0);
            gbc_panel_tytulowy.gridx = 0;
            gbc_panel_tytulowy.gridy = 0;
            contentPane.add(panel_tytulowy, gbc_panel_tytulowy);
            panel_tytulowy.setLayout(new GridLayout(0, 2, 0, 0));
            
            JLabel Pacjent_label = new JLabel("Pacjent: ");
            Pacjent_label.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 25));
            Pacjent_label.setHorizontalAlignment(SwingConstants.RIGHT);
            panel_tytulowy.add(Pacjent_label);
            JLabel IDPacjenta = new JLabel(a);
            IDPacjenta.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 25));
            panel_tytulowy.add(IDPacjenta);
            
            JScrollPane scrollPane_1 = new JScrollPane();
            scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
            gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
            gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
            gbc_scrollPane_1.gridx = 0;
            gbc_scrollPane_1.gridy = 1;
            contentPane.add(scrollPane_1, gbc_scrollPane_1);
            
            Dane_pacjenta = new JTable();
            Dane_pacjenta.setCellSelectionEnabled(true);
            Dane_pacjenta.setFillsViewportHeight(true);
            scrollPane_1.setViewportView(Dane_pacjenta);
            Dane_pacjenta.setModel(new DefaultTableModel(
            	new Object[][] {
            		{null, null, null, null, null, null, null, null},
            	},
            	new String[] {
            		"PESEL", "O\u015Brodek zg\u0142aszaj\u0105cy", "Od kiedy na OIOMie", "Data przyj\u0119cia", "Respirator", "ICD-10", "Hipotensja", "Resuscytacja"
            	}
            ));
            
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0,0,0,20));
            panel.setBorder(new TitledBorder(null, "Wykres zmian poziomu �wiadomo�ci w skali Glasgow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.gridx = 0;
            gbc_panel.gridy = 2;
            contentPane.add(panel, gbc_panel);
            GridBagLayout gbl_panel = new GridBagLayout();
            gbl_panel.columnWidths = new int[]{1039, 0};
            gbl_panel.rowHeights = new int[]{416, 0};
            gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
            panel.setLayout(gbl_panel);
            
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.gridx = 0;
            gbc_lblNewLabel.gridy = 0;
            panel.add(lblNewLabel, gbc_lblNewLabel);
            //lblNewLabel.setIcon(new ImageIcon(MyFrame.class.getResource("Przykladowy_wykres.jpg")));

       }  
  }  
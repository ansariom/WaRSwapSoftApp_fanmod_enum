/** Copyright (C) 2015 
 * @author Mitra Ansariola 
 * 
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
    Contact info:  megrawm@science.oregonstate.edu

 */

package edu.osu.netmotifs.warswap.ui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;

import edu.osu.netmotifs.warswap.common.CONF;

/**
 *
 * @author mitra
 */
public class ExportHtmlUI extends JDialog implements ActionListener, PropertyChangeListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9017370912356313101L;
	private static final String EXPORT_HTM_CONST = "exportHtm";
	HashMap<Integer, Color> colorHash = new HashMap<Integer, Color>();
	private boolean hasSelfloop = true;
	private ExportHtmlUI exportHtmlUI;
	private StartWarswapUI parent;
	private static Logger logger = Logger.getLogger(ExportHtmlUI.class);


	/**
	 * Creates new form ExportHtmlUI
	 */
	public ExportHtmlUI() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		colorHash.put(Integer.parseInt(String.valueOf(CONF.TF_Color)), Color.BLUE);
		colorHash.put(Integer.parseInt(String.valueOf(CONF.MIR_Color)), Color.RED);
		colorHash.put(Integer.parseInt(String.valueOf(CONF.GENE_Color)), Color.BLACK);
		colorHash.put(Integer.parseInt(String.valueOf(CONF.SL_Color)), Color.CYAN);
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		htmOutFilePath = new javax.swing.JTextField();
		htmChooserBtn = new javax.swing.JButton();
//		jLabel2 = new javax.swing.JLabel();
//		subgPerPage = new javax.swing.JTextField();
		jPanel2 = new javax.swing.JPanel();
		zscoreValue = new javax.swing.JTextField(5);
		zscoreCheck = new javax.swing.JCheckBox();
		pvalCheck = new javax.swing.JCheckBox();
		pvalValue = new javax.swing.JTextField(5);
		jPanel3 = new javax.swing.JPanel();
		zscoreSort = new javax.swing.JRadioButton();
		pvalSort = new javax.swing.JRadioButton();
		closeBtn = new javax.swing.JButton();
		createHtmBtn = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		tfColor = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		mirColor = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		geneColor = new javax.swing.JButton();
		slColor = new javax.swing.JButton();

		createHtmBtn.setActionCommand(EXPORT_HTM_CONST);
		createHtmBtn.addActionListener(this);
		
		slColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(ExportHtmlUI.this,
						"Choose color", Color.CYAN);
				colorHash.put(Integer.parseInt(String.valueOf(CONF.SL_Color)),
						newColor);
				slColor.setBackground(newColor);				
			}
		});
		tfColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(ExportHtmlUI.this,
						"Choose color", Color.BLUE);
				colorHash.put(Integer.parseInt(String.valueOf(CONF.TF_Color)),
						newColor);
				tfColor.setBackground(newColor);
			}
		});
		mirColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(ExportHtmlUI.this,
						"Choose color", Color.RED);
				colorHash.put(Integer.parseInt(String.valueOf(CONF.MIR_Color)),
						newColor);
				mirColor.setBackground(newColor);
			}
		});

		geneColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(ExportHtmlUI.this,
						"Choose color", Color.BLACK);
				colorHash.put(
						Integer.parseInt(String.valueOf(CONF.GENE_Color)),
						newColor);
				geneColor.setBackground(newColor);
			}
		});

//		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("File Options"));

		jLabel1.setText("HTML File: ");

		htmOutFilePath.setText(htmOutFile);
//		htmChooserBtn.setText("Browse");
		Icon warnIcon = new ImageIcon("open_btn.png");
//		htmChooserBtn.setIcon(warnIcon);
		htmChooserBtn.setText("Browse");
//		htmChooserBtn.setPreferredSize(new java.awt.Dimension(80,80));
		htmChooserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(new File("."));
				int returnVal = chooser.showOpenDialog(ExportHtmlUI.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					String inPath = file.getAbsolutePath();
					htmOutFilePath.setText(inPath);
					// outputPath.setText(inPath + ".subgraphs.OUT");

				}
			}
		});

//		jLabel2.setText("Subgraphs per page:");

//		subgPerPage.setText("20");

//		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
//				jPanel1);
//		jPanel1.setLayout(jPanel1Layout);
//		jPanel1Layout
//				.setHorizontalGroup(jPanel1Layout
//						.createParallelGroup(
//								javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(
//								jPanel1Layout
//										.createSequentialGroup()
////										.addComponent(jLabel2)
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
////										.addComponent(
////												subgPerPage,
////												javax.swing.GroupLayout.PREFERRED_SIZE,
////												javax.swing.GroupLayout.DEFAULT_SIZE,
////												javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addGap(0, 0, Short.MAX_VALUE))
//						.addGroup(
//								jPanel1Layout
//										.createSequentialGroup()
//										.addComponent(jLabel1)
//										.addGap(2, 2, 2)
//										.addComponent(htmOutFilePath)
//										.addGap(18, 18, 18)
//										.addComponent(
//												htmChooserBtn,
//												javax.swing.GroupLayout.PREFERRED_SIZE,
//												25,
//												javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addGap(22, 22, 22)));
//		jPanel1Layout
//				.setVerticalGroup(jPanel1Layout
//						.createParallelGroup(
//								javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(
//								jPanel1Layout
//										.createSequentialGroup()
//										.addGroup(
//												jPanel1Layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.BASELINE)
//														.addComponent(jLabel1)
//														.addComponent(
//																htmOutFilePath,
//																javax.swing.GroupLayout.PREFERRED_SIZE,
//																javax.swing.GroupLayout.DEFAULT_SIZE,
//																javax.swing.GroupLayout.PREFERRED_SIZE)
//														.addComponent(
//																htmChooserBtn))
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//										.addGroup(
//												jPanel1Layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.BASELINE)
////														.addComponent(jLabel2)
////														.addComponent(
////																subgPerPage,
////																javax.swing.GroupLayout.PREFERRED_SIZE,
////																javax.swing.GroupLayout.DEFAULT_SIZE,
////																javax.swing.GroupLayout.PREFERRED_SIZE)
//														)
//										.addGap(0, 0, Short.MAX_VALUE)));
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(htmOutFilePath, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(htmChooserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(htmOutFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(htmChooserBtn))
        );

		jPanel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Filters"));

		zscoreValue.setText("2");
		zscoreValue.setEnabled(false);
		
		zscoreCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (zscoreCheck.isSelected())
					zscoreValue.setEnabled(true);
				else
					zscoreValue.setEnabled(false);
			}
		});

		zscoreCheck.setText("Z-score bigger than");

		pvalCheck.setText("p-value less than");
		pvalCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pvalCheck.isSelected())
					pvalValue.setEnabled(true);
				else
					pvalValue.setEnabled(false);
			}
		});
		
		pvalValue.setText("0.01");
		pvalValue.setEnabled(false);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																zscoreCheck)
														.addComponent(pvalCheck))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(pvalValue)
														.addComponent(
																zscoreValue))
										.addContainerGap(115, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(4, 4, 4)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																zscoreCheck)
														.addComponent(
																zscoreValue,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(pvalCheck)
														.addComponent(
																pvalValue,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, Short.MAX_VALUE)));

//		jPanel3.setBorder(javax.swing.BorderFactory
//				.createTitledBorder("Sort By"));

		zscoreSort.setText("Z-score");

		pvalSort.setText("p-value");

//		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
//				jPanel3);
//		jPanel3.setLayout(jPanel3Layout);
//		jPanel3Layout
//				.setHorizontalGroup(jPanel3Layout
//						.createParallelGroup(
//								javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(
//								jPanel3Layout
//										.createSequentialGroup()
//										.addGroup(
//												jPanel3Layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.LEADING)
//														.addComponent(
//																zscoreSort)
//														.addComponent(pvalSort))
//										.addGap(0, 225, Short.MAX_VALUE)));
//		jPanel3Layout
//				.setVerticalGroup(jPanel3Layout
//						.createParallelGroup(
//								javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(
//								jPanel3Layout
//										.createSequentialGroup()
//										.addContainerGap()
//										.addComponent(zscoreSort)
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//										.addComponent(pvalSort)
//										.addContainerGap(
//												javax.swing.GroupLayout.DEFAULT_SIZE,
//												Short.MAX_VALUE)));

		closeBtn.setText("Close");
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane
						.showConfirmDialog(null,
								"Do you want to close this window?",
								"Confirm", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					exportHtmlUI.dispose();
					parent.setEnabled(true);
				}
			}
		});

		createHtmBtn.setText("Create HTML");

		jPanel4.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Vertex Colors"));

		jLabel3.setText("TF");

		tfColor.setBackground(java.awt.Color.blue);
		tfColor.setPreferredSize(new java.awt.Dimension(20, 20));

		jLabel4.setText("MIR");

		mirColor.setBackground(java.awt.Color.red);
		mirColor.setPreferredSize(new java.awt.Dimension(20, 20));

		jLabel5.setText("GENE");

		geneColor.setBackground(java.awt.Color.black);
		geneColor.setPreferredSize(new java.awt.Dimension(20, 20));

       jLabel6.setText("Self-loop");

        slColor.setBackground(java.awt.Color.CYAN);
        slColor.setPreferredSize(new java.awt.Dimension(20, 20));
        if (!hasSelfloop) {
        	slColor.setVisible(false);
        	jLabel6.setVisible(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mirColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(geneColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(slColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(mirColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(geneColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel3,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(createHtmBtn)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(closeBtn,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										76,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														jPanel2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jPanel3,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel4,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(createHtmBtn)
												.addComponent(closeBtn))));

		pack();
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ExportHtmlUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ExportHtmlUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ExportHtmlUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ExportHtmlUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ExportHtmlUI().setVisible(true);
			}
		});

	}

	public ExportHtmlUI(String htmOutFile, int motifSize, String motifOutFile, boolean hasSelfloop, StartWarswapUI rootFrame) {
		super((Frame) SwingUtilities.getAncestorOfClass(Frame.class, rootFrame), "Export Html");
		parent = rootFrame;
		parent.setEnabled(false);
		exportHtmlUI = this;
		this.htmOutFile = htmOutFile;
		this.hasSelfloop  = hasSelfloop;
		this.motifSize = motifSize;
		this.motifOutFile = motifOutFile;
		initComponents();
	}

	private String htmOutFile;
	private int motifSize;
	private String motifOutFile;
	// Variables declaration - do not modify
	private javax.swing.JButton geneColor;
	private javax.swing.JButton htmChooserBtn;
	private javax.swing.JButton closeBtn;
	private javax.swing.JButton createHtmBtn;
	private javax.swing.JLabel jLabel1;
//	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTextField htmOutFilePath;
	private javax.swing.JButton mirColor;
	private javax.swing.JButton slColor;
	private javax.swing.JCheckBox pvalCheck;
	private javax.swing.JRadioButton pvalSort;
	private javax.swing.JTextField pvalValue;
//	private javax.swing.JTextField subgPerPage;
	private javax.swing.JButton tfColor;
	private javax.swing.JCheckBox zscoreCheck;
	private javax.swing.JRadioButton zscoreSort;
	private javax.swing.JTextField zscoreValue;
	private ProgressMonitor progressMonitor;
	private Task task;
	// End of variables declaration
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase(EXPORT_HTM_CONST)) {
			float zscore = -1, pval = -1;
			try {
				if (htmOutFilePath.getText() == null || htmOutFilePath.getText().equalsIgnoreCase(""))
					throw new FileNotFoundException("HTML output is empty!");
//				File outFile = new File(htmOutFilePath.getText());
//				if (!outFile.isFile() || outFile.isDirectory()) 
//					throw new FileNotFoundException("HTML output file is not a valid file!");
				if (zscoreCheck.isSelected())
					zscore = Float.valueOf(zscoreValue.getText());
				if (pvalCheck.isSelected())
					pval = Float.valueOf(pvalValue.getText());
				GenerateMotifImages generateMotifImages = new GenerateMotifImages(colorHash, motifOutFile, motifSize, 
	            		htmOutFilePath.getText());
	            generateMotifImages.createHtm(zscore, pval, 25);
				JOptionPane.showMessageDialog(this, "Done! Output HTML file is located at: \n" + htmOutFilePath.getText());
				//----
//				progressMonitor = new ProgressMonitor(this,
//                        "Running a Long Task",
//                        "", 0, 100);
//				progressMonitor.setProgress(0);
//				task = new Task();
//				task.addPropertyChangeListener(this);
//				task.execute();
//
//				
//				progressMonitor.setProgress(100);
//				JOptionPane.showMessageDialog(this, "Html exported successfully!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
				logger.error(ex.getStackTrace().toString());
				
			}
		}
	}
	
	 public void propertyChange(PropertyChangeEvent evt) {
	        if ("progress" == evt.getPropertyName() ) {
	            int progress = (Integer) evt.getNewValue();
	            progressMonitor.setProgress(progress);
	            String message =
	                String.format("Completed %d%%.\n", progress);
	            progressMonitor.setNote(message);
//	            taskOutput.append(message);
	            if (progressMonitor.isCanceled() || task.isDone()) {
	                Toolkit.getDefaultToolkit().beep();
	                if (progressMonitor.isCanceled()) {
	                    task.cancel(true);
//	                    taskOutput.append("Task canceled.\n");
	                } else {
//	                    taskOutput.append("Task completed.\n");
	                }
//	                startButton.setEnabled(true);
	            }
	        }

	    }
	
	class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() throws Exception {
            Random random = new Random();
            int progress = 0;
            setProgress(0);
			float zscore = -1, pval = -1;
            if (zscoreCheck.isSelected())
				zscore = Float.valueOf(zscoreValue.getText());
			if (pvalCheck.isSelected())
				pval = Float.valueOf(pvalValue.getText());
            GenerateMotifImages generateMotifImages = new GenerateMotifImages(colorHash, motifOutFile, motifSize, 
            		htmOutFilePath.getText());
            generateMotifImages.createHtm(zscore, pval, 25);
            try {
                Thread.sleep(500);
                while (progress < 100 && generateMotifImages.getRunstatus() == 0) {
                    //Sleep for up to one second.
                    Thread.sleep(random.nextInt(500));
                    //Make random progress.
                    progress += random.nextInt(10);
                    setProgress(Math.min(progress, 100));
                }
            } catch (InterruptedException ignore) {}
            return null;
        }

        @Override
        public void done() {
//            Toolkit.getDefaultToolkit().beep();
//            startButton.setEnabled(true);
//            progressMonitor.setProgress(0);
        }
    }

}
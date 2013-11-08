package com.fa11.dvdverleih.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DVDVerleihTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DVDVerleihTable(String[] columnTitles, int rows) {
		
		super();
		
		final TableModel model = randomModel(columnTitles, rows);
			
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
        setRowSorter( sorter );
        sorter.setModel( model );
		
		setModel(model);
		getTableHeader().setReorderingAllowed(false); 
		getTableHeader().setResizingAllowed(false);
		setRowHeight(20);
		setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setAutoCreateRowSorter(true);
	}
	
	private static DefaultTableModel randomModel(String[] columnTitles, int rows){
               
		DefaultTableModel model = new DefaultTableModel( columnTitles, rows ){
			
			private static final long serialVersionUID = 1L;
        };      
        return model;
    }
		
	@Override
	public Component prepareRenderer(TableCellRenderer renderer,
            int rowIndex, int vColIndex) {

        Component comp = super.prepareRenderer(renderer, rowIndex, vColIndex);
        
        if (comp instanceof JComponent) {
            JLabel jl = (JLabel) comp;

            jl.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
            jl.setHorizontalAlignment(JLabel.LEFT);
            
            if (rowIndex % 2 == 0) {
                jl.setBackground(new Color(241,241,241));              
            } else {
                jl.setBackground(new Color(223,223,223));     
            }
        }
        
        if (isCellSelected(rowIndex, vColIndex)) {
            comp.setBackground(new Color(192,217,235));
        }     
        return comp;
    }
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}

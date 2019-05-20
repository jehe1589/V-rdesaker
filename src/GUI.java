import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
   String [] str = {"Ornament","Appliance","Share"};
   
   static ArrayList<ArticleOfValue> articlesOfValue = new ArrayList <>();
   JComboBox<String> alternatives;
   JTextArea field;
	
   public static void main(String[] args){
		
		Ornament v1 = new Ornament("Marble", 2, "Gold");
		Appliance v2 = new Appliance("Diskmaskin", 870, 7);
		Share v3 = new Share("Energistrategi Svenska AB", 47, 6700);
		articlesOfValue.add(v1);
		articlesOfValue.add(v2);
		articlesOfValue.add(v3);
		new GUI();
	}

	 GUI(){
		
	  setTitle("Sakregister");	 
	  setLayout(new BorderLayout());
	  
// Rubrik:	  
	  JPanel rubrikPanel = new JPanel();
	  add(rubrikPanel, BorderLayout.NORTH);
	  JLabel rubrik = new JLabel("Värdesaker");
	  rubrikPanel.add(rubrik);
	  
// Textfält:	  
	  field = new JTextArea();
	  add(field, BorderLayout.CENTER);
	  field.setEditable(false);
	  JScrollPane scroll = new JScrollPane();
	  field.add(scroll);
	  
// Knappar:	  
	  JPanel knappPanel = new JPanel();
	  add(knappPanel, BorderLayout.SOUTH);
	  JLabel nytt = new JLabel("Nytt:");
	  knappPanel.add(nytt);
	  alternatives = new JComboBox<>(str);
	  alternatives.addActionListener(new ComboBoxListener());
	  knappPanel.add(alternatives);
	  JButton visa = new JButton("Visa");
	  visa.addActionListener(new VisaListener());
	  knappPanel.add(visa);
	  JButton börskrasch = new JButton("Börskrasch");
	  börskrasch.addActionListener(new BörskraschListener());
	  knappPanel.add(börskrasch);
	  
// Radioknappar:	  
	  JPanel radioPanel = new JPanel();
	  radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
	  add(radioPanel, BorderLayout.EAST);
	  radioPanel.add(Box.createVerticalGlue());
	  JLabel radioRubrik = new JLabel("Sortering");
	  radioPanel.add(radioRubrik);
	  ButtonGroup grupp = new ButtonGroup();
	  JRadioButton namn = new JRadioButton("Namn", true);
	  namn.addActionListener(new NameListener());
	  grupp.add(namn);
	  radioPanel.add(namn);
	  JRadioButton värde = new JRadioButton("Värde");
	  värde.addActionListener(new ValueListener ());
	  grupp.add(värde);
	  radioPanel.add(värde);
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setLocation(500, 200);
	  setSize(530, 500);
	  setVisible(true);
	}
	 
   class ComboBoxListener implements ActionListener{
	   
	   public void actionPerformed(ActionEvent ave){
		   
		   String choice = (String)alternatives.getSelectedItem();
		   
			   if(choice.equals("Ornament")){
			   
			   JPanel form = new JPanel();
			   form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
			   JPanel nameRow = new JPanel();
			   JTextField nameField = new JTextField("", 10);
			   nameRow.add(new JLabel("Name:"));
			   nameRow.add(nameField);
			   form.add(nameRow);
			   JPanel gemRow = new JPanel();
			   JTextField gemField = new JTextField(10);
			   gemRow.add(new JLabel("Number of gems:"));
			   gemRow.add(gemField);
			   form.add(gemRow);
			   JCheckBox golden = new JCheckBox("Golden?");
			   form.add(golden);
			   
			   int answer = JOptionPane.showConfirmDialog(null, form, "New ornament", JOptionPane.OK_CANCEL_OPTION); 
			   
			   if(answer == JOptionPane.YES_OPTION){
				   
			    try {
			       
			    	if(StringUtils.isBlank(nameField.getText())) {
			    		
			    		throw new IllegalArgumentException();
			    	}
			    	
				    String name = nameField.getText();
				    int numberOfGems = Integer.parseInt(gemField.getText());
				   
				    if(golden.isSelected()){
					   
					    String material = "Gold";
					   
					    Ornament newJewelry = new Ornament(name, numberOfGems, material);
					    articlesOfValue.add(newJewelry);
				    }
				    else{
					   
					    String material = "Silver";
					   
					    Ornament newJewelry = new Ornament(name, numberOfGems, material);
					    articlesOfValue.add(newJewelry);
				       }
				    }
	             catch(IllegalArgumentException e){
	            	 
	            	    JOptionPane.showMessageDialog(form, "Wrong input!", "Error!", JOptionPane.ERROR_MESSAGE);
	             }  
			   }
		   }
		   
		   if(choice.equals("Appliance")){
			   
			   JPanel form = new JPanel();
			   form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
			   JPanel nameRow = new JPanel();
			   JTextField nameField = new JTextField(10);
			   nameRow.add(new JLabel("Name:"));
			   nameRow.add(nameField);
			   form.add(nameRow);
			   JPanel priceRow = new JPanel();
			   JTextField priceField = new JTextField(10);
			   priceRow.add(new JLabel("Price:"));
			   priceRow.add(priceField);
			   form.add(priceRow);
			   JPanel wearRow = new JPanel();
			   JTextField wearField = new JTextField(10);
			   wearRow.add(new JLabel ("Level of wear:"));
			   wearRow.add(wearField);
			   form.add(wearRow);
			   
			   int svar = JOptionPane.showConfirmDialog(null, form, "New appliance", JOptionPane.OK_CANCEL_OPTION);
			   
               if(svar == JOptionPane.YES_OPTION){
				   
            	   try{
            		   
            		   if(StringUtils.isBlank(nameField.getText())) {
   			    		
   			    		   throw new IllegalArgumentException();
   			    	   }
            		   
            		   String name = nameField.getText();
            		   double price = Double.parseDouble(priceField.getText());
            		   int levelOfWear = Integer.parseInt(wearField.getText());
            		   
            		   Appliance newAppliance = new Appliance(name, price, levelOfWear);
            		   
            		   articlesOfValue.add(newAppliance);
            	   }
            	   catch(IllegalArgumentException e){
            		   
            		   JOptionPane.showMessageDialog(form, "Wrong input!", "Error!", JOptionPane.ERROR_MESSAGE);
            	   }
			   }
            }
			   
		   if(choice.equals("Share")){
			   
			   JPanel form = new JPanel();
			   form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
			   JPanel nameRow = new JPanel();
			   JTextField nameField = new JTextField(10);
			   nameRow.add(new JLabel("Name:"));
			   nameRow.add(nameField);
			   form.add(nameRow);
			   JPanel numberRow = new JPanel();
			   JTextField numberField = new JTextField(10);
			   numberRow.add(new JLabel("Number:"));
			   numberRow.add(numberField);
			   form.add(numberRow);
			   JPanel priceRow = new JPanel();
			   JTextField priceField = new JTextField(10);
			   priceRow.add(new JLabel("Stock price:"));
			   priceRow.add(priceField);
			   form.add(priceRow);
			   
			   int svar = JOptionPane.showConfirmDialog(null, form, "New share", JOptionPane.OK_CANCEL_OPTION);
			   
			   if(svar==JOptionPane.YES_OPTION){
				   
				 try{
					 
					 if(StringUtils.isBlank(nameField.getText())) {
	   			    		
 			    		   throw new IllegalArgumentException();
 			    	 }
				     
					 String name = nameField.getText();
				     int number = Integer.parseInt(numberField.getText());
				     double stockPrice = Double.parseDouble(priceField.getText());
				     Share newShare = new Share(name, number, stockPrice);
				   
				     articlesOfValue.add(newShare);
				     } 
				 
				 catch(IllegalArgumentException e){
					 
				   JOptionPane.showMessageDialog(null, "Wrong input!", "Error!", JOptionPane.ERROR_MESSAGE); 
				 }
			   }
		   }
	   }
   }	 
	 
   class VisaListener implements ActionListener {
	   
	   public void actionPerformed(ActionEvent ave){
		 
		   String resultat = "";
		   field.setText("");
		   
		   for(ArticleOfValue v: articlesOfValue){
			   
			   resultat += v.toString() + "\n";
		   }
		   
		   field.setText(resultat);
		 }
   }	 
	 
   class BörskraschListener implements ActionListener{

	   public void actionPerformed(ActionEvent ave) {
			
			for(ArticleOfValue article : articlesOfValue){
				
				if(article instanceof Share){
					
					((Share) article).setStockPrice(0);
					((Share) article).calculateValue();
					}	
			}
		} 
	 } 
   
   class NameListener implements ActionListener{
	   
	   public void actionPerformed(ActionEvent ave){
		   
		   String nytt = "";
		   field.setText("");
		   Collections.sort(articlesOfValue, new NameCompare());
		   
		   for(ArticleOfValue v: articlesOfValue){
			   
			   nytt += v.toString() + "\n";
			   field.setText(nytt);
		   }
	   }
   }
   
   class ValueListener implements ActionListener{
	   
	   public void actionPerformed(ActionEvent ave){
		   
			   String nytt = "";
			   field.setText("");
			   Collections.sort(articlesOfValue, new ValueCompare());
			   
			   for (ArticleOfValue val: articlesOfValue){
				   
				   nytt += val.toString() + "\n";
				   field.setText(nytt);
			   }
		   }
	   }
   
   class NameCompare implements Comparator<ArticleOfValue>{

	@Override
	public int compare(ArticleOfValue thisOne, ArticleOfValue thatOne) {
		
		return thisOne.getName().compareTo(thatOne.getName());
	}
	   
	   
   }
   
   class ValueCompare implements Comparator<ArticleOfValue>{

	@Override
	public int compare(ArticleOfValue thisOne, ArticleOfValue thatOne) {
		
		if(thisOne.calculateValue() == thatOne.calculateValue()){
			
			return 0;
		} else if(thisOne.calculateValue() > thatOne.calculateValue()){
			
			return -1;
	    }else {
	    	
	    	return 1;
	    }
		
	 }
   }
}



import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;
import java.text.DecimalFormat;
// New event listener that monitors changing values for components

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Allows me to format the numbers

import java.text.NumberFormat;

// Allows me to edit borders on panels

import javax.swing.border.*;


public class Lesson22 extends JFrame{
    
    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2, textField3, textField4, studentName;
    JCheckBox dollarSign, commaSeparator;
    JRadioButton addNums, subtractNums, multNums, divideNums;
    JSlider howManyTimes;
    JTextArea avg;
    double number1, number2, number3, number4, totalCalc;
    
    public static void main(String[] args){
        
        new Lesson22();
        
    }
    
    public Lesson22(){
        
        // Define the size of the frame
        
        this.setSize(350, 400);
                
        // Opens the frame in the middle of the screen
        
        this.setLocationRelativeTo(null);
        
        // Define how the frame exits (Click the Close Button)
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        // Define the title for the frame
                
        this.setTitle("My Third Frame");
                
        // The JPanel contains all of the components for your frame
                
        JPanel thePanel = new JPanel();
        
        // ---------------------------------------------------------
        
        //Create First Field
        
        // How to add a label --------------------------
        
        JLabel name = new JLabel("Student Name");
        
        thePanel.add(name);
                
        // How to add a text field ----------------------
                
        studentName = new JTextField("", 20);
                        
        thePanel.add(studentName);
        
        
        // How to add a label --------------------------
        
        label1 = new JLabel("Unit 1 Test");
        
        thePanel.add(label1);
                
        // How to add a text field ----------------------
                
        textField1 = new JTextField("", 5);
                        
        thePanel.add(textField1);
        
        // How to add a label --------------------------
        
        label2 = new JLabel("Unit 2 Test");
                
        thePanel.add(label2);
                        
        // How to add a text field ----------------------
                        
        textField2 = new JTextField("", 5);
                                
        thePanel.add(textField2);
        
        // How to add a label --------------------------        
        JLabel label3 = new JLabel("Unit 3 Test");
        thePanel.add(label3);   
        // How to add a text field ----------------------       
        textField3 = new JTextField("", 5);                         
        thePanel.add(textField3);

        // How to add a label --------------------------        
        JLabel label4 = new JLabel("Unit 4 Test");
        thePanel.add(label4);   
        // How to add a text field ----------------------       
        textField4 = new JTextField("", 5);                         
        thePanel.add(textField4);

        // Creates radio buttons with default labels
        
        addNums = new JRadioButton("Freshman");
        subtractNums = new JRadioButton("Sophmore");
        multNums = new JRadioButton("Junior");
        divideNums = new JRadioButton("Senior");
        
        // Creates a group that will contain radio buttons
        // You do this so that when 1 is selected the others
        // are deselected
        
        ButtonGroup operation = new ButtonGroup();
        
        // Add radio buttons to the group
        
        operation.add(addNums);
        operation.add(subtractNums);
        operation.add(multNums);
        operation.add(divideNums);
        
        // Create a new panel to hold radio buttons
        
        JPanel operPanel = new JPanel();
        
        // Surround radio button panel with a border
        // You can define different types of borders
        // createEtchedBorder, createLineBorder, createTitledBorder
        // createLoweredBevelBorder, createRaisedBevelBorder
        
        Border operBorder = BorderFactory.createTitledBorder("Year");
        
        // Set the border for the panel
        
        operPanel.setBorder(operBorder);
        
        // Add the radio buttons to the panel
        
        operPanel.add(addNums);
        operPanel.add(subtractNums);
        operPanel.add(multNums);
        operPanel.add(divideNums);
        
        // Selects the add radio button by default
        
        addNums.setSelected(true);
        
        // Add the panel to the main panel
        // You don't add the group
        
        thePanel.add(operPanel);
        // Create a button with Click Here on it
        
        button1 = new JButton("Calculate");
                
        // Create an instance of ListenForEvents to handle events
                
        ListenForButton lForButton = new ListenForButton();
                
        // Tell Java that you want to be alerted when an event
        // occurs on the button
                
        button1.addActionListener(lForButton);
                
        thePanel.add(button1);
        
        this.add(thePanel);
        
        this.setVisible(true);
        
        //Average
        JLabel TestAverage = new JLabel("Test Average");
        
        thePanel.add(TestAverage);
                
        // How to add a text field ----------------------
                
        avg = new JTextArea(1, 5);
                        
        thePanel.add(avg);
        
        // Gives focus to the textfield
        
        textField1.requestFocus();
        
    }
    
    private class ListenForButton implements ActionListener{
        
        // This method is called when an event occurs
        
        public void actionPerformed(ActionEvent e){
            
            // Check if the source of the event was the button
            
            if(e.getSource() == button1){
                
                // getText returns a String so you have to parse it
                // into a double in this situation
                
                    avg.setText("");
                    
                    try{
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                    number3 = Double.parseDouble(textField3.getText());
                    number4 = Double.parseDouble(textField4.getText());
                }
                catch(Exception f){
                    
                }
                    double avrg = 0.0;
                    avrg = (number1+number2+number3+number4)/4;
                    
                    if(multNums.isSelected()){
                        avrg += 5;}
                    else if(subtractNums.isSelected()){
                        avrg += 10;}
                    else if(divideNums.isSelected()){
                        avrg += 0;}    
                    else{
                        avrg += 15;}
                    DecimalFormat df = new DecimalFormat("#.0");
                    avg.append("" + df.format(avrg));
                    
                    studentName.requestFocus();
                    studentName.setText("");
            }
            
        }
        
    }
    
    // Implements ActionListener so it can react to events on components
    
        private class ListenForSlider implements ChangeListener{

            @Override
            public void stateChanged(ChangeEvent e) {
                
                // Check if the source of the event was the button
                
                if(e.getSource() == howManyTimes){
                    
                    label3.setText("Perform How Many Times? " + howManyTimes.getValue() );
                    
                        
                }
                
            }
        
        
        
        }
        
        public static double addNumbers(double number1, double number2, int howMany){
            
            double total = 0;
            
            int i = 1;
            
            while(i <= howMany){
                total = total + (number1 + number2);
                i++;
            }
            
            return total;
            
        }
        
        public static double subtractNumbers(double number1, double number2, int howMany){
            
            double total = 0;
            
            int i = 1;
            
            while(i <= howMany){
                total = total + (number1 - number2);
                i++;
            }
            
            return total;
            
        }
        
        public static double multiplyNumbers(double number1, double number2, int howMany){
            
            double total = 0;
            
            int i = 1;
            
            while(i <= howMany){
                total = total + (number1 * number2);
                i++;
            }
            
            return total;
            
        }
        
        public static double divideNumbers(double number1, double number2, int howMany){
            
            double total = 0;
            
            int i = 1;
            
            while(i <= howMany){
                total = total + (number1 / number2);
                i++;
            }
            
            return total;
            
        }
    
}
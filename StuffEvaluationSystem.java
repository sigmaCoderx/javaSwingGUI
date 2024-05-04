
/* 
Java GUI stuff evaluation system

---Coded by: flippedCoin ---
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;

public class StuffEvaluationSystem {
        
        // JTable
        String[] columnNames = {"ID","Instructor Name","Student Department","Semister","Result","Comment"};
        Object[][] data = {};
        JTable table = new JTable(data, columnNames);

        PreparedStatement pst;
        ResultSet rs;

        // label for upper part 
        JLabel instructorNameLabel = new JLabel("Instructor Name");
        JLabel studentDepartmentLabel = new JLabel("Student's Department");
        JLabel academicYearLabel = new JLabel("Academic Year");
        JLabel semesterLabel = new JLabel("Enter Semester");

        // comboBox for Student Department
        String department[] = {"Select","Accounting","Business Management","Computer Science","Economics","Health","Marketing Management"};
        JComboBox<String> departmentList = new JComboBox<>(department);

        // TextField instructorNameLabel 
        JTextField instructorName = new JTextField(20);
        // TextField academicYear
        JTextField academicYear = new JTextField(20);
        // TextField semester
        JTextField semester = new JTextField(20);


        // instruction for rating. 5(very high), 4(high), 3(moderate), 2(low), 1(very low)

        JLabel instructionRating = new JLabel("***********************************************"+"Instruction for rating: if you give five it's very high,if it's four it's high, if it's three it's moderate"
                + " if it's two it's low, if it's one it's very low" + "********************************************");

        // label for core competency
        JLabel question1 = new JLabel("************************************"+"1.He/She prepare and organize the teaching-learning process"+"************************************");
        JLabel question2 = new JLabel("************************************"+ "2.He/She give balanced point to the questions included in the exam"+"************************************");
        JLabel question3 = new JLabel("***************************************************"+ "3.He/She relates test questions to lessons taught"+"***************************************************");
        JLabel question4 = new JLabel("************************************"+ "4.He/She arrange up make classes and other ways to componsate missing classes"+"************************************");
        JLabel question5 = new JLabel("************************************"+ "5.He/She before beginning the teaching-learning process provide relavant course outlines"+"************************************");
        
        // get the evaluated value
        JLabel evaluateLabel = new JLabel("****************************************"+"Enter the sum of the five above evaluation button"+"****************************************************");
        JTextField evaluate = new JTextField(10);
        
        // JLabel and TextArea for additional comments
        JLabel commentLabel = new JLabel("*******************************************"+"Comment"+"*******************************************");
        JTextField comment = new JTextField(10);

        // create buttons for the form
        JButton submitBtn = new JButton("Submit");
        JButton clearBtn = new JButton("Clear form");
        JButton viewBtn= new JButton("View");

        // create panels
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel leftPanel = new JPanel();
    
    
        // radio button for the first questions
        JRadioButton veryHigh1 = new JRadioButton("5");
        JRadioButton high1 = new JRadioButton("4");
        JRadioButton moderate1 = new JRadioButton("3");
        JRadioButton low1 = new JRadioButton("2");
        JRadioButton veryLow1 = new JRadioButton("1");
        
        // radio button for the second questions
        JRadioButton veryHigh2 = new JRadioButton("5");
        JRadioButton high2 = new JRadioButton("4");
        JRadioButton moderate2 = new JRadioButton("3");
        JRadioButton low2 = new JRadioButton("2");
        JRadioButton veryLow2 = new JRadioButton("1");
        
        // radio button for the third questions
        JRadioButton veryHigh3 = new JRadioButton("5");
        JRadioButton high3 = new JRadioButton("4");
        JRadioButton moderate3 = new JRadioButton("3");
        JRadioButton low3 = new JRadioButton("2");
        JRadioButton veryLow3 = new JRadioButton("1");
        
        // radio button for the fourth questions
        JRadioButton veryHigh4 = new JRadioButton("5");
        JRadioButton high4 = new JRadioButton("4");
        JRadioButton moderate4 = new JRadioButton("3");
        JRadioButton low4 = new JRadioButton("2");
        JRadioButton veryLow4 = new JRadioButton("1");

        // radio button for the fifth questions
        JRadioButton veryHigh5 = new JRadioButton("5");
        JRadioButton high5 = new JRadioButton("4");
        JRadioButton moderate5 = new JRadioButton("3");
        JRadioButton low5 = new JRadioButton("2");
        JRadioButton veryLow5 = new JRadioButton("1");


        //Class Constructor
   public StuffEvaluationSystem()
    {
        
        //this helps to group the radio button
        ButtonGroup radioBtnGroup1  = new ButtonGroup();
        radioBtnGroup1.add(veryHigh1);
        radioBtnGroup1.add(high1);
        radioBtnGroup1.add(moderate1);
        radioBtnGroup1.add(low1);
        radioBtnGroup1.add(veryLow1);
        
        ButtonGroup radioBtnGroup2  = new ButtonGroup();
        radioBtnGroup2.add(veryHigh2);
        radioBtnGroup2.add(high2);
        radioBtnGroup2.add(moderate2);
        radioBtnGroup2.add(low2);
        radioBtnGroup2.add(veryLow2);
        
        ButtonGroup radioBtnGroup3  = new ButtonGroup();
        radioBtnGroup3.add(veryHigh3);
        radioBtnGroup3.add(high3);
        radioBtnGroup3.add(moderate3);
        radioBtnGroup3.add(low3);
        radioBtnGroup3.add(veryLow3);
        
        ButtonGroup radioBtnGroup4  = new ButtonGroup();
        radioBtnGroup4.add(veryHigh4);
        radioBtnGroup4.add(high4);
        radioBtnGroup4.add(moderate4);
        radioBtnGroup4.add(low4);
        radioBtnGroup4.add(veryLow4);
        
        ButtonGroup radioBtnGroup5  = new ButtonGroup();
        radioBtnGroup5.add(veryHigh5);
        radioBtnGroup5.add(high5);
        radioBtnGroup5.add(moderate5);
        radioBtnGroup5.add(low5);
        radioBtnGroup5.add(veryLow5);
    
        // layout for the panel
        topPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new FlowLayout());
        rightPanel.setLayout(new FlowLayout());
        leftPanel.setLayout(new FlowLayout());
        
        
        // create frame object
        JFrame frame = new JFrame("Stuff Evaluation System");
        // Set layout for frame
        frame.setLayout(new BorderLayout());
        
        // adding components to the frame
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.add(centerPanel,BorderLayout.CENTER);
        frame.add(leftPanel,BorderLayout.WEST);
        frame.add(rightPanel,BorderLayout.EAST);
        
        // add components to the panel
        centerPanel.add(instructorNameLabel);
        centerPanel.add(instructorName);
        centerPanel.add(studentDepartmentLabel);
        centerPanel.add(departmentList);
        centerPanel.add(academicYearLabel);
        centerPanel.add(academicYear);
        centerPanel.add(semesterLabel);
        centerPanel.add(semester);
        centerPanel.add(instructionRating);
        // tooltip text for semester
        semester.setToolTipText("First or Second");
        
        // add the questions to the panel's zone
        centerPanel.add(question1);
        centerPanel.add(veryHigh1);
        centerPanel.add(high1);
        centerPanel.add(moderate1);
        centerPanel.add(low1);
        centerPanel.add(veryLow1);
        
        //question2
        centerPanel.add(question2);
        centerPanel.add(veryHigh2);
        centerPanel.add(high2);
        centerPanel.add(moderate2);
        centerPanel.add(low2);
        centerPanel.add(veryLow2);
        
        //question3
        centerPanel.add(question3);
        centerPanel.add(veryHigh3);
        centerPanel.add(high3);
        centerPanel.add(moderate3);
        centerPanel.add(low3);
        centerPanel.add(veryLow3);
        
        //question4
        centerPanel.add(question4);
        centerPanel.add(veryHigh4);
        centerPanel.add(high4);
        centerPanel.add(moderate4);
        centerPanel.add(low4);
        centerPanel.add(veryLow4);
        
        //question5
        centerPanel.add(question5);
        centerPanel.add(veryHigh5);
        centerPanel.add(high5);
        centerPanel.add(moderate5);
        centerPanel.add(low5);
        centerPanel.add(veryLow5);
        
        // this comonent used to get evaluated value
        centerPanel.add(evaluateLabel);
        centerPanel.add(evaluate);
        // add the below component to the panel
        centerPanel.add(commentLabel);
        centerPanel.add(comment);
        
        // add those buttons on the south(bottom) panel
       bottomPanel.add(submitBtn);
       bottomPanel.add(clearBtn);
       bottomPanel.add(viewBtn);
       
        // table property
        table.setPreferredScrollableViewportSize(new Dimension(800,150));
        table.setFillsViewportHeight(true);
        // add the table on the scrollpane
        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane);
        
        // frame property
        frame.setVisible(true);
        // the frame visible at center of the frame
        frame.setLocationRelativeTo(null);
        frame.setSize(260,650);
        //frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // the biggest enemy of a man is his comfort zone and his hesitation!

        // the below coce perform insertion operation to database 
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // call the insertData function
                insertData();
             
        }

        });
        
       
        
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructorName.setText("");
                instructorName.requestFocus();
                departmentList.setSelectedIndex(0);
                academicYear.setText("");
                semester.setText("");
                
                // make clear radioButtons after insertion
                radioBtnGroup1.clearSelection();
                radioBtnGroup2.clearSelection();
                radioBtnGroup3.clearSelection();
                radioBtnGroup4.clearSelection();
                radioBtnGroup5.clearSelection();
                // clear the text field
                evaluate.setText("");
                comment.setText("");

                
            }
        });
        
        // Retrive data's from database
        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // call the method
                showData();
            }
        });
        
    }
   
   // This method used to insert data's to database
   public void insertData()
   {
        try
              {
                  // Connection establishment --starts here
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stuffdb","TheEp","");
                  // Connection establishment --ends here

                  // get data's from the gui fields
                  String  getInstName,getSelectedOption,getSem,getComment;
                  int getAcademicYear,getEvaluated,getResult;
                  // get instructor name
                  getInstName = instructorName.getText();
                  // get student's department
                  getSelectedOption = (String) departmentList.getSelectedItem().toString();
                  // get academic year as string
                  getAcademicYear = Integer.parseInt(academicYear.getText());
                  // get semister
                  getSem = semester.getText();
                  
                  // get sum of evaluated value
                  getEvaluated = Integer.parseInt(evaluate.getText());
                  // divide for the sum
                  getResult = getEvaluated/5;
                  //System.out.println(getResult);
                  
                  // get comment
                  getComment = comment.getText();

                  // swl statement
                  String query = "insert into stuffevaluation(instName,stuDepartment,acaYear,semister,result,comment)values(?,?,?,?,?,?)";
                  pst = conn.prepareStatement(query);

                  // pass valeus
                  pst.setString(1, getInstName);
                  pst.setString(2, getSelectedOption);
                  pst.setInt(3,getAcademicYear);
                  pst.setString(4, getSem);
                  pst.setString(5, "The rank given is: "+getResult);
                  pst.setString(6, getComment);
                  
                  int result = pst.executeUpdate();
                  // close the connection
                  conn.close();
                  if(result==1)
                  {
                      JOptionPane.showMessageDialog(null, "The data's are inserted successfully!");
                      /* make clear input fields after insertion
                      instructorName.setText("");
                      instructorName.requestFocus();
                      // unselect selected combobox after the button pressed
                      departmentList.setSelectedIndex(0);
                      academicYear.setText("");
                      semester.setText("");


                      // clear the text field
                      evaluate.setText("");
                      comment.setText(""); */
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null, "Failed to insert the data's");
                  } 
              }
              catch(SQLException | ClassNotFoundException ex)
              {
                  ex.printStackTrace();
          }
        
        
   }
   
   // function(method) for viewBtn
   public void showData()
   {
       try
       {
           // Connection establishment --starts here
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stuffdb","TheEp","");
            // Connection establishment --ends here
            
            // sql query
            String fetchData = "select * from stuffevaluation";
            pst = conn.prepareStatement(fetchData);
            rs = pst.executeQuery();
            
            // create an empty default table model
            DefaultTableModel model = new DefaultTableModel();
            
            ResultSetMetaData resultSetMData = rs.getMetaData();
            int count = resultSetMData.getColumnCount();
            
            // write column to the table
            for(int i=1; i<=count; i++)
            {
                model.addColumn(resultSetMData.getColumnName(i));
            }
            
            while(rs.next())
            {
                Vector<String> row = new Vector<>();
                for(int i=1; i<=count; i++)
                {
                    row.add(rs.getString(i));
                }
                model.addRow(row);
            }
            
            table.setModel(model);
            
            // close the connection
            rs.close();
            conn.close();
            
       }
       catch(SQLException | ClassNotFoundException ex)
       {
           ex.printStackTrace();
       }
       
   }
   
   
    public static void main(String[] args) {
        new StuffEvaluationSystem();
        
    }
    
}

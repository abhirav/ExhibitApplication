//import packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhi
 */
public class ExhibitQueries {
   // URL pointing to Database in Derby
   private static final String URL = "jdbc:derby://localhost:1527/ExhibitDB";
    
   private Connection connection = null; // manages connection
   private Statement displayAllExhibits = null; // Displays all Exhibits
   private Statement displayExhibitsByWeightAndHeight = null; // Displays Exhibits having Height and Weight greater then specified Height and Weight
   private Statement displayExhibitsByLocation = null; // Displays Exhibits by Location
   private Statement displayNoOfExhibitsByWeight = null; // Displays total number Exhibits having weight greater than specified Weight
   
   //Constructor - to establish connection to derby
   public ExhibitQueries()
   {
     try 
     {
        connection = DriverManager.getConnection( URL );
     }// end try
     catch ( SQLException sqlException )
     {
        //Dialog popup when database connection is not established
        JOptionPane.showMessageDialog(null, "Connection to Database not established. Ensure you have started the Derby Database");
        System.exit( 1 );
     }// end catch
     catch (Exception e)
     {
         e.printStackTrace();
     }// end catch
   }
   
   //Method to display all the Exhibits in Exhibit Table
   public List< Exhibit > displayAllExhibits()
   {
     List< Exhibit > results = null;
     ResultSet resultSet = null;
     try 
     {
        // Displays all Exhibits 
        displayAllExhibits = connection.createStatement();
        //executeQuery returns ResultSet having matching queries
        resultSet = displayAllExhibits.executeQuery("SELECT * FROM Exhibits"); 
        results = new ArrayList< Exhibit >();
        
        while ( resultSet.next() )
        {
            results.add( new Exhibit(
            resultSet.getInt( "EXHIBITID" ),
            resultSet.getString( "EXHIBITNAME" ),
            resultSet.getString( "DESCRIPTION" ),
            resultSet.getString( "LOCATION" ),
            resultSet.getFloat( "WEIGHT" ),
            resultSet.getFloat( "HEIGHT" ) ) );
        }// end while
      }// try
      catch ( SQLException sqlException )
      {
         //database exception handling
         sqlException.printStackTrace();         
      }// catch
      finally
      {
            try 
            {
               resultSet.close();
            }// end try
            catch ( SQLException sqlException )
            {
               // database exceptin handling
               sqlException.printStackTrace();         
               close();
            }// end catch
         }// end finally
         return results; //return results list
      }// end method - displayAllExhibits()
   
   //Display Exhibits by Location
   public List< Exhibit > displayExhibitsByLocation( String location )
   {
      List< Exhibit > results = null;
      ResultSet resultSet = null;

      try 
      {
         // Displays Exhibits having Height and Weight greater then specified Height and Weight
         displayExhibitsByLocation = connection.createStatement();
         //executeQuery returns ResultSet having matching queries
         resultSet = displayExhibitsByLocation.executeQuery("SELECT * FROM Exhibits WHERE location = '"+location+"'"); 
         results = new ArrayList< Exhibit >();

         while ( resultSet.next() )
         {
               results.add( new Exhibit(
               resultSet.getInt( "EXHIBITID" ),
               resultSet.getString( "EXHIBITNAME" ),
               resultSet.getString( "DESCRIPTION" ),
               resultSet.getString( "LOCATION" ),
               resultSet.getFloat( "WEIGHT" ),
               resultSet.getFloat( "HEIGHT" ) ) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         //database exception handling
         sqlException.printStackTrace();
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            //database exception handling
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   }// end method - displayExhibitsByLocation()
   
   // Method to display Exhibits having height and weight greater than specified ones
   public List< Exhibit > displayExhibitsByHeightWeight( float weight, float height )
   {
      List< Exhibit > results = null;
      ResultSet resultSet = null;

      try 
      {
         // Displays Exhibits having Height and Weight greater then specified Height and Weight
         displayExhibitsByWeightAndHeight = connection.createStatement();
         // executeQuery returns ResultSet containing matching entries
         resultSet = displayExhibitsByWeightAndHeight.executeQuery("SELECT * FROM Exhibits WHERE weight > "+weight+" AND height > "+height); 
         results = new ArrayList< Exhibit >();
         while ( resultSet.next() )
         {
            results.add( new Exhibit(
               resultSet.getInt( "EXHIBITID" ),
               resultSet.getString( "EXHIBITNAME" ),
               resultSet.getString( "DESCRIPTION" ),
               resultSet.getString( "LOCATION" ),
               resultSet.getFloat( "WEIGHT" ),
               resultSet.getFloat( "HEIGHT" ) ) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();// database exception handling
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();// database exception handling      
            close();
         } // end catch
      } // end finally
      return results;// 
   }//end method - displayExhibitsByHeightAndWeight()
   
   //Method to display total number of exhibits by Weight
   public int displayNoOfExhibitsByWeight( float weight )
   {
      int size = 0;
      List< Exhibit > results = null;
      ResultSet resultSet = null;

      try 
      {
         // Displays total number Exhibits having weight greater than specified Weight
         displayNoOfExhibitsByWeight = connection.createStatement();
         // Create a column called NoOfExhibits and stored the count(*) result in that column. then return that integer.
         resultSet = displayNoOfExhibitsByWeight.executeQuery("SELECT Count(*) as NoOfExhibits FROM Exhibits WHERE weight > " +weight); 
         resultSet.next();
         size = resultSet.getInt("NoOfExhibits");
      }// end try
      catch ( SQLException sqlException )
      {
            sqlException.printStackTrace();// database exception handling        
            close();
      }//end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();// database exception handling       
            close();
         } // end catch
      } // end finally
      
      return size;// return the number of exhibits having weight greater than specified weight
   }// end method - displayExhibitByWeight()
   
   //Method to close the database connection
   public void close()
   {
       try 
       {
          connection.close();// close the connection
       }// end try
       catch ( SQLException sqlException )
       {
          sqlException.printStackTrace();// database exception handling
       }// end catch
   }// end method - close()
}

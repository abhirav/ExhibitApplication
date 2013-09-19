/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhi
 */

public class Exhibit {
    private int exhibitId;
    private String exhibitname;
    private String description;
    private String location;
    private float weight;
    private float height;

    //default constructor
    public Exhibit()
    {
    } // end no-argument Person constructor

    // constructor with arguments
    public Exhibit( int exhibit_id, String exhibit_name, String exhibit_desc, 
       String exhibit_location, float exhibit_weight, float exhibit_height )
    {
       setExhibitId( exhibit_id);
       setExhibitname( exhibit_name );
       setDescription( exhibit_desc );
       setLocation( exhibit_location );
       setWeight( exhibit_weight );
       setHeight( exhibit_height );
    }
    
    //set Exhibit Id
    public void setExhibitId(int exhibitId) {
        this.exhibitId = exhibitId;
    }
    
    //return Exhibit Id
    public int getExhibitId() {
        return exhibitId;
    }
    
    //set Exhibit name
    public void setExhibitname(String exhibitname) {
        this.exhibitname = exhibitname;
    }
    
    //return Exhibit name
    public String getExhibitname() {
        return exhibitname;
    }
    
    //set description
    public void setDescription(String description) {
        this.description = description;
    }

    //return description
    public String getDescription() {
        return description;
    }
    
    //set location
    public void setLocation(String location) {
        this.location = location;
    }
    
    //return location
    public String getLocation() {
        return location;
    }

    //set weight
    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    //return weight
     public float getWeight() {
        return weight;
    }

     //set height
    public void setHeight(float height) {
        this.height = height;
    }

    //return height
    public float getHeight() {
        return height;
    }
} //end Exhibit class

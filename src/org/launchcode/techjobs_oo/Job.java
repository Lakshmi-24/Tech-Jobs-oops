package org.launchcode.techjobs_oo;

import java.sql.SQLOutput;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //System.out.println("line 38");
        if (o == null || getClass() != o.getClass()) return false;
        //System.out.println("line 40");
        Job job = (Job) o;
        //System.out.println("id="+this.id);
        //System.out.println("job.id=" + job.getId());
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String notAvailable = "Data not available";
        String emp ,loc,pos,comp,nm;
        try{
            emp=getEmployer().getValue();
            loc=getLocation().getValue();
            pos= getPositionType().getValue();
            comp= getCoreCompetency().getValue();
            nm =name;
            if(emp.equals("")){emp=notAvailable;}
            if(loc.equals("")){loc=notAvailable;}
            if(pos.equals("")){pos=notAvailable;}
            if(comp.equals("")){comp=notAvailable;}
            if(nm.equals("")){nm=notAvailable;}
        }
       catch (java.lang.NullPointerException exception){
           return "OOPS! This job does not seem to exist.";
       }
        //System.out.println(emp);
        return " \n" +
                "ID: " + getId() + "\n" +
                "Name: " + nm + "\n" +
                "Employer: " + emp + "\n" +
                "Location: " + loc + "\n" +
                "Position Type: " + pos + "\n" +
                "Core Competency: " + comp + "\n" +
                " \n";
    }

}

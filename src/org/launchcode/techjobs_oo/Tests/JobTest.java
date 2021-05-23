package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    Job test_Job1,test_Job2,test_Job3,test_Job4;

    @Before
    public void createJobObject() {
        test_Job1 = new Job();
        test_Job2 = new Job();
        test_Job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_Job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //System.out.println(test_Job1.getId()  );
    }


    @Test
    public void emptyTest(){
        Assert.assertTrue(true);
    }

    @Test
    public void testSettingJobId(){
        Assert.assertEquals(1,test_Job2.getId()-test_Job1.getId(),0.01);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
    Assert.assertTrue(test_Job3 instanceof Job);
    Assert.assertEquals(16,test_Job3.getId());
    Assert.assertEquals("Product tester",test_Job3.getName());
    Assert.assertEquals("ACME",test_Job3.getEmployer().getValue());
    Assert.assertEquals("Desert",test_Job3.getLocation().getValue());
    Assert.assertEquals("Quality control",test_Job3.getPositionType().getValue());
    Assert.assertEquals("Persistence",test_Job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Assert.assertFalse(test_Job3.equals(test_Job4));
    }
    @Test
    public void testToString(){
        String[] out = test_Job3.toString().split("\\r?\\n");
        Assert.assertEquals(" ",out[0]);
        Assert.assertEquals("ID: 11",out[1]);
        Assert.assertEquals("Name: Product tester",out[2]);
        Assert.assertEquals("Employer: ACME",out[3]);
        Assert.assertEquals("Location: Desert",out[4]);
        Assert.assertEquals("Position Type: Quality control",out[5]);
        Assert.assertEquals("Core Competency: Persistence",out[6]);
        Assert.assertEquals(" ",out[out.length-1]);
        Assert.assertEquals("OOPS! This job does not seem to exist.",test_Job1.toString());
        Job test_Job5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String[] output1 = test_Job5.toString().split("\\r?\\n");
        Assert.assertEquals(" ",output1[0]);
        Assert.assertEquals("ID: 13",output1[1]);
        Assert.assertEquals("Name: Data not available",output1[2]);
        Assert.assertEquals("Employer: Data not available",output1[3]);
        Assert.assertEquals("Location: Data not available",output1[4]);
        Assert.assertEquals("Position Type: Data not available",output1[5]);
        Assert.assertEquals("Core Competency: Data not available",output1[6]);
        Assert.assertEquals(" ",output1[out.length-1]);
    }

}

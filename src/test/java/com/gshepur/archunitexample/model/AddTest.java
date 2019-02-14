package com.gshepur.archunitexample.model;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {

    Add add = new Add();

    @Test
    public void testAdd(){

        Assert.assertEquals(4, add.add(2,2));
    }
}

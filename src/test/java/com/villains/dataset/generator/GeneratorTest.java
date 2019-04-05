package com.villains.dataset.generator;

import com.villains.dataset.model.CarFleet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GeneratorTest {

    private Generator generator;

    @Before
    public void setup() {
        generator = new Generator();
    }

    @Test
    public void generateDummyObjShouldReturnCarFleetObj() {
        CarFleet carFleet = generator.generateDummyObjFromJson("CarFleet.json", CarFleet.class);

        assertNotNull(carFleet);
        assertNotNull(carFleet.getCars());
        assertNotNull(carFleet.getCars().get(0).getEngine().getType());
    }

    @Test
    public void generateDummyObjShouldThrownIOExceptionAndReturnNull() {
        CarFleet carFleet = generator.generateDummyObjFromJson("BadCarFleet.json", CarFleet.class);

        assertNull(carFleet);
    }

}

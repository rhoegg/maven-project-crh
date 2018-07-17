package com.mulesoft.training;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase {

    @Test @Ignore
    public void mavenFlowReturnsFlights() throws Exception {
        runFlowAndExpect("retrieveFlights", "[[{\"DESTINATION\":\"SFO\",\"PRICE\":555,\"ORIGIN\":\"YYZ\",\"ID\":0},{\"DESTINATION\":\"LAX\",\"PRICE\":450,\"ORIGIN\":\"YYZ\",\"ID\":1},{\"DESTINATION\":\"SEA\",\"PRICE\":777,\"ORIGIN\":\"SQL\",\"ID\":2},{\"DESTINATION\":\"SFO\",\"PRICE\":999,\"ORIGIN\":\"SQL\",\"ID\":3}]]");
    }
    
    @Test
    public void retrieveFlightsAddsAppropriateHeader() throws Exception {
      MuleEvent event = runFlow("retrieveFlights");
      String contentType = event.getMessage().getOutboundProperty("Content-Type");
      assertEquals("application/json", contentType);
    }
    
    @Override
    protected String getConfigFile() {
        return "maven-project.xml";
    }

}

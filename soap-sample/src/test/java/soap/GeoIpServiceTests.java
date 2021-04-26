package soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        String ipLocation20 = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("109.252.201.163");
        assertEquals(ipLocation20.ge);
    }
}

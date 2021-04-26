package soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testGeoIpService() {
        String ipLocation20 = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("109.252.201.163");
        assertEquals(ipLocation20.getBytes(StandardCharsets.UTF_8), "RU");
    }

}

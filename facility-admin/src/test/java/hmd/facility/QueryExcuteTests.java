package hmd.facility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hmd.FacilityAdminApplication;
import hmd.service.FacilityService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FacilityAdminApplication.class)
public class QueryExcuteTests {

    @Autowired
    public FacilityService facilityService;

    @Test
    public void test() {
        System.out.println("test ============="+ facilityService.getFacilityTotalCount());
    }

}

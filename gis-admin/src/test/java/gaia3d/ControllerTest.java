package gaia3d;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hmd.controller.MainController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
@ContextConfiguration(classes={MainController.class})
public class ControllerTest {

	@Autowired
	private MockMvc mock;
	
	
	@Before
	public void before() {
		log.info("@@ before ");
	}
	
	@Test
	public void res() throws Exception {
		mock.perform(get("/gis/hello")).andExpect(status().isOk()).andReturn();
	}
	
	
}

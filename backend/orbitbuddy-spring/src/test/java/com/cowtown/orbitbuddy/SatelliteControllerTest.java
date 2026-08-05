package com.cowtown.orbitbuddy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.cowtown.orbitbuddy.controller.SatelliteController;
import com.cowtown.orbitbuddy.repository.SatelliteRepository;
import com.cowtown.orbitbuddy.service.TleParserService;
import com.cowtown.orbitbuddy.service.TleService;

@WebMvcTest(value = SatelliteController.class)
public class SatelliteControllerTest {
	
	@MockitoBean
	private SatelliteController satelliteController;
	
	@MockitoBean
	private TleService tleService;
	
	@MockitoBean
	private TleParserService tleParserService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSatellites() throws Exception {
		//when(satelliteController.thisIsTest()).thenReturn("This is not real");
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/orbitbuddy/satellites");
		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200,status);

}
}
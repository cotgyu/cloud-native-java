package com.example.cloudnativejava;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CloudNativeJavaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CatRepository catRepository;


	public void before() throws Exception{
		Stream.of("Felix", "Garfield", "Whiskers")
				.forEach(n -> catRepository.save(new Cat(n)));
	}


	@Test
	public void catsReflectedInRead() throws Exception{
		// charset 설정하는 곳이 없음.. 일단 주석
		//MediaType halJson = MediaType.parseMediaType("application/hal+json;charset=UTF-8");
		MediaType halJson = MediaType.parseMediaType("application/hal+json");


		this.mockMvc
				.perform(get("/cats"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(halJson))
				.andExpect(
						mvcResult -> {
							String contentAsString = mvcResult.getResponse().getContentAsString();

							assertThat(contentAsString.split("totalElements")[1].split(":")[1].trim().split(",")[0].equals("3"));
						}
				);
	}
}

package br.com.vizir.telzir.falemais.rest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseRestControllerTest {

  @LocalServerPort
  private int porta;

  @Before
  public void init() {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = porta;
  }
}

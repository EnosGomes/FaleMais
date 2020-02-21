package br.com.vizir.telzir.falemais.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.apache.http.HttpStatus;
import org.junit.Test;

import io.restassured.http.ContentType;

public class LigacaoRestControllerTest extends BaseRestControllerTest {

  private static final String API_PATH = "/api/ligacoes";

  @Test
  public void quandoObterTodasOrigensDistintas_retornaQuatroOrigens() {

    Collection<?> origens = given().when().contentType("application/json").get(API_PATH + "/origens").then()
        .statusCode(is(HttpStatus.SC_OK)).assertThat().contentType(ContentType.JSON).extract().as(Collection.class);

    assertThat(origens.size(), is(4));
  }

}

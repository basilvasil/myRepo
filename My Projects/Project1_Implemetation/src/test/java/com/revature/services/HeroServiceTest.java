package com.revature.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.models.Hero;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HeroServiceTest {
    HeroService service;
    ObjectMapper mapperMock;
    ObjectWriter writerMock;
    HttpServletRequest requestMock;
    HttpServletResponse responseMock;
    List<Hero> heroList;
    ServletOutputStream outputStreamMock;
    String json;
    @Before
    public void setUp() {

        mapperMock = Mockito.mock(ObjectMapper.class);
        writerMock = Mockito.mock(ObjectWriter.class);
        requestMock = Mockito.mock(HttpServletRequest.class);
        responseMock = Mockito.mock(HttpServletResponse.class);
        outputStreamMock = Mockito.mock(ServletOutputStream.class);
        service = new HeroService();
        heroList = new ArrayList<>();
        json = "json";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllHeroes() throws IOException {
        heroList.add(new Hero());
        when(mapperMock.writerWithDefaultPrettyPrinter()).thenReturn(writerMock);
        when(mapperMock.writerWithDefaultPrettyPrinter().writeValueAsString(heroList)).thenReturn(json);
        when(responseMock.getOutputStream()).thenReturn(outputStreamMock);

        service.getAllHeroes(requestMock, responseMock);

        // verify acts as an assertion confirming that the response code was added successfully
        verify(responseMock).setStatus(HttpServletResponse.SC_OK);
        verify(outputStreamMock).print(json);
    }

    @Test
    public void updateHero() throws IOException {
        heroList.add(new Hero());
        when(mapperMock.writerWithDefaultPrettyPrinter()).thenReturn(writerMock);
        when(mapperMock.writerWithDefaultPrettyPrinter().writeValueAsString(heroList)).thenReturn(json);
        when(responseMock.getOutputStream()).thenReturn(outputStreamMock);

        service.updateHero(requestMock, responseMock);

        // verify acts as an assertion confirming that the response code was added successfully
        verify(responseMock).setStatus(HttpServletResponse.SC_OK);
        verify(outputStreamMock).print(json);
    }

    @Test
    public void deleteHero() throws IOException {
        heroList.add(new Hero());
        when(mapperMock.writerWithDefaultPrettyPrinter()).thenReturn(writerMock);
        when(mapperMock.writerWithDefaultPrettyPrinter().writeValueAsString(heroList)).thenReturn(json);
        when(responseMock.getOutputStream()).thenReturn(outputStreamMock);
        service.deleteHero(requestMock, responseMock);
        verify(responseMock).setStatus(HttpServletResponse.SC_OK);
        verify(outputStreamMock).print(json);
    }
}

package com.aq.soft.avalith.developer;

import com.aq.soft.avalith.developer.controller.DeveloperController;
import com.aq.soft.avalith.developer.entity.DeveloperEntity;
import com.aq.soft.avalith.developer.servicio.DeveloperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.MimeTypeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
;

/**
 * @author aquingaluisa
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DeveloperController.class)
public class TestDeveloper {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DeveloperService developerService;


    /**
     * Buscar developers
     * @throws Exception
     */
    @Test
    public void buscaDeveloper() throws Exception {

        DeveloperEntity developerEntity = new DeveloperEntity().builder()
                .nombreCompletos("Angel Quingaluisa")
                .linkGitHub("http://linkedLink/aquingaluisa")
                .build();
        developerEntity.setId(1);
        List<DeveloperEntity> developerEntityList = Arrays.asList(developerEntity);

        given(developerService.findAllDeveloperList()).willReturn(developerEntityList);


        mvc.perform(get("/developers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andReturn();
    }

    /**
     * Buscar developers
     * @throws Exception
     */
    @Test
    public void insertarDeveloper() throws Exception {

        DeveloperEntity developerEntity = new DeveloperEntity().builder()
                .nombreCompletos("Angel Quingaluisa")
                .linkGitHub("http://linkedLink/aquingaluisa")
                .build();
        developerEntity.setId(1);
        List<DeveloperEntity> developerEntityList = Arrays.asList(developerEntity);

        given(developerService.findAllDeveloperList()).willReturn(developerEntityList);


        mvc.perform(post("/developers")
                .content("{\n" +
                        "\"nombres_completos\": \"Yoconda Suarez\",\n" +
                        "\"link_github\": \"www.google.com\",\n" +
                        "\"tecnologias_conocidas\": [\"tecnologia-uno\"]\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}

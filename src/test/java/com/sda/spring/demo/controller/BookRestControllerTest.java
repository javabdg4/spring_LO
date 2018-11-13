package com.sda.spring.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.Person;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void should_create_new_category_when_try_to_update() throws Exception {

        given(categoryService.getCategoryById(20L)).willReturn(null);
        Category category = new Category("Fantastyka");

        ResultActions resultActions = mockMvc.perform(put("/api/category/10")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(category)));
        resultActions.andExpect(status().isNoContent());

    }


    @Test
    public void should_update_category() throws Exception {

        Category category = new Category("Dokument");
        category.setId(100L);

        given(categoryService.getCategoryById(100L)).willReturn(category);
        ResultActions resultActions = mockMvc.perform(put("/api/category/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(category)));

        resultActions.andExpect(status().isNoContent());

        Category cat = categoryService.getCategoryById(100L);
        Assertions.assertThat(cat).isNotNull();
        Assertions.assertThat(cat.getName()).isEqualTo("Dokument");


    }


    @Test
    public void givenCategories_whenGetCategories_thenReturnJsonArray() throws Exception{

        Category category = new Category("Fantastyka");
        Category category1 = new Category("Dokument");
        Category category2 = new Category("Si-Fi");

        List<Category> categories = Arrays.asList(category, category1, category2);

        given(categoryService.getCategories()).willReturn(categories);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

        MockHttpServletResponse response = resultActions.andReturn().getResponse();

        System.out.println(response.getContentAsString());

        verify(categoryService, VerificationModeFactory.times(1)).getCategories();

    }

}
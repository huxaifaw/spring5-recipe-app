package zaifi.springframework.spring5recipeapp.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import zaifi.springframework.spring5recipeapp.domain.Recipe;
import zaifi.springframework.spring5recipeapp.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class IndexControllerTest {
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;

    @Before
    @Deprecated
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {

        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe1);
        recipeSet.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipeSet);

        String viewName = indexController.getIndexPage(model);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> recipeSetController = argumentCaptor.getValue();
        assertEquals(2, recipeSetController.size());
    }
}
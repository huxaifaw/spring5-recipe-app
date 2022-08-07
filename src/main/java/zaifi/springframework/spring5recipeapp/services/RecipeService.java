package zaifi.springframework.spring5recipeapp.services;

import zaifi.springframework.spring5recipeapp.commands.RecipeCommand;
import zaifi.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long l);
    void deleteById(Long l);
}

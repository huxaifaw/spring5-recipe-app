package zaifi.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zaifi.springframework.spring5recipeapp.domain.Category;
import zaifi.springframework.spring5recipeapp.domain.UnitOfMeasure;
import zaifi.springframework.spring5recipeapp.repositories.CategoryRepository;
import zaifi.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        System.out.println("Using Intellij Developer Tools!!!");
        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category ID is " + category.get().getId());
        System.out.println("UnitOfMeasure ID is " + unitOfMeasure.get().getId());

        return "index";
    }
}

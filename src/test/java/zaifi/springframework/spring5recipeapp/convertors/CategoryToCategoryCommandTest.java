package zaifi.springframework.spring5recipeapp.convertors;

import org.junit.Before;
import org.junit.Test;
import zaifi.springframework.spring5recipeapp.commands.CategoryCommand;
import zaifi.springframework.spring5recipeapp.domain.Category;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryToCategoryCommand convertor;

    @Before
    public void setUp() throws Exception {
        convertor = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(convertor.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convertor.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = convertor.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());

    }

}
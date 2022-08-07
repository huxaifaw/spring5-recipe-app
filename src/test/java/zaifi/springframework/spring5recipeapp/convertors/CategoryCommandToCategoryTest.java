package zaifi.springframework.spring5recipeapp.convertors;

import org.junit.Before;
import org.junit.Test;
import zaifi.springframework.spring5recipeapp.commands.CategoryCommand;
import zaifi.springframework.spring5recipeapp.domain.Category;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory convertor;

    @Before
    public void setUp() throws Exception {
        convertor = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(convertor.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convertor.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = convertor.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

}
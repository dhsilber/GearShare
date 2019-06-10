package name.davidsilber.theater.share;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TemplateViewControllers.class, secure = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageContentTests {

    @Autowired
    private MockMvc mockMvc;

    MvcResult result;

    @BeforeAll
    public void setup() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/main")
                .accept(MediaType.TEXT_HTML);

        result = mockMvc
                .perform(requestBuilder)
                .andReturn();

//        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");
    }

    @Test

    public void mainPageTitle() throws Exception {
        String title = "<title>GearShare for David Silber</title>";
        assertTrue(result.getResponse().getContentAsString().contains(title));
    }

    @Test
    public void mainPageIncludesRequestForm() throws Exception {
        assertTrue(result.getResponse().getContentAsString().contains("<form action=\"/request\" method=\"post\">"));
    }

    @Test
    public void mainPageIncludesStartDateInput() throws Exception {
        assertTrue(result.getResponse().getContentAsString().contains("<input type=\"date\" name=\"start\"/>"));
    }

    @Test
    public void mainPageIncludesEndDateInput() throws Exception {
        assertTrue(result.getResponse().getContentAsString().contains("<input type=\"date\" name=\"end\"/>"));
    }

    @Test
    public void mainPageIncludesGearTable() throws Exception {
        assertTrue(result.getResponse().getContentAsString().contains("<table"));
    }

    @Test
    public void mainPageIncludesInstructions() throws Exception {
        String instructions = "elect the items you wish to borrow";
        assertTrue(result.getResponse().getContentAsString().contains(instructions));
    }

    @Test
    public void mainPageIncludesSubmitButton() throws Exception {
        String button = "<input type=\"submit\" value=\"Send Request\"/>";
        assertTrue(result.getResponse().getContentAsString().contains(button));
    }


}


package name.davidsilber.theater.share;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TemplateViewControllers.class, secure = false)
public class TemplateViewControllersTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void rootDisplaysIndexPage() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.TEXT_HTML);

        MvcResult result = mockMvc
                .perform(requestBuilder)
                .andReturn();

//        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");

        assertTrue(result.getResponse().getContentAsString().contains("GearShare"));
    }

    @Test
    public void adminDisplaysIndexPage() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/admin")
                .accept(MediaType.TEXT_HTML);

        MvcResult result = mockMvc
                .perform(requestBuilder)
                .andReturn();

//        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");

        assertTrue(result.getResponse().getContentAsString().contains("GearShare Global Settings"));
    }
}


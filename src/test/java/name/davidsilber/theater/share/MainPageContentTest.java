package name.davidsilber.theater.share;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TemplateViewControllers.class, secure = false)
public class MainPageContentTest {

    @Autowired
    private MockMvc mockMvc;

    MvcResult result;

    @BeforeEach
    public void setup() throws Exception {
        System.out.println("Beginning------------");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.TEXT_HTML);

        result = mockMvc
                .perform(requestBuilder)
                .andReturn();

        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");
    }

    @Test
    public void mainPageIncludesLoginFormTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.TEXT_HTML);

        result = mockMvc
                .perform(requestBuilder)
                .andReturn();

        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");
        assertTrue(result.getResponse().getContentAsString().contains("<form action=\"/login\" method=\"post\">"));
    }

    @Test
    public void mainPageIncludesUserNameInputtest() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/")
//                .accept(MediaType.TEXT_HTML);
//
//        result = mockMvc
//                .perform(requestBuilder)
//                .andReturn();
//
//        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");
        assertTrue(result.getResponse().getContentAsString().contains("<input type=\"text\" name=\"username\"/>"));
    }

    @Test
    public void testmainPageIncludesPasswordInput() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/")
//                .accept(MediaType.TEXT_HTML);
//
//        result = mockMvc
//                .perform(requestBuilder)
//                .andReturn();
//
//        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");
        assertTrue(result.getResponse().getContentAsString().contains("<input type=\"password\" name=\"password\"/>"));
    }
}


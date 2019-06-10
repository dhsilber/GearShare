package name.davidsilber.theater.share;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
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
public class RootPageContentTests {

    @Autowired
    private MockMvc mockMvc;

    MvcResult result;

    @BeforeAll
    public void setup() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.TEXT_HTML);

        result = mockMvc
                .perform(requestBuilder)
                .andReturn();

//        System.out.println("Start:"+ result.getResponse().getContentAsString()+":End");
    }

    @Test
    public void mainPageIncludesLoginForm() throws Exception {
        assertTrue(result.getResponse().getContentAsString().contains("<form action=\"/login\" method=\"post\">"));
    }

    @Test
    public void mainPageIncludesUserNameInput() throws Exception {
        assertTrue(result.getResponse().getContentAsString().contains("<input type=\"text\" name=\"username\"/>"));
    }

    @Test
    public void mainPageIncludesPasswordInput() throws Exception {
        assertTrue(result.getResponse().getContentAsString().contains("<input type=\"password\" name=\"password\"/>"));
    }

    @Test
    public void mainPageIncludesProgramIntroText() throws Exception {
        String programIntro = "his is an instance of GearShare";
        assertTrue(result.getResponse().getContentAsString().contains(programIntro));
    }

    @Test
    public void mainPageIncludesGitHubUrl() throws Exception {
        String githubUrl = "https://github.com/dhsilber/GearShare";
        assertTrue(result.getResponse().getContentAsString().contains(githubUrl));
    }

    @Test
    public void mainPageIncludesExplanationText() throws Exception {
        String explanation = "for sharing theatrical gear";
        assertTrue(result.getResponse().getContentAsString().contains(explanation));
    }
}


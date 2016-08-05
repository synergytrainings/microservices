import com.synisys.idm.bookstoreservice.BookstoreApplication;
import com.synisys.idm.bookstoreservice.endpoint.controller.BookServiceController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ashot.karapetyan on 8/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:test-config.xml")
@WebAppConfiguration
@SpringApplicationConfiguration(classes = BookstoreApplication.class)
public class BookServiceControllerTest {
	@Rule
	public RestDocumentation restDocumentation = new RestDocumentation("build/generated-snippets");

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;


	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation))
				.build();

	}

	@Test
	public void test()
			throws Exception {

		FieldDescriptor[] book = new FieldDescriptor[] {
				fieldWithPath("id").description("Title of the book"),
				fieldWithPath("title").description("Title of the book"),
				fieldWithPath("author").description("Author of the book") };

		this.mockMvc.perform(get("/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(document("book", responseFields(book)));

	}
}

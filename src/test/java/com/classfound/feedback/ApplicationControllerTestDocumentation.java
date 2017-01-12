package com.classfound.feedback;

import com.classfound.feedback.controller.ApplicationController;
import com.classfound.feedback.model.ApplicationModel;
import com.classfound.feedback.service.ApplicationService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by philic3 on 12/14/2016.
 */
@RunWith(SpringRunner.class)
public class ApplicationControllerTestDocumentation {

    /*@Autowired
    private WebApplicationContext context;*/

    @Mock
    private ApplicationService applicationService;

    @InjectMocks
    private ApplicationController applicationController;

    private MockMvc mockMvc;

    @Rule
    public JUnitRestDocumentation restDocumentation =
            new JUnitRestDocumentation  ("target/generated-snippets");

    /**
     * Set up MockMVC
     */
    @Before
    public void setUp(){
        /*this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();*/
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(applicationController)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void registerApplicationTest() throws Exception {
        ApplicationModel applicationStub = new ApplicationModel("mockMvc", "key", "owner" );
        doNothing().when(applicationService).registerApplication(applicationStub);
        Gson gson = new Gson();
        String applicationJson = gson.toJson(applicationStub);
        this.mockMvc.perform(post("/api/v1/application/register")
                .content(applicationJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("application"));
    }

    private static FieldDescriptor[] applicationFields(boolean isJsonArray) {
        return isJsonArray ?
                new FieldDescriptor[]{
                        fieldWithPath("[]").description("Application List"),
                        fieldWithPath("[].name").description("Application Name"),
                        fieldWithPath("[].key").description("Application Key"),
                        fieldWithPath("[].owner").description("Application Owner")
                } :
                new FieldDescriptor[]{
                        fieldWithPath("[].name").description("Application Name"),
                        fieldWithPath("[].key").description("Application Key"),
                        fieldWithPath("[].owner").description("Application Owner")
                };
    }

    /**
     * Pretty print request and response
     *
     * @param useCase the name of the snippet
     * @return RestDocumentationResultHandler
     */
    private RestDocumentationResultHandler documentPrettyPrintReqResp(String useCase) {
        return document(useCase,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()));
    }
}

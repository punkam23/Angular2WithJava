package javaee.demo.angular2.test.web;

import javaee.demo.angular2.model.DavisCup;
import javaee.demo.angular2.service.DavisService;
import javaee.demo.angular2.web.DavisController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by Yehoshua on 28.01.17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DavisController.class })
public class DavisControllerTest {

    @MockBean
    private DavisService davisService;

    @Autowired
    private MockMvc mvc;

    @Test
    @Ignore
    public void resultListTest() throws Exception {

        String expectedResult = "[{\"year\":2015,\"winner\":\"Yosh Team\"}]";
        given(this.davisService.getResultList()).willReturn(mockedDavisData());

        this.mvc.perform(get("/result_list"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResult));

    }

    @Test
    @Ignore
    public void resultYearTest() throws Exception {

        String expectedResult = "{\"year\":2015,\"winner\":\"Yosh Team\"}";
        given(this.davisService.getResultForYear(any())).willReturn(mockedDavisData().get(0));

        this.mvc.perform(get("/result_year"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResult));

    }

    private List<DavisCup> mockedDavisData() {

        List<DavisCup> davisCupMockedList = new ArrayList<>();
        DavisCup davisCup = new DavisCup(2015, "Yosh Team", "Peter Team", "3-2");

        davisCupMockedList.add(davisCup);

        return davisCupMockedList;

    }
}

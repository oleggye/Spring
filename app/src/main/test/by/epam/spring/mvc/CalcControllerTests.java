package by.epam.spring.mvc;

import org.springframework.web.servlet.ModelAndView;

import by.epam.spring.mvc.controller.CalcController;
import junit.framework.TestCase;

public class CalcControllerTests extends TestCase {

	public void testHandleRequestView() throws Exception{		
        CalcController controller = new CalcController();
        ModelAndView modelAndView = controller.calculate(1, 2);		
        assertEquals("displaySum", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String sum = (String) modelAndView.getModel().get("sum");
        assertNotNull(sum);
    }
}

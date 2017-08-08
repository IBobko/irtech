package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import ru.irtech.view.ExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Controller
@RequestMapping("/chart")
public class ChartPageController extends AbstractController {
    /**
     * Returns template of test chart.
     *
     * @return Tenplate of test chart.
     */
    @RequestMapping("")
    public String index() {
        return "chart/index";
    }

    /**
     * Downloads xlsx file containing data and chart.
     */
    @RequestMapping(value = "/export")
    @Override
    protected ModelAndView handleRequestInternal(final HttpServletRequest request,
                                                 final HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "inline; filename=\"export.xlsx\"");
        String output =
                ServletRequestUtils.getStringParameter(request, "output");

        //dummy data
        Map<String, String> revenueData = new HashMap<String, String>();
        revenueData.put("Jan-2010", "$100,000,000");
        revenueData.put("Feb-2010", "$110,000,000");
        revenueData.put("Mar-2010", "$130,000,000");
        revenueData.put("Apr-2010", "$140,000,000");
        revenueData.put("May-2010", "$200,000,000");

        //return excel view
        return new ModelAndView(new ExcelView(), "revenueData", revenueData);

        }

    }

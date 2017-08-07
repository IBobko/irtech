package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Controller to show latency.
 */
@RequestMapping("/latency")
@Controller
public class LatencyController {
    /**
     * Object for working with db.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Main page of latency.
     *
     * @return Text which provided users.
     */
    @RequestMapping("")
    public String index() {
        return "latency/index";

    }

    /**
     * bygrades page.
     *
     * @return template name.
     */
    @RequestMapping("bygrades")
    public String indexgrades() {
        return "latencybygrades/index";

    }

    /**
     *  Row data for latency.
     *
     * @return response.
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/raw_data.csv", produces = "text/plain")
    @ResponseBody
    public String rowData() {
        final Query query = entityManager.createNativeQuery("\n"
                + "SELECT AVG(latency),name, s.schoolnumber FROM irtech_ass_latency ass"
                + " INNER JOIN SUBJECTGROUPS sg ON sg.ID = ass.SGID"
                + " INNER JOIN SUBJECTS sb ON sb.SUBJECTID = sg.SUBJECTID"
                + " INNER JOIN GLOBALSUBJECTS gs ON gs.GLOBALSUBJID = sb.GLOBALSUBJID"
                + " INNER JOIN SCHOOLS s ON s.SCHOOLID = sb.SCHOOLID"
                + " WHERE s.schoolnumber = '3377' GROUP BY name,sb.SCHOOLID,s.schoolnumber ORDER BY AVG(latency) DESC");
        query.setParameter(1, 3377);

        final List<Object[]> results = query.getResultList();
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Question,1,2,3,4,5,N\n");
        for (final Object[] row : results) {
            if (row[0] != null) {
                int number = (int) Double.parseDouble(row[0].toString());
                stringBuilder.append(row[1].toString()).append(",0,0,0,0").append(number).append(",").append(number).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}

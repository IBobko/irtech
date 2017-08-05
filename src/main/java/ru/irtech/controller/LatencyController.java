package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RequestMapping("/latency")
@Controller
public class LatencyController {
    /**
     * Main page of latency
     *
     * @return Text which provided users.
     */
    @RequestMapping("")
    public String index() {
        return "latency/index";

    }
    @RequestMapping("bygrades")
    public String indexgrades() {
        return "latencybygrades/index";

    }

    /**
     * Object for working with db.
     */
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/raw_data.csv", produces = "text/plain")
    @ResponseBody
    public String row_data() {
//        String ss = "Question,1,2,3,4,5,N\n" +
//                "Question 1,0,0,0,0,2,2\n" +
//                "Question 2,0,0,0,0,2,2\n" +
//                "Question 3,0,0,0,0,2,2\n" +
//                "Question 4,0,0,0,0,2,2\n" +
//                "Question 5,0,0,0,0,2,2\n" +
//                "Question 6,0,0,0,0,2,2\n" +
//                "Question 7,0,0,0,0,2,2\n" +
//                "Question 8,0,0,0,0,2,2";
//        return ss;


//        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final Query query = entityManager.createNativeQuery("\n"
                + "select AVG(latency),name, s.schoolnumber from irtech_ass_latency ass\n" +
                "  inner join SUBJECTGROUPS sg on sg.ID=ass.SGID\n" +
                "  inner join SUBJECTS sb on sb.SUBJECTID=sg.SUBJECTID\n" +
                "  inner join GLOBALSUBJECTS gs on gs.GLOBALSUBJID=sb.GLOBALSUBJID\n" +
                "  inner join SCHOOLS s on s.SCHOOLID=sb.SCHOOLID\n" +
                "\n" +
                "WHERE s.schoolnumber = '3377' GROUP BY name,sb.SCHOOLID,s.schoolnumber ORDER BY AVG(latency) DESC");

        //WHERE s.schoolnumber = '3347'

        final List<Object[]> results = query.getResultList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Question,1,2,3,4,5,N\n");
        for (final Object[] o: results) {
            if (o[0]!=null)
            stringBuilder.append(o[1].toString()).append(",0,0,0,0").append((int) Double.parseDouble(o[0].toString()) + "," + (int) Double.parseDouble(o[0].toString())).append("\n");
        }
        return stringBuilder.toString();
    }
}

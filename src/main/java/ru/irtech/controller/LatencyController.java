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

    /**
     * Object for working with db.
     */
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping("/raw_data.csv")
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
                + "select AVG(latency),name,s.schoolnumber from irtech_ass_latency ass\n" +
                "  inner join SUBJECTGROUPS sg on sg.ID=ass.SGID\n" +
                "  inner join SUBJECTS sb on sb.SUBJECTID=sg.SUBJECTID\n" +
                "  inner join GLOBALSUBJECTS gs on gs.GLOBALSUBJID=sb.GLOBALSUBJID\n" +
                "  inner join SCHOOLS s on s.SCHOOLID=sb.SCHOOLID\n" +
                "\n" +
                "GROUP BY name,sb.SCHOOLID,s.schoolnumber ORDER BY AVG(latency) DESC");
        final List<Object[]> results = query.getResultList();
        final List<String> sc = new ArrayList<>();
        for (final Object[] o: results) {
            sc.add(o.toString());
        }
        return results;
    }
}

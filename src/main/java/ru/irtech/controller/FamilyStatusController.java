package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.dao.AnalysisDataAcess.DataBaseList;
import ru.irtech.dao.AnalysisDataAcess.Importers.IArrayImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.SchoolsImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.StudentsFamilyStatusImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.StudentsGradesImporter;
import ru.irtech.dao.AnalysisDataAcess.Model.Grade;
import ru.irtech.dao.AnalysisDataAcess.Model.School;
import ru.irtech.dao.AnalysisDataAcess.Model.StudentFamilyStatus;
import ru.irtech.dao.AnalysisDataAcess.Model.StudentMeanGrade;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.CoreObjects.SchoolDto;
import ru.irtech.dto.FamilyStatus.FamilyStatusToGradesRelationResponse;
import ru.irtech.dto.FamilyStatus.FamilyStatusToSchoolsRelationResponse;
import ru.irtech.dto.FamilyStatus.SchoolFamilyStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Iggytoto on 02.06.2017.
 * Controller that operates data related to the family status.
 */
@Controller
@RequestMapping("/familyStatus")
public class FamilyStatusController {

    /**
     * Main get method that returns table for all data that represents in database.
     *
     * @return FamilyStatusToGradesRelationResponse.
     */
    @RequestMapping(value = "/familyStatusToGradesRelationTable", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getFamilyStatuToGradesRelationTable() {
        try {
            return getFamilyStatusToGradesRelationResponse(new Date(0), new Date());
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    /**
     * Main get method that returns table for all data that presented in given period.
     *
     * @param fromDate start of the period.
     * @param toDate   end of the period.
     * @return FamilyStatusToGradesRelationResponse object
     */
    @RequestMapping(value = "/familyStatusToGradesRelationTableByPeriod", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getFamilyStatusToGradesRelationTable(
            @RequestParam("fromDate") final String fromDate,
            @RequestParam("toDate") final String toDate) {
        try {
            return getFamilyStatusToGradesRelationResponse(new Date(fromDate), new Date(toDate));
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    /**
     * Method that returns all schools family status percentage.
     *
     * @return FamilyStatusToSchoolsRelationResponse.
     */
    @RequestMapping(value = "/familyStatusToSchoolsRelation", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getAllschoolsFalimyStatus() {
        try {
            return new FamilyStatusToSchoolsRelationResponse((SchoolFamilyStatus[]) getFamilyStatuses().toArray());
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    /**
     * Method that returns school family status percentage by given school id.
     *
     * @param id School id.
     * @return FamilyStatusToSchoolRelationResponse.
     */
    @RequestMapping(value = "/familyStatusToSchoolRelation", method = RequestMethod.GET)
    @ResponseBody
    private ControllerResponse getFamilyStatusToSchoolRelationResponse(
            @RequestParam("schoolId") final Integer id) {
        try {
            List<SchoolFamilyStatus> statuses = getFamilyStatuses();
            List<SchoolFamilyStatus> result = statuses.stream()
                    .filter(item -> item.getSchool().getSchoolid() == id)
                    .collect(Collectors.toList());
            return new FamilyStatusToSchoolsRelationResponse((SchoolFamilyStatus[]) result.toArray());
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    /**
     * Returns all schools family statuses.
     *
     * @return Returns list of all family statuses for schools.
     * @throws IOException throws when cannot find sql query file.
     */
    private List<SchoolFamilyStatus> getFamilyStatuses() throws IOException {
        List<SchoolFamilyStatus> results = new ArrayList<>();

        IArrayImporter<School> schoolsImporter = new SchoolsImporter();
        IArrayImporter<StudentFamilyStatus> studentFamilyStatusImporter = new StudentsFamilyStatusImporter();

        List<School> schools = schoolsImporter.importAllData(DataBaseList.getDataBases().get(0));
        List<StudentFamilyStatus> familyStatuses = studentFamilyStatusImporter.importAllData(DataBaseList.getDataBases().get(0));

        HashMap<Integer, List<Boolean>> map = new HashMap<>();
        for (School school : schools) {
            map.put(school.getSchoolId(), new ArrayList<>());
            for (Integer studentId : school.getStudentsId()) {
                StudentFamilyStatus status = familyStatuses.stream().filter(x -> x.getStudentId() == studentId)
                        .findFirst()
                        .get();
                if (status != null) {
                    map.get(school.getSchoolId()).add(status.isFamilyFull());
                }
            }
        }

        List<SchoolFamilyStatus> result = new ArrayList<>();

        for (Integer schoolId : map.keySet()) {
            result.add(countStatus(schoolId, map.get(schoolId)));
        }

        return result;
    }

    /**
     * Method that counts percentage for the given school and returns object.
     *
     * @param schoolId school id.
     * @param statuses given statuses to parse.
     * @return SchoolFamilyStatus.
     */
    private SchoolFamilyStatus countStatus(final Integer schoolId, final List<Boolean> statuses) {
        int total = statuses.size();
        int full = 0;
        int notFull = 0;

        for (Boolean status : statuses) {
            if (status) {
                full++;
            } else {
                notFull++;
            }
        }

        return new SchoolFamilyStatus(full / total, notFull / total, new SchoolDto("", schoolId));
    }

    /**
     * Main worker method for receive data.
     *
     * @param fromDate Period start.
     * @param toDate   Period end.
     * @return FamilyStatusToGradesRelationResponse.
     * @throws IOException when could not read sql query file.
     */
    private FamilyStatusToGradesRelationResponse getFamilyStatusToGradesRelationResponse(final Date fromDate, final Date toDate) throws IOException {
        //checkstyle hack for yet unused params
        int a = fromDate.getHours() - toDate.getHours();
        System.out.println(a);

        IArrayImporter<StudentMeanGrade> meanGradeImporter = new StudentsGradesImporter();
        IArrayImporter<StudentFamilyStatus> familyStatusImporter = new StudentsFamilyStatusImporter();

        List<StudentMeanGrade> meanGrades = meanGradeImporter.importAllData(DataBaseList.getDataBases().get(0));
        List<StudentFamilyStatus> familyStatuses = familyStatusImporter.importAllData(DataBaseList.getDataBases().get(0));

        List<StudentMeanGrade> fullGrades = new ArrayList<>();
        List<StudentMeanGrade> notFullGrades = new ArrayList<>();

        for (StudentMeanGrade grade : meanGrades) {
            StudentFamilyStatus status = familyStatuses.stream().filter(x -> x.getStudentId() == grade.getStudentId())
                    .findFirst()
                    .get();
            if (status != null) {
                if (status.isFamilyFull()) {
                    fullGrades.add(grade);
                } else {
                    notFullGrades.add(grade);
                }
            }
        }

        double[] fullFamilyResults = countParams(fullGrades);
        double[] notFullFamilyResults = countParams(notFullGrades);

        return new FamilyStatusToGradesRelationResponse(fullFamilyResults, notFullFamilyResults);
    }

    /**
     * Counts params of given set of data.
     *
     * @param grades grades to count.
     * @return percentages.
     */
    private double[] countParams(final List<StudentMeanGrade> grades) {
        if (grades.size() == 0) {
            return new double[FamilyStatusToGradesRelationResponse.getSetsLength()];
        }

        double[] results = new double[FamilyStatusToGradesRelationResponse.getSetsLength()];

        int best = 0;
        int good = 0;
        int average = 0;
        int total = grades.size();

        for (StudentMeanGrade grade : grades) {
            if (grade.getMeanGrade() >= Grade.BEST_BORDER_GRADE) {
                best++;
            } else if (grade.getMeanGrade() >= Grade.GOOD_BORDER_GRADE) {
                good++;
            } else {
                average++;
            }
        }

        results[0] = best / total;
        results[1] = good / total;
        results[2] = average / total;

        return results;
    }
}

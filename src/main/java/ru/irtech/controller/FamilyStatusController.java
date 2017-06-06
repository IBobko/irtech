package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.FamilyStatus.FamilyStatusToGradesRelationResponse;
import ru.irtech.dto.FamilyStatus.FamilyStatusToSchoolsRelationResponse;

import java.util.Date;

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
     * @return
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
     * Main get method that returns table for all data that presetned in given period.
     *
     * @param fromDate start of the period.
     * @param toDate   end of the period.
     * @return  FamilyStatusToGradesRelationResponse object
     */
    @RequestMapping(value = "/familyStatusToGradesRelationTableByPeriod", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getFamilyStatusToGradesRelationTable(
            @RequestParam("fromDate") String fromDate,
            @RequestParam("toDate") String toDate) {
        try {
            return getFamilyStatusToGradesRelationResponse(new Date(fromDate), new Date(toDate));
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    /**
     * Method that returns all schools family status percentage
     *
     * @return
     */
    public ControllerResponse getAllschoolsFalimyStatus(){
        try{
            return getFamilyStatusToSchoolsRelationResponse();
        }
        catch (Exception e){
           return new ControllerResponse(e.getMessage());
        }
    }

    private FamilyStatusToSchoolsRelationResponse getFamilyStatusToSchoolsRelationResponse() {
    }

    /**
     * Main worker method for receive data
     *
     * @param fromDate Period start
     * @param fromDate Period end
     */
    private FamilyStatusToGradesRelationResponse getFamilyStatusToGradesRelationResponse(final Date fromDate, final Date toDate) {
        double[] fullFamilyResults = new double[]{0.33, 0.33, 0.33};
        double[] notFullFamilyResults = new double[]{0.33, 0.33, 0.33};

        return new FamilyStatusToGradesRelationResponse(fullFamilyResults, notFullFamilyResults);
    }
}

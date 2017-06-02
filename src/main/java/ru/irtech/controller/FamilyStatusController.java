package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.FamilyStatusToGradesRelationResponse;

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
            return getResponse(new Date(0), new Date());
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/familyStatusToGradesRelationTableByPeriod", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getFamilyStatusToGradesRelationTable(
            @RequestParam("fromDate") String fromDate,
            @RequestParam("toDate") String toDate) {

        try {
            return getResponse(new Date(fromDate), new Date(toDate));
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    /**
     * Main worker method for receive data
     *
     * @param fromDate Period start
     * @param fromDate Period end
     */
    private FamilyStatusToGradesRelationResponse getResponse(final Date fromDate, final Date toDate) {
        double[] fullFamilyResults = new double[]{0.33, 0.33, 0.33};
        double[] notFullFamilyResults = new double[]{0.33, 0.33, 0.33};

        return new FamilyStatusToGradesRelationResponse(fullFamilyResults, notFullFamilyResults);
    }
}

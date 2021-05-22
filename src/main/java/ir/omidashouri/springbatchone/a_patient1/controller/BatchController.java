package ir.omidashouri.springbatchone.a_patient1.controller;

import ir.omidashouri.springbatchone.a_patient1.services.ExecuteJobs;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/batch")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BatchController {

    private final ExecuteJobs executeJobs;

    //    http://localhost:8080/batch/job
    @GetMapping("/job")
    public ModelAndView securityContext() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        executeJobs.executeJob1();
        return new ModelAndView("bank");
    }
}

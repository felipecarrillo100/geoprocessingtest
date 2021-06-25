package com.example.geoprocessingtest.geoprocessing;

import com.example.geoprocessingtest.geoprocessing.process.*;
import com.example.geoprocessingtest.geoprocessing.process.ProcessBuilder;
import com.example.geoprocessingtest.geoprocessing.services.jobs.GetCurrentMoment;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobEntity;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/oapi-p/")
public class GeoProcessingController {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    private ProcessBuilder processBuilder;

    @GetMapping("")
    public ResponseEntity<GeoServerLinks> getServerLinks(HttpServletRequest request) {
        GeoServerLinks result = new GeoServerLinks(request);
        return new ResponseEntity<GeoServerLinks>(result, HttpStatus.OK);
    }

    @GetMapping("/processes")
    public ResponseEntity<List<GeoProcessingProcessSimplified>> getProcesses(HttpServletRequest request) {
        List<GeoProcessingProcessSimplified> results = processBuilder.getResultsSimplified();
        for ( GeoProcessingProcessSimplified result: results) {
            List<GeoProcessingProcessLinks> links = result.getLinks();
            for ( GeoProcessingProcessLinks link: links) {
                link.setHref(request.getRequestURL().toString() + link.getHref());
            }
        }
        return new ResponseEntity<List<GeoProcessingProcessSimplified>>(results, HttpStatus.OK);
    }

    @GetMapping("/processes/{id}")
    public ResponseEntity<GeoProcessingProcessDetailed> getProcessesId(HttpServletRequest request, @PathVariable String id) {
        GeoProcessingProcess process = processBuilder.findProcessByID(id);
        if (process == null) {
            return new ResponseEntity<GeoProcessingProcessDetailed>((GeoProcessingProcessDetailed)null, HttpStatus.NOT_FOUND);
        } else {
            GeoProcessingProcessDetailed geoProcessingProcessDetailed = new GeoProcessingProcessDetailed(process);
            GenericJSON genericJSON = new GenericJSON(geoProcessingProcessDetailed.loadInputs(resourceLoader, id));
            geoProcessingProcessDetailed.setInputs(genericJSON);
            return new ResponseEntity<GeoProcessingProcessDetailed>(geoProcessingProcessDetailed, HttpStatus.OK);
        }
    }

    @PostMapping("/processes/{processID}/execution")
    public ResponseEntity<JobStartSimplified> startProcessesId(HttpServletRequest request, @PathVariable String processID, @RequestBody GenericJSON body) {
        JobEntity jobEntity = new JobEntity(processID);
        jobRepository.save(jobEntity);

        JobStartSimplified jobStartSimplified = new JobStartSimplified();
        jobStartSimplified.setJobID(jobEntity.getJobID());
        jobStartSimplified.setStatus(jobEntity.getStatus());

        GeoProcessingProcess p = processBuilder.findProcessByID(processID);
        p.execute(request, resourceLoader, jobRepository, jobEntity, body);

        return new ResponseEntity<JobStartSimplified>(jobStartSimplified, HttpStatus.OK);
    }

    @GetMapping("/jobs")
    public ResponseEntity<Jobs> getJobs(HttpServletRequest request) {
        Jobs jobs = new Jobs();
        jobs.setJobs(jobRepository.findAll());
        jobs.setLinks(new ArrayList<JobLinks>());
        return new ResponseEntity<Jobs>(jobs, HttpStatus.OK);
    }

    @GetMapping("/purgejobs")
    public ResponseEntity<String> purgeJobs(HttpServletRequest request) {
        jobRepository.deleteAll();;
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/jobs/{jobID}")
    public ResponseEntity<JobEntity> getJobs(HttpServletRequest request, @PathVariable String jobID) {
        JobEntity jobEntityByJobID = jobRepository.findJobEntityByJobID(jobID);
        return new ResponseEntity<JobEntity>(jobEntityByJobID, HttpStatus.OK);
    }

}

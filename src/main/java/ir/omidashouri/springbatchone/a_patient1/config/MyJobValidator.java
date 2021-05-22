package ir.omidashouri.springbatchone.a_patient1.config;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class MyJobValidator implements JobParametersValidator {

    @Value("classpath:javaeeconcurencyfiles/sample.txt")
    Resource resource;

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String fileName = parameters.getString(Constants.JOB_PARAM_FILE_NAME);
        if (StringUtils.isBlank(fileName)) {
            throw new JobParametersInvalidException(
                    "The patient-batch-loader.fileName parameter is required.");
        }
        try {
//            Path file = Paths.get(resource +  File.separator + fileName);
            Path file = Paths.get(resource.getFilename());
            if (Files.notExists(file) || !Files.isReadable(file)) {
                throw new Exception("File did not exist or was not readable");
            }
        } catch (Exception e) {
            throw new JobParametersInvalidException(
                    "The input path + patient-batch-loader.fileName parameter needs to " +
                            "be a valid file location.");
        }
    }
}

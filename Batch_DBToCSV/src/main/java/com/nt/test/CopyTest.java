package com.nt.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CopyTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		JobLauncher jobLauncher = null;
		JobExecution execution = null;
		Job job=null;
		ctx = new ClassPathXmlApplicationContext("com/nt/config/application-context.xml");
		jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		job = (Job) ctx.getBean("job");
		try {
			execution = jobLauncher.run(job,new JobParameters());
			System.out.println(execution.getStatus());
		} catch (JobExecutionAlreadyRunningException e) {			
			e.printStackTrace();
		} catch (JobRestartException e) {	
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}finally {
			((AbstractApplicationContext) ctx).close();
		}
	}
}

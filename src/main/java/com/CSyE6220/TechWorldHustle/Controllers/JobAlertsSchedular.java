/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Controllers;

import com.CSyE6220.TechWorldHustle.DAO.JobAlertsDAO;
import com.CSyE6220.TechWorldHustle.DAO.JobDAO;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.JobAlerts;
import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.mail.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jyoti
 */
 @Configuration
 @EnableScheduling
public class JobAlertsSchedular {
    
    @Autowired
    JobAlertsDAO JADao;
    @Autowired
    JobDAO JDao; 
     
    @Scheduled(cron="0 0 8 * * 6")  // once a week (0 0 8 * * 6) 
         // for demo -- (cron="*/5 * * * * ?")
    public void ScheduledJobAlerts() throws EmailException {
            long alerts_count = JADao.numberOfJobAlerts();
            for(int i=1;i<=alerts_count;i++)
            {
                JobAlerts jobalerts = JADao.getJobAlerts(i);
                List<Job> jobs = JDao.JobBasedOnAlerts(jobalerts.getJobTitle(), jobalerts.getLocation(), jobalerts.getMinSalary());
                int  numberofjobs = jobs.size();
                for (Job j : jobs ){System.out.println(j.getJobId()+" "+j.getJobTitle()+" "+j.getLocation()+" "+j.getSalaryOffered());}
                Email email = new SimpleEmail();
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(465);
                email.setAuthenticator(new DefaultAuthenticator("vaswanij40@gmail.com", "Keepcalm2$"));
                email.setSSLOnConnect(true);
                email.setFrom("jobalerts@techworldhustle.com");
                email.setSubject("Job alerts as on: "+ new Date());
                email.setMsg("There are "+numberofjobs+" matching your preference!");
                email.addTo(jobalerts.getUserId().getUserName());
                email.send();
            }
    }
    
    
}

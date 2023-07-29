package io.pratik.footballdashboard.data;

import io.pratik.footballdashboard.model.Team;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final EntityManager em;

  @Autowired
  public JobCompletionNotificationListener(EntityManager em) {
    this.em = em;
  }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");
      Map<String, Team> teamData = new HashMap<String, Team>();
      em.createQuery("Select distinct m.homeTeam, count(*) from Match m group by m.homeTeam", Object[].class)
              .getResultList()
              .stream()
              .map(e -> new Team((String) e[0], (Long)e[1]))
              .forEach(team -> teamData.put(team.getTeamName(), team));

      em.createQuery("Select distinct m.awayTeam, count(*) from Match m group by m.awayTeam", Object[].class)
              .getResultList()
              .stream()
              .forEach(e -> {
                Team team = teamData.get((String) e[0]);
                if(team!=null) team.setTotalMatches(team.getTotalMatches() + (long) e[1]);
              });

//      em.createQuery("Select distinct m.matchWinner, count(*) from Match m group by m.matchWinner", Object[].class)
//              .getResultList()
//              .stream()
//              .forEach(e -> {
//                Team team = teamData.get((String) e[0]);
//                if(team != null) team.setTotalWins((long) e[1]);
//              });

      teamData.values().forEach(team -> em.persist(team));
      teamData.values().forEach(team -> System.out.println(team));
    }
  }
}

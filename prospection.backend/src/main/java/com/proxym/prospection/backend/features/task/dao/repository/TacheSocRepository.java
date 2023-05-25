package com.proxym.prospection.backend.features.task.dao.repository;

import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface TacheSocRepository extends JpaRepository<TacheS,Long> {

    @Query("SELECT t FROM TacheS t WHERE t.etat = 'task done'")
    List<TacheS> findTasksDone();
    @Query("SELECT t FROM TacheS t WHERE (t.etat <> 'task done' OR t.etat IS NULL ) AND t.date = CURRENT_DATE")
    List<TacheS> findTasksTodoToday();
    @Query("SELECT t FROM TacheS t WHERE (t.etat <> 'task done' OR t.etat IS NULL ) AND t.date > CURRENT_DATE")
    List<TacheS> findTasksToDoAfterToday();
    @Query("SELECT t FROM TacheS t WHERE (t.etat <> 'task done' OR t.etat IS NULL )AND t.date < CURRENT_DATE")
    List<TacheS> findDelayedTasks();

}

package lv.unversityManagementSystem.repository;


import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    void deleteEventById(Long id);
    Optional<Event> findEventById(Long id);
}

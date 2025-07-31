package sam.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.example.demo.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
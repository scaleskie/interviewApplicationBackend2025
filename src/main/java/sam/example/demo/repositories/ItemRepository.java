package sam.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.example.demo.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
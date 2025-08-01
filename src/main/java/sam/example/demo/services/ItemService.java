package sam.example.demo.services;

import org.springframework.web.bind.annotation.*;
import sam.example.demo.Item;
import sam.example.demo.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(@PathVariable Integer id) {
        return itemRepository.findById(id);
    }

    public void deleteItem(@PathVariable Integer id) {
        itemRepository.deleteById(id);
    }

    public Item updateItem(@RequestBody Item updatedItem) {
        return itemRepository.findById(updatedItem.getId())
                .map(item -> {
                    return itemRepository.save(updatedItem);
                })
                .orElseGet(() -> {
                    updatedItem.setId(updatedItem.getId());
                    return itemRepository.save(updatedItem);
                });
    }

}
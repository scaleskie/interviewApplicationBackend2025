package sam.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sam.example.demo.Item;
import sam.example.demo.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/allItems")
    @ResponseBody
    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/getItem/{id}")
    Optional<Item> getItem(@PathVariable Integer id) {
        return itemRepository.findById(id);
    }

    @DeleteMapping("/deleteItem/{id}")
    void deleteItem(@PathVariable Integer id) {
        itemRepository.deleteById(id);
    }
    @PostMapping("/updateItem")
    Item updateItem(@RequestBody Item updatedItem) {
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
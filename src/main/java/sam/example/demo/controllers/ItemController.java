package sam.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sam.example.demo.Item;
import sam.example.demo.repositories.ItemRepository;
import sam.example.demo.services.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    public ItemController (ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/allItems")
    @ResponseBody
    public List<Item> listAll() {
        return itemService.listAll();
    }

    @GetMapping("/getItem/{id}")
    Optional<Item> getItem(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @DeleteMapping("/deleteItem/{id}")
    void deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
    }
    @PostMapping("/updateItem")

    Item updateItem(@RequestBody Item updatedItem) {
        return itemService.updateItem(updatedItem);
    }

}
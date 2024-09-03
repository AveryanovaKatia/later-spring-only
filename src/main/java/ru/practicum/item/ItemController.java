package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<Item> getUserItems(@RequestHeader("X-Later-User-Id") Long userId) {
        return itemService.getUserItems(userId);
    }

    @PostMapping
    public Item saveItem(@RequestHeader("X-Later-User-Id") Long userId,
                    @RequestBody Item item) {
        return itemService.saveItem(userId, item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") Long userId,
                           @PathVariable(name = "itemId") Long itemId) {
        itemService.deleteItem(userId, itemId);
    }
}
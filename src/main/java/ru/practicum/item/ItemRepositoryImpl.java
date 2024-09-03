package ru.practicum.item;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class ItemRepositoryImpl implements ItemRepository {

    private final Map<Long, Item> items = new HashMap<>();

    @Override
    public List<Item> getItem(final Long userId) {
        return items.values().stream().filter(item -> Objects.equals(item.getUserId(), userId)).toList();
    }

    @Override
    public Item getItemById(final Long itemId) {
        return items.get(itemId);
    }

    @Override
    public Item saveItem(final Long userId, final Item item) {
        item.setId(getId());
        item.setUserId(userId);
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public void deleteItem(final Long userId, final Long itemId) {
        items.remove(itemId);
    }

    private long getId() {
        Long currentMaxId = items.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}

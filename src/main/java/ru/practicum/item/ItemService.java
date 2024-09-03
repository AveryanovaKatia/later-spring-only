package ru.practicum.item;

import java.util.List;

public interface ItemService {

    List<Item> getUserItems(final Long userId);

    Item saveItem(final Long userId, final Item item);

    void deleteItem(final Long userId, final Long itemId);
}
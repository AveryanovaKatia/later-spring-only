package ru.practicum.item;

import java.util.List;

interface ItemRepository {

    List<Item> getItem(final Long userId);

    Item getItemById(final Long itemId);

    Item saveItem(final Long userId, final Item item);

    void deleteItem(final Long userId, final Long itemId);
}
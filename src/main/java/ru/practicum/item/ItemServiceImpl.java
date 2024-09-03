package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.exception.NotFoundException;
import ru.practicum.user.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;
    UserRepository userRepository;

    @Override
    public List<Item> getUserItems(final Long userId) {
        validUserId(userId);
        return itemRepository.getItem(userId);
    }

    @Override
    public Item saveItem(final Long userId, final Item item) {
        validUserId(userId);
        return itemRepository.saveItem(userId, item);
    }

    @Override
    public void deleteItem(final Long userId, final Long itemId) {
        validUserId(userId);
        validItemId(itemId);
        itemRepository.deleteItem(userId, itemId);
    }

    private void validUserId(Long userId) {
        if (Objects.isNull(userRepository.getUser(userId))) {
            throw new NotFoundException("такого пользователя нет");
        }
    }

    private void validItemId(Long itemId) {
        if (Objects.isNull(itemRepository.getItemById(itemId))) {
            throw new NotFoundException("такой вещи нет");
        }
    }
}

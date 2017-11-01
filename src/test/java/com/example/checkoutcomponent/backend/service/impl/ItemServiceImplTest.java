package com.example.checkoutcomponent.backend.service.impl;

import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.repositories.ItemRepository;
import com.example.checkoutcomponent.backend.services.ItemService;
import com.example.checkoutcomponent.backend.services.reposervices.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;



import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kamildev7 on 2017-11-01.
 */
@RunWith(SpringRunner.class)
public class ItemServiceImplTest {

    @TestConfiguration
    static class ItemServiceImplTestContextConfiguration {
        @Bean
        public ItemService itemService() {
            return new ItemServiceImpl();
        }
    }

    @Autowired
    private ItemService itemService;

    @MockBean
    private ItemRepository itemRepository;

    @Before
    public void setup() {
        Item item = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        item.setId(1);
        item.setPrice(BigDecimal.valueOf(100));
        item.setHasDiscount(true);
        item2.setId(2);
        item2.setPrice(BigDecimal.valueOf(30));
        item2.setHasDiscount(true);
        item3.setId(3);
        item3.setPrice(BigDecimal.valueOf(80));
        item3.setHasDiscount(false);

        List<Item> itemList = Arrays.asList(item, item2, item3);

        Mockito.when(itemRepository.findOne(item.getId())).thenReturn(item);
        Mockito.when(itemRepository.findAll()).thenReturn(itemList);
        Mockito.when(itemRepository.findOne(-3)).thenReturn(null);
    }


    @Test
    public void shouldGetItemWithValidId() {
        Integer id = 1;
        Item found = itemService.getById(id);

        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    public void shouldReturnNullIfIdWrong() {
        Integer id = 10;
        Item found = itemService.getById(id);

        assertThat(found).isNull();
    }

    @Test
    public void shouldReturnListOfItems() {
        Item item = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        item.setId(1);
        item2.setId(2);
        item3.setId(3);

        List<Item> items = itemService.listAll();

        assertThat(items).hasSize(3).extracting(Item::getId).contains(item.getId(), item2.getId(), item3.getId());

    }
}

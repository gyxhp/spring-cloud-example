package com.gyx.repostory;

import com.gyx.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 * @description Created by IntelliJ IDEA.
 * @date 2019/4/12
 */
@Component
public interface ItemRepostory extends ElasticsearchCrudRepository<Item,Long> {

}

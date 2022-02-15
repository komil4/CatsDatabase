package com.catsDB.services;

import com.catsDB.enums.OrderType;
import com.catsDB.models.Cat;
import com.catsDB.repository.CatsRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    private String attribute;
    private OrderType order;
    private int offset;
    private int limit;
    private final CatsRepository catsRepository;

    public CatServiceImpl(CatsRepository catsRepository) {
        this.catsRepository = catsRepository;
    }

    @Override
    public List<Cat> getAll() {
        if (attribute == null) {
            if (offset != 0) {
                return (List<Cat>) catsRepository.findAll(PageRequest.of(offset, limit));
            }
        } else {
            if (offset == 0) {
                return catsRepository.findAll(Sort.by(order.equals(OrderType.ASC) ? Sort.Direction.ASC : Sort.Direction.DESC, attribute));
            } else {
                if (order.equals(OrderType.ASC)) {
                    return (List<Cat>) catsRepository.findAll(PageRequest.of(offset, limit, Sort.by(attribute).ascending()));
                } else {
                    return (List<Cat>) catsRepository.findAll(PageRequest.of(offset, limit, Sort.by(attribute).descending()));
                }
            }
        }
        return catsRepository.findAll();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public OrderType getOrder() {
        return order;
    }

    public void setOrder(OrderType order) {
        this.order = order;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public CatsRepository getCatsRepository() {
        return catsRepository;
    }

}

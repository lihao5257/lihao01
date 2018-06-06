package com.lee.demo.shortlink.dao;

import org.springframework.stereotype.Repository;

@Repository("shortLinkDAO")
public interface IShortLinkDAO {

    public String selectByKey(String key);
}
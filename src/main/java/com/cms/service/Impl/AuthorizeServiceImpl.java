package com.cms.service.Impl;

import com.cms.mapper.AuthorizeMapper;
import com.cms.service.AuthorizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    @Resource
    private AuthorizeMapper authorizeMapper;


}
